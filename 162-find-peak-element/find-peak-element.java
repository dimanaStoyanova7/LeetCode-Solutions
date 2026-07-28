class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            //slope is ascending
            if(nums[mid]<nums[mid+1]){
                //solution is in right half
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}