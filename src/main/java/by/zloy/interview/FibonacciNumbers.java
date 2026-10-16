package by.zloy.interview;

public class FibonacciNumbers {
    public static void main(String[] args) {
        //int[] fibs = {0, 1, 1, 2, 3, 5, 8};

        int[] sequence = initArrayOfPrecompute(10);
        System.out.println(sequence[2]); // 1
        System.out.println(sequence[6]); // 8
        System.out.println(sequence[9]); // 34
    }

    private static int[] initArrayOfPrecompute(int amountToStore) {
        int[] sequence = new int[amountToStore];
        sequence[0] = 0;
        sequence[1] = 1;
        for (int i = 2; i < amountToStore; i++) {
            sequence[i] =  sequence[i - 2] + sequence[i - 1];
        }
        return sequence;
    }
}
