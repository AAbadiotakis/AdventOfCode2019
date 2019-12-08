package hidden.style.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Utils {


    public static Scanner getScan(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        return new Scanner(file);
    }
}
