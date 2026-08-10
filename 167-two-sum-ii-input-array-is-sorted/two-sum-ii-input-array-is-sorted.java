class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int right = numbers.length-1;
        int left = 0;
        for(int i = 0; i< numbers.length; i++){
            int numRight = numbers[right];
            int numLeft = numbers[left];
            if(numRight+numLeft>target){
                right--;
            }
            else if(numRight+numLeft<target){
                left++;
            }
            else{
                return new int[]{left+1, right+1};
            }
        }
        return new int[2];
    }
}