package day_2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class RockPaperScissors {

    private static int getScoreFirstStrategy(String inputText) {
        Map<String, Integer> firstStrategyMap = new HashMap<>();
        firstStrategyMap.put("B X", 1);
        firstStrategyMap.put("C Y", 2);
        firstStrategyMap.put("A Z", 3);
        firstStrategyMap.put("A X", 4);
        firstStrategyMap.put("B Y", 5);
        firstStrategyMap.put("C Z", 6);
        firstStrategyMap.put("C X", 7);
        firstStrategyMap.put("A Y", 8);
        firstStrategyMap.put("B Z", 9);
        return firstStrategyMap.get(inputText);
    }
    private static int getScoreSecondStrategy(String inputText) {
        Map<String, Integer> secondStrategyMap = new HashMap<>();
        secondStrategyMap.put("B X", 1);
        secondStrategyMap.put("C X", 2);
        secondStrategyMap.put("A X", 3);
        secondStrategyMap.put("A Y", 4);
        secondStrategyMap.put("B Y", 5);
        secondStrategyMap.put("C Y", 6);
        secondStrategyMap.put("C Z", 7);
        secondStrategyMap.put("A Z", 8);
        secondStrategyMap.put("B Z", 9);
        return secondStrategyMap.get(inputText);
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileReader inputFile = new FileReader("src/day_2/input.txt");
        Scanner scanner = new Scanner(inputFile);
        int countScoreFirstStrategy = 0;
        int countScoreSecondStrategy = 0;
        while (scanner.hasNextLine()) {
            String inputTextLine = scanner.nextLine();
            countScoreFirstStrategy += getScoreFirstStrategy(inputTextLine);
            countScoreSecondStrategy += getScoreSecondStrategy(inputTextLine);
        }
        System.out.println("First strategy score - " + countScoreFirstStrategy);
        System.out.println("Second strategy score - " + countScoreSecondStrategy);
    }
}
