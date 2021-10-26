package solutions.medium;

public class LevenshteinDistance {
    public static int levenshteinDistance(String str1, String str2) {
        int[][] memoi = new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<str1.length();i++) {
            for(int j=0;j < str2.length();j++) {
                memoi[i][j] = -1;
            }
        }
        return levenshteinDistanceUtil(str1, str2, 0, 0, memoi);
    }

    public static int levenshteinDistanceUtil(String str1, String str2, int i, int j, int[][] memoi) {
        if (i == str1.length()) {
            memoi[i][j] = str2.length() - j;
        } else if (j == str2.length()) {
            memoi[i][j] = str1.length() - i;
        }
        if(memoi[i][j] != -1) {
            return memoi[i][j];
        }
        int replaceCounter = 1;
        if(str1.charAt(i) == str2.charAt(j)) {
            replaceCounter = 0;
        }
        int replaceCount = levenshteinDistanceUtil(str1, str2, i+1, j+1, memoi) + replaceCounter;
        int insertCount = levenshteinDistanceUtil(str1, str2, i, j+1, memoi) + 1;
        int deleteCount = levenshteinDistanceUtil(str1, str2, i+1, j, memoi) + 1;

        return getMin(replaceCount, insertCount, deleteCount);
    }

    private static int getMin(int a, int b, int c) {
        return Integer.min(Integer.min(a, b), c);
    }
}
