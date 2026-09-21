class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        addCombinations(candidates, res, new ArrayList<>(),0,0,target);
        return res;
    }
    private void addCombinations(int[] candidates, List<List<Integer>> res, List<Integer> current, int index, int sum, int target){
        if(target == sum){
            res.add(new ArrayList<>(current));
            return;
        }
        if(sum > target){
            return;
        }
        for(int i=index; i<candidates.length; i++){
            int number = candidates[i];
            sum += number;
            current.add(number);
            addCombinations(candidates, res, current, i, sum, target);
            current.remove(current.size()-1);
            sum -= number;
        }
    }
}