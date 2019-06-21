package MapADT;

public class Entry<K, V> {

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
