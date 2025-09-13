class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumsToCounts = new HashMap<>();
        int res =0;
        int sumSoFar = 0;
        //basecase
        sumsToCounts.put(0, 1);
        for(int i=0; i<nums.length; i++){
            int current = nums[i]; 
            sumSoFar += current;

            if (sumsToCounts.containsKey(sumSoFar - k)){
                res+=sumsToCounts.get(sumSoFar-k);
            }
            sumsToCounts.put(sumSoFar, sumsToCounts.getOrDefault(sumSoFar, 0)+1);

        }
        return res;
    }
}