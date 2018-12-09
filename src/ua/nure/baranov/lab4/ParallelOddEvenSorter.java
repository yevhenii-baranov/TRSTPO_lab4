package ua.nure.baranov.lab4;

/**
 * Parallel iterative sorter which performs odd-even sorting.
 */
public class ParallelOddEvenSorter implements Sorter {

    public double[] sort(double[] arr) {
        double[] array = arr.clone();


        int startPosition = 0;
        for (int j = 0; j < arr.length; j++) {

            //omp parallel for
            for (int i = startPosition; i < arr.length - 1; i += 2) {
                compareAndExchange(array, i, i + 1);
            }

            startPosition = (startPosition + 1) % 2;
        }

        return array;
    }
}
