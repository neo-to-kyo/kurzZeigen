package TreeADT;

import java.util.function.Function;

import ListeADT.List;
import MapADT.Tuple;


public interface Map<K extends Comparable<K>, V> {
    Map<K, V> insert(K key, V value);

    Map<K, V> insertWith(Function<V, Function<V, V>> f, K key, V value);

    boolean member(K key);

    Map<K, V> delete(K key);

    Result<V> lookupResult(K k);

    V lookup(K key); // obligatorischer Ausbau: Result<V> lookup(K key)

    boolean isEmpty();

    int size();

    List<Tuple<K, V>> toList();

    boolean all(Function<Entry<K, V>, Boolean> p);

    boolean allKeys(Function<K, Boolean> p);

    boolean isEqualTo(TreeMap<K, V> m);

    List<K> keys();

    List<V> elems();
}