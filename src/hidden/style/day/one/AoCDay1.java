package hidden.style.day.one;

import hidden.style.util.Utils;

import java.io.IOException;
import java.util.Scanner;

public class AoCDay1 {

    public static double findFuelRequirementPart1(double mass) {
        double fuelRequired = Math.floor(mass / 3);
        return fuelRequired - 2;
    }

    public static double findFuelRequirementPart2(double mass) {
        double fuelRequired = 0;
        while ( mass > 0) {
            double remainingMass = findFuelRequirementPart1(mass);
            mass = remainingMass;
            if(remainingMass > 0) {
                fuelRequired += remainingMass;
            }
        }
        return fuelRequired;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = Utils.getScan("src/hidden/style/day/one/AdventOfCodeDay1.txt");
        double totalFuelRequired = 0;
        while (scan.hasNextLine()) {
            String nextLine = scan.next();
//            totalFuelRequired += findFuelRequirementPart1(Double.valueOf(nextLine));
            totalFuelRequired += findFuelRequirementPart2(Double.valueOf(nextLine));
            System.out.println(totalFuelRequired);
        }
        System.out.println("Total Fuel required = " + totalFuelRequired);

    }
}
