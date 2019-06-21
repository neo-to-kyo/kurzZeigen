package ListeADT;

import MapADT.ListMap;
import MapADT.Map;
import SetADT.ListSet;
import SetADT.Set;

import java.util.function.Function;

import static SetADT.ListSet.empty;

public abstract class List<A> {

    public abstract Set<A> toSet();

    public abstract List<A> nub();

    public abstract A head();

    public abstract List<A> tail();

    public abstract boolean isEmpty();

    public abstract int length();

    public abstract List<A> cons(A e);

    public abstract <B> Map<B, List<A>> groupBy(Function<A, B> f);

    public abstract List<A> reverse();


    public abstract boolean elem(A x);


    public abstract boolean any(Function<A, Boolean> p);


    public abstract boolean all(Function<A, Boolean> p);


    public abstract <B> List<B> map(Function<A, B> f);


    public abstract List<A> filter(Function<A, Boolean> f);


    public abstract A find(Function<A, Boolean> f);


    public abstract List<A> init();


    public abstract A last();


    public abstract List<A> take(int n);


    public abstract List<A> drop(int n);


    public abstract List<A> takeWhile(Function<A, Boolean> p);


    public abstract List<A> dropWhile(Function<A, Boolean> p);


    public abstract boolean equals(Object o);


    @SuppressWarnings("rawtypes")
    public static final List NIL = new Nil();


    public String toString(List<A> list) {

        return null;
    }

    private List() {
    }


    public static <A> List<A> append(List<A> xs, List<A> ys) {
        return xs.isEmpty() ? ys : new Cons<>(xs.head(), append(xs.tail(), ys));
    }

   /* public static List<String> words(String s, Integer i, Integer j) {
        return  i==s.length()?
                new Cons<String>(s, NIL)
                : ((s.charAt(i) == ' ') || (s.charAt(i) == '\t') || (s.charAt(i) == '\n'))
                ? ((s.charAt(i+1) == ' ' || (s.charAt(i+1) == '\t')  || (s.charAt(i+1) == '\n')))?
                words(s, i+1 , j)
                : new Cons<String>(s.substring(j,i).replaceAll("\\s+",""), words(s.substring(i+1), 0 , 0))
                : words(s, i+1 , j);
    }*/

    public static List<String> words(String x) {

        List<String> list1 = list();
        String[] s = x.split(" +");
        List<String> str = list();

        list1 = toString(s, str, 0);
        return list1.reverse();

    }

    public static List<String> toString(String[] s, List<String> str, int size) {

        if (s.length == size) {

            return str;

        } else {

            return toString(s, str.cons(s[size]), size + 1);

        }

    }


    public static List<Integer> range(int start, int end) {
        return (start < end) ? NIL
                : new Cons(start, range(start + 1, end));
    }


//------------------------------------------------------------------

    private static class Nil<A> extends List<A> {

        private Nil() {
        }


        public A head() {
            throw new IllegalStateException("head called on empty list");

        }


        public List<A> tail() {
            //  throw new IllegalStateException("tail called on empty list");
            return list();
        }

        @Override
        public List<A> nub() {

            return list();
        }


        public boolean isEmpty() {
            return true;
        }

        public List<A> reverse() {
            return list();
        }

        @Override
        public List<A> cons(A e) {
            return list(e);
        }

        @Override
        public <B> Map<B, List<A>> groupBy(Function<A, B> f) {
            return null;
        }


        public String toString() {
            return "";
        }

        @Override
        public int length() {
            return 0;
        }

        @Override
        public <B> List<B> map(Function<A, B> f) {
            return list();
        }

        @Override
        public boolean elem(A x) {
            return false;
        }

        @Override
        public boolean any(Function<A, Boolean> p) {
            return false;
        }

        @Override
        public boolean all(Function<A, Boolean> p) {
            return false;
        }

        @Override
        public List<A> filter(Function<A, Boolean> f) {
            return this;
        }

        @Override
        public A find(Function<A, Boolean> f) {
            return null;
        }

