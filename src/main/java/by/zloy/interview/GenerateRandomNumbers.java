package by.zloy.interview;

import java.util.*;

public class GenerateRandomNumbers {
    static Random random = new Random();

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            numbers.add(i);
        }
        generateWithStandardFunction(numbers);
        generateManually(numbers);
    }

    private static void generateManually(List<Integer> list) {
        int n = list.size();
        int[] numbers = list.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .toArray();

        for (int i = n - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }

        for (int num : numbers) {
            System.out.print(num + ",");
        }
        System.out.println();
    }

    private static void generateWithStandardFunction(List<Integer> numbers) {
        Collections.shuffle(numbers);
        for (int n : numbers) {
            System.out.print(n + ",");
        }
        System.out.println();
    }


}
