class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // left and right
        // if target is met:
        // res = math.min(res, left - tight + 1)
        // move left until target is unmet

        int left = 0;
        int res = Integer.MAX_VALUE;
        int current = 0;
        for(int right=0; right<nums.length; right++){
            current += nums[right];
            while(current>=target){
                res = Math.min(res, right-left+1);
                current -=nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}