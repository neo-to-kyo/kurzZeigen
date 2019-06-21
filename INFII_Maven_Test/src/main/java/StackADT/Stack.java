package StackADT;

import ListeADT.List;


public interface Stack<A> {

    boolean isEmpty();
    Stack<A> push(A e);
    Integer size();
    Stack<A> pop();
    List<A> toList();
    A top();
     Tuple<A , Stack<A>> popTop();
    Stack<A> pushAll(List<A> l);



}






