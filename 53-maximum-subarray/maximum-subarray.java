class Solution {
    public int maxSubArray(int[] nums) {
        // construct prefix sum
        //nums = [5,4,-1,7,8]
        //       [5,9,8,15,23]
        // at each index: compute the prefix Sum - min Sum so far
        int minSum = 0;
        int result = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int num: nums){
            currentSum +=num;
            
            result = Math.max(result, currentSum-minSum);

            minSum = Math.min(minSum, currentSum);
        }
        return result;
    }
}