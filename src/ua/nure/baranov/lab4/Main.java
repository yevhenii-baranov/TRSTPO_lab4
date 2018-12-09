package ua.nure.baranov.lab4;

public class Main {

    public static void main(String[] args) {

    }

    /**
     * Serial version of the "Odd-even sort".
     *
     * <p>It uses pairs of elements and swaps them if needed to get required order in array.
     * <p>The sorting pairs start from the first element on the first iteration, then from the
     * second one on the next iteration, then from first element again and so on.
     *
     * <p>This process lasts until all items are sorted or if the maximum number of iterations is
     * reached.
     *
     * @param arr array to sort
     * @param n   maximum number of iterations
     * @return resulting array
     */
    private double[] OddEvenSortSerial(final double[] arr, int n) {
        double[] array = arr.clone();
        for (int i = 1; i < n; i++) {
            if (i % 2 == 1) {
                for (int j = 0; j < n / 2 - 2; j++)
                    compareAndExchange(array, 2 * j + 1, 2 * j + 2);
                if (n % 2 == 1)
                    compareAndExchange(array, n - 2, n - 1);
            }
            if (i % 2 == 0)
                for (int j = 1; j < n / 2 - 1; j++)
                    compareAndExchange(array, 2 * j, 2 * j + 1);
        }
        return arr;
    }

    /**
     * Performs basic 'compare and exchange' sorting operation.
     *
     * This operation checks whether the which element is bigger and swaps them if first element to
     * compare is larger.
     *
     * Note that this operation directly mutates source array and therefore nothing needs to be
     * returned.
     *
     * @param array array where computations will be performed
     * @param i     index of first element in the comparison
     * @param j     index of second element in the comparison
     */
    private void compareAndExchange(double[] array, int i, int j) {
        if (array[i] > array[j]) {
            double temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}