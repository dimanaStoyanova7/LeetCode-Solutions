class Solution {
    public int subarraySum(int[] nums, int k) {
        //work with prefix sums
        //at each prefix sum, check if the value of prefix sum - k was already a prefix sum,
        // and if yes, how many times
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        int currentSum = 0;
        int res = 0;
        prefixSumCount.put(0,1);

        for(int i = 0; i<nums.length; i++){
            currentSum += nums[i]; 
            if(prefixSumCount.containsKey(currentSum-k)){
                res += prefixSumCount.get(currentSum-k);
            }
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        }
        
        return res;
    }
}