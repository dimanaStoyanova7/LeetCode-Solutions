class Solution {
    public int countTriplets(int[] arr) {
        // brute force - at each index - start expanding k and when xor goes to 0 => add k-i
        int res=0;
        int n = arr.length;
        int[] prefixSums = new int[n+1];
        //construct prefix sum
        for(int i=1; i<=n; i++){
            prefixSums[i] = prefixSums[i-1]^arr[i-1];
        }
        // 
        for (int i=0; i<=n; i++){
            for (int j=i+1; j<=n; j++){
                if(prefixSums[i]==prefixSums[j])res += j-i-1;
            }
        }
        return res;
    
    }
}