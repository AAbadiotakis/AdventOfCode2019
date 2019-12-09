package hidden.style.day.five;

import hidden.style.util.IntCodeProgram;
import hidden.style.util.Utils;

import java.util.Arrays;
import java.util.Scanner;

public class AdventOfCodeDay5 {

    public static void main(String[] args) throws Exception {
        Scanner scan = Utils.getScan("src/main/java/hidden/style/day/five/AdventOfCodeDay5.txt");
        String inputString = scan.next();
        int[] inputArray = Arrays.stream(inputString.split(",")).mapToInt(Integer::parseInt).toArray();

        System.out.println("Answer Part 1: " + IntCodeProgram.decodeString(inputArray, 1));

        inputArray = Arrays.stream(inputString.split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Answer Part 2: " + IntCodeProgram.decodeString(inputArray, 5));
    }
}
