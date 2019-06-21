package TreeADT;

import java.util.function.Function;
import ListeADT.List;
import MapADT.Tuple;
import SetADT.Set;


public class TreeMap<K extends Comparable<K>, V> implements Map<K, V> {

    private final Set<Entry<K, V>> set;

    private TreeMap() {

        this.set = TreeSet.empty();

    }

    private TreeMap(Set<Entry<K, V>> s) {

        set = s;

    }

    public static <K extends Comparable<K>, V> Map<K, V> empty() {

        return new TreeMap<>();

    }

    public static <K extends Comparable<K>, V> Map<K, V> fromList(List<Tuple<K, V>> l) {

        Set<Entry<K, V>> a = TreeSet.empty();
        a = fromListHM(l, a);
        return new TreeMap<>(a);

    }

    private static <K extends Comparable<K>, V> Set<Entry<K, V>> fromListHM(List<Tuple<K, V>> l, Set<Entry<K, V>> s) {

        if (l.length() <= 0) {
            return s;
        } else {

//            Set<Entry<K, V>> a = TreeSet.empty();
//            a = a.insert(new Entry<K, V>(l.head().fst, l.head().snd));
            s = s.insert(new Entry<K, V>(l.head().fst, l.head().snd));

            return fromListHM(l.tail(), s);

        }

    }

    @Override
    public String toString() {

        if (this.isEmpty()) {
            return "{}";

        } else {
            return set.toString();
        }

    }

    @Override
    public boolean isEqualTo(TreeMap<K, V> m) {

        return this.toList().equals(m.toList());

    }

    @Override
    public boolean equals(Object o) {

        return o instanceof TreeMap && this.isEqualTo((TreeMap<K, V>) o);

    }

    @Override
    public Map<K, V> insert(K key, V value) {

        return new TreeMap<K, V>(this.set.insert(new Entry<K, V>(key, value)));
    }

    @Override
    public Map<K, V> insertWith(Function<V, Function<V, V>> f, K key, V value) {

        if (set.member(new Entry<K, V>(key, value))) {

            V v1 = f.apply(value).apply(this.lookup(key));

            Map<K, V> a = new TreeMap<K, V>(set.insert(new Entry<K, V>(key, v1)));
            return a;

        } else {

            Map<K, V> a = new TreeMap<K, V>(set.insert(new Entry<K, V>(key, value)));
            return a;

        }

    }

    @Override
    public boolean member(K key) {
        return set.member(new Entry<K, V>(key, null));
    }

    @Override
    public Map<K, V> delete(K key) {
        return new TreeMap<K, V>(set.delete(new Entry<K, V>(key, null)));
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


    //  @Override
    public Result<V> lookupResult(K key) {
        if (set.member(new Entry<K, V>(key, null))) {


            Entry<K, V> a = this.set.get(new Entry<K, V>(key, null));
            //TreeADT.Entry<K, V> a = this.set.get(new Entry<K, V>(key, null));

            return Result.success(a.getValue());

        } else {
            return Result.failure("empty");
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
    public List<Tuple<K, V>> toList() {
        return this.set.toList().map(e -> new Tuple<>(e.getKey(), (V) e.getValue()));

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
        return (this.set.toList().map(e -> e.getKey())).all(p);
    }

    @Override
    public List<K> keys() {
        return this.set.toList().map(e -> e.getKey());
    }

    @Override
    public List<V> elems() {
        return this.set.toList().map(e -> e.getValue());
    }


}