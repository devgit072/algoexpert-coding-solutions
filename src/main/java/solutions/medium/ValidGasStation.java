package solutions.medium;

public class ValidGasStation {
    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int startIndex = -1;
        int currCredit = 0;
        for(int i = 0;i<distances.length;i++) {
            if(startIndex == -1) {
                // Always remember to make currCredit as 0, so that everything fresh
                // will be started from current index.
                /*
                   I was doing mistake with not making currIndex=0.
                 */
                currCredit = 0;
                startIndex = i;
            }
            currCredit += (fuel[i]*mpg) - distances[i];
            if(currCredit < 0) {
                startIndex = -1;
            }
        }
        return startIndex;
    }


    public static void main(String[] args) {
        int[] distances = new int[]{1, 3, 10, 6, 7, 7, 2, 4};
        int[] fuel = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        int mpg = 5;
        //int[] distances = new int[]{5, 25, 15, 10, 15};
        //int[] fuel = new int[]{1, 2, 1, 0, 3};
        //int mpg = 10;
        System.out.println(validStartingCity(distances, fuel, mpg));
    }
}
