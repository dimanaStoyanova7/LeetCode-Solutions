class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> res = new ArrayList<>();
       boolean[] used = new boolean[nums.length];
       addPermutations(0, nums, new LinkedList<>(), res, used);
       return res;
    }
    private void addPermutations(int start, int[] nums, List<Integer> current, List<List<Integer>>res, boolean[] used){
        int n = nums.length;
        if(current.size() == n){
            res.add(new ArrayList<>(current));
            return;
        }
        for(int i=0; i<n; i++){
            if(used[i]) continue;
            used[i] = true;
            current.add(nums[i]);
            addPermutations(i+1, nums, current, res,used);
            current.remove(current.size()-1);
            used[i]=false;
        }
    }
}
// like backtracking for ocmbinations but k = nums.length;
// add 