class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
       int left = 0;
       int currentProduct = 1;
       int result = 0;
       if (k <= 1) return 0;
       for(int right = 0; right<nums.length; right++){
        //shrink window until valid
        currentProduct *=nums[right];
        while(currentProduct>=k){
            currentProduct /= nums[left];
            left++;
        }
        result+=right-left+1;
       } 
       return result;
    }
}