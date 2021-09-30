package com.devrajs.algoexpert.easy.medium;

import java.util.ArrayList;
import java.util.List;

public class ValidIP {
    static void validIp(String str, int currIndex, int remainingDots, String strSoFar, ArrayList<String> globalResult) {
        if(currIndex >= str.length() || remainingDots <= 0) {
            return;
        }
        for(int i=1;i<=3;i++) {
            if(currIndex+i > str.length()) {
                return;
            }
            String subStr = str.substring(currIndex, currIndex+i);
            if(isValidValue(subStr)) {
                String resultStr = "";
                if(remainingDots == 4) {
                    resultStr = subStr;
                } else {
                    resultStr = strSoFar + "." + subStr;
                }
                if (remainingDots == 1 && currIndex + i == str.length()) {
                   globalResult.add(resultStr);
                } else {
                    validIp(str, currIndex+i, remainingDots-1, resultStr, globalResult);
                }
            }
        }
    }

    private static boolean isValidValue(String val) {
        if(val.equals("0")) {
            return true;
        }
        if(val.equals("00") || val.equals("000") || val.startsWith("0")) {
            return false;
        }
        int intVal = Integer.parseInt(val);
        return intVal >= 0 && intVal <= 255;
    }
}
