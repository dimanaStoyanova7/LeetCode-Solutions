class BrowserHistory {
    String current;
    Deque<String> next;
    Deque<String> previous;

    public BrowserHistory(String homepage) {
        previous = new ArrayDeque<>();
        next = new ArrayDeque<>();
        current = homepage;
    }
    
    public void visit(String url) {
        //change current
        //put old current on 'go back' stack
        previous.push(current);
        current = url;
        next.clear();
    }
    
    public String back(int steps) {
        //change current
        //put old current on 'go forward' stack
        for(int i=0; i<steps;i++){
            if(previous.isEmpty()){
                return current;
            } 
            next.push(current);
            current = previous.pop();
        }
        return current;
    }
    
    public String forward(int steps) {
        for(int i=0; i<steps;i++){
            if(next.isEmpty()){
                return current;
            } 
            previous.push(current);
            current = next.pop();
        }
        return current;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */