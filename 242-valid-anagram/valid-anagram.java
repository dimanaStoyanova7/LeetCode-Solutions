class Solution {
    public boolean isAnagram(String s, String t) {
        //1st approach: sort and iterate

        /*
        char[] arr1 = s.toCharArray();
        Arrays.sort(arr1);

        char[] arr2 = t.toCharArray();
        Arrays.sort(arr2);
        
        for(int i = 0 ; i < arr1.length; i++){
            if (arr1[i]!=arr2[i]) return false;
        }
        return true;

        */

        // 2nd approach: using a map
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(char c: t.toCharArray()){
            if(!map.containsKey(c)) return false;
            map.put(c, map.get(c)-1);
            if(map.get(c)==0) map.remove(c);
        }
        return map.isEmpty();

        
    }
}