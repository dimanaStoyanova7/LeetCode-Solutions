class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // binary search on a solution space
        // solution space is bounded by 0 and the biggest pile
        int left = 0;
        int right = 0;
        for (int pile: piles) right = Math.max(right, pile);
        while(left<=right){
            int mid = (left+right)/2;
            if(isSpeedSufficient(piles, h, mid)){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    public boolean isSpeedSufficient(int[] piles, int h, int speed){
        int resHours = 0;
        for(int pile: piles){
            resHours += Math.ceil( (double) pile/speed);
        }
        return resHours<=h;
    }
}