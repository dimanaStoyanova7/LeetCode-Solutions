class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < nums.length; i ++){
            if(set.containsKey(target-nums[i])){
                return new int[]{i, set.get(target-nums[i])};
            }
            else{
                set.put(nums[i],i);
            }
        }
        return null;
    }
}