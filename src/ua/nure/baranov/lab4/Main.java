package ua.nure.baranov.lab4;

import java.util.Arrays;

/**
 * Application's entry point.
 */
public class Main {

    public static void main(String[] args) {
        double[] arr = {5, 7, 2, 14, 121, 256, 134, 2005, 3, 2018};

        Sorter serial = new SerialOddEvenSorter();
        double[] result = serial.sort(arr);

        System.out.println(Arrays.equals(arr, result));
        System.out.println(Arrays.toString(result));

        //omp parallel
        System.out.println("I have nothing to do");
    }
}