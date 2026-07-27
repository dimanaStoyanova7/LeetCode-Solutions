class Solution {
    public int maxSubArray(int[] nums) {
        int current = nums[0]; // sum so far
        int res = current;
        for(int i=1; i<nums.length; i++){
            current = Math.max(nums[i], nums[i]+current);
            res = Math.max(res, current);
        }
        return res;
    }
}