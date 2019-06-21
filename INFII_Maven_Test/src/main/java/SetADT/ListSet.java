package SetADT;

import ListeADT.List;
import TreeADT.Result;

import static ListeADT.List.append;

import java.util.function.Function;

public class ListSet<A> implements Set<A> {
    private final List<A> list;

    private ListSet() {
        list = List.list();
    }

    private ListSet(List<A> xs) {
        this.list = xs;
    }

    public static <A> Set<A> fromList(List<A> xs) {

        return List.foldl(x -> y -> x.insert(y), empty(), xs);
    }


    public static <A> Set<A> empty() {
        return new ListSet<>();
    }

    public static <A> Set<A> set(A... es) {
        return ListSet.fromList(List.list(es));
    }

    public A head() {
        return list.head();
    }

    public List<A> tail() {
        return list.tail();
    }



   /* @Override
    public Set<A> delete(A e) {
        //Function<Integer, Boolean> fFind = x -> x == e;
        return new ListSet<>(this.list.filter(x -> !x.equals(e)));
    }*/

/*    @Override
    public Set<A> insert(A e) {
        return new ListSet<>(this.delete(e).toList().cons(e));
    }*/

    @Override
    public Set<A> insert(A e) {

        return this.member(e) ? new ListSet<A>(this.toList().map(x -> x.equals(e) ? e : x))
                : new ListSet<A>(append(this.list, List.list(e)));
    }

    @Override
    public Set<A> delete(A e) {
        if (list.isEmpty() || !member(e))
            return this;

        Set<A> t = new ListSet<A>(list.filter(x -> !x.equals(e)));

        return t;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean member(A e) {
        // Function<Integer, Boolean> fFind = x -> x == e;
        return this.list.any(x -> x.equals(e));
    }


   /* @SuppressWarnings("unchecked")
    @Override
    public boolean member(A e) {
        //return this.list.any((Function<A, Boolean>) fFind);
        return this.list.elem(e);
    }*/

    @Override
    public int size() {
        return this.list.length();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

   /* @SuppressWarnings("unchecked")
    @Override
    public A get(A e) {
        return this.list.find(x -> x.equals(e));
    }*/

    public A get(A e) {
        return this.list.find(x -> x.equals(e));
    }

    @Override
    public Result<A> getResult(A e) {
        return Result.success(e);
    }

    @Override
    public Result<A> lookupMax() {
        return null;
    }

    @Override
    public Result<A> lookupMin() {
        return null;
    }

    @Override
    public A lookupMinValue() {
        return null;
    }

    @Override
    public A lookupMaxValue() {
        return null;
    }

    @Override
    public List<A> toList() {
        return this.list;
    }

    @Override
    public boolean all(Function<A, Boolean> p) {
        return list.all(p);
    }

   /* @Override
    public boolean any(Function<A, Boolean> p) {
        return list.any(p);
    }*/

    @Override
    public boolean any(Function<A, Boolean> p) {
        return list.filter(p).length() > 0;
    }

   /* @Override
    public boolean isSubsetOf(Set<A> s) {
        return this.all(x->s.member(x));

    }*/

    @Override
    public boolean isSubsetOf(Set<A> s) {

        List<A> myList = this.toList();

        List<A> list1 = s.toList();

        boolean elem = false;

        return isSubsetOf1(myList, list1, elem);

        // return this.all(x->s.member(x));

    }

    private boolean isSubsetOf1(List<A> l1, List<A> l2, boolean elem) {

        if (l1.length() == 0) {
            if (elem == true) {
                return true;
            } else {
                return false;
            }
        } else {

            elem = l2.elem(l1.head());
            return isSubsetOf1(l1.tail(), l2, elem);

        }

    }

    @Override
    public boolean isEqualTo(Set<A> s) {
        return this.size() == s.size() && this.isSubsetOf(s);
    }

    @Override
    public boolean disjoint(Set<A> s) {
        return this.all(x -> !s.member(x));
    }

    @Override
    public <A1> Set<A1> filter(Function<A1, Boolean> f, Set<A1> xs) {
        return null;
    }

    @Override
    public Set<A> union(Set<A> s) {

        Set<A> myNewSet = ListSet.fromList(List.list());

        Set<A> y = (union1(s.toList(), myNewSet));

        return fromList(List.append(this.toList(), y.toList()));

    }

    private Set<A> union1(List<A> s, Set<A> myNewSet) {
        if (s.length() <= 1) {
            if (this.member(s.head())) {
                return myNewSet;
            } else {
                return myNewSet.insert(s.head());
            }
        } else {
            return union1(s.tail(), this.member(s.head()) ? myNewSet : myNewSet.insert(s.head()));
        }
    }

    @Override
    public Set<A> intersection(Set<A> s) {
        Set<A> myNewSet = ListSet.fromList(List.list());
        return intersection1(s.toList(), myNewSet);
    }

    private Set<A> intersection1(List<A> s, Set<A> myNewSet) {
        if (s.length() <= 1) {
            if (this.member(s.head())) {
                return myNewSet.insert(s.head());
            } else {
                return myNewSet;
            }
        } else {
            return intersection1(s.tail(), this.member(s.head()) ? myNewSet.insert(s.head()) : myNewSet);
        }
    }



    /*@Override
    public Set<A> intersection(Set<A> xs, Set<A> ys) {
        return xs.list.filter(x-> ys.member(x));


    }


    @Override
    public Set<A> union(Set<A> xs, Set<A> ys) {
        // List.foldl(x-> y -> x.insert(y), empty(), xs)
        return List.foldr(x-> y -> ys.insert(x), xs, ys);
        // return List.foldl(x -> y -> x.insert(y), fromList(this.toList()), s);
    }*/


    static <A> Set<A> filterSet(Function<A, Boolean> f, Set<A> xs) {
        return fromList(xs.toList().filter(f));
    }

    static <A, B> Set<B> map(Function<A, B> f, Set<A> xs) {
        return fromList(List.map(f, xs.toList()));
    }

    static <A, B> B foldl(Function<B, Function<A, B>> f, B s, Set<A> xs) {
        return List.foldl(f, s, xs.toList());
    }

    public static <A, B> B foldr(Function<A, Function<B, B>> f, B s, Set<A> xs) {
        return List.foldr(f, s, xs.toList());

    }


    @Override
    public String toString() {
        return "{" + list.toString() + "}";
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        return o instanceof ListSet && this.isEqualTo((Set<A>) o);
    }
}