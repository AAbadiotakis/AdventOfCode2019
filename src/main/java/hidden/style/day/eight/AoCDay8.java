package hidden.style.day.eight;

import hidden.style.util.Utils;
import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.util.*;

public class AoCDay8 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = Utils.getScan("src/main/java/hidden/style/day/eight/AdventOfCodeDay8.txt");

        while(scan.hasNextLine()) {
            String nextLine = scan.nextLine();
            boolean creatingLayers = true;
            Map<Integer, List<String>> layerMap = new HashMap<>();
            int i = 0;
            int k = 0;
            while(creatingLayers) {
                List<String> layerList = new ArrayList<>();
                for(int j = 0; j < 6; j++) {
                    if(nextLine.length() < k) {
                        creatingLayers = false;
                        continue;
                    } else {
                        if(k+25 > nextLine.length()) {
                            layerList.add(nextLine.substring(k));
                        } else {
                            layerList.add(nextLine.substring(k, k+25));
                        }
                        k += 25;
                    }
                }
                layerMap.put(i, layerList);
                i++;
            }
            Map<Integer, Integer> keyToZeroDigitMap = new HashMap<>();

            int lowestCount = Integer.MAX_VALUE;
            int lowestCountKey = Integer.MAX_VALUE;

            for(Integer j : layerMap.keySet()) {
                List<String> layerList = layerMap.get(j);
                if(layerList.isEmpty() || layerList == null || layerList.size() < 2) {
                    continue;
                } else {
                    int zeroOccurences = 0;
                    for(String data : layerList) {
                        int count = StringUtils.countMatches(data, "0");
                        zeroOccurences += count;
                    }
                    keyToZeroDigitMap.put(j, zeroOccurences);
                    if(zeroOccurences < lowestCount) {
                        lowestCount = zeroOccurences;
                        lowestCountKey = j;
                    }
                }
            }

            List<String> strList = layerMap.get(lowestCountKey);
            int count1Digits = 0;
            int count2Digits = 0;
            for ( String str : strList) {
                count1Digits += StringUtils.countMatches(str, "1");
                count2Digits += StringUtils.countMatches(str, "2");
            }

            System.out.println("Answer part 1 = " + (count1Digits * count2Digits));
        }

    }
}
