class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //expand until window satisfies condition and then shrink from the right
        int left = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;
        for(int right = 0; right<nums.length; right++){
            currentSum += nums[right];
            while(currentSum>=target){
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }
        if(minLength==Integer.MAX_VALUE) return 0;
        return minLength;
    }
}