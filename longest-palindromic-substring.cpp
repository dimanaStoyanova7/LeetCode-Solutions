class Solution {
    
    public String longestPalindrome(String s) {
        //brute force
        if(s.length() < 2) return s;
        String res = "";
        for(int i=0; i<s.length();i++){
            for(int j=i; j<s.length(); j++){
                String current = s.substring(i, j+1);
                if(isPalindrome(current) && current.length()>res.length()) res = current;
            }
        }
        return res;
    }
    boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}