package TreeADT;


import ListeADT.List;
import SetADT.ListSet;
import SetADT.Set;

import java.util.function.Function;

public class TreeSet<A extends Comparable<A>> implements SortedSet<A> {

    private TreeSet(Tree<A> tree) { this.tree = tree;  }

    private final Tree<A> tree;

    private TreeSet() {
        tree = Tree.empty();
    }

    @SafeVarargs
    private TreeSet(A... e) {
        tree = Tree.tree((ListSet.set(e)).toList());
    }

    private TreeSet(List<A> xs) {
        this.tree = Tree.tree(xs);
    }



    public static <A extends Comparable<A>> Set<A> empty() {
        return new TreeSet<>();
    }



    public static <A extends Comparable<A>> Set<A> set(Tree<A> tree) {
        return new TreeSet<A>(tree);
    }

    public static <A extends Comparable<A>> Set<A> set(A... as) {
        return new TreeSet<A>(as);

    }

    public static <A extends Comparable<A>> Set<A> fromList(List<A> xs) {
//        // return new TreeSet<>(xs);
//        int length = xs.length();
//        TreeSet<A> a = new TreeSet<>();
//
//        for (int i = 0; i <= length - 1; i++) {
//            a = (TreeSet<A>) a.insert(xs.head());
//            xs = xs.tail();
//        }
        return new TreeSet<A>(xs);

        // return ListSet.fromList(xs);
    }

    // @Override
    public A findMin() {
        return null;
    }

   // @Override
    public A findMax() {
        return null;
    }

    @Override
    public Set<A> insert(A e) {

        return new TreeSet<A>(tree.insert(e).inOrder());

    }

    @Override
    public Set<A> delete(A e) {
        return new TreeSet<A>(tree.remove(e).inOrder());
    }

    @Override
    public boolean member(A e) {
        return tree.member(e);
    }

    @Override
    public int size() {
        return tree.size();
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public Result<A> getResult(A e) {
        return tree.find(e) ? Result.success(e) : Result.failure("negativ");
    }

    @Override
    public Result<A> lookupMax() {
        return Result.success(tree.findMax());
    }

    @Override
    public Result<A> lookupMin() {
        return Result.success(this.tree.findMin());
    }

    @Override
    public A get(A e) {
        return tree.inOrder().toSet().get(e);  }

    @Override
    public List<A> toList() {
        return tree.inOrder();
    }

    @Override
    public boolean all(Function<A, Boolean> p) {
        return tree.inOrder().all(p);
    }

    @Override
    public boolean any(Function<A, Boolean> p) {
        return tree.inOrder().all(p);
    }

    @Override
    public <A> Set<A> filter(Function<A, Boolean> f, Set<A> xs) {
        return null;
    }

    @Override
    public boolean isSubsetOf(Set<A> s) {

        return tree.inOrder().toSet().isSubsetOf(s.toList().toSet());
    }

    @Override
    public boolean isEqualTo(Set<A> s) {
        return tree.inOrder().toSet().isEqualTo(s);

    }

    @Override
    public boolean equals(Object o){
        return o instanceof TreeSet && isEqualTo((Set<A>)o);
    }

    @Override
    public boolean disjoint(Set<A> s) {
        // return tree.preorder().toSet().disjoint((s);
        //return !this.any(s::member) || !s.any(this::member);
        return tree.inOrder().toSet().disjoint(s);
    }

    @Override
    public Set<A> union(Set<A> s) {
        //public <B> B foldLeft(B identity, Function<B, Function<A, B>> f, Function<B, Function<B, B>> g)

       // return tree.foldRight(tree.empty(), x -> y -> s.insert(x)) ;
        return new TreeSet<A>(tree.inOrder().toSet().union(s).toList());

    }

    @Override
    public Set<A> intersection(Set<A> s) {
        return new TreeSet<A>(tree.inOrder().toSet().intersection(s).toList());
        //return new TreeSet<A>(tree.preOrder().toSet().intersection(s).toList());
    }

    @Override
    public String toString() {
        return "{" + this.toString(tree.preOrder()) + "}";
    }

    private String toString(List<A> list) {
        return list.length() == 1 ? "" + list.head() : list.head() + ", " + this.toString(list.tail());
    }


    @Override
    public A lookupMinValue() {
        return tree.findMin();
    }
    @Override
    public A lookupMaxValue() {
        return tree.findMax();
    }
}


