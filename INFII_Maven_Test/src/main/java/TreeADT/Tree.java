package TreeADT;

import java.util.function.Function;
import ListeADT.List;


public abstract class Tree<A extends Comparable<A>> {

    public abstract int sizeInnerHM(int n);

    public abstract Result<A> get(A a);

    public abstract int sizeLeaf();

    public abstract int sizeInner();

    public abstract int sizeHalf();

    public abstract int sizeFull();


    public abstract int sizeEmpty();

    @SuppressWarnings("rawtypes")
    public static final Tree EMPTY = new Empty();

    public abstract boolean isValueEmpty();

    public abstract Tree<A> remove(A a);

    abstract protected Tree<A> removeMerge(Tree<A> ta);

    public abstract A findMax();

    public abstract A findMin();

    public abstract boolean isEmpty();

    public abstract A value();

    public abstract boolean find(A value);

    public abstract Tree<A> left();

    public abstract Tree<A> right();

    public abstract List<A> inOrder();

    public abstract List<A> inOrder2();

    abstract protected List<String> inOrder1();

    public abstract List<A> postOrder();

    abstract protected List<String> postOrder1();

    public abstract List<A> preOrder();

    abstract protected List<String> preOrder1();

    public abstract List<A> levelOrder();


    public abstract boolean equals(Object o);


    abstract String levelOrder1(int h, int i);

    public abstract Tree<A> insert(A e);

    public abstract boolean member(A value);

    public abstract int size();


    public abstract int height();

    public abstract <B> B foldLeft(B identity, Function<B, Function<A, B>> f, Function<B, Function<B, B>> g);

    public abstract <B> B foldRight(B identity, Function<A, Function<B, B>> f, Function<B, Function<B, B>> g);

    public abstract <B> B foldInOrder(B identity, Function<B, Function<A, Function<B, B>>> f);

    public abstract <B> B foldPreOrder(B identity, Function<A, Function<B, Function<B, B>>> f);

    public abstract <B> B foldPostOrder(B identity, Function<B, Function<B, Function<A, B>>> f);

//...........................................................................


    public static <A extends Comparable<A>> Tree<A> tree(List<A> list) {
        return List.foldl(x -> t -> x.insert(t), empty(), list);
    }


    @SuppressWarnings("unchecked")
    public static <A extends Comparable<A>> Tree<A> empty() {
        return EMPTY;
    }

    // tree
    @SafeVarargs
    public static <A extends Comparable<A>> Tree<A> tree(A... xs) {
        return (T<A>) tree(List.list(xs));
    }

//...........................................................................
    // __________________________________________________________________________________________________________

    private static class Empty<A extends Comparable<A>> extends Tree<A> {

        @Override
        public boolean find(A value) {
            return false;
        }

        @Override
        public T<A> insert(A e) {
            return new T<>(empty(), e, empty());
        }

        @Override
        public boolean member(A value) {
            return false;
        }


        @Override
        public boolean equals(Object o) {
            return o instanceof Empty && isEquals((Empty<?>) o);
        }

        private boolean isEquals(Empty<?> o) {

            return true;

        }

        @Override
        public A findMax() {
            return null;
        }

        @Override
        public A findMin() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public int sizeLeaf() {
            return 0;
        }

        @Override
        public int height() {
            return -1;
        }


        @Override
        public boolean isValueEmpty() {
            return true;
        }

        @Override
        public A value() {
            throw new IllegalStateException("value() called on empty tree");
        }

        @Override
        public Tree<A> left() {
            throw new IllegalStateException("left() called on empty tree");
        }

        @Override
        public Tree<A> right() {
            throw new IllegalStateException("right() called on empty tree");
        }

        @Override
        public List<A> postOrder() {
            return List.list();
        }

        @Override
        public List<A> preOrder() {
            return List.list();
        }

        @Override
        public List<A> inOrder() {
            return List.list();
        }

        @Override
        public List<A> inOrder2() {
            return List.list();
        }

        @Override
        protected List<String> inOrder1() {
            return List.list();
        }

        @Override
        public List<A> levelOrder() {

            return null;
        }

        String levelOrder1(int h, int i) {

            return "";
        }

