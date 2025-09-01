class Solution {
    public int maxProfit(int[] prices) {
        int buyingDay = 0;
        int sellingDay = 0;
        int profit = 0;
        
        for(int i=1;i<prices.length;i++) {
            if(prices[i] > prices[i-1]) {
                sellingDay++;
            } else {
                profit += prices[sellingDay] - prices[buyingDay];
                sellingDay = i;
                buyingDay = i;
            }
        }
        
        profit += prices[sellingDay] - prices[buyingDay];
        
        return profit;
    } 
}