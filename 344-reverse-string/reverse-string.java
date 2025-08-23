class Solution {
    public void reverseString(char[] s) {
        // for(int i=0; i<s.length/2; i++){
        //     char temp = s[i];
        //     s[i] = s[s.length-i-1];
        //     s[s.length-i-1]=temp;
        // }
        // two pointers approach
        int l = 0;
        int r = s.length -1;
        while(r>l){
            char temp = s[l];
            s[l++]=s[r];
            s[r--]=temp;
        }
    }
}