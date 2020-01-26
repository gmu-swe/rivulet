package io.rivulet.test;

import io.rivulet.converter.*;
import org.apache.tomcat.util.buf.ByteChunk;
import org.apache.tomcat.util.http.Parameters;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.*;

/* Test the behavior of ForcedTypeConverter implementations. */
public class ConversionTest {

    /* Checks that the ByteChunkConverter singleton instance sets the bytes of a target ByteChunk to be the bytes from a
     * source String. */
    @Test
    public void testByteChunkConverter() {
        String source = "testByteChunkConverter";
        ByteChunk target = new ByteChunk();
        target.setBytes("target".getBytes(), 0, "target".length());
        ByteChunk result =  (ByteChunk)ByteChunkConverter.getInstance().convert(target, source);
        assertSame(target, result); // Check the conversion was in-place
        assertTrue(result.equals(source));
    }

    /* Checks that the CastingConverter singleton instance return the source instance when the source instance is a subtype
     * of the target instance's type. */
    @Test
    public void testCastingConverter() {
        LinkedHashMap<String, String> source = new LinkedHashMap<>();
        HashMap<String, String> target = new HashMap<>();
        @SuppressWarnings("unchecked")
        HashMap<String, String> result = (HashMap<String, String>)CastingConverter.getInstance().convert(target, source);
        assertSame(source, result);
    }
    
    /* Checks that a ChainTypeConverter that uses the StringArrayConverter and the HeapByteBufferConverter correctly
     * applies the converters to produce its final ByteBuffer conversion result. */
    @Test
    public void testChainTypeConverter() {
        ChainedTypeConverter converter = ChainedTypeConverter.getInstance(StringArrayConverter.getByteInstance(), HeapByteBufferConverter.getInstance());
        String source = "testChainTypeConverter";
        ByteBuffer target = ByteBuffer.wrap("target".getBytes());
        ByteBuffer result = (ByteBuffer)converter.convert(target, source);
        assertNotNull(result);
        assertEquals(ByteBuffer.wrap(source.getBytes()), result);
    }

    /* Checks that the appending CookieMapConverter instance correctly converts from Map sources. */
    @Test
    public void testAppendingCookieMapConverter() {
        HashMap<String, String> source = new HashMap<>();
        source.put("name2", "newValue2");
        source.put("name4", "newValue4");
        String target = "name1=value1; name2=value2; name3=value3";
        String result =  (String) CookieMapConverter.getInstance(true).convert(target, source);
        assertNotNull(result);
        HashMap<String, String> actual = CookieMapConverter.parseOriginalCookie(result);
        HashMap<String, String> expected = new HashMap<>(source);
        expected.put("name1", "value1");
        expected.put("name3", "value3");
        assertEquals(expected, actual);
    }

    /* Checks that the replacing CookieMapConverter instance correctly converts from Map sources. */
    @Test
    public void testReplacingCookieMapConverter() {
        HashMap<String, String> source = new HashMap<>();
        source.put("name2", "newValue2");
        source.put("name4", "newValue4");
        String target = "name1=value1; name2=value2; name3=value3";
        String result =  (String) CookieMapConverter.getInstance(false).convert(target, source);
        assertNotNull(result);
        HashMap<String, String> actual = CookieMapConverter.parseOriginalCookie(result);
        assertEquals(source, actual);
    }

    /* Checks that the appending CookieMapConverter instance correctly converts even when there is an equals in a cookie
     * value. */
    @Test
    public void testEqualsInValueAppendingCookieMapConverter() {
        HashMap<String, String> source = new HashMap<>();
        source.put("name1", "newValue1");
        source.put("name2", "newValue2");
        source.put("name4", "newValue4");
        String target = "name1=va=lue1; name2==value2; name3=value3";
        String result =  (String) CookieMapConverter.getInstance(true).convert(target, source);
        assertNotNull(result);
        HashMap<String, String> actual = CookieMapConverter.parseOriginalCookie(result);
        source.put("name3", "value3");
        assertEquals(source, actual);
    }

