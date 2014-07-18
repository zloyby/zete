package by.zloy.certification;

public class SingleNumber {

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 3;
        System.out.println(singleNumber(arr));

    }

    static public int singleNumber(int[] arr) {
        int x = 0;

        for (int a : arr) {
            x = x ^ a;
        }

        return x;
    }
}
