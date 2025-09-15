class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
       int n = nums.length;
       Map<Integer, Integer> remainderToIndex = new HashMap<>();
       remainderToIndex.put(0, -1);
       int sum = 0;
       for(int i=0; i<n; i++){
            sum += nums[i];
            int remainder = sum%k;
            if(remainderToIndex.containsKey(remainder)){
                if(i-remainderToIndex.get(remainder)>=2){
                    return true;
                }
                continue;
            }
            remainderToIndex.put(remainder,i);
       }
       return false;
    }
}