class Solution {
    public int maxProfit(int[] prices) {
        // at each index - take the diffence with the lowest before it
        int minIndex = 0;
        int res = 0;
        for(int i=1; i<prices.length; i++){
            int min = prices[minIndex];
            //if smaller than smallest so far - > update index and continue
            if(min>prices[i]){
                minIndex = i;
            }
            else{
                res = Math.max(res, prices[i]-min);
            }
        }
        return res;
    }
}