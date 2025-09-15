class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
       //sort characters in each word
       //use a hashmap sorted -> list of original strings
       Map<String, List<String>> map = new HashMap<>();
       for(String word: strs){
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(word);
       }
       return new ArrayList(map.values());
    }
}