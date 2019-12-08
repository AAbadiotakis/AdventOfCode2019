package hidden.style.day.three;

import hidden.style.util.Utils;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AoCDay3 {

    static Map<String, Integer> getCoordinateList(String str) {
        String[] arr = str.split(",");
        int x = 0;
        int y = 0;
        int distanceTravelled = 0;
        Map<String, Integer> coordinateList = new HashMap<String, Integer>();

        for (String cmd : arr) {
            String direction = cmd.substring(0,1);
            int distanceMoved = Integer.parseInt(cmd.substring(1));
            for (int i = 0; i < distanceMoved ; i++) {
                distanceTravelled++;
                if (direction.equalsIgnoreCase("L")) {
                    x--;
                } else if(direction.equalsIgnoreCase("R")) {
                    x++;
                } else if(direction.equalsIgnoreCase("U")) {
                    y++;
                } else if(direction.equalsIgnoreCase("D")) {
                    y--;
                }
                if (!coordinateList.containsKey(x + "," + y)) {
                    coordinateList.put(x + "," + y, distanceTravelled);
                }
            }
        }
        return coordinateList;
    }

    static Set<String> intersection(Set<String> A, Set<String> B) {
        return A.stream().filter(B::contains).collect(Collectors.toSet());
    }

    static int getClosestIntersectionPart1(Set<String> intersections) {
        int closestIntersection = Integer.MAX_VALUE;
        for (String str : intersections) {
            int x = Integer.parseInt(str.split(",")[0]);
            int y = Integer.parseInt(str.split(",")[1]);
            int intersectedManhattanDistance = Math.abs(x) + Math.abs(y);
            if (closestIntersection > intersectedManhattanDistance) {
                closestIntersection = intersectedManhattanDistance;
            }
        }
        return closestIntersection;
    }

    static int getClosestIntersectionPart2(Set<String> intersections, Map<String, Integer> a, Map<String, Integer> b) {
        int closestIntersection = Integer.MAX_VALUE;
        for(String str : intersections) {
            int i = a.get(str) + b.get(str);
            if(closestIntersection > i) {
                closestIntersection = i;
            }
        }
        return closestIntersection;
    }



    public static void main(String[] args) throws IOException {
        Scanner scan = Utils.getScan("src/hidden/style/day/three/AdventOfCodeDay3.txt");

        Map<String, Integer> a = getCoordinateList(scan.nextLine());
        Map<String, Integer> b = getCoordinateList(scan.nextLine());

        Set<String> intersections = intersection(a.keySet(), b.keySet());
        System.out.println(intersections);

        int answer_part1 = getClosestIntersectionPart1(intersections);
        int answer_part2 = getClosestIntersectionPart2(intersections, a, b);

        System.out.println(answer_part1);
        System.out.println(answer_part2);

    }
}
