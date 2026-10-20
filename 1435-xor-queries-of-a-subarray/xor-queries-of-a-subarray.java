class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        // brute force 
        int n = queries.length;
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int xor =0;
            while(l<=r){
                xor^=arr[l++];
            }
            result[i] = xor;
        }
        return result;
    }
}