package io.rivulet;

import edu.columbia.cs.psl.phosphor.org.objectweb.asm.Type;

import java.lang.reflect.Method;

/* Stores the bytecode signatures of source methods in PhosphorHttpRequest. */
public enum PhosphorHttpRequestSource {

    ENCODED_PATH("getEncodedPath"),
    ENCODED_QUERY("getEncodedQuery"),
    ENTITY_BODY("getEntityBody"),
    COOKIE_HEADER("getCookieHeader"),
    CONTENT_TYPE_HEADER("getContentTypeHeader");

    // The bytecode signature for the method
    private final String signature;

    PhosphorHttpRequestSource(String methodName) {
        try {
            Method targetMethod = null;
            for(Method method : Class.forName("io.rivulet.PhosphorHttpRequest").getDeclaredMethods()) {
                if(method.getName().equals(methodName)) {
                    targetMethod = method;
                    break;
                }
            }
            if(targetMethod == null) {
                throw new RuntimeException("Failed find PhosphorHttpRequest method: " + methodName);
            }
            this.signature  = String.format("%s.%s%s", "io/rivulet/PhosphorHttpRequest", methodName, Type.getMethodDescriptor(targetMethod));
        } catch(Exception e) {
            throw new RuntimeException("Failed find PhosphorHttpRequest method: " + methodName);
        }
    }

    /* Getter for signature. */
    public String getSignature() {
        return signature;
    }

    /* Returns whether the specified baseSource String matches this instance's signature. */
    public boolean matchesSignature(String baseSource) {
        return signature.equals(baseSource);
    }
}
