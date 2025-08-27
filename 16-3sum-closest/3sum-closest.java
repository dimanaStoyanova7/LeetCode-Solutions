class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2; i++){
            int curr = nums[i];
            int l = i+1;
            int r = nums.length-1;
            while(l<r){
                int sum = curr+nums[l]+nums[r];
                if(Math.abs(target-sum)<Math.abs(target-res)){
                    res = sum;
                }
                else if (sum<target){
                    l++;
                }
                else if(sum>target){
                    r--;
                }
                else return target;
            }
        }
        return res;
    }
}