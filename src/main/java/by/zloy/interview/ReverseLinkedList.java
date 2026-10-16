package by.zloy.interview;

import java.util.LinkedList;
import java.util.List;

public class ReverseLinkedList {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(List.of(1, 2, 3, 4, 5));
        System.out.println(reverse(list));
        System.out.println(reverse2(list));
    }

    private static List<Integer> reverse(List<Integer> list) {
        return list.reversed();
    }

    private static List<Integer> reverse2(List<Integer> list) {

        return null;
    }
}