        @Override
        public List<A> init() {
            return this;
        }

        @Override
        public A last() {
            return null;
        }

        @Override
        public List<A> take(int n) {
            return this;
        }

        @Override
        public List<A> drop(int n) {
            return this;
        }

        @Override
        public List<A> takeWhile(Function<A, Boolean> p) {
            return this;
        }


        @Override
        public List<A> dropWhile(Function<A, Boolean> p) {
            return this;
        }


        @Override
        public boolean equals(Object o) {
            return o instanceof Nil;
        }

        @Override
        public Set<A> toSet() {
            return empty();
        }

        public static List<String> words(String s, Integer i, Integer j) {
            return list();
        }


    }

    // ------------------------------------------------------------
//    ------------------------------------------------------------------

    private static class Cons<A> extends List<A> {
        private final A head;
        private final List<A> tail;

        private Cons(A head, List<A> tail) {
            this.head = head;
            this.tail = tail;
        }

        @Override
        public Set<A> toSet() {
            return ListSet.fromList(this);
        }

        @Override
        public List<A> nub() {

            return (this.toSet()).toList();
        }


        public A head() {
            return head;
        }

        public List<A> tail() {
            return tail;
        }

        public boolean isEmpty() {
            return false;
        }


        @Override
        public List<A> cons(A a) {
            return new Cons<>(a, this);
        }

        @Override
        public <B> Map<B, List<A>> groupBy(Function<A, B> f) {

            List<A> workList = this;

            Map<B, List<A>> m = ListMap.empty();

            while (!workList.isEmpty()) {
                final B k = f.apply(workList.head());
                // List<A> rt = m.lookup(k).getOrElse(list()).cons(workList.head());
                List<A> rt = list();

                if (!m.member(k)) {
                    rt = (List<A>) (list()).cons(workList.head());
                } else {
                    rt = m.lookup(k);
                }


                m = m.insert(k, rt);
                workList = workList.tail();
            }
            return m;

        }


        // ...


        @Override
        public String toString() {

            return toString(this);
        }

        @Override
        public String toString(List<A> list) {

            StringBuilder s = new StringBuilder();
            return list.isEmpty() ? "" : list.head() + (list.tail().isEmpty() ? "" : ", " + s.append(list.tail()));
        }

        @Override
        public int length() {
            return 1 + tail().length();
        }


        @Override
        public <B> List<B> map(Function<A, B> f) {

            return new Cons<>(f.apply(head()), tail().map(f));
        }

        @Override
        public boolean elem(A x) {

            if (this.isEmpty())
                return false;
            return this.head().equals(x) || tail().elem(x);
        }

        @Override
        public boolean any(Function<A, Boolean> p) {

//           //return this.isEmpty() ? false : any(p.apply(this.head)) || any(p.apply(this.tail));
            return !isEmpty() && (p.apply(this.head()) || this.tail().any(p));

        }

        @Override
        public boolean all(Function<A, Boolean> p) {
            return !isEmpty() && (p.apply(this.head()) && this.tail().any(p));

        }

        @Override
        public List<A> filter(Function<A, Boolean> f) {

            // return List.foldl(x-> y -> f.apply(y) ? new Cons<A>(y, x) : x, list(),this);
            return f.apply(this.head) ? new Cons<>(this.head(), this.tail().filter(f)) : this.tail().filter(f);
        }

        @Override
        public A find(Function<A, Boolean> f) {
            return this.filter(f).head();
        }

        @Override
        public List<A> init() {
            if (!this.tail.isEmpty()) {
                return new Cons<>(this.head, this.tail.init());
            }
            return list();
        }

        @Override
        public A last() {
            if (!this.tail.isEmpty()) {
                return this.tail.last();
            }
            return this.head;


        }

        @Override
        public List<A> take(int n) {
            if (n <= 1) {
                return new Cons<>(this.head(), list());
            }
            return new Cons<>(this.head(), this.tail().take(n - 1));
        }


        public List<A> drop(int n) {
            if (n > 0) {
                return this.tail.drop(n - 1);
            }
            return this;
        }

