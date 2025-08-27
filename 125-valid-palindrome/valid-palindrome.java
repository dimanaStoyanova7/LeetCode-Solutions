class Solution {
    public boolean isPalindrome(String s) {
        // Remove all non-alphanumeric characters and convert to lowercase
        String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Check for palindrome
        int len = cleanedString.length();
        for(int i=0; i<len/2;i++){
            if(cleanedString.charAt(i)!=cleanedString.charAt(len-1-i)) return false;
            
        }
        return true;
    }
}
