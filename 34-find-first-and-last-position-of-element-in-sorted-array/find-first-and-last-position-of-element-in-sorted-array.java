class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums, target), findLast(nums, target)};
    }
    int findFirst(int[] nums, int target){
        int res = -1;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low) /2;
            if (nums[mid]==target){
                res = mid;
                high = mid-1;
            } else if (nums[mid] < target) {
            low = mid + 1; 
            } else {
                high = mid - 1;
            }
        }
        return res;

    }
    int findLast(int[] nums, int target){
        int res = -1;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low) /2;
            if (nums[mid]==target){
                res = mid;
                low = mid+1;
            } else if (nums[mid] < target) {
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }
        return res;
    }
}