        @Override
        public String toString() {
            // return "E";
            return "";
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public <B> B foldLeft(B identity, Function<B, Function<A, B>> f, Function<B, Function<B, B>> g) {
            return identity;
        }

        @Override
        public <B> B foldRight(B identity, Function<A, Function<B, B>> f, Function<B, Function<B, B>> g) {
            return identity;
        }

        @Override
        public <B> B foldInOrder(B identity, Function<B, Function<A, Function<B, B>>> f) {
            return identity;
        }

        @Override
        public <B> B foldPreOrder(B identity, Function<A, Function<B, Function<B, B>>> f) {
            return identity;
        }

        @Override
        public <B> B foldPostOrder(B identity, Function<B, Function<B, Function<A, B>>> f) {
            return identity;
        }

        @Override
        protected List<String> preOrder1() {

            return List.list();
        }


        @Override
        protected List<String> postOrder1() {

            return List.list();
        }

        @Override
        protected Tree<A> removeMerge(Tree<A> ta) {
            return ta;
        }

        @Override
        public Tree<A> remove(A a) {
            return this;
        }


        @Override
        public Result<A> get(A a) {
            return Result.failure("empty");
        }

        @Override
        public int sizeInner() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int sizeHalf() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int sizeFull() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int sizeEmpty() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int sizeInnerHM(int n) {
            // TODO Auto-generated method stub
            return 0;
        }

    }

//___________________________________________________________________________________________________________________

    private static class T<A extends Comparable<A>> extends Tree<A> {
        private final Tree<A> left;
        private final Tree<A> right;
        private final A value;
        private final int height;
        private final int size;

        private T(Tree<A> left, A value, Tree<A> right) {
            this.left = left;
            this.value = value;
            this.right = right;

            // this.height = this.height();

            if (this.isEmpty()) {
                System.out.println("aqui");
                this.height = -1;
            } else {

                this.height = 1 + Math.max(left.height(), right.height());
                // System.out.print(" -- " + height);
            }

            this.size = 1 + left.size() + right.size();
        }

        // removeMerge
        @Override
        protected Tree<A> removeMerge(Tree<A> ta) {
            if (ta.isEmpty()) {
                return this;
            }
            if (ta.value().compareTo(value) < 0) {
                return new T<>(left.removeMerge(ta), value, right);
            } else if (ta.value().compareTo(value) > 0) {
                return new T<>(left, value, right.removeMerge(ta));
            }
            throw new IllegalStateException("We shouldn't be here.");
        }

        // remove
        // delete
        @Override
        public Tree<A> remove(A a) {
            if (a.compareTo(this.value) < 0) {
                return new T<>(left.remove(a), value, right);
            } else if (a.compareTo(this.value) > 0) {
                return new T<>(left, value, right.remove(a));
            } else {
                return left.removeMerge(right);
            }


        }


        public Result<A> get(A a) {
            if (this.find(a)) {

                if (a.compareTo(this.value) < 0) {
                    return this.left.get(a);
                }
                if (a.compareTo(this.value) > 0) {
                    return this.right.get(a);
                } else {


                    return Result.success(this.value);
                }

            } else {

                return Result.failure("empty");
            }
        }


        @Override
        public boolean isValueEmpty() {
            return false;
        }

        @Override
        public A findMax() {
            return this.inOrder().last();
        }

        @Override
        public A findMin() {
            return (this.inOrder().head());
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof T && isEquals((T<?>) o);
        }

        private boolean isEquals(T<?> o) {

            return o.inOrder().equals(this.inOrder());

        }


        @Override
        public A value() {
            return value;
        }


        @Override
        public Tree<A> left() {
            return left;
        }


        @Override
        public Tree<A> right() {
            return right;
        }

        @Override
        public Tree<A> insert(A a) {
            return a.compareTo(this.value) < 0 ? new T<>(left.insert(a), this.value, right)
                    : a.compareTo(this.value) > 0 ? new T<>(left, this.value, right.insert(a))
                    : new T<>(this.left, a, this.right);
        }

        // member
        @Override
        public boolean member(A value) {
            return value.compareTo(this.value) < 0 ? left.member(value)
                    : value.compareTo(this.value) > 0 ? right.member(value) : true;
        }

        // size
        @Override
        public int size() {
            return this.size;
        }


        // height
        @Override
        public int height() {

            if (this.isEmpty()) {
                return -1;

            } else {

                return (1 + Math.max(left.height(), right.height()));
            }

            // return height;
        }

