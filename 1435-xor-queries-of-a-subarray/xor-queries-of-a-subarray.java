class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        // prefix sum
        int n = arr.length;
        int[] prefix = new int[n+1];
        for(int i=0; i<n; i++){
            prefix[i+1] = prefix[i] ^ arr[i];
        }
        int[] res = new int[queries.length];
        for(int i=0; i<queries.length;i++){
            int[] q = queries[i];
            int l = q[0];
            int r = q[1];
            res[i] = prefix[l]^prefix[r+1];
        }
        return res;

        // brute force 

        // int n = queries.length;
        // int[] result = new int[n];
        // for(int i=0; i<n; i++){
        //     int l = queries[i][0];
        //     int r = queries[i][1];
        //     int xor =0;
        //     while(l<=r){
        //         xor^=arr[l++];
        //     }
        //     result[i] = xor;
        // }
        // return result;
    }
}