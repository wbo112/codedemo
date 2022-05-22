package com.wbo112.demo1;

import com.wbo112.demo1.impl.MyHelloWorld;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Iterator;
import java.util.ServiceLoader;

public class HelloWorld {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        System.out.println(helloWorld.getClass().getName());
        System.out.println(helloWorld.getClass());


        //SPI service provide interface
        ServiceLoader<IHelloWorld> loads = ServiceLoader.load(IHelloWorld.class);
        Iterator<IHelloWorld> iterator = loads.iterator();
        while (iterator.hasNext()) {
            IHelloWorld next = iterator.next();
            System.out.println(next.hi());
        }

        System.out.println("========================");
        obainFields(Thread.class);
        System.out.println("========================");
        obainMethods(Thread.class);
        System.out.println("========================");
    }

    private static <T> void obainFields(Class<T> clazz) {

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType() + " " + field.getName());
        }
    }

    private static <T> void obainMethods(Class<T> clazz) {

        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            method.setAccessible(true);
            System.out.print(Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getSimpleName() + " " + method.getName() + "(");
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.print(parameter.getType() + " " + parameter.getName());
            }
            System.out.println(")");
        }
    }
}
