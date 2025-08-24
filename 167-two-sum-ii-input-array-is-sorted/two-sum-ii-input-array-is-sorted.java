class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0;
        int r = n-1;
        while(l<r){
            int lVal = numbers[l];
            int rVal = numbers[r];
            if (lVal + rVal == target){
                return new int[] {l+1,r+1};
            }
            else if (lVal + rVal < target){
                l++;
            }
            else{
                r--;
            }
        }
        return null;
    }
}