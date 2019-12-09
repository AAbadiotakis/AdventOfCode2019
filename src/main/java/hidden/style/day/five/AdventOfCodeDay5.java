package hidden.style.day.five;

import hidden.style.util.IntCodeProgram;
import hidden.style.util.Utils;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdventOfCodeDay5 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = Utils.getScan("src/main/java/hidden/style/day/five/AdventOfCodeDay5.txt");
        String inputString = scan.next();
        String[] inputArray = inputString.split(",");
        System.out.println("Answer Part 1: " + IntCodeProgram.decodeString(inputArray, 1));

        scan = Utils.getScan("src/main/java/hidden/style/day/five/AdventOfCodeDay5.txt");
        inputString = scan.next();
        inputArray = inputString.split(",");
        System.out.println("Answer Part 2: " + IntCodeProgram.decodeString(inputArray, 5));
    }
}
