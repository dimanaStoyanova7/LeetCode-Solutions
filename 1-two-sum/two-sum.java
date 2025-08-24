class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < nums.length; i ++){
            int need = target-nums[i];
            if(set.containsKey(need)){
                return new int[]{i, set.get(need)};
            }
            else{
                set.put(nums[i],i);
            }
        }
        return null;
    }
}