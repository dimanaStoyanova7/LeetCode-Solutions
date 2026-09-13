class Solution {
    public int longestOnes(int[] nums, int k) {
        // keep a counter for 0s 
        //sliding window
        int counter = 0;
        int left = 0;
        int result = 0;
        for (int right = 0; right<nums.length; right++){
            if(nums[right]==0){
                // expand on the right
              counter++;  
            }
            while(counter>k){
                //shrink from the left
                if(nums[left++]==0){
                    counter--;
                }
            }
            //check if res should be updated
            result = Math.max(result, right-left+1);
        }
        return result;

    }
}
