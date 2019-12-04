package hidden.style.day.three;

import hidden.style.util.Utils;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AoCDay3 {


    public static List<Coordinate> getCoordinateList(String str) {
        List<Coordinate> coordinateList = new ArrayList<>();
        String[] arr = str.split(",");
        int x = 0;
        int y = 0;
        for ( String cmd : arr) {
            String direction = cmd.substring(0,1);
            long distanceMoved = Integer.parseInt(cmd.substring(1));
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
                coordinateList.add(coordinate);
            }
        }
        return coordinateList;
    }



    public static void main(String[] args) throws IOException {
        Scanner scan = Utils.getScan("src/hidden/style/day/three/AdventOfCodeDay3.txt");

        int closestCollision = Integer.MAX_VALUE;
        List<Coordinate> coordinateList = new ArrayList<Coordinate>();
        while(scan.hasNextLine()) {
            coordinateList.addAll(getCoordinateList(scan.nextLine()));
        }
        int collision = Integer.MAX_VALUE;

        for (Coordinate coordinate : coordinateList) {
            int numMatches = 0;
            for (Coordinate c : coordinateList) {
                if(c.getX() == coordinate.getX() && c.getY() == coordinate.getY()) {
                    numMatches++;
                }
            }
            if(numMatches > 1) {
                int collides = Math.abs(coordinate.getX()) + Math.abs(coordinate.getY());
                if(collision > collides) {
                    collision = collides;
                }
            }
        }

        System.out.println(collision);

    }
}
