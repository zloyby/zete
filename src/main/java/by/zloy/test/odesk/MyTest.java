package by.zloy.test.odesk;

class MyTest {

    public static void main(String[] args) {
        lattice_paths(1, 1);
        lattice_paths(2, 1);
        lattice_paths(2, 2);
        lattice_paths(2, 3);
        lattice_paths(3, 3);
        lattice_paths(20, 20);
        zeon_day_of_week(17, 11, 2013);
        palindromes(new String[]{"noon", "orange", "wow"});
        palindromes(new String[]{"radar", "apple", "hello", "evitative"});
    }

    public static void lattice_paths(int x, int y) {
        long[][] array = new long[x + 1][y + 1];

        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                if (i == 0 && j == 0) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = ((i > 0) ? array[i - 1][j] : 0) + ((j > 0) ? array[i][j - 1] : 0);
                }
            }
        }

        System.out.println(array[x][y]);
    }

    public static void palindromes(String[] words) {
        for (String word : words) {
            System.out.print(word.equals(new StringBuffer(word).reverse().toString()) ? "T" : "F");
        }
        System.out.println();
    }

    public static void zeon_day_of_week(int day, int month, int year) {

        final int START_YEAR = 1900;
        final int START_MONTH = 1;
        final int DAYS_IN_EVEN = 21;//6 months
        final int DAYS_IN_ODD = 22;//7 months
        final int YEAR_ALL_COUNT = 21 * 6 + 22 * 7;
        final int YEAR_LEAP_COUNT = 21 * 6 + 22 * 7 - 1;//every 5 years

        int daysCount = 0;

        for (int y = START_YEAR; y < year; y++) {
            daysCount += (((y % 5) == 0) ? YEAR_LEAP_COUNT : YEAR_ALL_COUNT);
        }

        for (int m = START_MONTH; m < month; m++) {
            daysCount += (((m % 2) == 0) ? DAYS_IN_EVEN : DAYS_IN_ODD);
        }

        daysCount += day;
        int dayOfTheWeek = daysCount % 7;

        switch (dayOfTheWeek) {
            case 0:
                System.out.println("Sunday");
                break;
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
        }

    }
}