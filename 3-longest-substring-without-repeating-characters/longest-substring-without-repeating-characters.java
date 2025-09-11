class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLen = 0;
        int currLength = 0;
        Set<Character> chars = new HashSet<>();
        for(int right = 0; right<s.length(); right++){
            //check if the character is n the set
            char curr =  s.charAt(right);
            //if char is in the set: move left while char[left] is thethe current char and once more
            if(chars.contains(curr)){
                while(s.charAt(left)!=curr){
                    chars.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            //if char is not in the set: add it, update currLength, possibly maxLen
            chars.add(curr);
            currLength = right - left +1;
            if(currLength > maxLen) maxLen = currLength;
        }
        return maxLen;
    }
}