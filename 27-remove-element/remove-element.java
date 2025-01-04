class Solution {
    public int removeElement(int[] nums, int val) {
        // 1st approach: fast and slow pointer
        // int i = 0;
        // for (int j = 0; j < nums.length; j++){
        //     if(nums[j]!=val){
        //         nums[i] = nums[j];
        //         i++;
        //     }
        // }
        // return i;

        // 2nd approach: put unnecessary elements in the back (when we have few invalid el.)
        int i = nums.length-1;
        int j = 0;
        while(j<=i){
            if (nums[j]==val){
                nums[j] = nums[i];
                i--;
            }
            else{
                j++;
            }
        }
        return j;
    }       
}