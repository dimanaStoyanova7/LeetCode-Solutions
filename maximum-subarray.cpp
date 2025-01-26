class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==1) return nums[0];
        int res = nums[0];
        int sumSoFar = 0;
        for(int i=0; i<nums.length; i++){
            sumSoFar = Math.max(nums[i], sumSoFar+nums[i]);
            res = Math.max(res, sumSoFar);
        }
        return res;
    }
}