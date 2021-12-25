package solutions.hard;

public class MaximizeExpression {
    public int maximizeExpressionBruteForce(int[] array) {
        int len = array.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len - 3; i++) {
            for (int j = i+1; j < len - 2; j++) {
                for (int k = j+1; k < len - 1; k++) {
                    for (int l = k+1; l < len; l++) {
                        int value = array[i] - array[j] + array[k] - array[l];
                        if (value > max) {
                            max = value;
                        }
                    }
                }
            }
        }
        if(max == Integer.MIN_VALUE) {
            return 0;
        }
        return max;
    }

    public int maximizeExpression(int[] array) {
        if(array.length < 4) {
            return 0;
        }
        int len = array.length;
        int[] a = new int[len];
        a[0] = array[0];
        for(int i=1;i<len;i++) {
            a[i] = Math.max(a[i-1], array[i]);
        }
        int[] aMinusB = new int[len];
        aMinusB[0] = 0;
        aMinusB[1] = a[0] - array[1];
        for(int i=2;i<len;i++) {
            aMinusB[i] = Math.max(aMinusB[i-1], a[i-1]-array[i]);
        }
        int[] aMinusBPlusC = new int[len];
        aMinusBPlusC[0]=0;
        aMinusBPlusC[1]=0;
        aMinusBPlusC[2]=aMinusB[1]+array[2];
        for(int i=3;i<len;i++) {
            aMinusBPlusC[i] = Math.max(aMinusBPlusC[i-1], aMinusB[i-1]+array[i]);
        }
        int[] aMinusBPlusCMinusD = new int[len];
        aMinusBPlusCMinusD[0] = 0;
        aMinusBPlusCMinusD[1] = 0;
        aMinusBPlusCMinusD[2] = 0;
        aMinusBPlusCMinusD[3] = aMinusBPlusC[2]-array[3];
        for(int i=4;i<len;i++) {
            aMinusBPlusCMinusD[i] = Math.max(aMinusBPlusCMinusD[i-1], aMinusBPlusC[i-1]-array[i]);
        }
        return aMinusBPlusCMinusD[len-1];
    }
}
