package solutions.medium;

public class LongestSubstringPalindrome {
    public static String longestPalindromicSubstring(String str) {
        char[] arr = str.toCharArray();
        String longestStr = "";
        for(int i=0;i<str.length();i++) {
            int x = i-1;
            int y = i+1;
            String longestLocal = str.charAt(i) + "";
            while(x >=0 && y < arr.length) {
                if(arr[x] == arr[y]) {
                    longestLocal = str.substring(x,y+1);
                    x--;y++;
                } else {
                    break;
                }
            }
            if(longestLocal.length() > longestStr.length()) {
                longestStr = longestLocal;
            }
        }
        for(int i=1;i<str.length();i++) {
            int x = i-1;
            int y = i;
            String longestLocal = "";
            while(x >=0 && y < arr.length) {
                if(arr[x] == arr[y]) {
                    longestLocal = str.substring(x,y+1);
                    x--;y++;
                } else {
                    break;
                }
            }
            if(longestLocal.length() > longestStr.length()) {
                longestStr = longestLocal;
            }
        }
        return longestStr;
    }

    public static void main(String[] args) {
        String str = "abaxyzzyxf";
        String res = longestPalindromicSubstring(str);
        System.out.println(res);
    }
}
