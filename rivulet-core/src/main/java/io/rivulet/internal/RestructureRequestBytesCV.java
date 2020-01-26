package io.rivulet.internal;

import edu.columbia.cs.psl.phosphor.Configuration;
import edu.columbia.cs.psl.phosphor.TaintUtils;
import edu.columbia.cs.psl.phosphor.org.objectweb.asm.ClassVisitor;
import edu.columbia.cs.psl.phosphor.org.objectweb.asm.MethodVisitor;
import edu.columbia.cs.psl.phosphor.org.objectweb.asm.Opcodes;
import edu.columbia.cs.psl.phosphor.org.objectweb.asm.Type;
import edu.columbia.cs.psl.phosphor.org.objectweb.asm.tree.FieldNode;

/* Builds a request object from the bytes that reach the server side of a socket in order to taint them. */
public class RestructureRequestBytesCV extends ClassVisitor implements Opcodes {

    // The name of the channel class used by Tomcat to read bytes from the socket
    public static final String TOMCAT_CHANNEL_CLASS = "org/apache/tomcat/util/net/NioChannel";
    // The name of the channel class used by Jetty to read bytes from the socket
    public static final String JETTY_CHANNEL_CLASS = "org/eclipse/jetty/io/ChannelEndPoint";
    // The name of the ByteBuffer field added to store the restructured bytes
    public static final String BYTE_BUFF_FIELD_NAME = TaintUtils.PHOSPHOR_ADDED_FIELD_PREFIX + "BUF";

    // Node for field added to store the restructured bytes
    private final FieldNode bufFieldNode;
    // The name of the class being visited
    private String className;

    public RestructureRequestBytesCV(ClassVisitor cv) {
        super(Configuration.ASM_VERSION, cv);
        bufFieldNode = new FieldNode(ACC_PUBLIC, BYTE_BUFF_FIELD_NAME, "Ljava/nio/ByteBuffer;", null, null);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.className = name;
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if(isApplicable(className)) {
            if("init".equals(name)) {
                // Visiting a constructor
                mv = new InitByteBufferMV(mv, className, bufFieldNode);
            }
            mv = new SocketReadInterceptingMV(mv);
        }
        return mv;
    }

    @Override
    public void visitEnd() {
        if(isApplicable(className)) {
            bufFieldNode.accept(cv);
        }
        super.visitEnd();
    }

    /* Returns whether the class with the specified name is one of the classes targeted by this class visitor. */
    public static boolean isApplicable(String className) {
        return TOMCAT_CHANNEL_CLASS.equals(className) || JETTY_CHANNEL_CLASS.equals(className);
    }

    /* Initializes the added byte buffer field to be null. */
    private static class InitByteBufferMV extends MethodVisitor {

        // The class that owns the method being visited
        private final String owner;
        // Node for field added to store the restructured bytes
        private final FieldNode bufFieldNode;

        InitByteBufferMV(MethodVisitor mv, String owner, FieldNode bufFieldNode) {
            super(Configuration.ASM_VERSION, mv);
            this.owner = owner;
            this.bufFieldNode = bufFieldNode;
        }

        @Override
        public void visitInsn(int opcode) {
            if(TaintUtils.isReturnOpcode(opcode)) {
                super.visitVarInsn(ALOAD, 0); // Load this onto the stack
                super.visitInsn(ACONST_NULL); // Put a null value onto the stack to initialize the added buffer field
                super.visitFieldInsn(PUTFIELD, owner, bufFieldNode.name, bufFieldNode.desc);
            }
            super.visitInsn(opcode);
        }
    }

    /* Intercepts method calls which read from a SocketChannel or ByteChannel. */
    private static class SocketReadInterceptingMV extends MethodVisitor {

        SocketReadInterceptingMV(MethodVisitor mv) {
            super(Configuration.ASM_VERSION, mv);
        }

        @Override
        public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
            if((owner.equals("java/nio/channels/SocketChannel") || owner.equals("java/nio/channels/ByteChannel")) && name.equals("read")) {
                super.visitVarInsn(ALOAD, 0); // Load this onto the stack
                Type[] args = Type.getArgumentTypes(desc);
                Type ret = Type.getReturnType(desc);
                StringBuilder descBuilder = new StringBuilder("(Ljava/nio/channels/ByteChannel;");
                for(Type arg : args) {
                    descBuilder .append(arg.getDescriptor());
                }
                descBuilder.append("Ljava/lang/Object;)").append(ret.getDescriptor());
                super.visitMethodInsn(INVOKESTATIC, "io/rivulet/PhosphorHttpRequest", "read", descBuilder.toString(), false);
            } else {
                super.visitMethodInsn(opcode, owner, name, desc, itf);
            }
        }
    }
}
