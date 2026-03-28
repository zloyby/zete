package by.zloy.interview;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class RandomShuffleArray {
    public static void main(String[] args) {
        Integer[] list = {1, 2, 3, 4, 5, 6, 16, 15, 14, 13, 12, 11};
        Stream.of(list).forEach(x -> System.out.print(x + ","));

        // Return list with same size but with shuffled elements by Fisher–Yates
        List<Integer> shuffled = shuffle(list);
        System.out.println("\r\nShuffled:");
        shuffled.forEach(x -> System.out.print(x + ","));

        // Shuffle by java
        shuffled = shuffleByJava(list);
        System.out.println("\r\nShuffled by java:");
        shuffled.forEach(x -> System.out.print(x + ","));

        // Just shows 10 random elements
        System.out.println("\r\nJust random:");
        new Random().ints(0, list.length).limit(list.length).forEach(p -> System.out.print(list[p] + ","));

    }

    private static List<Integer> shuffleByJava(Integer[] ar) {
        List<Integer> list = Arrays.asList(ar);
        Collections.shuffle(list);
        return list;
    }

    private static List<Integer> shuffle(Integer[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Fisher–Yates shuffle
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }

        return new ArrayList<>(Arrays.asList(ar));
    }
}
