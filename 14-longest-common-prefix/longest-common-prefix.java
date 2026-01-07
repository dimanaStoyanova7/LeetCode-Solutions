class Solution {


    public String longestCommonPrefix(String[] strs) {
        //stringbuilder as a result
        //append to stringbuilder if all strs at index i have the same character
        if (strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();

        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }

        for(int i = 0; i< minLen; i++){
            boolean areTheSame = true;
            char c = strs[0].charAt(i);
            for(String str: strs){
                if (str.charAt(i) != c){
                    areTheSame = false;
                }
            }
            if(areTheSame){
                sb.append(c);
            }
            else{
                return sb.toString();
            }
        }
        return sb.toString();
        
    }
}