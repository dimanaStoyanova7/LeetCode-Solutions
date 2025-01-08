class LRUCache {
    //hashmap key -> node with key and value
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    // add to front
    public void addToList(Node node){
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    // remove from any given poisiton
    public void removeFromList(Node node){
       node.prev.next = node.next;
       node.next.prev = node.prev;
    }
    
    /*
     * when getting an element, we remove the element from list, and add it back to reflect on frequent use
     */
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        removeFromList(node);
        addToList(node);
        return node.value;
    }
    /*
     * remove element if it exists : from map and from list
     * then add element to both map and list,
     * if capacity is exceed: fix
     */
    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            removeFromList(node);
            addToList(node);
            node.value = value;
        } else {
            Node node = new Node(key, value);
            addToList(node);
            map.put(key, node);
        }
        if(map.size()>capacity){
            //take node before tail and remove it from list and map
            Node nodeToRemove = tail.prev;
            tail.prev = nodeToRemove.prev;
            tail.prev.next = tail;
            map.remove(nodeToRemove.key);
        }
        
    }
}
class Node{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */