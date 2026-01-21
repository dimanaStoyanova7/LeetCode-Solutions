class Solution {
    public int subarraySum(int[] nums, int k) {
        //prefix sums go into hashmap
        int n = nums.length;
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);
        int res = 0;
        int currentSum = 0;
        for(int i=0; i<n; i++){
            //calculate current prefix sum
            //if k - current prefix sum exists in map, add to result
            // add in map current prefix sum
            currentSum += nums[i];
            int target = currentSum-k;
            if(sumToCount.containsKey(target)){
                res += sumToCount.get(target);
            }
            sumToCount.put(
                currentSum,
                sumToCount.getOrDefault(currentSum, 0)+1
            );
        }
        return res;

        

    }
}