class LFUCache {

    class Entry{
        int key;
        int value;
        int frequency;
        Entry(int key, int value, int frequency){
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }
    }

    Map<Integer, Entry> keyToEntry;
    Map<Integer, List<Entry>> frequencyToElements;
    int capacity;
    int smallestFrequency;

    public LFUCache(int capacity) {
        keyToEntry = new HashMap<>();
        frequencyToElements = new HashMap<>();
        this.capacity = capacity;
        this.smallestFrequency = 1;
    }
    
    public int get(int key) {
        if(!keyToEntry.containsKey(key)){
            return -1;
        }
        Entry entry = keyToEntry.get(key);
        //remove from bucket
        List<Entry> entries = frequencyToElements.get(entry.frequency);
        entries.remove(entry);
        if (entries.isEmpty() && entry.frequency == smallestFrequency) {
            smallestFrequency++;                                   // fix 6
        }
        entry.frequency += 1;
        frequencyToElements.computeIfAbsent(entry.frequency, k -> new LinkedList<>()).add(entry);
        return entry.value;

    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;                                  

        if (keyToEntry.containsKey(key)) {
            Entry entry = keyToEntry.get(key);
            entry.value = value;                                    
            List<Entry> entries = frequencyToElements.get(entry.frequency);
            entries.remove(entry);
            if (entries.isEmpty() && entry.frequency == smallestFrequency) {
                smallestFrequency++;                              
            }
            entry.frequency += 1;
            frequencyToElements.computeIfAbsent(entry.frequency, k -> new LinkedList<>()).add(entry); 
            return;
        }
        if (keyToEntry.size() == capacity) {                        
            List<Entry> entries = frequencyToElements.get(smallestFrequency);
            Entry toRemove = entries.remove(0);
            keyToEntry.remove(toRemove.key);
        }
        Entry entry = new Entry(key, value, 1);                     
        frequencyToElements.computeIfAbsent(1, k -> new LinkedList<>()).add(entry);
        keyToEntry.put(key, entry);                                 
        smallestFrequency = 1;                                    
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */