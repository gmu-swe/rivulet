package io.rivulet.internal;

import edu.columbia.cs.psl.phosphor.Configuration;
import edu.columbia.cs.psl.phosphor.org.objectweb.asm.ClassVisitor;
import edu.columbia.cs.psl.phosphor.org.objectweb.asm.MethodVisitor;
import edu.columbia.cs.psl.phosphor.org.objectweb.asm.Opcodes;

/* Prevents String caching in JSoup. */
public class DisableJsoupCachingCV extends ClassVisitor implements Opcodes {

    // Name of the CharacterReader class in Jsoup
    private static final String CHAR_READER_CLASS = "io/rivulet/org/jsoup/parser/CharacterReader";

    // The name of the class being visited
    private String className;

    public DisableJsoupCachingCV(ClassVisitor cv) {
        super(Configuration.ASM_VERSION, cv);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.className = name;
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, null);
        if(isApplicable(className) && "cacheString".equals(name)) {
            mv = new CacheDisableMV(mv);
        }
        return mv;
    }

    /* Returns whether the class with the specified name is one of the classes targeted by this class visitor. */
    public static boolean isApplicable(String className) {
        return className != null && className.endsWith(CHAR_READER_CLASS);
    }

    private static class CacheDisableMV extends MethodVisitor {

        CacheDisableMV(MethodVisitor mv) {
            super(Configuration.ASM_VERSION, mv);
        }

        @Override
        public void visitIntInsn(int opcode, int operand) {
            if(opcode == BIPUSH) {
                super.visitIntInsn(opcode, 0);
            } else {
                super.visitIntInsn(opcode, operand);
            }
        }
    }
}
