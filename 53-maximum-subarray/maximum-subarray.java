class Solution {
    public int maxSubArray(int[] nums) {
        if (nums==null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        // use dp
        int n = nums.length;
        int [] dp = new int [n];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i<n; i++){
            dp[i] = Math.max(dp[i-1]+ nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}