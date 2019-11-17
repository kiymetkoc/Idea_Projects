package com.cbt.utilities;

public class StringUtility {
    public static boolean verifyEquals(String expected, String actual){
        System.out.println(expected.equals(actual)? "PASS" : "FAIL");
        return expected.equals(actual);
    }
}
