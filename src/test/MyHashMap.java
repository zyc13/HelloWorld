package test;

/**
 * 手写HashMap
 * 定义一个HashMap算法：
 * 	1. 定义数据结构
 * 	2. 定义好一个 hash 函数
 * 	3. 数组加链表如何操作
 * 	4. hashCode冲突是怎么解决的
 * 	5. 扩容的时候是怎么解决的
 * @date 2018.12.10
 */
public class MyHashMap<K, V> {

    /**
     * 默认初始大小
     */
    private static final int DEFAULT_SIZE = 1 << 4;
    /**
     * Map大小
     */
    private int size;
    /**
     * 初始化大小
     */
    private int initialCapacity;

    private Entry[] table;

    private class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 构造函数
     */
    public MyHashMap() {
        this(DEFAULT_SIZE);
    }

    public MyHashMap(int size) {
        if (size > 0) {
            this.initialCapacity = size;
            this.table = new Entry[size];
            this.size = 0;
        } else {
            System.out.println("初始化大小必须大于0");
        }
    }

    /**
     * 计算hashCode
     * @param key 主键
     * @return 对应的 hash 码
     */
    private int hash(Object key) {
        int h;
        // TODO 应该把  % initialCapacity 写入一个新的方法：indexFor(hashCode)
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) % initialCapacity;
    }

    /**
     * put方法
     * @param key 主键
     * @param value 值
     */
    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        int h = hash(key);
        Entry<K, V> newEntry = new Entry<>(key, value, null);  // 新 put 的 Entry
        Entry<K, V> oldEntry = table[h];  // 原对应索引上的旧 Entry

        while (oldEntry != null) {
            if (key.equals(oldEntry.key)) {
                oldEntry.value = value;
                return;
            }
            oldEntry = oldEntry.next;
        }

        newEntry.next = table[h];
        table[h] = newEntry;
        size++;
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }

        int h = hash(key);
        Entry<K, V> entry = table[h];
        while (entry != null) {
            if (key.equals(entry.key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        return "";
    }

    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("1", "11");
        map.put("2", "22");
        map.put("2", "33");
        System.out.println(map.get("1"));
        System.out.println(map.get("2"));
    }
}
