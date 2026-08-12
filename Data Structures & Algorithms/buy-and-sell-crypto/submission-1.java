class Solution {
    public int maxProfit(int[] prices) {
        // int highestProfit = 0;
        // for(int i=0; i<prices.length; i++) {
        //     for(int j=i+1; j<prices.length; j++) {
        //         int profit = prices[j] - prices[i];
        //         if(profit > highestProfit) {
        //             highestProfit = profit;
        //         }
        //     }
        // }
        // return highestProfit;
        int highestProfit = 0;
        for(int i=0; i<prices.length; i++) {
            int priceBoughtAt = prices[i];
            int maxPriceSoldAt = Arrays.stream(Arrays.copyOfRange(prices, i+1, prices.length+1)).max().orElse(0);
            int maxProfit = maxPriceSoldAt - priceBoughtAt;
            if(maxProfit > highestProfit) {
                highestProfit = maxProfit;
            }
        }
        return highestProfit;
    }
}
