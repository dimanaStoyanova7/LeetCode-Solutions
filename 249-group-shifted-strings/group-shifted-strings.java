class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        //for each - take the first letter, shift it to begin with a 
        //use a hashmap
        Map<String, List<String>> map = new HashMap<>();
        for(String str:strings){
            String key = buildKey(str);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
    public String buildKey(String str){
        StringBuilder sb=new StringBuilder();
        int shift = str.charAt(0) - 'a';

        for(char c : str.toCharArray()){
            int normalized =(c - 'a' - shift +26)%26;
            sb.append((char)(normalized + 'a'));
        }
        return sb.toString();
    } 
}