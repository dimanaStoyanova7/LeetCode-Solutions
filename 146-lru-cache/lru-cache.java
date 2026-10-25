class LRUCache {
    private class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> valueToReference;

    public LRUCache(int capacity) {
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        valueToReference = new HashMap<>();
    }
    
    public int get(int key) {
        if (!valueToReference.containsKey(key)){
            return -1;
        }
        Node node = valueToReference.get(key);
        remove(node);                               
        addToTail(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(valueToReference.containsKey(key)){
            Node node = valueToReference.get(key);
            node.value = value;
            remove(node);                          
            addToTail(node);
            return;
        }
        else if(valueToReference.size()==capacity){
            //remove front 
            Node lru = head.next;
            remove(lru);
            valueToReference.remove(lru.key);
        }
        //add to tail
        Node node = new Node(key, value);          
        valueToReference.put(key, node);
        addToTail(node);

    }
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */