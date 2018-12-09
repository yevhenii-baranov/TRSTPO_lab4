#!/bin/bash
JAVADIR=src/ua/nure/baranov/lab4
java -jar omp4j-1.2.jar -d result -v "$JAVADIR/Sorter.java" "$JAVADIR/ParallelOddEvenSorter.java" "$JAVADIR/SerialOddEvenSorter.java" "$JAVADIR/Main.java"
