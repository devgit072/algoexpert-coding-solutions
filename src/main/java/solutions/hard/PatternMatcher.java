package solutions.hard;

public class PatternMatcher {
    public static String[] patternMatcher(String pattern, String str) {
        boolean swap = false;
        if (pattern.startsWith("y")) {
            pattern = pattern.replace("x", "m");
            pattern = pattern.replace("y", "x");
            pattern = pattern.replace("m", "y");
            swap = true;
        }
        int xCount = 0;
        int yCount = 0;
        int strLength = str.length();
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'x') {
                xCount++;
            } else {
                yCount++;
            }
        }
        int yIndexInPattern = pattern.indexOf('y');
        for (int i = 1; i < strLength; i++) {
            int xLen = i;
            //get y len now.
            if (yIndexInPattern != -1 && (strLength - xCount * xLen) % yCount != 0) {
                continue;
            }
            String xTrialString = str.substring(0, xLen);
            String yTrialString = "";
            if(yIndexInPattern != -1) {
                int yLen = (strLength - xCount * xLen) / yCount;
                int yIndexInString = yIndexInPattern * xLen;
                if (yLen >= 0 && yIndexInString + yLen <= str.length()) {
                    yTrialString = str.substring(yIndexInString, yIndexInString + yLen);
                }
            }

            String formedString = formString(xTrialString, yTrialString, pattern);
            if (formedString.equals(str)) {
                if (swap) {
                    return new String[]{yTrialString, xTrialString};
                } else {
                    return new String[]{xTrialString, yTrialString};
                }
            }
        }
        return new String[]{};
    }

    private static String formString(String x, String y, String pattern) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'x') {
                builder.append(x);
            } else {
                builder.append(y);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String[] values = patternMatcher("xxxx", "testtesttesttest");
        for (String value :
                values) {
            System.out.println(value);
        }
    }
}
