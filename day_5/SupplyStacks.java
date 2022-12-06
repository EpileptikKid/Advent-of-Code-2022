package day_5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SupplyStacks {
    private static final List<Stack> stacks = new ArrayList<>();

    private static int[] parseNumber(String inputLine) {
        if (inputLine != null) {
            int[] arrInt = new int[3];
            String[] arrStr = inputLine.split(" ");
            arrInt[0] = Integer.parseInt(arrStr[1]);
            arrInt[1] = Integer.parseInt(arrStr[3]) - 1;
            arrInt[2] = Integer.parseInt(arrStr[5]) - 1;
            return arrInt;
        }
        return null;
    }

    private static void moveElementFirstVersion(int count, int from, int to) {
        stacks.get(to).addLastReverse(stacks.get(from).getLastCrates(count));
    }

    private static void moveElementSecondVersion(int count, int from, int to) {
        stacks.get(to).addLast(stacks.get(from).getLastCrates(count));
    }
    private static void addElementToStacks(String inputLine) {
        if (inputLine != null) {
            int size = inputLine.length() / 4 + 1;
            for (int i = 0; i < size; i++) {
                if (!(inputLine.charAt(i * 4 + 1) == ' ')) {
                    stacks.get(i).addFirst(String.valueOf(inputLine.charAt(i * 4 + 1)));
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileReader inputFile = new FileReader("src/day_5/input.txt");
        Scanner scanner = new Scanner(inputFile);

        List<String> inputArr = new ArrayList<>();
        while (scanner.hasNext()) {
            String inputLine = scanner.nextLine();
            if (inputLine.contains("[")) {
                inputArr.add(inputLine);
            } else if (inputLine.contains("m")) {
                int[] parameters = parseNumber(inputLine);
                moveElementSecondVersion(parameters[0], parameters[1], parameters[2]);
            } else if (inputLine.startsWith(" 1")) {
                while (inputLine.contains("  ")) {
                    inputLine = inputLine.replaceAll("  ", " ");
                }
                inputLine = inputLine.trim();
                int count = inputLine.split(" ").length;
                for (int i = 0; i < count; i++) {
                    stacks.add(new Stack());
                }
                for (String inputStr : inputArr) {
                    addElementToStacks(inputStr);
                }
            }
        }





        for (int i = 0; i < stacks.size(); i++) {
            System.out.print(stacks.get(i).getLastCrateLite());
        }
    }


}
