class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // keep stack of indices
        // check peek of stack: while the element at that index < current element: pop
        // put on stack of incdices
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i<n; i++){
            int currentTemp = temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.peek()]<currentTemp){
                int processedIndex = stack.pop();
                res[processedIndex] = i-processedIndex;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            res[stack.pop()] = 0;
        }
        return res;
    }
}