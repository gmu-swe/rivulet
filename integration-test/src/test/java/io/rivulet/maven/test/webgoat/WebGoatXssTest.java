package io.rivulet.maven.test.webgoat;

import io.rivulet.ExpectsRivuletRerun;
import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;
import org.apache.http.client.utils.URIBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import java.net.URI;
import java.util.Collections;
import java.util.LinkedList;

@Source(method = "io/rivulet/PhosphorHttpRequest.getEntityBody()Ljava/lang/String;")
@Sink(method = "java/nio/channels/SocketChannel.write(Ljava/nio/ByteBuffer;)I")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;II)J")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;)J")
public class WebGoatXssTest extends WebGoatBaseTest {

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testPhishingWithXss() throws Exception {
		try {
			URI uri = getBaseURIBuilderForLesson("Phishing with XSS").build();
			postWithForm(uri, "Username=Jim&SUBMIT=Search");
		} catch(Exception e) {
			if(!methodTaintRule.isRivuletRerun()) {
				throw e;
			}
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testStage1StoredXss() throws Exception {
		try {
			URI uri = getBaseURIBuilderForLesson("Stage 1: Stored XSS").build();
			postWithForm(uri, "employee_id=105&password=tom&action=Login");
			postWithForm(uri, "employee_id=105&action=ViewProfile");
			postWithForm(uri, "employee_id=105&action=EditProfile");
			postWithForm(uri, "firstName=Tom&lastName=Cat&address1=22+Maple+Rd.&address2=New+York%2C+NY&phoneNumber=" +
					"443-599-0762&startDate=1011999&ssn=792-14-6364&salary=80000&ccn=5481360857968521&ccnLimit=30000&" +
					"description=Co-Owner.&manager=105&disciplinaryNotes=NA&disciplinaryDate=0&employee_id=105&" +
					"title=Engineer&action=UpdateProfile");
		} catch(Exception e) {
			if(!methodTaintRule.isRivuletRerun()) {
				throw e;
			}
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testStage5ReflectedXss() throws Exception {
		try {
			URI uri = getBaseURIBuilderForLesson("Stage 5: Reflected XSS").build();
			postWithForm(uri, "employee_id=105&password=tom&action=Login");
			postWithForm(uri, "employee_id=105&action=SearchStaff");
			postWithForm(uri, "search_name=larry&action=FindProfile");
		} catch(Exception e) {
			if(!methodTaintRule.isRivuletRerun()) {
				throw e;
			}
		}
	}

	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testStoredXssAttacks() throws Exception {
		try {
			URI uri = getBaseURIBuilderForLesson("Stored XSS Attacks").build();
			String body = postWithForm(uri, "title=Welcome&message=TEXT&SUBMIT=Submit");
			Document doc = Jsoup.parse(body);
			LinkedList<Integer> nums = new LinkedList<>();
			for(Element el : doc.getElementsByTag("a")) {
				if(el.hasAttr("href")) {
					String value = el.attr("href");
					if(value != null && value.startsWith("attack?Num="))  {
						String numStr = value.substring("attack?Num=".length());
						nums.add(Integer.parseInt(numStr));
					}
				}
			}
			Collections.sort(nums);
			String num = nums.getLast().toString();
			URIBuilder builder = getBaseURIBuilder().setPath("WebGoat/attack").addParameter("Num", num);
			get(builder.build());
		} catch(Exception e) {
			if(!methodTaintRule.isRivuletRerun()) {
				throw e;
			}
		}
	}

	/* Field1 is not sanitized. */
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.AT_LEAST_ONE, numReruns = ExpectsRivuletRerun.AT_LEAST_ONE)
	public void testReflectedXssAttacksField1() throws Exception {
		try {
			URI uri = getBaseURIBuilderForLesson("Reflected XSS Attacks").build();
			postWithForm(uri, "QTY1=&QTY2=&QTY3=&QTY4=&field2=&field1=111&SUBMIT=Purchase");
		} catch(Exception e) {
			if(!methodTaintRule.isRivuletRerun()) {
				throw e;
			}
		}
	}

	/* Field2 is sanitized. */
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE)
	public void testReflectedXssAttacksField2() throws Exception {
		try {
			URI uri = getBaseURIBuilderForLesson("Reflected XSS Attacks").build();
			postWithForm(uri, "QTY1=&QTY2=&QTY3=&QTY4=&field2=4128+3214+0002+1999&field1=&SUBMIT=Purchase");
		} catch(Exception e) {
			if(!methodTaintRule.isRivuletRerun()) {
				throw e;
			}
		}
	}

	/* QTY1 is sanitized. */
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE)
	public void testReflectedXssAttacksQty1() throws Exception {
		try {
			URI uri = getBaseURIBuilderForLesson("Reflected XSS Attacks").build();
			postWithForm(uri, "QTY1=1&QTY2=&QTY3=&QTY4=&field2=&field1=&SUBMIT=Purchase");
		} catch(Exception e) {
			if(!methodTaintRule.isRivuletRerun()) {
				throw e;
			}
		}
	}

	/* QTY2 is sanitized. */
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE)
	public void testReflectedXssAttacksQty2() throws Exception {
		try {
			URI uri = getBaseURIBuilderForLesson("Reflected XSS Attacks").build();
			postWithForm(uri, "QTY1=&QTY2=1&QTY3=&QTY4=&field2=&field1=&SUBMIT=Purchase");
		} catch(Exception e) {
			if(!methodTaintRule.isRivuletRerun()) {
				throw e;
			}
		}
	}

	/* QTY3 is sanitized. */
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE)
	public void testReflectedXssAttacksQty3() throws Exception {
		try {
			URI uri = getBaseURIBuilderForLesson("Reflected XSS Attacks").build();
			postWithForm(uri, "QTY1=&QTY2=&QTY3=1&QTY4=&field2=&field1=&SUBMIT=Purchase");
		} catch(Exception e) {
			if(!methodTaintRule.isRivuletRerun()) {
				throw e;
			}
		}
	}

	/* QTY4 is sanitized. */
	@Test
	@ExpectsRivuletRerun(numCriticalViolations = ExpectsRivuletRerun.NONE)
	public void testReflectedXssAttacksQty4() throws Exception {
		try {
			URI uri = getBaseURIBuilderForLesson("Reflected XSS Attacks").build();
			postWithForm(uri, "QTY1=&QTY2=&QTY3=&QTY4=1&field2=&field1=&SUBMIT=Purchase");
		} catch(Exception e) {
			if(!methodTaintRule.isRivuletRerun()) {
				throw e;
			}
		}
	}
}


