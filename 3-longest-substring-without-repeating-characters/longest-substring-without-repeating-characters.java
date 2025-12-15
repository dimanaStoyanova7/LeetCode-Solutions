class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        int right = 0;
        for (int l = 0; l<s.length(); l++){
            char c = s.toCharArray()[l];
            while(set.contains(c)){
                set.remove(s.toCharArray()[right]);
                right++;
            }
            set.add(c);
            result = Math.max(result, l-right+1);
        }
        return result;
    }
}