class Solution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxval = 0;
        for(int i=0;i<prices.length;i++)
        {
            if(minprice < prices[i])
            {
                int profit = prices[i]-minprice;
                maxval = Math.max(maxval,profit);
            }else
            {
                minprice = prices[i];
            }
        }
        return maxval;
    }
}