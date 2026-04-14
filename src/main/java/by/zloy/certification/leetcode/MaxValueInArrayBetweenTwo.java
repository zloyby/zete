package by.zloy.certification.leetcode;

public class MaxValueInArrayBetweenTwo {

    public static void main(String[] args) {
        MaxValueInArrayBetweenTwo profit = new MaxValueInArrayBetweenTwo();
        int[] stocks = new int[]{15, 3, 5, 2, 5, 2, 8, 14, 10}; // return 12, as most profit value was 14-2=12
        //int[] stocks = new int[]{7, 3, 5, 1, 6, 4}; // return 5, as most profit value was 6-1=5
        //int[] stocks = new int[]{1,2}; // return 1, as most profit is 2-1=1
        System.out.println(profit.maxProfit(stocks));
        System.out.println(profit.maxProfit_KadaneAlgorithm(stocks));
    }

    public int maxProfit_KadaneAlgorithm(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i]; //3,1,
            } else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;//5-3,6-1,
            }
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int price = prices[i];
            for (int j = i + 1; j <= prices.length - 1; j++) {
                int compare = prices[j];
                int profit = compare - price;
                if (compare > price && max < profit) {
                    max = profit;
                }
            }
        }
        return max;
    }
}
