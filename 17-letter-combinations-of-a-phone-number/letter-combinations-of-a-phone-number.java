class Solution {
    public String[] mapping = new String[]{"","","abc","def", "ghi","jkl", "mno", "pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return List.of();
        List<String> res = new ArrayList<>();
        backtrack(res, digits, new StringBuilder(""), 0);
        return res;
    }
    void backtrack(List<String> result, String digits, StringBuilder current, int index){
        if(current.length()==digits.length()){
            result.add(current.toString());
            return;
        }
        String currentLetters = mapping[digits.charAt(index)-'0'];
        for(char c : currentLetters.toCharArray()){
            current.append(c);
            backtrack(result, digits, current, index+1);
            current.deleteCharAt(current.length()-1);
        }
    }
}