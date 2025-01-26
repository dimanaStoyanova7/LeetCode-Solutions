class Logger {
    Map<Integer, Integer> map;
    Queue<int[]> queue;

    public Logger() {
        map = new HashMap<>();
        queue = new LinkedList<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        while(!queue.isEmpty() && queue.peek()[0]<=timestamp-10){
            int messageHash = queue.poll()[1];
            map.remove(messageHash);
        }
        if(map.containsKey(message.hashCode())){
            return false;
        }
        queue.offer(new int[]{timestamp, message.hashCode()});
        map.put(message.hashCode(), timestamp);
        return true;
        
        
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */