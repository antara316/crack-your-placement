class Solution {
    public int maxProfit(int[] prices) {
        int buyprices = Integer.MAX_VALUE;
        int maxval = 0;
        for(int i=0;i<prices.length;i++)
        {
            if(buyprices < prices[i])
            {
                int profit = prices[i]-buyprices;
                maxval = Math.max(maxval,profit);
            }else
            {
                buyprices = prices[i];
            }
        }
        return maxval;
    }
}