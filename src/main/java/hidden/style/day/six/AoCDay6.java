package hidden.style.day.six;

import hidden.style.util.Utils;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AoCDay6 {

    public static void main(String[] args) throws IOException {
        Scanner scan = Utils.getScan("src/main/java/hidden/style/day/six/AdventOfCodeDay6.txt");

        List<OrbitalMap> orbitalMapList = new ArrayList<OrbitalMap>();

        orbitalMapList.add(new OrbitalMap("COM", null));

        while(scan.hasNextLine()) {
            String str = scan.nextLine();
            orbitalMapList.add(new OrbitalMap(str.split("\\)")[1], str.split("\\)")[0]));
        }

        for(OrbitalMap orbitalMap : orbitalMapList) {
            if(orbitalMap.getPreviousOrbitalPlanet() != null) {
                int numOrbitsFromCenterOfMass = 0;
                boolean foundCenterOfMass = false;
                String previousOrbitalPlanet = orbitalMap.getPreviousOrbitalPlanet();
                while(!foundCenterOfMass) {
                    numOrbitsFromCenterOfMass++;
                    if(previousOrbitalPlanet.equalsIgnoreCase("COM")) {
                        foundCenterOfMass = true;
                        orbitalMap.setOrbitsFromCenterOfMass(numOrbitsFromCenterOfMass);
                    } else {
                        String finalPreviousOrbitalPlanet = previousOrbitalPlanet;
                        OrbitalMap previousOrbitalMap = orbitalMapList.stream().filter(o -> o.getPlanet().equalsIgnoreCase(finalPreviousOrbitalPlanet)).findFirst().orElse(null);
                        previousOrbitalPlanet = previousOrbitalMap.getPreviousOrbitalPlanet();
                    }
                }
            }
        }
        System.out.println("Answer Part 1: " + orbitalMapList.stream().mapToInt(OrbitalMap::getOrbitsFromCenterOfMass).sum());

        List<String> orbitsBetweenCenterOfMassAndYou = new ArrayList<String>();
        orbitsBetweenCenterOfMassAndYou.addAll(orbitalMapList.stream().filter(o -> o.getPlanet().equalsIgnoreCase("YOU")).map(OrbitalMap::getPreviousOrbitalPlanet).collect(Collectors.toList()));
        boolean reachedCenterOfMass = false;
        String previousPlanetNameFromYou = orbitalMapList.stream().filter(orbitalMap -> orbitalMap.getPlanet().equalsIgnoreCase("YOU")).map(OrbitalMap::getPreviousOrbitalPlanet).findFirst().orElse(null);
        while(!reachedCenterOfMass) {
            if(previousPlanetNameFromYou.equalsIgnoreCase("COM") || previousPlanetNameFromYou == null) {
                reachedCenterOfMass = true;
            } else {
                String finalPreviousPlanetNameFromYou = previousPlanetNameFromYou;
                orbitsBetweenCenterOfMassAndYou.addAll(orbitalMapList.stream().filter(o -> o.getPlanet().equalsIgnoreCase(finalPreviousPlanetNameFromYou)).map(OrbitalMap::getPreviousOrbitalPlanet).collect(Collectors.toList()));
                previousPlanetNameFromYou = orbitalMapList.stream().filter(orbitalMap -> orbitalMap.getPlanet().equalsIgnoreCase(finalPreviousPlanetNameFromYou)).map(OrbitalMap::getPreviousOrbitalPlanet).findFirst().orElse(null);
            }
        }

        reachedCenterOfMass = false;
        List<String> orbitsBetweenCenterOfMassAndSan = new ArrayList<String>();
        orbitsBetweenCenterOfMassAndSan.addAll(orbitalMapList.stream().filter(o -> o.getPlanet().equalsIgnoreCase("SAN")).map(OrbitalMap::getPreviousOrbitalPlanet).collect(Collectors.toList()));
        String previousPlanetNameFromSan = orbitalMapList.stream().filter(orbitalMap -> orbitalMap.getPlanet().equalsIgnoreCase("SAN")).map(OrbitalMap::getPreviousOrbitalPlanet).findFirst().orElse(null);
        while(!reachedCenterOfMass) {
            if(previousPlanetNameFromSan.equalsIgnoreCase("COM") || previousPlanetNameFromSan == null) {
                reachedCenterOfMass = true;
            } else {
                String finalPreviousPlanetNameFromSan = previousPlanetNameFromSan;
                orbitsBetweenCenterOfMassAndSan.addAll(orbitalMapList.stream().filter(o -> o.getPlanet().equalsIgnoreCase(finalPreviousPlanetNameFromSan)).map(OrbitalMap::getPreviousOrbitalPlanet).collect(Collectors.toList()));
                previousPlanetNameFromSan = orbitalMapList.stream().filter(orbitalMap -> orbitalMap.getPlanet().equalsIgnoreCase(finalPreviousPlanetNameFromSan)).map(OrbitalMap::getPreviousOrbitalPlanet).findFirst().orElse(null);
            }
        }

        int i = 0;
        Set<String> planetsBetweenYouAndSan = new HashSet<String>();
        for(String str : orbitsBetweenCenterOfMassAndYou) {
            planetsBetweenYouAndSan.add(str);
            i++;
            if(orbitsBetweenCenterOfMassAndSan.contains(str)) {
                System.out.println("Answer Part 2: " + (i + orbitsBetweenCenterOfMassAndSan.indexOf(str)));
                return;
            }
        }



    }
}
