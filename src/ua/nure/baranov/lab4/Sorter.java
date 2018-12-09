package ua.nure.baranov.lab4;

/**
 * Interface for classes which are used to perform sorting of double array.
 */
public interface Sorter {

    double[] sort(double[] array);

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
    default void compareAndExchange(double[] array, int i, int j) {
        if (array[i] > array[j]) {
            double temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
