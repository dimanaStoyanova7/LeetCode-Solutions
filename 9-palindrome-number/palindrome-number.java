class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int original = x;
        int reversed = 0;
        //reverse the number
        while(x>0){
            int digit = x % 10;
            x /= 10;
            reversed = 10* reversed + digit;
        }
        return reversed == original;
    }
}