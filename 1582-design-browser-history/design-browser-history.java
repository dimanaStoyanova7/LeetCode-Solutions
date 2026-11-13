class BrowserHistory {
    List<String> history;
    int current;
    int last;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        current = 0;
        last = 0;
    }
    
    public void visit(String url) {
        current++;
        if(current<history.size()){
            history.set(current, url);
        }else{
            history.add(url);
        }
        last=current;
    }
    
    public String back(int steps) {
        current = Math.max(0, current-steps);
        return history.get(current);
    }
    
    public String forward(int steps) {
        current = Math.min(current+steps, last);
        return history.get(current);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */