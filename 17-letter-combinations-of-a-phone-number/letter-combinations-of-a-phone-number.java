class Solution {
    public List<String> letterCombinations(String digits) {
        //have a map
        Map<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        //call a backtracking method to compose the combinations
        List<String> result = new ArrayList<>();
        addCombinations(result, "", 0,digits, map);
        return result;
    }
    /// current string
    // index from the digits to take next
    /// digits to iterate though
    /// map to take from
    private void addCombinations(List<String> result, String current, int index, String digits, Map<Character, String> map){
        if(current.length()==digits.length()){
            result.add(current);
            return;
        }
        //take the digit at inde
        char digit = digits.charAt(index);
        //get the possible letters for that digit
        String letters = map.get(digit);
        //append 
        //recursive call
        //unappend
        for(char letter : letters.toCharArray()){
            addCombinations(result,current+letter, index+1, digits, map);
        }
    }
}