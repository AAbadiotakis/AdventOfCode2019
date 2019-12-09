package hidden.style.day.two;

import hidden.style.util.IntCodeProgram;
import hidden.style.util.Utils;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AoCDay2 {

    public static void main(String[] args) throws Exception {
        Scanner scan = Utils.getScan("src/main/java/hidden/style/day/two/AdventOfCodeDay2.txt");
        String inputString = scan.next();
        int[] inputArray = Arrays.stream(inputString.split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Answer Part 1: " + IntCodeProgram.decodeString(inputArray, null));

        for (int noun = 0; noun < 99; noun++) {
            for (int verb = 0; verb < 99; verb++) {
                inputArray = Arrays.stream(inputString.split(",")).mapToInt(Integer::parseInt).toArray();
                inputArray[1] = noun;
                inputArray[2] = verb;
                if (IntCodeProgram.decodeString(inputArray, null) == 19690720) {
                    System.out.println("Answer Part 2: " + (100 * noun + verb));
                }
            }
        }
    }
}
