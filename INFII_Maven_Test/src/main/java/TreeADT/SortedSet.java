package TreeADT;

import SetADT.Set;


public interface SortedSet<A extends Comparable<A>> extends Set<A> {
    //A findMin();
    //A findMax();
    Result<A> lookupMax();

    Result<A> lookupMin();

    boolean isEqualTo(Set<A> s);


    A lookupMinValue();


    A lookupMaxValue();


}
