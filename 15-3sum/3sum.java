class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //sort and then fix one element and apply 2 sum to the rest (2 sum with 2 pointers) <- o(n^2)
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum = nums[left] + nums[right]+ nums[i];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                }
                if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }

        }
        return res;
    }
}