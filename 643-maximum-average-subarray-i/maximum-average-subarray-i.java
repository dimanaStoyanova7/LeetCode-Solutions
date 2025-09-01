class Solution {
    public double findMaxAverage(int[] nums, int k) {
        long current = 0;
        for(int i=0; i<k; i++){
            current += nums[i];
        }
        long res = current;
        for(int i=k; i<nums.length; i++){
            current = current - nums[i-k] + nums[i];
            if (current>res) res = current;
        }
        return (double) res/k;
    }
}