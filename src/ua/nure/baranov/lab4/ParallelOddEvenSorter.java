package ua.nure.baranov.lab4;

/**
 * Parallel iterative sorter which performs odd-even sorting.
 */
public class ParallelOddEvenSorter implements Sorter {

    public double[] sort(double[] arr) {
        double[] array = arr.clone();

        //TODO: I don't know how to fix hardcoded number, but if array is not of size 10, number here
        //TODO: should be changed to arr.length
        //omp parallel threadNum(10) public(array)
        {
            int thisProcessor = OMP4J_THREAD_NUM;
            int num_processors = OMP4J_NUM_THREADS;

            for (int i = 0; i < num_processors; i++) {
                if (i % 2 == 1) {
                    // On odd iteration
                    if (thisProcessor % 2 == 1) {
                        // нечетный номер процесса
                        // сравнение-обмен с процессом - соседом справа
                        if (thisProcessor < num_processors - 1)
                            compare_split_min(array, thisProcessor + 1);
                    } else
                        // сравнение-обмен с процессом - соседом слева
                        if (thisProcessor > 0) compare_split_max(array, thisProcessor - 1);
                }
                if (i % 2 == 0) {
                    // четная итерация
                    if (thisProcessor % 2 == 0) {
                        // четный номер процесса
                        // сравнение-обмен с процессом - соседом справа
                        if (thisProcessor < num_processors - 1)
                            compare_split_min(array, thisProcessor + 1);
                    } else
                        // сравнение-обмен с процессом - соседом слева
                        compare_split_max(array, thisProcessor - 1);
                }
                //omp barrier
                {
                }
            }
        }
        return array;
    }

    private void compare_split_max(double[] array, int currentProcessor) {
        this.compareAndExchange(array, currentProcessor, currentProcessor + 1);
    }

    private void compare_split_min(double[] array, int currentProcessor) {
        this.compareAndExchange(array, currentProcessor - 1, currentProcessor);
    }
}
