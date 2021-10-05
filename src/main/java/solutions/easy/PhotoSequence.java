package solutions.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhotoSequence {
    public static void main(String[] args) {

    }

    public boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        List<Integer> redShirtCopy = new ArrayList<>(redShirtHeights);
        List<Integer> blueShirtCopy = new ArrayList<>(blueShirtHeights);
        Collections.sort(redShirtCopy);
        Collections.sort(blueShirtCopy);
        if (redShirtCopy.get(0) > blueShirtCopy.get(0)) {
            return checkIfArray1IsGreaterThanArray2(redShirtCopy, blueShirtCopy);
        } else {
            return checkIfArray1IsGreaterThanArray2(blueShirtCopy, redShirtCopy);
        }
    }

    public boolean checkIfArray1IsGreaterThanArray2(List<Integer> arr1, List<Integer> arr2) {
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) <= arr2.get(i)) {
                return false;
            }
        }
        return true;
    }

}
