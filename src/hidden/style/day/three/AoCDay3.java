package hidden.style.day.three;

import hidden.style.util.Utils;

import java.io.IOException;
import java.util.*;

public class AoCDay3 {


    public static Set<Coordinate> getCoordinateSet(String str) {
        Set<Coordinate> coordinateSet = new HashSet<Coordinate>();
        String[] arr = str.split(",");
        Long x = 0L;
        Long y = 0L;
        for ( String cmd : arr) {
            String direction = cmd.substring(0,1);
            Long distanceMoved = Long.parseLong(cmd.substring(1));
            for (int i = 1; i <= distanceMoved; i++) {
                if (direction.equalsIgnoreCase("L")) {
                    x--;
                } else if(direction.equalsIgnoreCase("R")) {
                    x++;
                } else if(direction.equalsIgnoreCase("U")) {
                    y++;
                } else if(direction.equalsIgnoreCase("D")) {
                    y--;
                }
                Coordinate coordinate = new Coordinate(x,y);
                coordinateSet.add(coordinate);
            }
        }
        return coordinateSet;
    }



    public static void main(String[] args) throws IOException {
        Scanner scan = Utils.getScan("src/hidden/style/day/three/AdventOfCodeDay3.txt");

        Long closestCollision = Long.MAX_VALUE;

        String firstLine = scan.nextLine();
        Set<Coordinate> firstCoordinateSet = getCoordinateSet(firstLine);

        String secondLine = scan.nextLine();
        Set<Coordinate> secondCoordinateSet = getCoordinateSet(secondLine);


        for ( Coordinate coordinate : firstCoordinateSet) {
            if(secondCoordinateSet.contains(coordinate)) {
                if(closestCollision > Math.abs(coordinate.getX()) + Math.abs(coordinate.getY())) {
                    closestCollision = Math.abs(coordinate.getX()) + Math.abs(coordinate.getY());
                    System.out.println("Updated closest collision to " + closestCollision);
                }
                System.out.println("CONTAINED");
            }
        }

        System.out.println("Closest Collision = " + closestCollision);

    }
}
