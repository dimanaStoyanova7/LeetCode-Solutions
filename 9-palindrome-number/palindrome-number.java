class Solution {
    public boolean isPalindrome(int x) {
        //if negative: return false
        if (x<0){
            return false;
        }
        int copyX = x;
        int reverted = 0;
        while(x>0){
            reverted = reverted*10 + x%10;
            x /= 10;
        }
        return reverted == copyX;
    }
}