package StackADT;

import ListeADT.List;

import static ListeADT.List.list;

public class ListStack<A> implements Stack<A> {
    private final List<A> list;


    public ListStack() {
        list = list();
    }

    public ListStack(List xs) {
        this.list = xs;
    }

    @Override
    // O(1)
    public boolean isEmpty() {

        return list.isEmpty();
    }

    @Override
    public String toString() {
        return this.list.toString();
    }

    @Override
    // O(1)
    public Stack<A> pop() throws StackError {
        if (isEmpty()) {
            throw new StackError("pop from an empty stack");
        }

        return new ListStack<>(list.tail());
    }


    @Override
    // O(1)
    public Stack<A> push(A e) {

        return new ListStack<>(list.cons(e));

    }

    @Override
    public Stack<A> pushAll(List<A> l) {
        // return new ListStack<A>(List.append(this.list, l));
        return new ListStack<A>(List.append(l, this.list));
        // return new ListStack<A>());
    }

    public Integer size() {
        return this.list.length();
    }


    @Override
    // O(1)
    public A top() throws StackError {
        if (isEmpty()) {
            throw new StackError("top from an empty stack");
        }
        return list.head();
    }


    @Override
    public List<A> toList() {
        return list;
    }

    @Override
    // O(1)
    public Tuple<A, Stack<A>> popTop() {
        return new Tuple<>(top(), pop());
    }


    private boolean isEqualTo(ListStack<A> s) {
        return list.equals(s.toList());
    }


    @Override
    public boolean equals(Object o) {
        return o instanceof ListStack && isEqualTo((ListStack<A>) o);
    }


    @SuppressWarnings("unchecked")
    public static <A> ListStack<A> empty() {
        return new ListStack();
    }

    @SuppressWarnings("unchecked")
    public static <A> ListStack<A> fromList(List<A> xs) {
        return new ListStack<>(xs);
    }




}
