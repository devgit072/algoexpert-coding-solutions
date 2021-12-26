package solutions.hard;

import java.util.ArrayList;
import java.util.List;

public class GenerateDivtags {
    static String openingTag = "<div>";
    static String closingTag = "</div>";
    public ArrayList<String> generateDivTags(int numberOfTags) {
        ArrayList<String> result = new ArrayList<>();
        generateDivTagsUtil(new StringBuilder(), result, 0, 0, numberOfTags);
        ArrayList<String> divResult = new ArrayList<>();
        for(String res : result) {
            String div = res;
            div = div.replace("(", openingTag);
            div = div.replace(")", closingTag);
            divResult.add(div);
        }

        return divResult;
    }
    static void generateDivTagsUtil(StringBuilder strSofar, List<String> result, int opening, int closing, int tagsCount) {
        if(strSofar.length() == tagsCount * 2) {
            result.add(strSofar.toString());
        }
        if(opening < tagsCount) {
            strSofar.append("(");
            generateDivTagsUtil(strSofar, result, opening+1, closing, tagsCount);
            // backtrack
            strSofar.deleteCharAt(strSofar.length() - 1);
        }
        if(closing < opening) {
            strSofar.append(")");
            generateDivTagsUtil(strSofar, result, opening, closing + 1, tagsCount);
            strSofar.deleteCharAt(strSofar.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        generateDivTagsUtil(new StringBuilder(), result, 0, 0, 3);
        for(String s : result) {
            System.out.println(s);
        }
    }
}
