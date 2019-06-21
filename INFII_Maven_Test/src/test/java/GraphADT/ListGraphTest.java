package GraphADT;


import MapADT.ListMap;
import MapADT.Map;
import MapADT.Tuple;
import TreeADT.Result;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ListGraphTest {

    Graph<Integer> g = ListGraph.graph(ListMap
            .fromList(ListeADT.List.list(new Tuple<>(new Tuple<>(1, 2), 12),
                    new Tuple<>(new Tuple<>(1, 3), 34),
                    new Tuple<>(new Tuple<>(1, 4), 55),
                    new Tuple<>(new Tuple<>(3, 6), 93),
                    new Tuple<>(new Tuple<>(5, 4), 78),
                    new Tuple<>(new Tuple<>(6, 2), 44),
                    new Tuple<>(new Tuple<>(6, 5), 26))));

    Map<Tuple<Integer, Integer>, Integer> es = ListMap
            .fromList(ListeADT.List.list(new Tuple<>(new Tuple<>(1, 2), 12),
                    new Tuple<>(new Tuple<>(1, 3), 34),
                    new Tuple<>(new Tuple<>(1, 4), 55),
                    new Tuple<>(new Tuple<>(3, 6), 93),
                    new Tuple<>(new Tuple<>(5, 4), 78),
                    new Tuple<>(new Tuple<>(6, 2), 44),
                    new Tuple<>(new Tuple<>(6, 5), 26)));

    Graph<Integer> brd = ListGraph.graph(ListMap
            .fromList(ListeADT.List.list(new Tuple<>(new Tuple<>(0, 5), 34),
                    new Tuple<>(new Tuple<>(5, 0), 34),

                    new Tuple<>(new Tuple<>(0, 6), 224),
                    new Tuple<>(new Tuple<>(6, 0), 224),

                    new Tuple<>(new Tuple<>(0, 1), 181),
                    new Tuple<>(new Tuple<>(1, 0), 181),

                    new Tuple<>(new Tuple<>(5, 3), 174),
                    new Tuple<>(new Tuple<>(3, 5), 174),

                    new Tuple<>(new Tuple<>(3, 7), 30),
                    new Tuple<>(new Tuple<>(7, 3), 30),

                    new Tuple<>(new Tuple<>(3, 1), 66),
                    new Tuple<>(new Tuple<>(1, 3), 66),

                    new Tuple<>(new Tuple<>(1, 6), 88),
                    new Tuple<>(new Tuple<>(6, 1), 88),

                    new Tuple<>(new Tuple<>(1, 8), 136),
                    new Tuple<>(new Tuple<>(8, 1), 136),

                    new Tuple<>(new Tuple<>(1, 2), 104),
                    new Tuple<>(new Tuple<>(2, 1), 104),

                    new Tuple<>(new Tuple<>(3, 2), 106),
                    new Tuple<>(new Tuple<>(2, 3), 106),

                    new Tuple<>(new Tuple<>(4, 2), 96),
                    new Tuple<>(new Tuple<>(2, 4), 96),

                    new Tuple<>(new Tuple<>(2, 8), 93),
                    new Tuple<>(new Tuple<>(8, 2), 93),

                    new Tuple<>(new Tuple<>(4, 7), 104),
                    new Tuple<>(new Tuple<>(7, 4), 104))));

    Graph<Integer> kalifornien = ListGraph.graph(ListMap
            .fromList(ListeADT.List.list(new Tuple<>(new Tuple<>(1, 2), 15),
                    new Tuple<>(new Tuple<>(2, 1), 15),

                    new Tuple<>(new Tuple<>(1, 0), 18),
                    new Tuple<>(new Tuple<>(0, 1), 18),

                    new Tuple<>(new Tuple<>(0, 3), 12),
                    new Tuple<>(new Tuple<>(3, 0), 12),

                    new Tuple<>(new Tuple<>(3, 2), 15),
                    new Tuple<>(new Tuple<>(2, 3), 15),

                    new Tuple<>(new Tuple<>(0, 14), 15),
                    new Tuple<>(new Tuple<>(14, 0), 15),

                    new Tuple<>(new Tuple<>(0, 4), 20),
                    new Tuple<>(new Tuple<>(4, 0), 20),

                    new Tuple<>(new Tuple<>(4, 13), 25),
                    new Tuple<>(new Tuple<>(13, 4), 25),

                    new Tuple<>(new Tuple<>(13, 14), 15),
                    new Tuple<>(new Tuple<>(14, 13), 15),

                    new Tuple<>(new Tuple<>(4, 5), 20),
                    new Tuple<>(new Tuple<>(5, 4), 20),

                    new Tuple<>(new Tuple<>(3, 5), 20),
                    new Tuple<>(new Tuple<>(5, 3), 20),

                    new Tuple<>(new Tuple<>(4, 6), 18),
                    new Tuple<>(new Tuple<>(6, 4), 18),

                    new Tuple<>(new Tuple<>(6, 7), 15),
                    new Tuple<>(new Tuple<>(7, 6), 15),

                    new Tuple<>(new Tuple<>(5, 7), 14),
                    new Tuple<>(new Tuple<>(7, 5), 14),

                    new Tuple<>(new Tuple<>(7, 8), 20),
                    new Tuple<>(new Tuple<>(8, 7), 20),

                    new Tuple<>(new Tuple<>(6, 9), 10),
                    new Tuple<>(new Tuple<>(9, 6), 10),

                    new Tuple<>(new Tuple<>(9, 8), 15),
                    new Tuple<>(new Tuple<>(8, 9), 15),

                    new Tuple<>(new Tuple<>(8, 11), 60),
                    new Tuple<>(new Tuple<>(11, 8), 60),

                    new Tuple<>(new Tuple<>(11, 12), 70),
                    new Tuple<>(new Tuple<>(12, 11), 70),

                    new Tuple<>(new Tuple<>(12, 10), 10),
                    new Tuple<>(new Tuple<>(10, 12), 10),

                    new Tuple<>(new Tuple<>(10, 9), 35),
                    new Tuple<>(new Tuple<>(9, 10), 35),

                    new Tuple<>(new Tuple<>(12, 13), 50),
                    new Tuple<>(new Tuple<>(13, 12), 50))));

    @BeforeAll
    static void setUpBeforeClass() throws Exception {



    }

    // nodeIn x g == elem x (nodes g)
    @Test
    void test1() {



        assertEquals(g.nodes().elem(1), g.nodeIn(1));

    }

    // edgeIn x y g == member (x,y) (edges g)
    @Test
    void test2() {

        assertEquals(g.edgeIn(1, 2), g.edges().member(new Tuple<>(1, 2)));

    }

    // elem x (adj y g) == edgeIn y x g
    @Test
    void test3() {

        assertEquals(g.adj(1).elem(2), g.edgeIn(1, 2));

    }

    // weight x y g == lookup(x,y)(edges g)
    @Test
    void test5() {

        assertEquals(g.weight(1, 2), Result.success(g.edges().lookup(new Tuple<>(1, 2))));

    }

    // graph (edges g) == g
    @Test
    void test6() {

        assertEquals(ListGraph.graph(g.edges()), g);

    }

    // edges (graph es) == es
    @Test
    void test7() {


        assertEquals(ListGraph.graph(es).edges(), es);

    }

    // nodes (graph es) == isEmpty es ? [] : [minimum ns .. maximum ns] where
    // ns = concat [[u,v]|(u,v)<-keys es]
    @Test
    void test8() {

        assertEquals((ListGraph.graph(es)).nodesSort(),
                es.isEmpty() ? ListeADT.List.list() : TreeADT.Tree.tree(ListGraph.graph(es).nodes()).inOrder());

    }


}