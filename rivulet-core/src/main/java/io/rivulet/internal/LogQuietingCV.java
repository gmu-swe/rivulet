package io.rivulet.internal;

import edu.columbia.cs.psl.phosphor.Configuration;
import edu.columbia.cs.psl.phosphor.org.objectweb.asm.ClassVisitor;
import edu.columbia.cs.psl.phosphor.org.objectweb.asm.MethodVisitor;
import edu.columbia.cs.psl.phosphor.org.objectweb.asm.Opcodes;
import edu.columbia.cs.psl.phosphor.org.objectweb.asm.Type;

/* Removes persistent, noisy logging code. */
public class LogQuietingCV extends ClassVisitor implements Opcodes {

    // The name of factory class used by slf4j that reports configuration warnings
    private static final String LOGGER_FACTORY_CLASS = "org/slf4j/LoggerFactory";
    // The name of the class being visited
    private String className;

    public LogQuietingCV(ClassVisitor cv) {
        super(Configuration.ASM_VERSION, cv);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.className = name;
        super.visit(version, access, name, signature, superName, interfaces);
    }

    /* Returns whether the class with the specified name is one of the classes targeted by this class visitor. */
    public static boolean isApplicable(String className) {
        return LOGGER_FACTORY_CLASS.equals(className);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if(isApplicable(className)) {
            mv = new LogQuietingMV(mv, className);
        }
        return mv;
    }

    /* Remove logging instructions. */
    public static class LogQuietingMV extends MethodVisitor {
        // The class that owns the method being visited
        private final String declaringClass;

        LogQuietingMV(MethodVisitor mv, String declaringClass) {
            super(Configuration.ASM_VERSION, mv);
            this.declaringClass = declaringClass;
        }

        @Override
        public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean isInterface) {
            if(declaringClass.equals(LOGGER_FACTORY_CLASS) && opcode == INVOKESTATIC && "org/slf4j/helpers/Util".equals(owner)
                    && "report".equals(name) && Type.getReturnType(desc).equals(Type.VOID_TYPE)) {
                // Remove the logging instruction
                Type[] args = Type.getArgumentTypes(desc);
                for(int i = args.length - 1; i >= 0; i--) {
                    int sort = args[i].getSort();
                    if(sort == Type.LONG || sort == Type.DOUBLE) {
                        super.visitInsn(POP2);
                    } else {
                        super.visitInsn(POP);
                    }
                }
            } else {
                super.visitMethodInsn(opcode, owner, name, desc, isInterface);
            }
        }
    }
}
