package day_6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class TuningTrouble {
    private static boolean checker = true;

    private static boolean createFirstTime(String inputFirstLine) {
        char[] arrChar = inputFirstLine.toCharArray();
        List<Character> temp = new ArrayList<>();
        for (char element : arrChar) {
            if (temp.contains(element)) {
                checker = false;
                break;
            }
            temp.add(element);
        }
        if (!checker) {
            checker = true;
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileReader inputFile = new FileReader("src/day_6/input.txt");
        Scanner scanner = new Scanner(inputFile);
        String inputString = scanner.nextLine();
        for (int i = 14; i < inputString.length(); i++) {
            if (createFirstTime(inputString.substring(i-13,i+1))) {
                System.out.println("Answer - " + (i + 1));
                break;
            }
        }
    }
}
