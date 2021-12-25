package solutions.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonSubsequence {
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        List<Character>[][] val = new List[str1.length()+1][str2.length()+1];
        for(int i=0;i<str1.length();i++) {
            for(int j=0;j<str2.length();j++) {
                val[i][j] = null;
            }
        }
        longestCommonSubsequenceUtil(str1.toCharArray(), str2.toCharArray(), 0, 0, val);
        if(val[0][0] == null) {
            return new ArrayList<>();
        }
        return val[0][0];
    }

    public static List<Character> longestCommonSubsequenceUtil(char[] chArr1, char[] chArr2, int index1, int index2, List[][] val) {
        if(val[index1][index2] != null) {
            return val[index1][index2];
        }

        if(index1 >= chArr1.length || index2 >= chArr2.length) {
            return new ArrayList<>();
        }

        List<Character> list = new ArrayList<>();
        if(chArr1[index1] == chArr2[index2]) {
            list.add(chArr1[index1]);
            List<Character> subList = longestCommonSubsequenceUtil(chArr1, chArr2, index1+1, index2+1, val);
            list.addAll(subList);
            val[index1][index2] = list;
            return list;
        } else {
            List<Character> subList1 = longestCommonSubsequenceUtil(chArr1, chArr2, index1+1, index2, val);
            List<Character> subList2 = longestCommonSubsequenceUtil(chArr1, chArr2, index1, index2+1, val);
            if(subList1.size() > subList2.size()) {
                val[index1][index2] = subList1;
                return subList1;
            } else {
                val[index1][index2] = subList2;
                return subList2;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("8111111111111111142", "222222222822222222222222222222433333333332"));
        //System.out.println(longestCommonSubsequence("", ""));
    }
}