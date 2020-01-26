package io.rivulet.internal;

import edu.columbia.cs.psl.phosphor.Configuration;
import edu.columbia.cs.psl.phosphor.org.objectweb.asm.ClassVisitor;

/* Applies Rivulet specific class transformations. */
public class RivuletCV extends ClassVisitor {

    public RivuletCV(ClassVisitor cv, boolean skipFrames) {
        super(Configuration.ASM_VERSION, addRivuletClassVisitors(cv));
    }

    private static ClassVisitor addRivuletClassVisitors(ClassVisitor cv) {
        cv = new RestructureRequestBytesCV(cv);
        cv = new DisableJsoupCachingCV(cv);
        return new LogQuietingCV(cv);
    }
}