        @Override
        public List<A> takeWhile(Function<A, Boolean> p) {
            //return p.apply(head()) ? new Cons<>(head(), tail().takeWhile(p)) : append(list(), this.tail());
            return p.apply(head()) ? new Cons<>(head(), tail().takeWhile(p)) : list();
        }

        @Override
        public List<A> dropWhile(Function<A, Boolean> p) {
            if (p.apply(this.head)) return append(list(), tail().dropWhile(p));
            return append(list(), this.tail());
        }

        @Override
        public List<A> reverse() {
            return this.isEmpty() ? list()
                    : append(this.tail().reverse(), list(this.head()));
        }


        private boolean isEquals(Cons<?> o) {

            //return this.equals(o);
            return o.head().equals(head()) && o.tail().equals(tail());
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof Cons && isEquals((Cons<?>) o);
            // if (o instanceof Cons && isEquals((Cons<?>) o))

            //    return ((Cons<?>) o).head().equals(this.head()) && ((Cons<?>) o).tail().equals(this.tail());
            //  return false;
        }


    }

// --- abstrakte   Liste ---------------


    public static <A> List<A> setHead(List<A> list, A h) {
        if (list.isEmpty()) {
            throw new IllegalStateException("setHead called on an empty list");
        } else {

            return new Cons<>(h, list.tail());
        }
    }


    @SuppressWarnings("unchecked")
    public static <A> List<A> list() {
        return NIL;
    }


    @SafeVarargs
    public static <A> List<A> list(A... a) {
        List<A> n = list();
        for (int i = a.length - 1; i >= 0; i--) {
            n = new Cons<>(a[i], n);
        }
        return n;
    }

    //


    public static Integer sum(List<Integer> xs) {
        return xs.isEmpty() ? 0 : xs.head() + sum(xs.tail());
    }


    public static Double prod(List<Double> xs) {
        return xs.isEmpty() ? 1 : xs.head() * prod(xs.tail());

    }


    public static <A, B> List<B> map(Function<A, B> f, List<A> xs) {
        return new Cons<>(f.apply(xs.head()), xs.tail().map(f));
    }


    // public static <A> List<A> reverse(List<A> xs) {
    //   return xs.isEmpty() ? list() : append(reverse(xs.tail()), list(xs.head()));
    //}


    public static <A, B> B foldr(Function<A, Function<B, B>> f, B s, List<A> xs) {
        return xs.isEmpty() ? s : f.apply(xs.head()).apply(foldr(f, s, xs.tail()));
    }


    public static Integer sumRF(List<Integer> xs) {
        return foldr(x -> y -> x + y, 0, xs);
    }


    public static Double prodRF(List<Double> xs) {
        return foldr(x -> y -> x * y, 1.0, xs);
    }


    public static <A> Integer lengthRF(List<A> xs) {
        return foldr(x -> n -> n + 1, 0, xs);
    }


    public static <A> List<A> reverseRF(List<A> list) {
        return foldr(x -> xs -> xs.append(list(x), list(x)), list(), list);
    }


    public static <A> List<A> appendR(List<A> xs, List<A> ys) {
        return foldr(x -> l -> new Cons<>(x, l), ys, xs);
    }


    public static <A, B> B foldl(Function<B, Function<A, B>> f, B s, List<A> xs) {
        return xs.isEmpty() ? s : foldl(f, f.apply(s).apply(xs.head()), xs.tail());
    }


    public static Integer sumLF(List<Integer> xs) {
        return foldl(x -> y -> x + y, 0, xs);
    }


    public static Double prodLF(List<Double> xs) {
        return foldl(x -> y -> x * y, 1.0, xs);
    }


    public static <A> Integer lengthLF(List<A> xs) {
        return foldl(n -> x -> n + 1, 0, xs);
    }


    public static <A> List<A> appendLF(List<A> xs, List<A> ys) {
        return foldl(l -> x -> l.cons(x), ys, xs.reverse());
    }


}