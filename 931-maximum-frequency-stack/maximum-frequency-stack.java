class FreqStack {
    Map<Integer, Integer> valToCount;
    Map<Integer, Deque<Integer>> countToValues;
    int maxCount;
    public FreqStack() {
        valToCount = new HashMap<>();
        countToValues = new HashMap<>();
        maxCount = 0;
    }
    
    public void push(int val) {
        int count =  valToCount.getOrDefault(val,0)+1;
        valToCount.put(val, count);
        countToValues.computeIfAbsent(count, c -> new ArrayDeque<>()).push(val);
        maxCount = Math.max(count, maxCount);
    }
    
    public int pop() {
        Deque<Integer> elements = countToValues.get(maxCount);
        int element = elements.pop();
        if(maxCount == 1){
            valToCount.remove(element);
        }
        else{
            valToCount.put(element, maxCount-1);
        }
        if(elements.isEmpty()){
            countToValues.remove(maxCount);
            maxCount--;
        }
        return element;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */