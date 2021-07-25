package com.wbo112.asm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;

public class AddTimerMethodAdapter6 extends AdviceAdapter {
    private String owner;
    private int localVarIndex;
    //private int localVarIndex1;;

    public AddTimerMethodAdapter6(int access, String name, String desc,
                                  MethodVisitor mv, String owner) {
        super(ASM9, mv, access, name, desc);
        this.owner = owner;


    }

    @Override
    protected void onMethodEnter() {
        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System",
                "currentTimeMillis", "()J", false);
        localVarIndex = newLocal(Type.LONG_TYPE);
        mv.visitVarInsn(LSTORE, localVarIndex);
    }

    @Override
    protected void onMethodExit(int opcode) {
        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System",
                "currentTimeMillis", "()J", false);
        mv.visitVarInsn(LLOAD, localVarIndex);
        mv.visitInsn(LSUB);
        int localVarIndex1 = newLocal(Type.LONG_TYPE);
        mv.visitVarInsn(LSTORE, localVarIndex1);
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//                "currentTimeMillis", "()J");
        mv.visitVarInsn(LLOAD, localVarIndex1);

//        mv.visitFieldInsn(GETSTATIC, owner, "timer", "J");
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
//                "currentTimeMillis", "()J");
//        mv.visitInsn(LADD);
//        mv.visitFieldInsn(PUTSTATIC, owner, "timer", "J");
    }

//    @Override
//    public void visitMaxs(int maxStack, int maxLocals) {
//        super.visitMaxs(maxStack + 4, maxLocals+4);
//    }
}