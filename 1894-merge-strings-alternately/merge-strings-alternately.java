class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        boolean flag = true;
        while(i<word1.length() && j<word2.length()){
            if(flag==true){
                sb.append(word1.charAt(i++));
            }else{
                sb.append(word2.charAt(j++));
            }
            flag = !flag;
        }
        while(i<word1.length()){
            sb.append(word1.charAt(i++));   
        }
        while(j<word2.length()){
            sb.append(word2.charAt(j++));   
        }
        return sb.toString();
        
    }
}