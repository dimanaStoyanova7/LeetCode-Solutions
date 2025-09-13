class Solution {
    public int characterReplacement(String s, int k) {
        //longest substring with all same characters with k exceptions 
        //changes needed = window length - maxCount (maxCount indicates same element)
        //keep the window valid
        //when it is no longer valid - shrink on the right
        int res = 0;
        int left = 0;
        int maxCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int right = 0; right<s.length(); right++){
            char c = s.charAt(right);
            //put it in the map
            map.put(c, map.getOrDefault(c,0)+1);
            maxCount = Math.max(maxCount, map.get(c));
            //shrink window until valid (if needed)
            while(k<(right-left+1)-maxCount){
                char removed = s.charAt(left); 
                map.put(removed, map.get(removed)-1);
                left++;
            }
            //update result
            res = Math.max(res, right-left+1);
        }
        return res;
    }
}
