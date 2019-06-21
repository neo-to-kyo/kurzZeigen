package ListeADT;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {


    @Test
    void append() {
        List l = List.list(1,2,3,4);
        List k = List.list(5,6,7,8);
        List m = List.append(l, k);
        assertEquals(m, List.list(1,2,3,4,5,6,7,8));

    }

    @Test
    void isEmpty() {
        List l = List.list();
        assertEquals(true, l.isEmpty());
    }


    @Test
    void sum() {
        List k = List.list(5,6,7,8);
        assertEquals(26, List.sum(k));


    }

    @Test
    void prod() {
        List k = List.list(0.0,6.0,7.0,8.0);
        assertEquals(0.0, List.prod(k));
    }

    @Test
    void map() {
        List k = List.list(5,6,7,8);
        Function<Integer, Integer> fMap = x -> (x * 2);
        List exp = List.list(10,12,14,16);
        assertEquals(exp, k.map(fMap));
    }

    //elem(x,cons(x,l)) -> True
    @Test
    void elem() {
        List k = List.list(5,6,7,8);
        assertEquals(true, (k.cons(1)).elem(1));


    }

    //length(cons(x,l)) -> length(l)+1
    @Test
    void length() {
        List l = List.list(1,2,3,4);
        assertEquals(l.length() + 1, l.cons(5).length());
    }

    @Test
    void init() {
        List l = List.list(1,2,3,4);
        List k = List.list(1,2,3);

        assertEquals(k, l.init());

    }

    @Test
    void last() {
        List l = List.list(1,2,3,4);
        assertEquals(4, l.last());


    }

    @Test
    void reverse() {
        List l = List.list(1,2,3,4);
        List k = List.list(4,3,2,1);
        assertEquals(k, l.reverse());

    }

    @Test
    void drop() {
        List l = List.list(1,2,3,4);
        List k = List.list(3,4);
        assertEquals(k, l.drop(2));

    }

    @Test
    void take() {
        List l = List.list(1,2,3,4);
        List k = List.list(1,2);
        assertEquals(k, l.take(2));

    }

    @Test
    void dropWhile() {
        List l = List.list(1,2,3,4);
        Function<Integer, Boolean> fDW = x -> x < 3;
        assertEquals(List.list(4), l.dropWhile(fDW));



    }

    @Test
    void takeWhile() {
        List l = List.list(1,2,3,4);
        Function<Integer, Boolean> fDW = x -> x < 3;
        assertEquals(List.list(1,2), l.takeWhile(fDW));

    }

    @Test
    void filter() {
        List l = List.list(1,2,3,4);
        Function<Integer, Boolean> fDW = x -> x == 3;
        assertEquals(List.list(3), l.filter(fDW));
    }
}