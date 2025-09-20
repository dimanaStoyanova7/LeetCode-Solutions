class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int res = 0;
        boolean hasOdd = false;
        for(int count : map.values()){
            res +=(count/2)*2;
            if (count%2==1) hasOdd = true;
        } 
        if(hasOdd) res++;
        return res;
    }
}