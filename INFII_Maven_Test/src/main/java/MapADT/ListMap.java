package MapADT;

import java.util.function.Function;

import ListeADT.List;
import SetADT.ListSet;
import SetADT.Set;

public class ListMap<K, V> implements Map<K, V> {

    private final Set<Entry<K, V>> set;

    private ListMap() {
        this.set = ListSet.empty();
    }

    private ListMap(Set<Entry<K, V>> set) {

        this.set = set;
    }


    public static <K, V> Map<K, V> empty() {

        return new ListMap<K, V>();
    }


    @Override
    public Map<K, V> insert(K key, V value) {

        Map<K, V> x = new ListMap<K, V>(this.set.insert(new Entry<K, V>(key, value)));
        return x;

    }

    public static <K, V> Map<K, V> fromList(List<Tuple<K, V>> xs) {

        return fromList1(xs, new ListMap<K, V>());

    }

    private static <K, V> Map<K, V> fromList1(List<Tuple<K, V>> xs, Map<K, V> m) {

        if (xs.isEmpty()) {

            return m;

        }

        Map<K, V> nMap = m.insert(xs.head().fst, xs.head().snd);
        return fromList1(xs.tail(), nMap);

    }

    @Override
    public List<Tuple<K, V>> toList() {

        return this.set.toList().map(e -> new Tuple<>(e.getKey(), (V) e.getValue()));

    }

    @Override
    public boolean member(K key) {

        return set.member(new Entry<K, V>(key, null));

    }

    @Override
    public Map<K, V> delete(K key) {

        return new ListMap<K, V>(set.delete(new Entry<K, V>(key, null)));

    }

    @Override
    public V lookup(K key) {

        if (set.member(new Entry<K, V>(key, null))) {
            Entry<K, V> a = this.set.get(new Entry<K, V>(key, null));

            return a.getValue();
        } else {
            return null;
        }

    }


    @Override
    public boolean isEmpty() {

        return this.set.isEmpty();
    }

    @Override
    public int size() {

        return this.set.size();
    }

    @Override
    public String toString() {

        if (this.isEmpty()) {
            return "{}";

        } else {
            return this.set.toString();
        }

    }

    @Override
    public Map<K, V> insertWith(Function<V, Function<V, V>> f, K key, V value) {
        if (set.member(new Entry<K, V>(key, value))) {
            V v1 = f.apply(value).apply(this.lookup(key));
//
            Map<K, V> a = new ListMap<K, V>(set.insert(new Entry<K, V>(key, v1)));
            return a;

        } else {

            Map<K, V> a = new ListMap<K, V>(set.insert(new Entry<K, V>(key, value)));
            return a;
        }

    }

    @Override
    public List<K> keys() {

        return this.set.toList().map(e -> e.getKey());

    }

    @Override
    public List<V> elems() {

        return this.set.toList().map(e -> e.getValue());

    }

    @Override
    public boolean all(Function<Entry<K, V>, Boolean> p) {

        Function<Boolean, Boolean> fTrue = x -> x == true;

        if (((this.set.toList().map(e -> p.apply(e))).map(fTrue)).elem(false)) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public boolean allKeys(Function<K, Boolean> p) {

        // Function<K, Boolean> fTrue = x -> x.equals(true);

        return (this.set.toList().map(e -> e.getKey())).all(p);

    }

    @Override
    public boolean isEqualTo(Map<K, V> m) {

        return this.toList().equals(m.toList());

    }

    @Override
    public boolean equals(Object o) {

        return o instanceof Map && this.isEqualTo((Map<K, V>) o);

    }

    public static Map<String, Integer> wordFreqMap(String s) {

        List<String> l = List.words(s);
        Map<String, Integer> m = empty();

        // l.map(e -> (m.member(e)) ? (m.insert(e, m.lookup(e) + 1)) : (m.insert(e,
        // 1)));
        m = wordFreqMap1(l, m);
        return m;

    }

    // Hilfsmethode Rekursiv
    private static Map<String, Integer> wordFreqMap1(List<String> xs, Map<String, Integer> m) {

        if (xs.isEmpty()) {

            return m;

        } else {

            if (m.member(xs.head())) {

                Map<String, Integer> nMap = m.insert(xs.head(), m.lookup(xs.head()) + 1);
                return wordFreqMap1(xs.tail(), nMap);

            } else {

                Map<String, Integer> nMap = m.insert(xs.head(), 1);
                return wordFreqMap1(xs.tail(), nMap);

            }

        }

    }

    @Override
    public List<V> getOrElse(List<K> list) {

        if (!this.isEmpty()) {
            return this.elems();
        }
        return (List<V>) list;

    }


}
