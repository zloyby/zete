package by.zloy.poc.core;

public class TryCatchFinally {
    public static void main(String[] args) {
        TryCatchFinally.run();
    }

    private static void run() {
        try {
            printTry();
        } finally {
            printFinally();
        }
    }

    private static void printTry() {
        int a = 10 / 0;
        System.out.println("try");
        throw new NullPointerException();
    }

    private static void printFinally() {
        System.out.println("finally");
    }
}
