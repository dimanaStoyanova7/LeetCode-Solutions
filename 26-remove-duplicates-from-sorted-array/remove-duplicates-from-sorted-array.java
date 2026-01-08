class Solution {

    public int removeDuplicates(int[] nums) {
        //2 pointers
        //1 at at the write index and one iterating
        int writeIndex = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]!=nums[i-1]){
                nums[writeIndex++] = nums[i];
            }
        }
        return writeIndex;
    }
}