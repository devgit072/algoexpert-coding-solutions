package solutions.hard;

public class StringInterweaving {
    public static boolean interweavingStrings(String one, String two, String three) {
        Boolean[][] memo = new Boolean[one.length() + 1][two.length() + 1];
        util(one, two, three, 0, 0, 0, memo);
        return memo[0][0];
    }

    private static boolean util(String one, String two, String three, int index1, int index2, int index3, Boolean[][] memo) {
        if (memo[index1][index2] != null) {
            return memo[index1][index2];
        }
        if (index3 == three.length() && index1 == one.length() && index2 == two.length()) {
            memo[index1][index2] = true;
            return true;
        }
        if (index3 == three.length()) {
            memo[index1][index2] = false;
            return false;
        }
        if (index1 < one.length() && index2 < two.length() && one.charAt(index1) == three.charAt(index3)
                && two.charAt(index2) == three.charAt(index3)) {
            boolean res1 = util(one, two, three, index1 + 1, index2, index3 + 1, memo);

            if (res1) {
                memo[index1][index2] = true;
            } else {
                boolean res2 = util(one, two, three, index1, index2 + 1, index3 + 1, memo);
                memo[index1][index2] = res2;
            }
        } else if (index1 < one.length() && one.charAt(index1) == three.charAt(index3)) {
            memo[index1][index2] = util(one, two, three, index1 + 1, index2, index3 + 1, memo);
        } else if (index2 < two.length() && two.charAt(index2) == three.charAt(index3)) {
            memo[index1][index2] = util(one, two, three, index1, index2 + 1, index3 + 1, memo);
        } else {
            memo[index1][index2] = false;
        }
        return memo[index1][index2];
    }

    public static void main(String[] args) {
        String one = "algoexpert";
        String three = "ayloguore-xdpreeratm-job";
        String two = "your-dream-job";
        System.out.println(interweavingStrings(one, two, three));
    }
}
