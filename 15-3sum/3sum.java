class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); 
        for(int i=0; i<nums.length-2; i++){
            int curr = nums[i];
            if(i>0 && curr==nums[i-1]) continue;
            //use two pointers and implement two sum
            int l = i+1;
            int r = nums.length-1;
            while (l<r){
                int sum = nums[l]+nums[r]+curr;
                if(sum==0){
                    res.add(Arrays.asList(curr, nums[l], nums[r]));
                    l++; r--;
                    //skip dublicates on the right and left
                    while (l < r && nums[l]==nums[l-1]) l++;
                    while (l < r && nums[r]==nums[r+1]) r--;
                }
                else if (sum>0) r--;
                else l++;
            }
            
        }
        return res;
    }
}