package io.rivulet.internal;

import edu.columbia.cs.psl.phosphor.runtime.Taint;
import edu.columbia.cs.psl.phosphor.runtime.TaintSourceWrapper;
import edu.columbia.cs.psl.phosphor.struct.LazyCharArrayObjTags;
import io.rivulet.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.jsoup.parser.Parser;

import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Provides utility functions for working with lexing and parsing strings from various languages. */
public class ParseUtils {

    // Dummy base source method String used to create dummy taint tags to create original indices across various String
    // transformations
    private static final String DUMMY_BASE_SOURCE = "DummyClass.dummySource()V";
    // Dummy ID used for the InvocationRanges of the dummy taint tags
    public static final int DUMMY_INVOCATION_ID = -1;

    /* Copy the specified String and adds dummy taint tags to to each character of the copy recording its index in the copy
     * String. Returns the copy. */
    public static String taintCharsWithPosition(String str) {
        IndexedSourceInfoTaintLabel baseLabel = new IndexedSourceInfoTaintLabel(DUMMY_BASE_SOURCE, DUMMY_BASE_SOURCE, -2, String.class, false, new InvocationRanges(DUMMY_INVOCATION_ID));
        String copy = new String(str);
        char[] val = copy.toCharArray();
        Taint[] currentTaints = TaintSourceWrapper.getStringValueTaints(copy);
        @SuppressWarnings("unchecked")
        Taint<SourceInfoTaintLabel>[] taints = (Taint<SourceInfoTaintLabel>[])(currentTaints == null ? new Taint[val.length] : currentTaints.clone());
        for(int i = 0; i < taints.length; i++) {
            Taint<SourceInfoTaintLabel> tag = new Taint<>(new IndexedSourceInfoTaintLabel(baseLabel, i));
            if(taints[i] == null) {
                taints[i] = tag;
            } else {
                taints[i] = taints[i].copy();
                taints[i].addDependency(tag);
            }
        }
        TaintSourceWrapper.setStringValueTag(copy, new LazyCharArrayObjTags(val, taints));
        return copy;
    }

    /* Returns whether the specified String contains at least one character that is tainted with a non-dummy taint tag. */
    public static boolean containsNonDummyTaint(String s) {
        if(s == null) {
            return false;
        }
        @SuppressWarnings("unchecked")
        Taint<SourceInfoTaintLabel>[] taints = TaintSourceWrapper.getStringValueTaints(s);
        if(taints != null) {
            for(Taint<SourceInfoTaintLabel> taint : taints) {
                if(taint != null && !taint.isEmpty()) {
                    for(SourceInfoTaintLabel label : taint.getLabels(new SourceInfoTaintLabel[0])) {
                        if(!label.getBaseSource().equals(DUMMY_BASE_SOURCE)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* Returns a copy of the specified String with any dummy index position tags removed from its chars taint array. */
    public static String removeDummyPositionTags(String str) {
        String copy = new String(str);
        @SuppressWarnings("unchecked")
        Taint<SourceInfoTaintLabel>[] taints = TaintSourceWrapper.getStringValueTaints(copy);
        if(taints != null) {
            for(int i = 0; i < taints.length; i++) {
                if(taints[i] != null && !taints[i].isEmpty()) {
                    Taint<SourceInfoTaintLabel> temp = taints[i];
                    taints[i] = new Taint<>();
                    for(SourceInfoTaintLabel label : temp.getLabels(new SourceInfoTaintLabel[0])) {
                        if(!label.getBaseSource().equals(DUMMY_BASE_SOURCE)) {
                            taints[i].addDependency(new Taint<>(label));
                        }
                    }
                }
            }
        }
        return copy;
    }

    /* Returns an InvocationRanges instance containing all of the indices from the dummy taints on the specified String. */
    public static InvocationRanges getMergedRangesFromTaints(String str) {
        InvocationRanges range = new InvocationRanges(DUMMY_INVOCATION_ID);
        if(str != null) {
            Taint[] taints = TaintSourceWrapper.getStringValueTaints(str);
            if(taints != null) {
                for(Taint taint : taints) {
                    if(taint != null && !taint.isEmpty()) {
                        for(Object label : taint.getLabels()) {
                            if(label instanceof IndexedSourceInfoTaintLabel) {
                                IndexedSourceInfoTaintLabel indexedLabel = (IndexedSourceInfoTaintLabel)label;
                                if(indexedLabel.getBaseSource().equals(DUMMY_BASE_SOURCE)) {
                                    range.merge(indexedLabel.getIndexInfoCopy());
                                }
                            }
                        }
                    }
                }
            }
        }
        return range;
    }

    public static List<LinkedList<String>> parseSQL(String sql) {
        BasicSQLLexer lexer = new BasicSQLLexer(new ANTLRInputStream(sql));
        BasicSQLParser parser = new BasicSQLParser(new CommonTokenStream(lexer));
        lexer.removeErrorListeners();
        parser.removeErrorListeners();
        lexer.addErrorListener(ExceptionThrowingErrorListener.INSTANCE);
        parser.addErrorListener(ExceptionThrowingErrorListener.INSTANCE);
        try {
            parser.parse();
            return Arrays.asList(parser.code, parser.commented, parser.quoted);
        } catch(Exception e) {
            return Arrays.asList(new LinkedList<>(), new LinkedList<>(), new LinkedList<>());
        }
    }

    public static List<LinkedList<String>> parseVBScript(String script) {
        BasicVBScriptLexer lexer = new BasicVBScriptLexer(new ANTLRInputStream(script));
        BasicVBScriptParser parser = new BasicVBScriptParser(new CommonTokenStream(lexer));
        lexer.removeErrorListeners();
        parser.removeErrorListeners();
        lexer.addErrorListener(ExceptionThrowingErrorListener.INSTANCE);
        parser.addErrorListener(ExceptionThrowingErrorListener.INSTANCE);
        try {
            parser.parse();
            return Arrays.asList(parser.code, parser.commented, parser.quoted);
        } catch(Exception e) {
            return Arrays.asList(new LinkedList<>(), new LinkedList<>(), new LinkedList<>());
        }
    }

    public static List<LinkedList<String>> parseJavaScript(String script) {
        BasicJavaScriptLexer lexer = new BasicJavaScriptLexer(new ANTLRInputStream(script));
        BasicJavaScriptParser parser = new BasicJavaScriptParser(new CommonTokenStream(lexer));
        lexer.removeErrorListeners();
        parser.removeErrorListeners();
        lexer.addErrorListener(ExceptionThrowingErrorListener.INSTANCE);
        parser.addErrorListener(ExceptionThrowingErrorListener.INSTANCE);
        try {
            parser.parse();
            return Arrays.asList(parser.code, parser.commented, parser.quoted);
        } catch(Exception e) {
            return Arrays.asList(new LinkedList<>(), new LinkedList<>(), new LinkedList<>());
        }
    }

    /* Returns a list of name, value pairs for the attributes in the HTML opening tag at the start of the specified HTML
     * fragment. */
    public static LinkedList<String[]> parseAttributesFromStartOfHtmlOpeningTag(String htmlFragment) {
        HTMLAttributesLexer lexer = new HTMLAttributesLexer(new ANTLRInputStream(htmlFragment));
        HTMLAttributesParser parser = new HTMLAttributesParser(new CommonTokenStream(lexer));
        lexer.removeErrorListeners();
        parser.removeErrorListeners();
        lexer.addErrorListener(ExceptionThrowingErrorListener.INSTANCE);
        parser.addErrorListener(ExceptionThrowingErrorListener.INSTANCE);
        try {
            parser.parse();
            return parser.attributes;
        } catch(Exception e) {
            return (e instanceof EndOfAttributeException) ? parser.attributes : new LinkedList<>();
        }
    }

    /* Unescapes any named or numeric character references in the specified String while ensuring that the taint tags
     * of the character reference are assigned to their unescaped values. */
    public static String unescapeHtmlReferencesEnsuringTags(String html) {
        HTMLCharReferencesLexer lexer = new HTMLCharReferencesLexer(new ANTLRInputStream(html));
        HTMLCharReferencesParser parser = new HTMLCharReferencesParser(new CommonTokenStream(lexer));
        lexer.removeErrorListeners();
        parser.removeErrorListeners();
        lexer.addErrorListener(ExceptionThrowingErrorListener.INSTANCE);
        parser.addErrorListener(ExceptionThrowingErrorListener.INSTANCE);
        CharRefListener listener = new CharRefListener();
        parser.addParseListener(listener);
        try {
            parser.parse();
            return listener.builder.toString();
        } catch(Exception e) {
            return html;
        }
    }

    private static class CharRefListener extends HTMLCharReferencesBaseListener {

        TaintedStringBuilder builder = new TaintedStringBuilder();

        @Override public void exitDecimalCharRef(HTMLCharReferencesParser.DecimalCharRefContext ctx) {
            appendUnescaped(ctx.value.getText());
        }

        @Override public void exitNamedCharRef(HTMLCharReferencesParser.NamedCharRefContext ctx) {
            appendUnescaped(ctx.value.getText());
        }

        @Override public void exitHexCharRef(HTMLCharReferencesParser.HexCharRefContext ctx) {
            appendUnescaped(ctx.value.getText());
        }

        @Override public void exitUnescapedChars(HTMLCharReferencesParser.UnescapedCharsContext ctx) {
            builder.append(ctx.value.getText());
        }

        private void appendUnescaped(String escaped) {
            String unescaped = Parser.unescapeEntities(escaped, false);
            if(unescaped.equals(escaped)) {
                builder.append(escaped);
            } else {
                @SuppressWarnings("unchecked")
                Taint<SourceInfoTaintLabel> taint = Taint.combineTaintArray(TaintSourceWrapper.getStringValueTaints(escaped));
                builder.append(TaintedStringBuilder.taintChars(unescaped, taint));
            }
        }
    }

    /* Decodes the specified URL string without ensuring that its tags are properly propagated. */
    public static String decodeUrl(String s) {
        try {
            return URLDecoder.decode(s, StandardCharsets.UTF_8.name());
        } catch(Exception e) {
            return s;
        }
    }

    /* Decodes the specified URL String while ensuring that the taint tags of the encoded characters are properly
     * assigned to their decoded values. */
    public static String decodeUrlEnsuringTags(String url) {
        EncodedURLLexer lexer = new EncodedURLLexer(new ANTLRInputStream(url));
        EncodedURLParser parser = new EncodedURLParser(new CommonTokenStream(lexer));
        lexer.removeErrorListeners();
        parser.removeErrorListeners();
        lexer.addErrorListener(ExceptionThrowingErrorListener.INSTANCE);
        parser.addErrorListener(ExceptionThrowingErrorListener.INSTANCE);
        DecodeListener listener = new DecodeListener();
        parser.addParseListener(listener);
        try {
            parser.parse();
            return listener.builder.toString();
        } catch(Exception e) {
            return url;
        }
    }

    private static class DecodeListener extends EncodedURLBaseListener {

        TaintedStringBuilder builder = new TaintedStringBuilder();

        @Override public void exitPercentEncodedChar(EncodedURLParser.PercentEncodedCharContext ctx) {
            appendDecoded(ctx.value.getText());
        }

        @Override public void exitUnencodedChars(EncodedURLParser.UnencodedCharsContext ctx) {
            builder.append(ctx.value.getText());
        }

        @Override public void exitPlusEncodedSpace(EncodedURLParser.PlusEncodedSpaceContext ctx) {
            appendDecoded(ctx.value.getText());
        }

        @SuppressWarnings("unchecked")
        private void appendDecoded(String encoded) {
            String decoded = decodeUrl(encoded);
            if(decoded.equals(encoded)) {
                builder.append(encoded);
            } else if(decoded.length() == 1) {
                Taint<SourceInfoTaintLabel> taint = Taint.combineTaintArray(TaintSourceWrapper.getStringValueTaints(encoded));
                builder.append(TaintedStringBuilder.taintChars(decoded, taint));
            } else {
                // Multiple percent encoded bytes producing multiple characters
                Taint<SourceInfoTaintLabel>[] decodedTags = (Taint<SourceInfoTaintLabel>[]) new Taint[decoded.length()];
                int start = 0;
                for(int i = 0; i < decoded.length(); i++) {
                    char c = decoded.charAt(i);
                    ByteBuffer buffer = StandardCharsets.UTF_8.encode(CharBuffer.wrap(new char[]{c}));
                    // Three original characters, i.e. %##, per byte
                    int len = buffer.remaining() * 3;
                    String encodedPortion = encoded.substring(start, start += len);
                    Taint<SourceInfoTaintLabel> taint = Taint.combineTaintArray(TaintSourceWrapper.getStringValueTaints(encodedPortion));
                    decodedTags[i] = taint;
                }
                TaintSourceWrapper.setStringValueTag(decoded, new LazyCharArrayObjTags(decoded.toCharArray(), decodedTags));
                builder.append(decoded);
            }
        }
    }

    /* Error listener that throws an exception for syntax errors. */
    private static class ExceptionThrowingErrorListener extends BaseErrorListener {

        public static final ExceptionThrowingErrorListener INSTANCE = new ExceptionThrowingErrorListener();

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            throw new ParseCancellationException();
        }
    }
}
