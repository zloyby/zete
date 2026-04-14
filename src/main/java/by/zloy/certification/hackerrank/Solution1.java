package by.zloy.certification.hackerrank;

import java.util.*;

/*
Returns the number of unique pairs in array where sum is equals by diff.
array: list of unique integers
diff: integer, the targeted difference
return: number of pairs realizing the difference
*/
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.test1();
    }

    private void test1() {
        ArrayList<Data> array = new ArrayList<>() {{
            add(new Data(1, "one"));
            add(new Data(4, "four"));
            add(new Data(2, "two"));
            add(new Data(5, "five"));
            add(new Data(3, "three"));
            add(new Data(5, "five"));
        }};
        int diff = 3; // must be 2 == { 4-1; 5-2 }
        System.out.println("Result: " + countPairs(array, diff));
    }

    private int countPairs(List<Data> array, int diff) {
        int pairs = 0;

        // 1. sort
        //Comparator<Data> comparator = (o1, o2) -> o2.i.compareTo(o1.i); // desc comparator
        //Comparator<Data> comparator = Comparator.comparing(o -> o.i, Comparator.reverseOrder()); // desc comparator
        //array.sort(comparator);

        // 2. remove duplicates
        //List<Data> cleared = array.stream().distinct().toList();
        //Set<Data> cleared = new LinkedHashSet<>(array);

        // 3. sort and remove duplicates in stream, as we don't need Data name
        List<Integer> ids = array.stream().map(d -> d.i).distinct().sorted(Comparator.reverseOrder()).toList();

        for (Integer id : ids) {
            if (ids.contains(id + diff)) {
                pairs++;
            }
        }
        return pairs;
    }

    public record Data(Integer i, String n) {
    }
}
