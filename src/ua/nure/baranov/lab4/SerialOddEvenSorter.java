package ua.nure.baranov.lab4;

/**
 * Serial iterative sorter which performs odd-even sorting.
 */
public class SerialOddEvenSorter implements Sorter {

    /**
     * Serial version of the "Odd-even sort".
     *
     * <p>It uses pairs of elements and swaps them if needed to get required order in array.
     * <p>The sorting pairs start from the first element on the first iteration, then from the
     * second one on the next iteration, then from first element again and so on.
     *
     * @param arr array to sort

     * @return resulting array
     */
    @Override
    public double[] sort(final double[] arr) {
        double[] array = arr.clone();
        int n = array.length;

        for (int i = 1; i < n; i++) {

            //For odd iteration, we take (1,2), (3,4) and so on
            if (i % 2 == 1) {
                for (int j = 0; j < array.length / 2 - 1; j++) {
                    compareAndExchange(array, 2 * j + 1, 2 * j + 2);
                }

                //And if the array has odd number of elements,
                // we perform additional comparison for the last element
                if (array.length % 2 == 1) {
                    compareAndExchange(array, array.length - 2, array.length - 1);
                }
            }
            //For even iteration, we take (0, 1), (2, 3) and so on
            else if (i % 2 == 0)
                for (int j = 0; j < array.length / 2 - 1; j++)
                    compareAndExchange(array, 2 * j, 2 * j + 1);
        }
        return array;
    }
}
