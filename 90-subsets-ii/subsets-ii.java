class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Backtracking approach
        Arrays.sort(nums);
        List<List<Integer>> res  = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        backtrack(res, currentSubset, nums, 0);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> current, int[] nums, int start){
        res.add(new ArrayList<>(current));
        for(int i = start; i < nums.length; i++){
            if (i != start && nums[i] ==nums[i-1]) continue;
            current.add(nums[i]);
            backtrack(res, current, nums, i+1);
            current.remove(current.size()-1);
        }
    }
}