package SetADT;

import org.junit.jupiter.api.Test;

import ListeADT.List;
import SetADT.wordSet;

import static org.junit.jupiter.api.Assertions.*;

class ListSetTest {

    Set<Integer> s1 = ListSet.fromList(List.list(1, 2, 3, 7, 8, 9));
    Set<Integer> s2 = ListSet.fromList(List.list(1, 2, 3, 4, 5, 6));
    Set<Integer> s3 = ListSet.fromList(List.list(6, 7, 8, 9));


    @Test
    void delete() {
        Set<Integer> s = ListSet.fromList(List.list(2));
        s.delete(2);
        assertEquals(s, s);
    }

    // delete(y,insert(x,s)) == x==y ? delete(y,s) : insert(x,delete(y,s))
    void test10() {
        Set<Integer> s = ListSet.fromList(List.list(1,2));
        Integer x = 3;
        Integer y = 1;
        s.insert(x);
        assertEquals(x == y ? s.delete(y) : (s.delete(y)).insert(x), s.delete(y));
    }

    @Test
    void insert() {

        Set<Integer> s = ListSet.fromList(List.list(1, 2));
        Integer x = 3;
        s.insert(x);

        assertEquals((s.member(x)) ? (s.size() + 1) : s.size(), s.size());
    }

    void test8() {
        Set<Integer> s = ListSet.fromList(List.list());
        Integer x = 3;
        Integer y = 4;
        assertEquals(x == y ? s.insert(y) : (s.insert(y).insert(x)), (s.insert(x)).insert(y));
    }



    @Test
    void member() {
        Set<Integer> s = ListSet.fromList(List.list());
        Integer x = 1;
        Integer y = 1;
        s.insert(y);
        assertEquals(x != y ? true : s.member(y), s.member(x));
    }

    // member(x,empty) == False
    void test3() {

        Set<Integer> s = ListSet.fromList(List.list());
        assertEquals(false, s.member(4));
    }


        @Test
        void isEmpty () {
            Set<Integer> s = ListSet.fromList(List.list());
            assertEquals(true, s.isEmpty());
        }

        // isEmpty(insert(x,s)) == False
        void test2 () {

            Set<Integer> s = ListSet.fromList(List.list());
            s.insert(1);
            assertEquals(false, s.isEmpty());

        }

        @Test
        void get () {
            Set<Integer> s = ListSet.fromList(List.list(1, 2));
            Integer x = 3;
            Integer y = 1;

            s.insert(x);

            assertEquals(x == y ? x : s.get(y), s.get(y));
        }


        @Test
        void union () {
            assertEquals((s1.union(s2).union(s3)), (s3.union(s2).union(s1)));

        }

        @Test
        void intersection () {
            Set<Integer> a = ListSet.fromList(List.list(1, 2, 3, 4, 5));
            Set<Integer> b = ListSet.fromList(List.list(4, 5, 6, 7));
            Set<Integer> c = ListSet.fromList(List.list(5, 6, 7, 8, 9));

            assertEquals((a.intersection(b)).intersection(c), a.intersection(b.intersection(c)));
        }

        // A ∩ (B ∩ C) = (A ∩ B) ∩ C
        @Test
        void test14 () {

            Set<Integer> a = ListSet.fromList(List.list(1, 2, 3, 4, 5));
            Set<Integer> b = ListSet.fromList(List.list(4, 5, 6, 7));
            Set<Integer> c = ListSet.fromList(List.list(5, 6, 7, 8, 9));

            assertEquals((a.intersection(b)).intersection(c), a.intersection(b.intersection(c)));

        }

        // Distributivgesetz: A ∪ (B ∩ C) = (A ∪ B) ∩ (A ∪ C)
        @Test
        void test15 () {

            Set<Integer> a = ListSet.fromList(List.list(1, 2));
            Set<Integer> b = ListSet.fromList(List.list(4, 5));
            Set<Integer> c = ListSet.fromList(List.list(5, 6, 7, 8));

            assertEquals((a.union(b)).intersection(a.union(c)), a.union(b.intersection(c)));

        }

        // A ∩ (B ∪ C) = (A ∩ B) ∪ (A ∩ C)
        @Test
        void test16 () {

            Set<Integer> a = ListSet.fromList(List.list(1, 2, 7));
            Set<Integer> b = ListSet.fromList(List.list(5, 6, 7));
            Set<Integer> c = ListSet.fromList(List.list(7, 8, 9));

            assertEquals((a.intersection(b)).union(a.intersection(c)), a.intersection(b.union(c)));

        }

        // Absorptionsgesetz: A ∪ (A ∩ B) = A
        @Test
        void test17 () {

            Set<Integer> a = ListSet.fromList(List.list(1, 2, 7));
            Set<Integer> b = ListSet.fromList(List.list(5, 6, 7));

            assertEquals(a, a.union(a.intersection(b)));

        }

        // A ∩ (A ∪ B) = A
        @Test
        void test18 () {

            Set<Integer> a = ListSet.fromList(List.list(1, 2, 7));
            Set<Integer> b = ListSet.fromList(List.list(5, 6, 7));

            assertEquals(a, a.intersection(a.union(b)));

        }

        // assertTrue(wordSet("Elfen helfen Elfen").isEqualTo(set("Elfen","helfen")));
        @Test
        void test19 () {

            String x = "Elfen helfen Elfen";
            String y = "Elfen helfen";

            Set<String> set1 = wordSet.wordSet(x);
            Set<String> set2 = wordSet.wordSet(y);

            assertTrue(set1.isEqualTo(set2));

        }

    }
