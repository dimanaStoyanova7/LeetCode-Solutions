class Solution {
    public int lengthOfLongestSubstring(String s) {
        //1st approach: brute force - start at each char and check
        //2nd approach: sliding window
        int left = 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>(); //character pointing at its last occurance
        for(int right = 0; right<s.length(); right++){
            char current = s.charAt(right);
            if(map.containsKey(current)){
                left = Math.max(left, map.get(current)+1);
            }
            map.put(current, right);
            res = Math.max(res, right-left+1);
        }
        return res;
    }
}