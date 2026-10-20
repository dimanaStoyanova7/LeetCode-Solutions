class Solution {
    public int lengthOfLIS(int[] nums) {
        //tails[i] = has the best(smallest) ending of length i
        //use binary search to find the highest i that could be extended to i+1
        int n = nums.length;
        int size = 0;
        int tails[] = new int[n];
        for(int i=0; i<n; i++){
            int val = nums[i];
            int low = 0;
            int high = size;
            while (low<high){
                int mid = low+ (high-low)/2;
                if(val<=tails[mid]){
                    high = mid;
                }else{
                    low = mid+1;
                }
            }
            tails[low] = val;
            if(low==size) size++;
        } 
        return size;
    }
}