        // find
        @Override
        public boolean find(A value1) {

            return find1(this, value1);

        }

        // Hilfsmethode Find
        private boolean find1(Tree<A> t, A value1) {

            if (!(t.isEmpty())) {
                if (t.value() == value1) {
                    return true;
                } else {

                    boolean f1 = find1(t.left(), value1);
                    boolean f2 = find1(t.right(), value1);

                    if (f1 || f2) {
                        return true;
                    }
                }
            }
            return false;

        }

        //***********************************************
        // toString
        @Override
        public String toString() {
            // return String.format("(T %s %s %s)", left, value, right);
            return left + " " + value + "(" + height + ")" + " " + right;
            // return this.value() + " ";
            // return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";

        }

        @Override
        public List<A> preOrder() {

//            List<A> l = List.list();
//            l = preOrder1();
//            l = l.tail();
//            return l;

            List<String> l = List.list();
            l = preOrder1();
            l = l.tail();

            List<Integer> r = List.list();
            return (List<A>) transform(l, r).reverse();


        }

        // preOrder HM
        @Override
        protected List<String> preOrder1() {
            String x = "";

            x = x + " " + value;

            if (left != null) {
                x = x + left.preOrder1();
            }
            if (right != null) {
                x = x + right.preOrder1();
            }

            String y = x.replaceAll(" +", " ");
            y = y.replaceAll("\\,", " ");

            return List.words(y);

        }

  /*      // preOrder
        @Override
        public List<A> preOrder() {

            List<A> l = List.list();
            l = preOrder1();
            l = l.tail();
            return l;

        }

        // preOrder HM
        @Override
        protected List<A> preOrder1() {
            String x = "";

            x = x + " " + value;

            if (left != null) {
                x = x + left.preOrder1();
            }
            if (right != null) {
                x = x + right.preOrder1();
            }

            String y = x.replaceAll(" +", " ");
            y = y.replaceAll("\\,", " ");

            return (List<A>) List.words(y);

        }*/

       /* // inOrder
        @Override
        public List<A> inOrder2() {

            List<A> l = List.list();
            l = inOrder1();
            l = l.tail();
            return l;

        }

        // inOrder HM
        @Override
        protected List<A> inOrder1() {
            String x = "";

            if (left != null) {
                x = x + left.inOrder1();
            }

            x = x + " " + value;

            if (right != null) {
                x = x + right.inOrder1();
            }

            String y = x.replaceAll(" +", " ");
            y = y.replaceAll("\\,", " ");

            return (List<A>) List.words(y);

        }*/

/*       @Override
        public List<A> inOrder() {
            return List.appendLF(left.inOrder().cons(value), right.inOrder());
        }*/

        @Override
        public List<A> inOrder() {

            List<String> l = List.list();
            l = inOrder1();
            l = l.tail();
            // return (List<A>) l;
            List<Integer> r = List.list();
            return (List<A>) transform(l, r).reverse();

            // return List.append(left.inOrder().cons(value), right.inOrder());

        }

        @Override
        public List<A> inOrder2() {
            return null;
        }


        // inOrder HM
        @Override
        protected List<String> inOrder1() {
//            List<A> y = List.list();

            String x = "";

            if (left != null) {
                x = x + left.inOrder1();
                // y = y.append(List.list(), left.inOrder1());
            }

            // y = y.cons(value);
            x = x + " " + value;

            if (right != null) {
                x = x + right.inOrder1();
                // y = y.append(List.list(), right.inOrder1());
            }

            String y = x.replaceAll(" +", " ");
            y = y.replaceAll("\\,", " ");

            // return (List<A>) ;

//            return y;

            return List.words(y);

//            List<Integer> r = List.list();
//            return transform(List.words(y), r);

        }


        private List<Integer> transform(List<String> l, List<Integer> r) {

            if (l.isEmpty()) {
                return r;
            } else {

                r = r.cons(Integer.valueOf(l.head()));
                return transform(l.tail(), r);
            }

        }


        @Override
        public List<A> postOrder() {

            List<String> l = List.list();
            l = postOrder1();
            l = l.tail();
            List<Integer> r = List.list();
            return (List<A>) transform(l, r).reverse();

        }

