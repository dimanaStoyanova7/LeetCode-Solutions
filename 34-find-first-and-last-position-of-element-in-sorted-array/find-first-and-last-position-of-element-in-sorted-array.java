class Solution {
    public int[] searchRange(int[] nums, int target) {
        // brute force approach:  iterate from beggining and track
        // optimizer approah : o(log(n)) - 2 binary searches
        int l1 = 0;
        int r1 = nums.length-1;
        int l2 = 0;
        int r2 = nums.length-1;
        int[] result = {-1,-1};
        while(l1<=r1){
            int mid = l1+(r1-l1)/2;
            if(nums[mid]<target) l1 = mid + 1;
            else r1 = mid-1; 
        }
        while(l2<=r2){
            int mid = l2+(r2-l2)/2;
            if(nums[mid]<=target) l2 = mid+1;
            else r2 = mid-1;
        }
        if (l1 < nums.length && nums[l1] == target) {
            result[0] = l1;
        }
        if (r2 >= 0 && nums[r2] == target) {
            result[1] = r2;
        }
        return result;
    }
}