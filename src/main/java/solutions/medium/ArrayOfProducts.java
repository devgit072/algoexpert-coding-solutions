package solutions.medium;

public class ArrayOfProducts {
    public int[] arrayOfProducts(int[] array) {
        int[] leftProducts = new int[array.length];
        int[] rightProducts = new int[array.length];
        int[] productArr = new int[array.length];
        if (array.length < 1) {
            return new int[0];
        }
        if (array.length == 1) {
            productArr[0] = 0;
            return productArr;
        }
        leftProducts[0] = array[0];
        rightProducts[array.length - 1] = array[array.length - 1];
        for (int i = 1; i < leftProducts.length; i++) {
            leftProducts[i] = array[i] * leftProducts[i - 1];
        }
        for (int i = array.length - 2; i >= 0; i--) {
            rightProducts[i] = array[i] * rightProducts[i + 1];
        }
        productArr[0] = rightProducts[1];
        productArr[array.length - 1] = leftProducts[array.length - 2];
        for (int i = 1; i < array.length - 1; i++) {
            productArr[i] = leftProducts[i - 1] * rightProducts[i + 1];
        }
        return productArr;
    }
}
