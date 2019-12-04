package hidden.style.day.four;

import hidden.style.day.three.Coordinate;
import hidden.style.util.Utils;

import java.io.IOException;
import java.util.*;

public class AoCDay4 {


    public static void main(String[] args) throws IOException {
        Integer startingInteger = 359282;
        Integer endingInteger = 820401;

        Set<Integer> setOfPossiblePasswordCombinations = new HashSet<Integer>();

        for ( int i = startingInteger; i < endingInteger; i++) {
            String str = String.valueOf(i);

            if( str.contains("11") ||
                str.contains("22") ||
                str.contains("33") ||
                str.contains("44") ||
                str.contains("55") ||
                str.contains("66") ||
                str.contains("77") ||
                str.contains("88") ||
                str.contains("99")) {

                if(     Integer.parseInt(str.substring(0,1)) <= Integer.parseInt(str.substring(1,2)) &&
                        Integer.parseInt(str.substring(1,2)) <= Integer.parseInt(str.substring(2,3)) &&
                        Integer.parseInt(str.substring(2,3)) <= Integer.parseInt(str.substring(3,4)) &&
                        Integer.parseInt(str.substring(3,4)) <= Integer.parseInt(str.substring(4,5)) &&
                        Integer.parseInt(str.substring(4,5)) <= Integer.parseInt(str.substring(5))) {

                    setOfPossiblePasswordCombinations.add(i);
                }
            }
        }

        System.out.println("NumPossibleCombinations = " + setOfPossiblePasswordCombinations.size());

    }
}
