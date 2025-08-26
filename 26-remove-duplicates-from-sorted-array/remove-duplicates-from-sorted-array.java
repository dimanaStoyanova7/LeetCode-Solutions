class Solution {
    public int removeDuplicates(int[] nums) {
    //     int k = 1;
    //     for(int i = 1; i< nums.length; i++){
    //         if(nums[i]!=nums[i-1]){
    //             nums[k++] = nums[i];

    //         }
    //     }
    //    return k;
    // }
    //todo - implement with runs
        int k = 0;
        int i = 0;
        while (i<nums.length){
            int current = nums[i];
            while ( i<nums.length && nums[i]==current){
                i++;
            }
            nums[k++] = current;
        }
        return k;
    }
    
}