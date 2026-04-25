// Ex 6.5
//Write a Java program to sort a numeric array, and calculate the sum and average value of
//array elements.

import java.util.Arrays;

public class Array{
    public static void main(String[] args) {
        int[] array = {10, 3, 20, 4, 5};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(array));

        // Sort the array
        Arrays.sort(array);

        System.out.println("\nSorted Array: ");
        System.out.println(Arrays.toString(array));

        int sum = 0;
        for(int i=0; i<array.length; i++) {
            sum += array[i];
        }
        double average = (double)sum / array.length;

        System.out.println("\nSum of Array Elements: " + sum);
        System.out.printf("Average Value of Array Elements: %.2f\n", average);

    }
}