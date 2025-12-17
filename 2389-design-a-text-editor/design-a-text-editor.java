class TextEditor {
    // left | cursor | right
    private Deque<Character> left;
    private Deque<Character> right;

    public TextEditor() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }
    
    public void addText(String text) {
        for(char c : text.toCharArray()){
            left.addLast(c);
        }
    }
    
    public int deleteText(int k) {
        int deleted = 0;
        while(k>0 && !left.isEmpty()){
            left.removeLast();
            deleted++;
            k--;
        }
        return deleted;        
    }
    public String cursorLeft(int k) {
        while(k>0 && !left.isEmpty()){
            right.addFirst(left.removeLast());
            k--;
        }
        return last10Helper();
    
    }
    
    public String cursorRight(int k) {
        while(k>0 && !right.isEmpty()){
            left.addLast(right.removeFirst());
            k--;
        }
        return last10Helper();
    }
    private String last10Helper(){
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        Iterator<Character> it = left.descendingIterator();
        while(counter<10 && it.hasNext()){
            sb.append(it.next());
            counter++;
        }
        return sb.reverse().toString();
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */