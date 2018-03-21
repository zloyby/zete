package by.zloy.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author EugenKozlov
 */
public class TestGetRandomByRecursion {
    private Random rnd = new Random();

    public static void main(String[] args) {
        TestGetRandomByRecursion testGetRandomByRecursion = new TestGetRandomByRecursion();
        testGetRandomByRecursion.run();
    }

    private void run() {
        Map<String, Integer> commands = new HashMap<String, Integer>();
        commands.put("C1", 10);
        commands.put("C2", 10);
        commands.put("C3", 10);

        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        for (int i = 0; i < 10000; i++) {
            String r = getRandomCommandByWeight(commands, 10);
            if (r.equals("C1")) {
                c1++;
            }
            if (r.equals("C2")) {
                c2++;
            }
            if (r.equals("C3")) {
                c3++;
            }
        }
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }

    private String getRandomCommandByWeight(Map<String, Integer> commands, Integer max) {
        int randomMax = rnd.nextInt(max);

        int randomValue = rnd.nextInt(commands.size());

        if ((Integer) commands.values().toArray()[randomValue] >= randomMax) {
            return (String) commands.keySet().toArray()[randomValue];
        } else {
            return getRandomCommandByWeight(commands, max);
        }
    }
}
