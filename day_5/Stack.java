package day_5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Stack {
    private Deque<String> stackCrates;

     Stack() {
        stackCrates = new ArrayDeque<>();
    }

    public void addFirst(String element) {
        stackCrates.addFirst(element);
    }

    public void addLast(List<String> arrElement) {
         for (int i = 0; i < arrElement.size(); i++) {
             stackCrates.addLast(arrElement.get(i));
         }
    }

    public void addLastReverse(List<String> arrElement) {
         for (int i = arrElement.size() - 1; i >= 0; i--) {
             stackCrates.addLast(arrElement.get(i));
         }
    }

    public List<String> getLastCrates(int count) {
         List<String> arrElement = new ArrayList<>();
         for (int i = 0; i < count; i++) {
             arrElement.add(stackCrates.getLast());
             stackCrates.removeLast();
         }
         return arrElement;
    }

    public String getLastCrate() {
        String element = stackCrates.getLast();
        stackCrates.removeLast();
        return element;
    }

    public String getLastCrateLite() {
         return stackCrates.getLast();
    }

    public void addLast(String element) {
         stackCrates.addLast(element);
    }
}
