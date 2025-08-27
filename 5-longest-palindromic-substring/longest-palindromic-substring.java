class Solution {
    public String longestPalindrome(String s) {
        int[] res = new int[] {0,0};
        for(int i = 0; i<s.length(); i++){
            int oddLength = expand(s, i, i);
            int evenLength = expand(s,i, i+1);
            if(oddLength > res[1] - res[0]+1){
                res[0] = i - oddLength/2;
                res [1] = i + oddLength/2;
            }
            if(evenLength > res[1] - res[0]+1){
                res[0] = i - evenLength/2 + 1;
                res[1] = i + (evenLength/2) ;

            }
        }
        return s.substring(res[0], res[1]+1);
    }
    public int expand(String s, int l, int r){
        while(l>=0 && r< s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
}