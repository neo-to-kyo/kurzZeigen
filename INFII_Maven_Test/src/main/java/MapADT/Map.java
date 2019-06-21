package MapADT;

import java.util.function.Function;

import ListeADT.List;


public interface Map<K, V> {
    Map<K, V> insert(K key, V value);

    Map<K, V> insertWith(Function<V, Function<V, V>> f, K key, V value);

    boolean member(K key);

    Map<K, V> delete(K key);

    V lookup(K key);

    //Result<V> lookup(K key);


    boolean isEmpty();

    int size();

    List<Tuple<K, V>> toList();

    boolean all(Function<Entry<K, V>, Boolean> p);

    boolean allKeys(Function<K, Boolean> p);

    boolean isEqualTo(Map<K, V> m);

    List<K> keys();

    List<V> elems();


    // Map<String, Integer> wordFreqMap(String s);

    // <B> Map<B, List<A>> groupBy(Function<A, B> f);

    List<V> getOrElse(List<K> list);


}




