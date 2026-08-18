class BrowserHistory {
    private String[] history;
    private int current;
    private int size;
                  
    public BrowserHistory(String homepage) {
         history = new String[5001];
        history[0] = homepage;
        current = 0;
        size = 1;
    }
    
    public void visit(String url) {
         current++;

        history[current] = url;
        size = current + 1;
    }
    
    public String back(int steps) {
        current = Math.max(0, current - steps);
        return history[current];
    }
    
    public String forward(int steps) {
        
     current = Math.min(size - 1, current + steps);
        return history[current];
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */