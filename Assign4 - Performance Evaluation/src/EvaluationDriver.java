// Justin Herzog A02306067

/**
 * Assignment 4 for CS 1410
 * This program evaluates the linear and binary searching, along
 * with comparing performance difference between the selection sort
 * and the built-in java.util.Arrays.sort.
 *
 * @author James Dean Mathias
 * @author Justin Tyler Herzog
 */

import java.lang.Math;
import java.util.Arrays;

public class EvaluationDriver {
    static final int MAX_VALUE = 1_000_000;
    static final int MAX_ARRAY_SIZE = 100_000;
    static final int ARRAY_INCREMENT = 20_000;
    static final int NUMBER_SEARCHES = 50_000;

    public static void main(String[] args) {

         int[] array = {-42, -7, 0, 2, 9, 21, 44, 65, 73, 81};

         System.out.println(binarySearch(array, 2));

         demoLinearSearchUnsorted();
         demoLinearSearchSorted();
         demoBinarySearchSelectionSort();
         demoBinarySearchFastSort();
    }

    public static int[] generateNumbers(int howMany, int maxValue) {
        // Checks to see that howMany is valid
        if (howMany <= 0) {
            System.out.printf("The array must be greater than or equal to one. You asks for an array of %d\n", howMany);
            return null;
        }
        // Creates an array of length howMany.
        int[] randomNumbers = new int[howMany];

        // Puts the random values of into the array howMany
        for (int i = 0; i < howMany; i++) {
            randomNumbers[i] = (int) (maxValue * Math.random());
        }

        return randomNumbers;

    }

    public static boolean linearSearch(int[] data, int search) {

        boolean found = false;

        for (int i = 0; i < data.length; i++) {
            if (data[i] == search) {
                found = true;
                break;
            }
        }

        return found;
    }

    public static boolean binarySearch(int[] data, int search) {

        boolean found = false;

        // Write code that binary searches an array of data for a specified value.
        // Checks that it is possible that 'search' exists within data, so we can do a for loop.

        int index = (int) ((data.length / 2) + 0.5);
        int floor = 0;
        int ceiling = data.length - 1;
        while (!found) {
            // Checks to see if 'search' is equal to the value at the current index.
            if (data[index] == search) {
                found = true;

            } // Checks to see if 'search' is greater than the value at the current index.
            else if (data[index] < search) {
                if (floor == index) {
                    break;
                }
                floor = index;
                if ((((double) ceiling - index) % 2) == 0) {
                    index = (int) (index + (((double) ceiling - index) / 2));
                }
                else {
                    index = (int) (index + ((((double) ceiling - index) / 2) + 0.5));
                }

            } // Checks to see if 'search' is less than the value at the current index.
            else if (data[index] > search) {
                if (ceiling == index) {
                    break;
                }
                ceiling = index;
                if (((index - (double) floor) % 2) == 0) {
                    index = (int) (index - ((index - (double) floor) / 2));
                }
                else {
                    index = (int) (index - (((index - (double) floor) / 2) + 0.5));
                }

            }

            // Checks to see if the number is not in the array.
            if (floor == ceiling) {
                break;
            }

        }

        return found;
    }

    // sorts an array of integers for lowest to highest
    public static void selectionSort(int[] data) {

        int startingIndex = 0;
        // Runs a loop as long as the array is.
        while (startingIndex < data.length) {
            int lowestValue = Integer.MAX_VALUE;
            int positionToSwap = startingIndex;
            for (int i = startingIndex; i < data.length; i++) {
                if (data[i] < lowestValue) {
                    lowestValue = data[i];
                    positionToSwap = i;
                }
            }

            int tempStorage = data[startingIndex];
            data[startingIndex] = lowestValue;
            data[positionToSwap] = tempStorage;
            startingIndex++;

        }

    }


    public static void demoLinearSearchUnsorted() {

        int amountOfRandomNumbers = ARRAY_INCREMENT;

        System.out.print("--- Linear Search Timing (unsorted) ---\n");

        while (amountOfRandomNumbers <= MAX_ARRAY_SIZE) {
            int timesFound = 0;
            long startTime = System.currentTimeMillis();

            int[] randomNumbers = generateNumbers(amountOfRandomNumbers, MAX_VALUE);

            for (int i = 0; i < NUMBER_SEARCHES; i++) {
                 int searchTerm = (int) (Math.random() * MAX_VALUE);

                 if (linearSearch(randomNumbers, searchTerm)) {
                     timesFound += 1;
                }
            }

            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;

            System.out.printf("%-21s : %-7d \n", "Number of items", amountOfRandomNumbers);
            System.out.printf("%-21s : %-7d \n", "Times value was found", timesFound);
            System.out.printf("%-21s : %d ms\n", "Total search time", totalTime);
            System.out.println();

            amountOfRandomNumbers += 20000;

        }

    }

    public static void demoLinearSearchSorted() {

        int amountOfRandomNumbers = ARRAY_INCREMENT;

        System.out.print("--- Linear Search Timing (Selection Sort) ---\n");

        while (amountOfRandomNumbers <= MAX_ARRAY_SIZE) {
            int timesFound = 0;
            long startTime = System.currentTimeMillis();

            int[] randomNumbers = generateNumbers(amountOfRandomNumbers, MAX_VALUE);
            selectionSort(randomNumbers);

            for (int i = 0; i < NUMBER_SEARCHES; i++) {
                int searchTerm = (int) (Math.random() * MAX_VALUE);

                if (linearSearch(randomNumbers, searchTerm)) {
                    timesFound += 1;
                }
            }

            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;

            System.out.printf("%-21s : %-7d \n", "Number of items", amountOfRandomNumbers);
            System.out.printf("%-21s : %-7d \n", "Times value was found", timesFound);
            System.out.printf("%-21s : %d ms\n", "Total search time", totalTime);
            System.out.println();

            amountOfRandomNumbers += 20000;

        }

    }

    public static void demoBinarySearchSelectionSort() {

        int amountOfRandomNumbers = ARRAY_INCREMENT;

        System.out.print("--- Binary Search Timing (Selection Sort) ---\n");

        while (amountOfRandomNumbers <= MAX_ARRAY_SIZE) {
            int timesFound = 0;
            long startTime = System.currentTimeMillis();

            int[] randomNumbers = generateNumbers(amountOfRandomNumbers, MAX_VALUE);
            selectionSort(randomNumbers);

            for (int i = 0; i < NUMBER_SEARCHES; i++) {
                int searchTerm = (int) (Math.random() * MAX_VALUE);

                if (binarySearch(randomNumbers, searchTerm)) {
                    timesFound += 1;
                }
            }

            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;

            System.out.printf("%-21s : %-7d \n", "Number of items", amountOfRandomNumbers);
            System.out.printf("%-21s : %-7d \n", "Times value was found", timesFound);
            System.out.printf("%-21s : %d ms\n", "Total search time", totalTime);
            System.out.println();

            amountOfRandomNumbers += 20000;

        }
    }

    public static void demoBinarySearchFastSort() {

        int amountOfRandomNumbers = ARRAY_INCREMENT;

        System.out.print("--- Binary Search Timing (Arrays.sort) ---\n");

        while (amountOfRandomNumbers <= MAX_ARRAY_SIZE) {
            int timesFound = 0;
            long startTime = System.currentTimeMillis();

            int[] randomNumbers = generateNumbers(amountOfRandomNumbers, MAX_VALUE);
            Arrays.sort(randomNumbers);

            for (int i = 0; i < NUMBER_SEARCHES; i++) {
                int searchTerm = (int) (Math.random() * MAX_VALUE);

                if (binarySearch(randomNumbers, searchTerm)) {
                    timesFound += 1;
                }
            }

            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;

            System.out.printf("%-21s : %-7d \n", "Number of items", amountOfRandomNumbers);
            System.out.printf("%-21s : %-7d \n", "Times value was found", timesFound);
            System.out.printf("%-21s : %d ms\n", "Total search time", totalTime);
            System.out.println();

            amountOfRandomNumbers += 20000;

        }
    }

}