        // postOrder HM
        @Override
        protected List<String> postOrder1() {
            String x = "";

            if (left != null) {
                x = x + left.inOrder1();
            }

            if (right != null) {
                x = x + right.inOrder1();
            }
            x = x + " " + value;

            String y = x.replaceAll(" +", " ");
            y = y.replaceAll("\\,", " ");

            return List.words(y);

        }

       /* // postOrder
        @Override
        public List<A> postOrder() {

            List<A> l = List.list();
            l = postOrder1();
            l = l.tail();
            return l;

        }

        // postOrder HM
        @Override
        protected List<A> postOrder1() {
            String x = "";

            if (left != null) {
                x = x + left.inOrder();
            }

            if (right != null) {
                x = x + right.inOrder();
            }
            x = x + " " + value;

            String y = x.replaceAll(" +", " ");
            y = y.replaceAll("\\,", " ");

            return (List<A>) List.words(y);

        }*/

        // levelOrder
        @Override
        public List<A> levelOrder() {

            return levelOrderHelper(List.list(value), this);

        }

        // levelOrder HM
        private List<A> levelOrderHelper(List<A> list, Tree<A> tree) {
            if (!tree.left().isEmpty())
                list = List.append(list, List.list(tree.left().value()));
            if (!tree.right().isEmpty())
                list = List.append(list, List.list(tree.right().value()));

            if (!tree.left().isEmpty())
                list = levelOrderHelper(list, tree.left());
            if (!tree.right().isEmpty())
                list = levelOrderHelper(list, tree.right());

            return list;

        }

        public String levelOrder1(int h, int i) {
            String x = "";

            if (value == null) {
                return "";
            }
            if (i == 1) {
                x = x + " " + value;
                return x;
            }
            if (i > 1) {
                x = x + " " + left.levelOrder1(h, i);
                x = x + " " + right.levelOrder1(h, i);
                return x;
            }
            return x;

        }

//***********************************************

        @Override
        public <B> B foldLeft(B identity, Function<B, Function<A, B>> f, Function<B, Function<B, B>> g) {
            // Post order right:
            return g.apply(right.foldLeft(identity, f, g))
                    .apply(f.apply(left.foldLeft(identity, f, g)).apply(this.value));
        }

        @Override
        public <B> B foldRight(B identity, Function<A, Function<B, B>> f, Function<B, Function<B, B>> g) {
            // Pre order left
            return g.apply(f.apply(this.value).apply(left.foldRight(identity, f, g)))
                    .apply(right.foldRight(identity, f, g));
        }

        @Override
        public <B> B foldInOrder(B identity, Function<B, Function<A, Function<B, B>>> f) {
            return f.apply(left.foldInOrder(identity, f)).apply(value).apply(right.foldInOrder(identity, f));
        }

        @Override
        public <B> B foldPreOrder(B identity, Function<A, Function<B, Function<B, B>>> f) {
            return f.apply(value).apply(left.foldPreOrder(identity, f)).apply(right.foldPreOrder(identity, f));
        }

        @Override
        public <B> B foldPostOrder(B identity, Function<B, Function<B, Function<A, B>>> f) {
            return f.apply(left.foldPostOrder(identity, f)).apply(right.foldPostOrder(identity, f)).apply(value);
        }


        @Override
        public int sizeLeaf() {
            return (left.isEmpty() && right.isEmpty() ? 1 : 0) + left.sizeLeaf() + right.sizeLeaf();
        }

        @Override
        public int sizeInner() {
            return (!left.isEmpty() || !right.isEmpty() ? 1 : 0) + left.sizeInner() + right.sizeInner();
        }

        @Override
        public int sizeHalf() {
            return (left.isEmpty() ^ right.isEmpty() ? 1 : 0) + left.sizeHalf() + right.sizeHalf();
        }

        @Override
        public int sizeFull() {
            return (!left.isEmpty() && !right.isEmpty() ? 1 : 0) + left.sizeFull() + right.sizeFull();
        }

        @Override
        public int sizeEmpty() {
            return (!left.isEmpty() || !right.isEmpty() ? 0 : 1) + left.sizeEmpty() + right.sizeEmpty();
        }

        @Override
        public int sizeInnerHM(int n) {
            // TODO Auto-generated method stub
            return 0;
        }

    }

}