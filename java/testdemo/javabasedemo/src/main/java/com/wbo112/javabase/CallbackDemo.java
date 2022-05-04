package com.wbo112.javabase;

import java.lang.reflect.Method;

public class CallbackDemo {
    public interface Callback {
    }

    private interface ConditionalCallback extends Callback {

        boolean isMatch(Method candidateMethod);
    }

    public static void main(String[] args) {
        System.out.println(( (ConditionalCallback)NoOp.INSTANCE).isMatch(null));
    }
    public interface NoOp extends Callback {
        NoOp INSTANCE = new NoOp() {
        };
    }

}
