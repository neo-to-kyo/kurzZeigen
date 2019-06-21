package GraphADT;


import StackADT.StackError;
import MapADT.ListMap;
import MapADT.Tuple;
import QueueADT.QueueException;


public class MainListGraph {

    public static void main(String[] args) throws QueueException, StackError {

//        Graph<Integer> g1 = ListGraph.graph(ListMap.fromList([((1,2),12),
//                                  ((1,3),34),
//                                  ((1,4),55),
//                                  ((3,6),93),
//                                  ((5,4),78),
//                                  ((6,2),44),
//                                  ((6,5),26) ]);



        Graph<Integer> g = ListGraph.graph(ListMap.fromList(
                ListeADT.List.list(new Tuple<>(new Tuple<>(1, 2), 12),
                        new Tuple<>(new Tuple<>(1, 3), 34),
                        new Tuple<>(new Tuple<>(1, 4), 55),
                        new Tuple<>(new Tuple<>(3, 6), 93),
                        new Tuple<>(new Tuple<>(5, 4), 78),
                        new Tuple<>(new Tuple<>(6, 2), 44),
                        new Tuple<>(new Tuple<>(6, 5), 26))));

        Graph<Integer> brd = ListGraph.graph(ListMap.fromList(
                ListeADT.List.list(new Tuple<>(new Tuple<>(0, 5), 34),
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

        Graph<Integer> kalifornien = ListGraph.graph(ListMap.fromList(
                ListeADT.List.list(new Tuple<>(new Tuple<>(1, 2), 15),
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

        // String Graph
        System.out.println();
        System.out.println("Graph: " + g);

        // nodes:
        System.out.println();
        System.out.println("Nodes:");
        System.out.println(g.nodes());

        // edges
        // kanten
        System.out.println();
        System.out.println("Kanten:");
        System.out.println(g.edges());

        // adj
        System.out.println();
        int node = 1;
        System.out.println("adj:" + node + ": ");
        System.out.println(g.adj(node));
        // adj3
        System.out.println();
        int node3 = 3;
        System.out.println("adj:" + node3 + ": ");
        System.out.println(g.adj(node3));

        // adj 6
        System.out.println();
        int node6 = 6;
        System.out.println("adj:" + node6 + ": ");
        System.out.println(g.adj(node6));

        //

        // edgeIn
        System.out.println();
        int edgeInU = 1;
        int edgeInV = 2;
        System.out.println("edgeIn: " + edgeInU + " - " + edgeInV + "? " + g.edgeIn(edgeInU, edgeInV));

        // nodeIn
        System.out.println();
        int nodeIn = 90000;
        System.out.println("nodeIn: " + nodeIn + " ? ");
        System.out.println(g.nodeIn(nodeIn));

        // weight
        System.out.println();
        int w1 = 1;
        int w2 = 2;
        System.out.println("weight: (" + w1 + "," + w2 + "): ");
        System.out.println(g.weight(w1, w2));

        // bfs
        System.out.println();
        System.out.println("bfs(BreiteSuche): ");
        System.out.println(g.breitenSuche(1));

        // dfs Tiefensuche
        System.out.println();
        System.out.println("dfs (TiefenSuche g):");
        System.out.println(g.tiefenSuche(1));

        // dfs Tiefensuche
        System.out.println("---------------------------------------------");
        System.out.println("kalifornien:");
        System.out.println();
        System.out.println("dfs (TiefenSuche Kalifornien):");
        System.out.println(kalifornien.tiefenSuche(0));

        // bfs
        System.out.println();
        System.out.println("bfs(BreiteSuche) Kalifornien: ");
        System.out.println(kalifornien.breitenSuche(0));

        System.out.println("---------------------------------------------");
        System.out.println("BRD:");
        System.out.println();
        System.out.println("dfs (TiefenSuche BRD):");
        System.out.println(brd.tiefenSuche(0));

        // bfs
        System.out.println();
        System.out.println("bfs(BreiteSuche) BRD: ");
        System.out.println(brd.breitenSuche(0));

    }

}