class Solution {
    public int lengthOfLongestSubstring(String s) {
      // 1st approach: brute force: for every character, 
      //find the distance without repeating     characters (o(n^2))

      // 2nd approach: sliding window and hashmap
      int left = 0;
      char[] arr = s.toCharArray();
      Map<Character, Integer> map = new HashMap();
      int res = 0;
      for(int right = 0; right< s.length(); right++){
        if(map.containsKey(arr[right])){
            left = Math.max(map.get(arr[right])+1, left);
            map.put(arr[left], left);
        }
        map.put(arr[right], right);
        res = Math.max(res, right-left+1);
      }
      return res;

    }
}