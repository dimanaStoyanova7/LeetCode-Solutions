class Solution {
    public int climbStairs(int n) {
        //recursive fibonacci
/*
        if(n==1) return 1;
        if(n==2) return 2;
        return climbStairs(n-1)+ climbStairs(n-2);
*/
        //dp with o(n) space complexity
        //formula dp[i] = dp[i-1]+dp[i-2]

        
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        //dp[2]=2;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
  

        //dp approach with constant space complexity
        /*
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        int first = 1;
        int second = 2;
        for(int i=3; i<=n; i++){
            int current = first + second;
            first = second;
            second = current;
        }
        return second;
        */
        
    }
}