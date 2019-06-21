package TreeADT;


public class Entry<K extends Comparable<K>, V> implements Comparable<Entry<K, V>> {

    @Override
    public int compareTo(Entry<K, V> o) {

        return this.key.compareTo(o.key);
    }

    private final K key;
    private final V value;

    public Entry(K k, V v) {

        this.key = k;
        this.value = v;

    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object k) {
        return key.equals(((Entry<K, V>) (k)).getKey());
    }

    @Override
    public String toString() {
        return "(" + this.key + ", " + this.value + ")";
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

}