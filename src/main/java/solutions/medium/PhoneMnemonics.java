package solutions.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PhoneMnemonics {
    public List<String> phoneNumberMnemonics(String phoneNumber) {
        //return phoneNumberMnemonicsRecursive(phoneNumber);
        return phoneNumberMnemonicsNonRecursive(phoneNumber);
    }
    // Recursive solution.
    public List<String> phoneNumberMnemonicsRecursive(String phoneNumber) {
        if(phoneNumber.length() == 0) {
            return Collections.emptyList();
        }
        List<String> l1 = getStringForChar(phoneNumber.charAt(0));
        if(phoneNumber.length() == 1) {
            return l1;
        }
        List<String> remainingList = phoneNumberMnemonicsRecursive(phoneNumber.substring(1));
        return multiply(l1, remainingList);
    }

    // Non-Recursive solution.
    public List<String> phoneNumberMnemonicsNonRecursive(String phoneNumber) {
        char[] arr = phoneNumber.toCharArray();
        List<String> resultList = new ArrayList<>();
        for(int i=0;i<arr.length;i++) {
            List<String> l1 = getStringForChar(arr[i]);
            resultList = multiply(resultList, l1);
        }
        return resultList;
    }

    private List<String> getStringForChar(char ch) {
        if(ch == '1') {
            return Collections.singletonList("1");
        } else if( ch == '2') {
            return List.of("a", "b", "c");
        } else if(ch == '3') {
            return List.of("d", "e", "f");
        } else if(ch == '4') {
            return List.of("g", "h", "i");
        } else if (ch == '5') {
            return List.of("j", "k", "l");
        } else if(ch == '6') {
            return List.of("m", "n", "o");
        } else if(ch == '7') {
            return List.of("p","q","r","s");
        } else if(ch == '8') {
            return List.of("t", "u", "v");
        } else if(ch == '9') {
            return List.of("w","x","y","z");
        } else if(ch == '0') {
            return Collections.singletonList("0");
        } else {
            System.out.println("Error: Invalid char");
            return Collections.emptyList();
        }
    }

    List<String> multiply(List<String> l1, List<String> l2) {
        if(l1.isEmpty()) {
            return l2;
        } else if (l2.isEmpty()) {
            return l1;
        }
        List<String> res = new ArrayList<>();
        for(String l : l1) {
            for (String s : l2) {
                res.add(l + s);
            }
        }
        return res;
    }
}
