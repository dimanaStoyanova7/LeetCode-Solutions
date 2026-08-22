class Solution {
    public void sortColors(int[] nums) { 
        int n = nums.length;
        int red = 0; // red 0
        int white = 0; //white 1
        for(int num:nums){
            if(num == 0){
                red++;
            }
            if(num == 1){
                white++;
            }
        }
        for(int i = 0; i<red; i++){
            nums[i]=0;
        }
        for(int i=red; i<red+white; i++){
            nums[i]=1;
        }
        for(int i=red+white; i<n; i++){
            nums[i]=2;
        }
    }
}