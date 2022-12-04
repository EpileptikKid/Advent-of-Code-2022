package day_4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CampCleanup {
    private static int findSingleRange(int x1, int y1, int x2, int y2) {
        if ((((x1>=x2)&&(x1<=y2))&&((y1<=y2)&&(y1>=x2)))||(((x2>=x1)&&(x2<=y1))&&((y2<=y1)&&(y2>=x1))))
            return 1;
        return 0;
    }

    private static  int findMutualRange(int x1, int y1, int x2, int y2) {
        if ((((x1>=x2)&&(x1<=y2))||((y1<=y2)&&(y1>=x2)))||(((x2>=x1)&&(x2<=y1))||((y2<=y1)&&(y2>=x1))))
            return 1;
        return 0;
    }


    public static void main(String[] args) throws FileNotFoundException {
        FileReader inputFile = new FileReader("src/day_4/input.txt");
        Scanner scanner = new Scanner(inputFile);
        int countSingleRange = 0;
        int countMutualRange = 0;
        while (scanner.hasNextLine()) {
            String inputTextLine = scanner.nextLine();
            String[] rangeArr = inputTextLine.split(",");
            int x1 = Integer.parseInt(rangeArr[0].split("-")[0]);
            int y1 = Integer.parseInt(rangeArr[0].split("-")[1]);
            int x2 = Integer.parseInt(rangeArr[1].split("-")[0]);
            int y2 = Integer.parseInt(rangeArr[1].split("-")[1]);
            countSingleRange += findSingleRange(x1, y1, x2, y2);
            countMutualRange += findMutualRange(x1, y1, x2, y2);
        }
        System.out.println("Single result - " + countSingleRange);
        System.out.println("Mutual result - " + countMutualRange);
    }
}
