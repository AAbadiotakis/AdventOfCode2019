package hidden.style.day.two;

import hidden.style.util.Utils;

import java.io.IOException;
import java.util.Scanner;

public class AoCDay2Part2 {

    public static void printArray(String[] arr) {
        for(String str : arr) {
            System.out.print(str + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = Utils.getScan("src/hidden/style/day/two/AdventOfCodeDay2.txt");
        String str = scan.next();
        String[] arr = str.split(",");

        while(true) {
            for (int noun = 0; noun <= 99; noun++ ) {
                for (int verb = 0; verb <= 99; verb++) {
                    scan = Utils.getScan("src/hidden/style/day/two/AdventOfCodeDay2.txt");
                    str = scan.next();
                    arr = str.split(",");
                    arr[1] = Integer.toString(noun);
                    arr[2] = Integer.toString(verb);
                    int pos = 0;
                    while (true) {
                        int opCode = Integer.parseInt(arr[pos]);
                        if (opCode == 99) {
                            /* Finished */
                            break;
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
//                    System.out.println("Array output = " + arr[0] + " for noun = " + noun + ", verb = " + verb);
                    if( arr[0].equalsIgnoreCase("19690720")) {
                        System.out.println("Answer found: " + (100 * noun + verb));
                        return;
                    }
                    if ( noun == 99 && verb == 99) {
                        System.out.println("Finished with no matches");
                        return;
                    }
                }
            }
        }
    }
}
