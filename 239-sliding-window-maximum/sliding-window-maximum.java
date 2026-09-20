class Solution {
    // complexity space - o(n log n)
    // complexity time - o(n) maximal
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // storing indices in monotonic order
        Deque<Integer> dq = new ArrayDeque<>(); 
        int[] res = new int[n-k+1];
        for(int i = 0; i<n; i++){
            int currentElement = nums[i];
            //remove indices that are too old        
            while(!dq.isEmpty() && dq.peekFirst()<= i - k){
                dq.pollFirst();
            }
            //keep monotonicity
            while(!dq.isEmpty() && currentElement>nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.addLast(i);
            if(i>=k-1){
                res[i-k+1] = nums[dq.peekFirst()];

            }
        }
        return res;
    
    }
}