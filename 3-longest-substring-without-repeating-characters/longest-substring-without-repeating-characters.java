class Solution {
    public int lengthOfLongestSubstring(String s) {
        // set of characters in string
        Set<Character> set = new HashSet<>();
        int left = 0;
        int res = 0;
        for(int right = 0; right<s.length(); right++){
            char current = s.toCharArray()[right];
            while(set.contains(current)){
                set.remove(s.toCharArray()[left]);
                left++;
            }
            set.add(current);
            res = Math.max(res, right-left+1);
        }
        return res;
    }
}