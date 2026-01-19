class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int right = height.length - 1;
        int left = 0;
        while(left<right){
            //length = right - lef
            int current = (right-left)*Math.min(height[right], height[left]);
            if (current>res){
                res = current;
            }
            if(height[left]>height[right]){
                right--;
            }
            else{
                left++;
            }
        }
        return res;
    }
}