package ua.nure.baranov.lab4;

import java.util.Arrays;

/**
 * Application's entry point.
 */
public class Main {

    public static void main(String[] args) {
        double[] arr = {5, 7, 2, 14, 121, 256, 134, 2005, 3, 2018};

        Sorter serial = new SerialOddEvenSorter();
        long startSerialTime = System.nanoTime();
        double[] result = serial.sort(arr);
        long endSerialTime = System.nanoTime();


        System.out.print("With serial sorting: ");
        System.out.println(Arrays.toString(result));
        System.out.println("Serial sort took " + (endSerialTime - startSerialTime)
                + " nanoseconds");
        System.out.println();


        Sorter parallel = new ParallelOddEvenSorter();
        long startParallelTime = System.nanoTime();
        double[] parallelResult = parallel.sort(arr);
        long endParallelTime = System.nanoTime();

        System.out.print("With parallel sorting: ");
        System.out.println(Arrays.toString(parallelResult));
        System.out.println("Parallel sort took " + (endParallelTime - startParallelTime)
                + " nanoseconds");
    }
}