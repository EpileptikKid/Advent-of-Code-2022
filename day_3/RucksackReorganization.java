package day_3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class RucksackReorganization {

    private static int getPriorityRucksack(String line) {
        String firstHalfString = line.substring(0, line.length()/2);
        String secondHalfString = line.substring(line.length()/2);
        char symbol = 0;
        for (int i = 0; i < firstHalfString.length(); i++) {
            if (secondHalfString.contains(firstHalfString.subSequence(i, i+1)))
                symbol = firstHalfString.charAt(i);
        }
        return getCodeOfSymbol(symbol);
    }

    private static int getCodeOfSymbol(char symbol) {
        String arrSymbol = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 52; i++) {
            if (arrSymbol.charAt(i) == symbol)
                return i + 1;
        }
        return 0;
    }

    private static int getCommonPinCode(String lineOne, String lineTwo, String lineThree) {
        char temp;
        for (int i = 0; i < lineOne.length(); i++) {
            if (lineTwo.contains(lineOne.substring(i, i+1)) && lineThree.contains(lineOne.substring(i, i+1))) {
                temp = lineOne.charAt(i);
                return getCodeOfSymbol(temp);
            }
        }
        return 0;
    }


    public static void main(String[] args) throws FileNotFoundException {
        FileReader inputFile = new FileReader("src/day_3/input.txt");
        Scanner scanner = new Scanner(inputFile);
        int countPriority = 0;
        int countSinglePriority = 0;
        while (scanner.hasNextLine()) {
            String inputTextOne = scanner.nextLine();
            String inputTextTwo = scanner.nextLine();
            String inputTextThree = scanner.nextLine();
            countSinglePriority += (getPriorityRucksack(inputTextOne) + getPriorityRucksack(inputTextTwo) + getPriorityRucksack(inputTextThree));
            countPriority += getCommonPinCode(inputTextOne, inputTextTwo, inputTextThree);
        }
        System.out.println("Summary single priority - " + countSinglePriority);
        System.out.println("Summary priority Rucksack - " + countPriority);
    }
}
