package SetADT;

import java.util.function.Function;

import ListeADT.List;
import TreeADT.Result;


public interface Set<A> {
    Set<A> insert(A e);

    Set<A> delete(A e);

    boolean member(A e);

    A get(A e);

    int size();

    boolean isEmpty();


    boolean any(Function<A, Boolean> p);

    boolean all(Function<A, Boolean> p);

    boolean isSubsetOf(Set<A> s);

    Set<A> union(Set<A> s);

    Set<A> intersection(Set<A> s);

    boolean isEqualTo(Set<A> s);

    boolean disjoint(Set<A> s);

    <A> Set<A> filter(Function<A, Boolean> f, Set<A> xs);

    List<A> toList();


    boolean equals(Object o);

    Result<A> getResult(A e);

    Result<A> lookupMax();

    Result<A> lookupMin();


    A lookupMinValue();


    A lookupMaxValue();


}