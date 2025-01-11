class Solution {
    public int maxProfit(int[] prices) {
        //dp problem where we track states
        if (prices == null || prices.length == 0 || prices.length == 1) return 0;
        int[] hold = new int[prices.length]; // max profit on i-th day by doing holding 
                                             // (buying or carrying over from prev. day)
        int[] sold = new int[prices.length]; //max profit on i-th day by doing action buy
        int[] rest = new int[prices.length]; //max profit on i-th day by doing action rest

        hold[0] = -prices[0]; //max profit when owning a stock
        sold[0] = 0; //cannot make profit from selling on day 0 
        rest[0] = 0; //cannot make profit from buying on day 0 
        for(int i = 1 ; i < prices.length ; i++){
            hold[i] = Math.max(hold[i-1], rest[i-1]-prices[i]); 
            sold[i] = hold[i-1]+prices[i];
            rest[i] = Math.max(rest[i-1], sold[i-1]);
        }
        return Math.max(sold[prices.length-1], rest[prices.length-1]);

    }
}