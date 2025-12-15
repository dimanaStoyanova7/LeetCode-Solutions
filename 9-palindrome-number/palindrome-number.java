class Solution {
    public boolean isPalindrome(int x) {
        //if negative -> false
        if(x<0){
            return false;
        }
        //revert number
        int reverted = 0;
        int original = x;
        while(x>0){
            reverted = reverted*10 + (x%10);
            x /= 10;
        }
        //compare reverted and x
        return reverted == original;
    }
}