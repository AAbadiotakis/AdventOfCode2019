package hidden.style.day.two;

import hidden.style.util.Utils;

import java.io.IOException;
import java.util.Scanner;

public class AoCDay2 {

    public static void printArray(String[] arr) {
        for(String str : arr) {
            System.out.print(str + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = Utils.getScan("src/hidden/style/day/two/AdventOfCodeDay5.txt");
        while(scan.hasNext()) {
            String str = scan.next();
            String[] arr = str.split(",");
            int pos = 0;
            while (true) {
                int opCode = Integer.parseInt(arr[pos]);
                if (opCode == 99) {
                    /* Finished */
                    printArray(arr);
                    return;
                }
                pos++;
                int val1 = Integer.parseInt(arr[Integer.parseInt(arr[pos])]);
                pos++;
                int val2 = Integer.parseInt(arr[Integer.parseInt(arr[pos])]);
                pos++;
                int val3 = Integer.parseInt(arr[pos]);
                pos++;
                if (opCode == 1) {
                    /* Addition */
                    arr[val3] = Integer.toString(val1 + val2);
                } else if (opCode == 2) {
                    /* Multiplication */
                    arr[val3] = Integer.toString(val1 * val2);
                }
            }
        }
    }
}
