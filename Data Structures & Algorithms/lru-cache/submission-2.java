class LRUCache {

    private final int capacity;
    private final LinkedList<Integer> keyList;
    private final Map<Integer, CacheValue> cacheMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyList = new LinkedList<>();
        this.cacheMap = new HashMap<>(capacity);
    }

    public synchronized int get(int key) {
        CacheValue cacheValue = cacheMap.get(key);
        int value = cacheValue != null ? cacheValue.value() : -1;
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
        put(key, value, null);
    }

    public synchronized void put(int key, int value, Integer ttl) {
        CacheValue prevValue = cacheMap.put(key, new CacheValue(value, ttl));
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

    private record CacheValue(Integer value, Integer ttl) {}
}