    /* Checks that the HeapByteBufferConverter singleton instance can convert a byte array into a HeapByteBuffer. */
    @Test
    public void testHeapByteBufferConverter() {
        byte[] source = "testHeapByteBufferConverter".getBytes();
        ByteBuffer target = ByteBuffer.wrap("target".getBytes());
        ByteBuffer result = (ByteBuffer)HeapByteBufferConverter.getInstance().convert(target, source);
        assertNotNull(result);
        assertEquals(ByteBuffer.wrap(source), result);
    }

    /* Checks that the InPlaceArrayConverter singleton instance can in-place convert a source String array into a target
     * String array. */
    @Test
    public void testInPlaceArrayConverter() {
        String[] source = new String[]{"source0", "source1", "source2"};
        String[] target = new String[]{"target0", "target1", "target2", "target3"};
        String[] result = (String[])InPlaceArrayConverter.getInstance().convert(target, source);
        assertSame(target, result);
        for(int i = 0; i < source.length; i++) {
            assertEquals(source[i], result[i]);
        }
    }

    /* Check that the OneArgConstructorConverter instance can convert a char array to a String using the single
     * argument String constructor. */
    @Test
    public void testOneArgConstructorConverter() {
        char[] source = "testOneArgConstructorConverter".toCharArray();
        String target = "target";
        String result = (String) OneArgConstructorConverter.getInstance().convert(target, source);
        assertEquals(new String(source), result);
    }

    /* Checks that the appending ParametersConverter instance correctly converts from Map sources. */
    @Test
    public void testAppendingParametersConverterMapSource() {
        String value = new String("testAppendingParametersConverterMapSource");
        String key = new String("key2");
        HashMap<String, String> source = new HashMap<>();
        source.put(key, value);
        Parameters target = new Parameters();
        target.addParameter("key1", "value1");
        Parameters result = (Parameters) ParametersConverter.getInstance(true).convert(target, source);
        assertNotNull(result);
        assertEquals(value, result.getParameter(key));
        assertEquals("value1", result.getParameter("key1"));
    }

    /* Checks that the replacing ParametersConverter instance correctly converts from Map sources. */
    @Test
    public void testReplacingParametersConverterMapSource() {
        HashMap<String, String> source = new HashMap<>();
        source.put("key2", "value2");
        source.put("key3", "value3");
        Parameters target = new Parameters();
        target.addParameter("key1", "value1");
        Parameters result = (Parameters) ParametersConverter.getInstance(false).convert(target, source);
        assertNotNull(result);
        assertNull(result.getParameter("key1"));
        assertEquals("value2", result.getParameter("key2"));
        assertEquals("value3", result.getParameter("key3"));
    }

    /* Checks that the replacing ParametersConverter instance correctly converts from String sources. */
    @Test
    public void testReplacingParametersConverterStringSource() {
        String value = new String("testReplacingParametersConverterStringSource");
        Parameters target = new Parameters();
        target.addParameter("key1", "value1");
        Parameters result = (Parameters)ParametersConverter.getInstance(false).convert(target, value);
        assertNotNull(result);
        assertEquals(value, result.getParameter("key1"));
    }

    /* Checks that the appending, decoded QueryConverter instance correctly converts from Map sources. */
    @Test
    public void testAppendingQueryConverterMapSource() throws Exception {
        HashMap<String, String> source = new HashMap<>();
        source.put("name2", "newValue2");
        source.put("name4", "newValue4");
        String target = "name1=value1&name2=value2&name3=value3";
        String result =  (String) QueryConverter.getInstance(true, false).convert(target, source);
        assertNotNull(result);
        HashMap<String, String> actual = QueryConverter.getInstance(true, false).parseOriginalQuery(result);
        HashMap<String, String> expected = new HashMap<>(source);
        expected.put("name1", "value1");
        expected.put("name3", "value3");
        assertEquals(expected, actual);
    }

    /* Checks that the replacing, decoded QueryConverter instance correctly converts from Map sources. */
    @Test
    public void testReplacingQueryConverterMapSource() {
        HashMap<String, String> source = new HashMap<>();
        source.put("name2", "newValue2");
        source.put("name4", "newValue4");
        String target = "name1=value1&name2=value2&name3=value3";
        String result = (String)QueryConverter.getInstance(false, false).convert(target, source);
        assertNotNull(result);
        HashMap<String, String> actual = QueryConverter.getInstance(false, false).parseOriginalQuery(result);
        assertEquals(source, actual);
    }

    /* Checks that the replacing, decoded QueryConverter instance correctly converts from String sources. */
    @Test
    public void testReplacingQueryConverterStringSource() throws Exception {
        String source = "newValue";
        String target = "name1=value1&name2=value2&name3=value3";
        String result = (String)QueryConverter.getInstance(false, false).convert(target, source);
        assertNotNull(result);
        HashMap<String, String> actual = QueryConverter.getInstance(false, false).parseOriginalQuery(result);
        HashMap<String, String> expected = new HashMap<>();
        expected.put("name1", source);
        expected.put("name2", source);
        expected.put("name3", source);
        assertEquals(expected, actual);
    }

    /* Check that the StringArrayConverter instance for byte arrays can convert a String source into a byte array target. */
    @Test
    public void testStringByteArrayConverter() {
        String source = "testStringByteArrayConverter";
        byte[] target = "target".getBytes();
        byte[] result = (byte[])StringArrayConverter.getByteInstance().convert(target, source);
        assertArrayEquals(source.getBytes(), result);
    }

    /* Check that the StringArrayConverter instance for char arrays can convert a String source into a char array target. */
    @Test
    public void testStringCharArrayConverter() {
        String source = "testStringCharArrayConverter";
        char[] target = "target".toCharArray();
        char[] result = (char[])StringArrayConverter.getCharInstance().convert(target, source);
        assertArrayEquals(source.toCharArray(), result);
    }

    /* Checks that the appending UriPathConverter instance appends the source String to the target String. */
    @Test
    public void testUriPathConverter() {
        String source = new String("testUriPathConverter");
        String prefix = new String("a/b/c/");
        String target = prefix + "ending-example.test";
        String result = (String)UriPathConverter.getInstance(true, true).convert(target, source);
        assertNotNull(result);
        assertEquals(target + '/' + source, result);
    }

    /* Checks that SubstringConverter replaces only the portion of the target string that is in its range. */
    @Test
    public void testSubstringConverter() {
        String source = "testSubstringConverter";
        String target = "0123456789";
        ForcedTypeConverter converter = new SubstringConverter(3, 7);
        String result = (String)converter.convert(target, source);
        assertEquals("012" + source + "789", result);
    }

    /* Checks that SubstringConverter replaces beyond the end of the target String if necessary. */
    @Test
    public void testSubstringConverterEndOutsideLength() {
        String source = "testSubstringConverter";
        String target = "0123456789";
        ForcedTypeConverter converter = new SubstringConverter(3, 12);
        String result = (String)converter.convert(target, source);
        assertEquals("012" + source, result);
    }

    /* Checks that SubArrayConverter replaces only the portion of the target array that is in its range. */
    @Test
    public void testSubArrayConverter() {
        char[] source = "testSubstringConverter".toCharArray();
        char[] target = "0123456789".toCharArray();
        ForcedTypeConverter converter = new SubArrayConverter(3, 7);
        char[] result = (char[])converter.convert(target, source);
        assertEquals("012" + new String(source) + "789", new String(result));
    }

    /* Checks that SubArrayConverter replaces beyond the end of the target array if necessary. */
    @Test
    public void testSubArrayConverterEndOutsideLength() {
        byte[] source = "testSubstringConverter".getBytes();
        byte[] target = "0123456789".getBytes();
        ForcedTypeConverter converter = new SubArrayConverter(3, 12);
        byte[] result = (byte[])converter.convert(target, source);
        assertEquals("012" + new String(source), new String(result));
    }
}