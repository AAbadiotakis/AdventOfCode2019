package hidden.style.day.five;

import hidden.style.util.Utils;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AoCDay5 {

    public static void printArray(String[] arr) {
        for(String str : arr) {
            System.out.print(str + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = Utils.getScan("src/hidden/style/day/five/AdventOfCodeDay5.txt");
        int inputValue = 1;

        while(scan.hasNext()) {
            String str = scan.next();
            String[] arr = str.split(",");
            printArray(arr);
            int pos = 0;

            while (true) {
                if(pos > arr.length) {
                    System.out.println("Reached pos > arr length");
                    printArray(arr);
                    return;
                }
                String fullCode = arr[pos];
                int firstParameter = 0;
                int secondParameter = 0;
                int thirdParameter = 0;
                if(fullCode.length() > 2) {
                    String partialCode = fullCode.substring(0, fullCode.length() - 2);
                    if(partialCode.length() == 3) {
                        thirdParameter = Integer.parseInt(partialCode.substring(0,1));
                        secondParameter = Integer.parseInt(partialCode.substring(1,2));
                        firstParameter = Integer.parseInt(partialCode.substring(2,3));
                    } else if(partialCode.length() == 2) {
                        secondParameter = Integer.parseInt(partialCode.substring(0,1));
                        firstParameter = Integer.parseInt(partialCode.substring(1,2));
                    } else if(partialCode.length() == 1) {
                        firstParameter = Integer.parseInt(partialCode.substring(0,1));
                    }
                }
                int opCode = Integer.parseInt(fullCode);
                if(fullCode.length() > 2) {
                    opCode = Integer.parseInt(arr[pos].substring(arr[pos].length() - 2));
                }

                if (opCode == 99) {
                    printArray(arr);
                    return;
                } else if (opCode == 1) {
                    pos++;
                    int val1;
                    if(firstParameter == 1) {
                        val1 = Integer.parseInt(arr[pos]);
                    } else {
                        val1 = Integer.parseInt(arr[Integer.parseInt(arr[pos])]);
                    }
                    pos++;
                    int val2;
                    if(secondParameter == 1) {
                        val2 = Integer.parseInt(arr[pos]);
                    } else {
                        val2 = Integer.parseInt(arr[Integer.parseInt(arr[pos])]);
                    }
                    pos++;
                    int val3 = Integer.parseInt(arr[pos]);
                    arr[val3] = Integer.toString(val1 + val2);
                    System.out.println("Updating position " + val3 + " to " + (val1 + val2));
                    pos++;
                } else if(opCode == 2) {
                    pos++;
                    int val1;
                    if(firstParameter == 1) {
                        val1 = Integer.parseInt(arr[pos]);
                    } else {
                        val1 = Integer.parseInt(arr[Integer.parseInt(arr[pos])]);
                    }
                    pos++;
                    int val2;
                    if(secondParameter == 1) {
                        val2 = Integer.parseInt(arr[pos]);
                    } else {
                        val2 = Integer.parseInt(arr[Integer.parseInt(arr[pos])]);
                    }
                    pos++;
                    int val3 = Integer.parseInt(arr[pos]);
                    arr[val3] = Integer.toString(val1 * val2);
                    System.out.println("Updating position " + val3 + " to " + (val1 * val2));
                    pos++;
                } else if(opCode == 3) {
                    pos++;
                    int val1 = Integer.parseInt(arr[pos]);
                    arr[val1] = String.valueOf(inputValue);
                    System.out.println("Updating position " + val1 + " to " + inputValue);
                    pos++;
                } else if(opCode == 4) {
                    pos++;
                    int val1 = Integer.parseInt(arr[Integer.parseInt(arr[pos])]);
                    System.out.println("Output: " + val1);
                    pos++;
                } else if(opCode == 5) {
                    pos++;
                    if(firstParameter == 1) {
                        if(pos != 0) {
                            pos = Integer.parseInt(arr[pos]);
                            System.out.println("moving position to " + pos);
                        }
                    } else {
                        if(Integer.parseInt(arr[pos]) != 0) {
                            pos = Integer.parseInt(arr[Integer.parseInt(arr[pos])]);
                            System.out.println("moving position to " + pos);
                        }
                    }
                } else if(opCode == 6) {
                    pos++;
                    if(firstParameter == 1) {
                        if(pos == 0) {
                            pos = Integer.parseInt(arr[pos]);
                            System.out.println("Moving position to " + pos);
                        }
                    } else {
                        if(Integer.parseInt(arr[pos]) == 0) {
                            pos = Integer.parseInt(arr[Integer.parseInt(arr[pos])]);
                            System.out.println("Moving position to " + pos);
                        }
                    }
                } else if(opCode == 7) {
                    pos++;
                    int val1;
                    if(firstParameter == 1) {
                        val1 = Integer.parseInt(arr[pos]);
                    } else {
                        val1 = Integer.parseInt(arr[Integer.parseInt(arr[pos])]);
                    }
                    pos++;
                    int val2;
                    if(secondParameter == 1) {
                        val2 = Integer.parseInt(arr[pos]);
                    } else {
                        val2 = Integer.parseInt(arr[Integer.parseInt(arr[pos])]);
                    }
                    pos++;
                    if(val1 < val2) {
                        arr[pos] = String.valueOf(1);
                        System.out.println("Updating position " + pos + " to 1");
                    } else {
                        arr[pos] = String.valueOf(0);
                        System.out.println("Updating position " + pos + " to 0");
                    }
                } else if(opCode == 8) {
                    pos++;
                    int val1;
                    if(firstParameter == 1) {
                        val1 = Integer.parseInt(arr[pos]);
                    } else {
                        val1 = Integer.parseInt(arr[Integer.parseInt(arr[pos])]);
                    }
                    pos++;
                    int val2;
                    if(secondParameter == 1) {
                        val2 = Integer.parseInt(arr[pos]);
                    } else {
                        val2 = Integer.parseInt(arr[Integer.parseInt(arr[pos])]);
                    }
                    pos++;
                    if(val1 == val2) {
                        arr[pos] = String.valueOf(1);
                        System.out.println("Updating position " + pos + " to 1");
                    } else {
                        arr[pos] = String.valueOf(0);
                        System.out.println("Updating position " + pos + " to 0");
                    }
                } else {
                    System.out.println("Error, opCode not found: " + opCode + " at position " + pos);
                    printArray(arr);
                    return;
                }
            }
        }


    }
}
