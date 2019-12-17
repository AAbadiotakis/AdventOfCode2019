package hidden.style.day.ten;

import hidden.style.util.Utils;

import java.io.FileNotFoundException;
import java.util.*;

public class AoCDay10 {

    public static double findDegreesFromXYCoordinatePair(int x, int y, int checkX, int checkY) {
        double degreesBetweenCurrentAsteroid = Math.toDegrees(Math.atan2(Math.abs(checkY - y), Math.abs(checkX - x)));
        if(y == checkY) {
            if(x < checkX) {
                // Station is on the same Y as the asteroid, but directly above
                degreesBetweenCurrentAsteroid = 0.0;
            } else {
                // Station is on the same Y as the asteroid, but directly below
                degreesBetweenCurrentAsteroid = 180.0;
            }
        } else if(x == checkX) {
            if(y < checkY) {
                // Station is on the same X as the asteroid, but to the left
                degreesBetweenCurrentAsteroid = 90.0;
            } else {
                degreesBetweenCurrentAsteroid = 270.0;
            }
        } else {
            // Station is not on the same x or y
            if(x < checkX && y < checkY) {
                // do nothing (degrees are correct)
                // Top right quadrant
            } else {
                if(x < checkX) {
                    if(y > checkY) {
                        // Bottom right quadrant
                        degreesBetweenCurrentAsteroid += 90.0;
                    }
                } else if(x > checkX) {
                    if(y > checkY) {
                        // Bottom left quadrant
                        degreesBetweenCurrentAsteroid += 180.0;
                    } else {
                        // Top left quadrant
                        degreesBetweenCurrentAsteroid += 270.0;
                    }
                }
            }
        }
        return degreesBetweenCurrentAsteroid;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = Utils.getScan("src/main/java/hidden/style/day/ten/AdventOfCodeDay10.txt");
        int rowY = 0;
        Map<Integer, List<Integer>> asteroidMap = new HashMap<>();
        while(scan.hasNextLine()) {
            String str = scan.nextLine();
            List<Integer> row = new ArrayList<>();
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '.') {
                    row.add(i, 0);
                } else {
                    row.add(i, 1);
                }

            }
            asteroidMap.put(rowY, row);
            rowY++;
        }

        int mostAsteroidsSeen = 0;
        int bestX = 0;
        int bestY = 0;
        for(int y : asteroidMap.keySet()) {
            for(int x  = 0; x < asteroidMap.get(y).size(); x++) {
                // Check if the position contains an asteroid
                if(asteroidMap.get(y).get(x) > 0) {
                    System.out.println("Checking count of asteroids seen by " + x + ", " + y);
                    int asteroidsSeen = 0;
                    List<Double> asteroidAngles = new ArrayList<>();
                    /*
                     * x,y here are the coordinates of the monitoring system
                     */
                    for(int checkY : asteroidMap.keySet()) {
                        for(int checkX = 0; checkX < asteroidMap.get(checkY).size(); checkX++) {
                            /*
                             * checkX, checkY should contain an asteroid, and be viewable by x,y
                             * if true, iterate asteroidsSeen
                             */

                            double degreesBetweenCurrentAsteroid = findDegreesFromXYCoordinatePair(x, y, checkX, checkY);
                            if(asteroidMap.get(checkY).get(checkX) > 0 && !(checkX == x && checkY == y)) {
                                if(asteroidAngles.contains(degreesBetweenCurrentAsteroid)) {
                                    System.out.println("Asteroid found (" + checkX + "," + checkY + ") with an already existing angle of " + degreesBetweenCurrentAsteroid);
                                } else {
                                    System.out.println("Asteroid found at " + checkX + "," + checkY + " with an angle of " + degreesBetweenCurrentAsteroid);
                                    asteroidsSeen++;
                                    asteroidAngles.add(degreesBetweenCurrentAsteroid);
                                }
                            }
                        }
                    }

                    if (asteroidsSeen > mostAsteroidsSeen) {
                        bestX = x;
                        bestY = y;
                        mostAsteroidsSeen = asteroidsSeen;
                    }
                    System.out.println("Asteroid seen at " + x + "," + y + " = " + asteroidsSeen);
                }
            }
        }
        System.out.println("Best X coordinate: " + bestX);
        System.out.println("Best Y coordinate: " + bestY);
        System.out.println("Most Asteroids Seen: " + mostAsteroidsSeen);
    }
}
