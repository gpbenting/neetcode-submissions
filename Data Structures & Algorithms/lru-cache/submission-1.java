class LRUCache {

    private int capacity;
    private LinkedList<Integer> keyList;
    private Map<Integer, Integer> cacheMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyList = new LinkedList<>();
        this.cacheMap = new HashMap<>(capacity);
    }

    public int get(int key) {
        Integer value = cacheMap.getOrDefault(key, -1);
        if (value >= 0) {
            moveToLast(key);
        }
        return value;
    }

    private void moveToLast(int key) {
        keyList.remove((Integer) key);
        keyList.addLast(key);
    }

    public void put(int key, int value) {
        Integer prevValue = cacheMap.put(key, value);
        if (prevValue == null) {
            if (cacheMap.size() > capacity) {
                Integer removeKey = keyList.removeFirst();
                cacheMap.remove(removeKey);
            }
            keyList.addLast(key);
        } else {
            moveToLast(key);
        }
    }
}
