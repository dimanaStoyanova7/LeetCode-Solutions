class Solution {
    public int maxArea(int[] height) {
        // start from both ends
        // shrink from the smaller end
        // until the 2 ends meet
        // keep a max 
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while(left<right){
            int area = Math.min(height[left], height[right]) * (right-left);
            result = Math.max(result, area);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }

        return result;
    }
}