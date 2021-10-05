package solutions.medium;

import java.util.List;

public class MoveElementToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int leftP = 0;
        int rightP = array.size()-1;
        while(leftP < rightP) {
            while (array.get(leftP) != toMove && leftP < rightP) {
                leftP++;
            }
            while (array.get(rightP) == toMove && leftP < rightP) {
                rightP--;
            }
            if(leftP >= rightP) {
                break;
            }
            // swap elements left and right pointers
            int temp = array.get(leftP);
            array.set(leftP, array.get(rightP));
            array.set(rightP, temp);
            leftP++;
            rightP--;
        }
        return array;
    }
}
