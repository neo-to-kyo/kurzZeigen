package MapADT;

public class Tuple<K, V> {

    public final K fst;
    public final V snd;

    public Tuple(K fst, V snd) {
        this.fst = fst;
        this.snd = snd;
    }
    
    
    @Override
    public boolean equals(Object t) {

        return (this.fst).equals(((Tuple<K, V>) t).fst) && (this.snd).equals(((Tuple<K, V>) t).snd);
        
    }

    @Override
    public String toString() {
        return tupleToString(this);
    }

    public String tupleToString(Tuple<K, V> tuple) {
        return "<<" + this.fst + "> <" + this.snd + ">>";
    }
}

