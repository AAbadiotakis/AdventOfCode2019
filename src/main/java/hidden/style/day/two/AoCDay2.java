package hidden.style.day.two;

import hidden.style.util.IntCodeProgram;
import hidden.style.util.Utils;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AoCDay2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = Utils.getScan("src/main/java/hidden/style/day/two/AdventOfCodeDay2.txt");
        String inputString = scan.next();
        String[] inputArray = inputString.split(",");
        System.out.println("Answer Part 1: " + IntCodeProgram.decodeString(inputArray, null));

        for (int noun = 0; noun < 99; noun++) {
            for (int verb = 0; verb < 99; verb++) {
                scan = Utils.getScan("src/main/java/hidden/style/day/two/AdventOfCodeDay2.txt");
                inputString = scan.next();
                inputArray = inputString.split(",");
                inputArray[1] = String.valueOf(noun);
                inputArray[2] = String.valueOf(verb);
                if (IntCodeProgram.decodeString(inputArray, null) == 19690720) {
                    System.out.println("Answer Part 2: " + (100 * noun + verb));
                }
            }
        }
    }
}
