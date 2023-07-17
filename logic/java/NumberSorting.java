package examplejava;

import java.util.stream.Collectors;
import java.util.*;

class NumberSorting {
    public static int sortArrayAsc(int[] a, Boolean returnLargest) {
        int temp;
        int total = a.length;
        for (int i = 0; i < total; i++) {
            for (int j = i + 1; j < total; j++) {
                if (a[i] > a[j]) { // if you want sorting Desc, just invert this comparison
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        // printing out sorted result
        for (int i = 0; i < total; i++) {
            System.out.println(a[i]);
        }

        int result = (returnLargest) ? a[total - 1] : a[0];
        return result;
    }

    public static Boolean isPrime(int n, int startingNumber) {
        // Corner cases
        if (n == 0 || n == 1) {
            return false;
        }

        // Checking Prime
        if (n == startingNumber)
            return true;

        // Base cases
        if (n % startingNumber == 0) {
            return false;
        }
        startingNumber++;
        return isPrime(n, startingNumber);
    }

    static void getOccuringChar(String str) {
        int count[] = new int[256];

        // finds the length of the string
        int len = str.length();

        // initialize count array index
        for (int i = 0; i < len; i++) {
            count[str.charAt(i)]++;
        }

        // create an array of given String size
        char ch[] = new char[str.length()];
        for (int i = 0; i < len; i++) {
            ch[i] = str.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {
                // if any matches found
                if (str.charAt(i) == ch[j]) {
                    find++;
                }
            }
            if (find == 1)
                System.out.println("The occurrence of " + str.charAt(i) + " is: " +
                        count[str.charAt(i)]);
        }

        // System.out.println(count.length);
    }

    static int getOccuringNumber(int[] data, int searchKeyword) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == searchKeyword) {
                count++;
            }
        }

        // System.out.println("number of occurence of " + searchKeyword + ": " + count);
        return count;
    }

    public static void main(String[] aStrings) {
        // sortArrayAsc implementation
        int[] numberArray = { 9, 8, 10, 15, 1, 3 };
        System.out.println("Largest: " + String.valueOf(sortArrayAsc(numberArray, true)));

        // isPrime implementation
        System.out.println("is prime: " + isPrime(4, 2));

        // getOccuringChar implementation
        getOccuringChar("luukiiiiiii");

        // getOccuringChar, but using Java 8
        // String str = "Communication";
        // Map<String, Long> result =
        // Arrays.stream(str.split("")).map(String::toLowerCase)
        // .collect(Collectors.groupingBy(s -> s, LinkedHashMap::new,
        // Collectors.counting()));
        // System.out.println(result);

        // getOccuringNumber implementation
        int[] numberOccuring = { 1, 1, 1, 1, 5, 5, 5, 6, 7, 8, 8 };
        System.out.println(getOccuringNumber(numberOccuring, 8));
    }
}