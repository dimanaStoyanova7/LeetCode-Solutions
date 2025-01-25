class Solution {
    
    public String longestPalindrome(String s) {
        //brute force
        /*
        if(s.length() < 2) return s;
        String res = "";
        for(int i=0; i<s.length();i++){
            for(int j=i; j<s.length(); j++){
                String current = s.substring(i, j+1);
                if(isPalindrome(current) && current.length()>res.length()) res = current;
            }
        }
        return res;
        */
        String longest = "";
        for(int i=0; i<s.length(); i++){
            String even = expandFromCentre(s, i,i);
            String odd = expandFromCentre(s, i, i+1);
            if(even.length()>longest.length()) longest = even;
            if(odd.length()>longest.length()) longest = odd;
        }
        return longest;
    }
    String expandFromCentre(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1, r);
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