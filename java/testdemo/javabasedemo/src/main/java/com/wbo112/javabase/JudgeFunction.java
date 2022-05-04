package com.wbo112.javabase;

import java.io.InputStream;

@FunctionalInterface
interface MyFunction {
    boolean processInputStream(InputStream zipInputStream, String str);
}
