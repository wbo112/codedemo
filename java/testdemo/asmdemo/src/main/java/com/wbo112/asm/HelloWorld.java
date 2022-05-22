package com.wbo112.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.Method;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HelloWorld {


    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader("HelloWorld1");
        ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_FRAMES);
        AddTimerAdapter addTimerAdapter = new AddTimerAdapter(cw);
        cr.accept(addTimerAdapter, 0);
        Files.createDirectories(Paths.get("asm"));
        OutputStream outputStream = Files.newOutputStream(Paths.get("asm/helloworld1.class"));
        outputStream.write(cw.toByteArray());
        outputStream.close();

        System.out.println(Type.getMethodType("(J)Ljava/lang/String;").getArgumentTypes()[0].getClassName());
        System.out.println(Type.getMethodType("(J)Ljava/lang/String;").getReturnType().getClassName());

    }


}
