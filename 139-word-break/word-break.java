class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp with formula dp[i], i being the i-th character
        // is true if is it possible to have the character

        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];

        dp[0] = true; //) characters
        for(int i = 1; i<=s.length(); i++){
            for (int j = 0; j< i; j++){
                if(dp[j]==true && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}