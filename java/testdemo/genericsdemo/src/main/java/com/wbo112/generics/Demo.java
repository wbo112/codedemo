package com.wbo112.generics;


import java.lang.reflect.*;

public class Demo {
    public static void main(String[] args) {

        System.out.println("=========================");
        Field[] fields = TestA.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            printType(field.getGenericType());
        }


        Method[] methods = TestA.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("=========================");
            method.setAccessible(true);

            System.out.println("方法返回类型===");
            printType(method.getGenericReturnType());
            System.out.println();
            System.out.println("方法参数类型===");
            for (Type parameterType : method.getGenericParameterTypes()) {
                System.out.println(parameterType.getTypeName());
                printType(parameterType);

            }
        }


    }

    private static void printType(Type type) {
        //如果类型是ParameterizedType,就表示是泛型参数
        if (type instanceof ParameterizedType) {

            ParameterizedType parameterizedType = (ParameterizedType) type;
            //获取实际的泛型参数
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            //获取原生的类型
            System.out.println("擦除后的参数原生类型：" + parameterizedType.getRawType());
            for (Type argument : actualTypeArguments) {
                //获取泛型参数
                System.out.println("泛型参数 ：" + argument.getTypeName());
            }


        }
    }
}
