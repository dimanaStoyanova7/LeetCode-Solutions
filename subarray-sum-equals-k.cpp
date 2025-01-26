class Solution {
    public int subarraySum(int[] nums, int k) {
        //work with prefix sums
        //at each prefix sum, check if the value of prefix sum - k was already a prefix sum,
        // and if yes, how many times
    
        Map<Integer, Integer> prefixSumCounts = new HashMap<>();
        prefixSumCounts.put(0,1);
        int res = 0;
        int currentSum = 0;
        for (int num : nums){
            currentSum +=num;
            if(prefixSumCounts.containsKey(currentSum-k)){
                res += prefixSumCounts.get(currentSum-k);
            }
            prefixSumCounts.put(currentSum, prefixSumCounts.getOrDefault(currentSum, 0)+1);

        }
        return res;
    }
}