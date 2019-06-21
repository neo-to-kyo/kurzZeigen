package TreeADT;

import ListeADT.List;
import SetADT.Set;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class TreeSetTest {


    @Test
    void lookupMin() {
        Set<Integer> a1 = TreeSet.empty();
        a1 = TreeSet.fromList(List.list(50, 45, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        assertEquals(a1.lookupMinValue(), 45);
    }

    @Test
    void lookupMax() {
        Set<Integer> a1 = TreeSet.empty();
        a1 = TreeSet.fromList(ListeADT.List.list(50, 45, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        assertEquals(a1.lookupMaxValue(), 70);

    }

    @Test
    void insert() {
        Set<Integer> a1 = TreeSet.empty();
        Set<Integer> a2 = TreeSet.empty();
        a1 = TreeSet.fromList(ListeADT.List.list(50, 45, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        a2 = TreeSet.fromList(ListeADT.List.list(2, 50, 45, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        assertEquals(a1.insert(2), a2);
    }

    @Test
    void delete() {
        Set<Integer> a1 = TreeSet.empty();
        Set<Integer> a2 = TreeSet.empty();
        a1 = TreeSet.fromList(ListeADT.List.list(50, 45, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        a2 = TreeSet.fromList(ListeADT.List.list(2, 50, 45, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        assertEquals(a2.delete(2), a1);

    }

    @Test
    void member() {
        Set<Integer> a1 = TreeSet.empty();
        Set<Integer> a2 = TreeSet.empty();
        a1 = TreeSet.fromList(ListeADT.List.list(50, 45, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        a2 = TreeSet.fromList(ListeADT.List.list(2, 50, 45, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        assertEquals(a2.member(2), true);
    }

    @Test
    void size() {
        Set<Integer> a1 = TreeSet.empty();
        Set<Integer> a2 = TreeSet.empty();
        a1 = TreeSet.fromList(ListeADT.List.list(50, 45, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        assertEquals(a1.size(), 11);
    }

    @Test
    void isEmpty() {
        Set<Integer> a1 = TreeSet.empty();
        Set<Integer> a2 = TreeSet.empty();
        Set<Integer> a3 = TreeSet.empty();
        a1 = TreeSet.fromList(ListeADT.List.list(50, 45, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        assertEquals(a3.isEmpty(), true);
    }


    @Test
    void getResult() {
        Set<Integer> a1 = TreeSet.empty();
        Set<Integer> a2 = TreeSet.empty();
        Set<Integer> a3 = TreeSet.empty();
        a1 = TreeSet.fromList(ListeADT.List.list(50, 45, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        a1.get(53);
        assertEquals(a1.getResult(50), Result.success(50));
    }

    @Test
    void all() {
        Set<Integer> a1 = TreeSet.empty();
        Set<Integer> a2 = TreeSet.empty();
        Set<Integer> a3 = TreeSet.empty();
        a1 = TreeSet.fromList(ListeADT.List.list(50, 45, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        assertTrue(a1.all(e -> e < 100));

    }



    @Test
    void isSubsetOf() {
        Set<Integer> a1 = TreeSet.empty();
        Set<Integer> a2 = TreeSet.empty();
        Set<Integer> a3 = TreeSet.empty();
        a1 = TreeSet.fromList(ListeADT.List.list(50, 45, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        a2 = TreeSet.fromList(ListeADT.List.list(50, 45, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        assertTrue(a1.isSubsetOf(a2));
    }

    @Test
    void disjoint() {
        Set<Integer> a1 = TreeSet.empty();
        Set<Integer> a2 = TreeSet.empty();
        Set<Integer> a3 = TreeSet.empty();
        a1 = TreeSet.fromList(ListeADT.List.list(50, 45, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        a2 = TreeSet.fromList(ListeADT.List.list(1,2,3,4,5));
        assertTrue(a1.disjoint(a2));
    }

    @Test
    void union() {
        Set<Integer> a1 = TreeSet.empty();
        Set<Integer> a2 = TreeSet.empty();
        Set<Integer> a3 = TreeSet.empty();
        a1 = TreeSet.fromList(ListeADT.List.list(50, 45, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        a2 = TreeSet.fromList(ListeADT.List.list(1,2,3,4,5));
        a3 = TreeSet.fromList(ListeADT.List.list(1,2,3,4,5,50, 45, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        assertEquals(a1.union(a2), a3);


    }

    @Test
    void intersection() {
        Set<Integer> a1 = TreeSet.empty();
        Set<Integer> a2 = TreeSet.empty();
        Set<Integer> a3 = TreeSet.empty();
        Set<Integer> a4 = TreeSet.empty();
        a1 = TreeSet.fromList(ListeADT.List.list(50, 45, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        a2 = TreeSet.fromList(ListeADT.List.list(1,2,3,4,5));
        a3 = TreeSet.fromList(ListeADT.List.list(1,2,3,4,5,50, 45, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        a4 = TreeSet.fromList(ListeADT.List.list(1,2,3,4,5));
        assertEquals(a2.intersection(a3), a4);
    }
}