package day_1;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CalorieCounting {
    public static void main(String[] args) throws IOException {
        FileReader inputFile = new FileReader("src/day_1/input.txt");
        Scanner scanner = new Scanner(inputFile);
        List<Integer> arrCountCalories = new ArrayList<>();
        int currentCount = 0;
        while (scanner.hasNextLine()) {
            String inputTextLine = scanner.nextLine();
            if (inputTextLine.equals("")) {
                arrCountCalories.add(currentCount);
                currentCount = 0;
            } else {
                currentCount += Integer.parseInt(inputTextLine);
            }
        }

        int sum = Collections.max(arrCountCalories);
        System.out.println("Max count calories - " + Collections.max(arrCountCalories));
        arrCountCalories.remove(Collections.max(arrCountCalories));
        sum += Collections.max(arrCountCalories);
        arrCountCalories.remove(Collections.max(arrCountCalories));
        sum += Collections.max(arrCountCalories);
        System.out.println("Sum of three max count calories - " + sum);
    }
}
