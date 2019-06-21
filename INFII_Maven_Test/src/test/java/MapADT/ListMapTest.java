package MapADT;


import static org.junit.jupiter.api.Assertions.assertEquals;
import ListeADT.List;
import org.junit.jupiter.api.Test;



class MapTest {

    // isEmpty(empty) == True
    @Test
    void Test1() {

        Map<String, Integer> m = ListMap.fromList(List.list());
        assertEquals(true, m.isEmpty());

    }

    // isEmpty(insert(k,v,m)) == False
    @Test
    void Test2() {

        Map<String, Integer> m = ListMap.fromList(List.list());
        m = m.insert("R", 23);

        assertEquals(false, m.isEmpty());

    }

    // member(k,empty) == False
    @Test
    void Test3() {

        Map<String, Integer> m = ListMap.fromList(List.list());

        assertEquals(false, m.member("a"));

    }

    // member(k2,insert(k1,v,m)) == k1==k2 ? true : member(k2,m)
    @Test
    void Test4() {

        Map<Integer, String> m = ListMap.fromList(List.list(new Tuple<>(1, "a"), new Tuple<>(2, "b"), new Tuple<>(3, "c")));
        Tuple<Integer, String> k1 = new Tuple<>(4, "d");
        Tuple<Integer, String> k2 = new Tuple<>(4, "d");
        m = m.insert(k1.fst, k1.snd);

        assertEquals(k1.fst == k2.fst ? true : m.member(k2.fst), m.member(k2.fst));

    }

    // member(k2,delete(k1,m)) == k1==k2 ? false : member(k2,m)
    @Test
    void Test5() {

        Map<Integer, String> m = ListMap.fromList(List.list(new Tuple<>(1, "a"), new Tuple<>(2, "b"), new Tuple<>(3, "c")));
        Tuple<Integer, String> k1 = new Tuple<>(4, "d");
        Tuple<Integer, String> k2 = new Tuple<>(4, "d");
        m = m.insert(k1.fst, k1.snd);
        m = m.delete(k1.fst);
        assertEquals(k1.fst == k2.fst ? false : m.member(k2.fst), m.member(k2.fst));
    }

    // size(empty) == 0
    @Test
    void Test6() {

        Map<Integer, String> m = ListMap.fromList(List.list());
        assertEquals(0, m.size());

    }

    // size(insert(k,v,m)) == !member(k,m) ? size(m)+1 : size(m)
    @Test
    void Test7() {

        Map<Integer, String> m = ListMap.fromList(List.list(new Tuple<>(1, "a"), new Tuple<>(2, "b"), new Tuple<>(3, "c")));
        Tuple<Integer, String> k = new Tuple<>(4, "d");

        m = m.insert(k.fst, k.snd);

        assertEquals((!m.member(k.fst)) ? (m.size() + 1) : m.size(), m.size());
    }

    // insert(k2,v,insert(k1,v,m)) == insert(k1,v,insert(k2,v,m))
    @Test
    void Test8() {

        Map<Integer, String> m = ListMap.fromList(List.list(new Tuple<>(1, "a"), new Tuple<>(2, "b"), new Tuple<>(3, "c")));
        Map<Integer, String> m1 = ListMap.fromList(List.list(new Tuple<>(1, "a"), new Tuple<>(2, "b"), new Tuple<>(3, "c")));
        Tuple<Integer, String> k1 = new Tuple<>(4, "d");
        Tuple<Integer, String> k2 = new Tuple<>(4, "d");
        m = m.insert(k1.fst, k1.snd);
        m = m.insert(k2.fst, k2.snd);

        assertEquals((m1.insert(k2.fst, k2.snd)).insert(k1.fst, k2.snd), m);
    }

    // insert(k,v2,insert(k,v1,m)) == insert(k,v2,m)
    @Test
    void Test9() {

        Map<Integer, String> m = ListMap.fromList(List.list(new Tuple<>(1, "a"), new Tuple<>(2, "b"), new Tuple<>(3, "c")));
        Map<Integer, String> m1 = ListMap.fromList(List.list(new Tuple<>(1, "a"), new Tuple<>(2, "b"), new Tuple<>(3, "c")));
        Tuple<Integer, String> k = new Tuple<>(4, "d");
        Tuple<Integer, String> k1 = new Tuple<>(4, "X");
        m = m.insert(k.fst, k.snd);
        m = m.insert(k1.fst, k1.snd);

        assertEquals(m1 = m1.insert(k1.fst, k1.snd), m);
    }

    // delete(k2,insert(k1,v,m)) == k1==k2 ? delete(k2,m) :
    // insert(k1,v,delete(k2,m))
    @Test
    void Test10() {

        Map<Integer, String> m = ListMap.fromList(List.list(new Tuple<>(1, "a"),
                new Tuple<>(2, "b"), new Tuple<>(3, "c")));
        Map<Integer, String> m1 = ListMap.fromList(List.list(new Tuple<>(1, "a"),
                new Tuple<>(2, "b"), new Tuple<>(3, "c")));
        Tuple<Integer, String> k1 = new Tuple<>(4, "d");
        Tuple<Integer, String> k2 = new Tuple<>(4, "X");

        m = m.insert(k1.fst, k1.snd);
        m = m.delete(k2.fst);

        assertEquals((k1.fst == k2.fst) ? (m1 = m1.delete(k2.fst))
                        : (m1 = m1.delete(k2.fst)).insert(k1.fst, k1.snd), m);
    }

    // lookup(k2,insert(k1,v,m)) == k1==k2 ? v : lookup(k2,m)
    @Test
    void Test11() {

        Map<Integer, String> m = ListMap.fromList(List.list(new Tuple<>(1, "a"), new Tuple<>(2, "b"), new Tuple<>(3, "c")));

        Tuple<Integer, String> k1 = new Tuple<>(4, "d");
        Tuple<Integer, String> k2 = new Tuple<>(4, "X");

        m = m.insert(k1.fst, k1.snd);

        assertEquals((k1.fst == k2.fst) ? k1.snd : m.lookup(k2.fst), m.lookup(k2.fst));
    }

    // lookup(k2,delete(k1,m)) == k1==k2 ? null : lookup(k2,m)
    @Test
    void Test12() {

        Map<Integer, String> m = ListMap.fromList(List.list(new Tuple<>(1, "a"), new Tuple<>(2, "b"), new Tuple<>(3, "c")));

        Tuple<Integer, String> k1 = new Tuple<>(4, "d");
        Tuple<Integer, String> k2 = new Tuple<>(4, "X");

        m = m.delete(k1.fst);

        assertEquals((k1.fst == k2.fst) ? null : m.lookup(k2.fst), m.lookup(k2.fst));
    }


    @Test
    void Test13() {


        System.out.println("groupBy:");
        List<Payment> list = List.list();
        list = list.cons(new Payment("Alex", 100));
        list = list.cons(new Payment("Bart", 200));
        list = list.cons(new Payment("Carla", 300));


        Map<String, List<Payment>> map = list.groupBy(e -> e.name);

        assertEquals(false, map.isEmpty());


    }

}