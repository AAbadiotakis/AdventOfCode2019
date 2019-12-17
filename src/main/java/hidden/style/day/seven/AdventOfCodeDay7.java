package hidden.style.day.seven;

import hidden.style.util.IntCodeProgram;
import hidden.style.util.Utils;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AdventOfCodeDay7 {

    public static void main(String[] args) throws Exception {
        int ampA = 0;
        int ampB = 1;
        int ampC = 2;
        int ampD = 3;
        int ampE = 4;

        Scanner scan = Utils.getScan("src/main/java/hidden/style/day/seven/AdventOfCodeDay7Example2.txt");
        String inputString = scan.next();
        int[] inputArray = Arrays.stream(inputString.split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(inputArray);
        System.out.println("ampA = " + IntCodeProgram.decodeString(inputArray, ampA));
        System.out.println(inputArray);
        System.out.println("ampB = " + IntCodeProgram.decodeString(inputArray, ampB));
        System.out.println(inputArray);
        System.out.println("ampC = " + IntCodeProgram.decodeString(inputArray, ampC));
        System.out.println(inputArray);
        System.out.println("ampD = " + IntCodeProgram.decodeString(inputArray, ampD));
        System.out.println(inputArray);
        System.out.println("ampE = " + IntCodeProgram.decodeString(inputArray, ampE));
    }

}
