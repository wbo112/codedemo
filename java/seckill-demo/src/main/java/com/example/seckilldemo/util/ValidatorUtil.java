package com.example.seckilldemo.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class ValidatorUtil {
    private static final Pattern mobile_pattern=Pattern.compile("[1]([3-9][0-9])");
    public static boolean isMobile(String mobile){
        if(StringUtils.isBlank(mobile)){
            return false;
        }
        return true;
    }
}
