class Solution {
    public int lengthOfLIS(int[] nums) {
        // brute force approach : start from each index and count 

        // dp approach: 
        if (nums.length == 0) return 0;


        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for(int i = 0; i < nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[j]+1, dp[i]);
            }
        }
        int res = 0;
        for( int dpRes : dp){
            res = Math.max(res, dpRes);
        }
        return res;

    }
}