package GraphADT;

import StackADT.ListStack;
import StackADT.Stack;
import StackADT.StackError;
import ListeADT.List;
import MapADT.ListMap;
import MapADT.Map;
import MapADT.Tuple;
import QueueADT.ListQueue;
import QueueADT.Queue;
import QueueADT.QueueException;
import SetADT.Set;
import TreeADT.Result;
import SetADT.ListSet;



public class ListGraph<A> implements Graph<A> {

    private final Integer[][] matrix;

    private ListGraph() {

        matrix = new Integer[0][0];

    }

    private ListGraph(Integer m) {

        matrix = new Integer[m][m];

    }

    private ListGraph(Integer[][] newMatrix) {

        matrix = newMatrix;

    }

    @Override
    public boolean equals(Object o) {

        return o instanceof ListGraph && isEqualTo((ListGraph<A>) o);
    }

    @Override
    public boolean isEqualTo(Graph<A> g) {

        return this.edges().toList().equals(g.edges().toList());
    }

    @Override
    public List<Integer> tiefenSuche(Integer v) throws StackError {

        Stack<Integer> stack1 = ListStack.empty();

        Set<Integer> set1 = ListSet.empty();

        List<Integer> dfsList = List.list();

        stack1 = stack1.push(v);

        return dfs(stack1, dfsList, v, set1.insert(v)).reverse();

    }

    // TiefenSuche HM:

    private List<Integer> dfs(Stack<Integer> stack1, List<Integer> dfsList, Integer v, Set<Integer> set1)
            throws StackError {

        if (stack1.isEmpty()) {

            return dfsList;

        } else {

            if (!dfsList.elem(v)) {

                dfsList = dfsList.cons(v);
                stack1 = stack1.pop();

                stack1 = stack1.pushAll(this.adj(v));

                if (stack1.isEmpty()) {

                    return dfsList;
                } else {
                    return dfs(stack1, dfsList, stack1.top(), set1);
                }

            } else {

                stack1 = stack1.pop();

                if (stack1.isEmpty()) {

                    System.out.println("here");
                    return dfsList;
                } else {
                    return dfs(stack1, dfsList, stack1.top(), set1);
                }

            }

        }

    }

    @Override
    public List<Integer> breitenSuche(Integer u) throws QueueException {

        Queue<Integer> q = new ListQueue<Integer>();
        // Set<Integer> s = ListSet.empty();
        List<Integer> bfsList = List.list();

        q = q.enQueue(u);

        return bfs(q, bfsList, u).reverse();



    }

    private List<Integer> bfs(Queue<Integer> q, List<Integer> bfsList, Integer u) throws QueueException {

        if (q.isEmpty()) {

            return bfsList;
        } else {


            if (!bfsList.elem(u)) {

                bfsList = bfsList.cons(u);



                q = q.enQueueAll(this.adj(u));

                q = q.deQueue();

                if (q.isEmpty()) {

                    return bfsList;

                } else {

                    return bfs(q, bfsList, q.front());
                }

            } else {

                q = q.deQueue();

                if (q.isEmpty()) {

                    return bfsList;

                } else {

                    return bfs(q, bfsList, q.front());
                }

            }

        }

    }

    private Queue<Integer> insertQueue(Queue<Integer> q, List<Integer> listIterator, List<Integer> aktuelleList) {


        if (listIterator.length() == 0) {
            System.out.println("List: " + aktuelleList);
            return q;
        } else {

            if (!aktuelleList.elem(listIterator.head())) {

                q = q.enQueue(listIterator.head());
                aktuelleList = aktuelleList.cons(listIterator.head());


                return insertQueue(q, listIterator.tail(), aktuelleList);

            } else {


                return insertQueue(q, listIterator.tail(), aktuelleList);

            }

        }

    }


    private static <A> Integer[][] matrixHM(List<Tuple<Integer, Integer>> k, List<A> v, Integer[][] m) {

        if (k.length() <= 1) {

            m[k.head().fst][k.head().snd] = (Integer) v.head();
            return m;

        } else {

            if (v.length() <= 1) {

                m[k.head().fst][k.head().snd] = (Integer) v.head();

                return matrixHM(k.tail(), v, m);

            } else {

                m[k.head().fst][k.head().snd] = (Integer) v.head();

                return matrixHM(k.tail(), v.tail(), m);

            }

        }

    }

    public static <A> Graph<A> graph(Map<Tuple<Integer, Integer>, A> es) {

        List<Tuple<Integer, Integer>> keys = es.keys();

        Integer max = maxKeys(keys, 0);
        System.out.println("max: " + max);
        List<A> values = es.elems();

        Integer[][] s = matrixHM(keys, values, new Integer[(max + 2)][(max + 2)]);

        // System.out.println("Max Keys: " + max);

        return new ListGraph<A>(s);

    }

    private static Integer maxKeys(List<Tuple<Integer, Integer>> k, Integer max) {

        if (k.length() <= 1) {

            if (k.head().fst >= k.head().snd) {

                if (k.head().fst >= max) {

                    max = k.head().fst;
                }

            } else {

                if (k.head().snd >= max) {

                    max = k.head().snd;
                }

            }
            return max;

        } else {

            if (k.head().fst >= k.head().snd) {

                if (k.head().fst >= max) {

                    max = k.head().fst;
                }

            } else {

                if (k.head().snd >= max) {

                    max = k.head().snd;
                }

            }

            return maxKeys(k.tail(), max);

        }

    }

    @Override
    public List<Integer> adj(Integer n) {

        List<Integer> l = List.list();
        List<Integer> result = List.list();

        result = adjHM(this.edges().keys(), l, n);

        return result.reverse();
    }

    private List<Integer> adjHM(List<Tuple<Integer, Integer>> l, List<Integer> adjL, int node) {

        if (l.length() == 0) {

            return adjL;

        } else {

            if (node == l.head().fst) {
                adjL = adjL.cons(l.head().snd);
            }
            return adjHM(l.tail(), adjL, node);

        }

    }




    // nodes
    // Knoten o. Ecken
    @Override
    public List<Integer> nodes() {

        // List<Integer> l = nodesHM(this.matrix, 0, 0, List.list());

        List<Integer> l = List.list();
        return nodesHM(this.edges().keys(), l).toSet().toList();

    }

    @Override
    public List<Integer> nodesSort() {

        List<Integer> l = TreeADT.Tree.tree(this.nodes()).inOrder();
        return l;

    }

   // @Override
    public static List<Integer> sort(List<Integer> a) {

        List<Integer> l = TreeADT.Tree.tree(a).inOrder();
        return l;

    }

    private List<Integer> nodesHM(List<Tuple<Integer, Integer>> t, List<Integer> l) {

        if (t.isEmpty()) {


            return l;
        } else {
            l = l.cons(t.head().fst);
            l = l.cons(t.head().snd);

            return nodesHM(t.tail(), l);
        }
    }




        // edges
    // Kanten
    @Override
    public Map<Tuple<Integer, Integer>, Integer> edges() {

        Map<Tuple<Integer, Integer>, Integer> m1 = ListMap.empty();

        Map<Tuple<Integer, Integer>, Integer> m = edgesHM(this.matrix, 0, 0, m1);
        return m;

    }

    // HilfsMethode Kanten
    private Map<Tuple<Integer, Integer>, Integer> edgesHM(Integer[][] m, int i, int j,
            Map<Tuple<Integer, Integer>, Integer> m1) {

        if (i == m.length) {

            return m1;

        } else {

            if (j == m[0].length) {

                return edgesHM(m, i + 1, 0, m1);

            } else {

                if (m[i][j] != null) {

                    Tuple<Integer, Integer> k = new Tuple<Integer, Integer>(i, j);

                    m1 = m1.insert(k, m[i][j]);

                }
                return edgesHM(m, i, j + 1, m1);

            }

        }

    }


    // edgeIn testet, ob eine bestimmte Kante im Graph existiert
    @Override
    public Boolean edgeIn(Integer u, Integer v) {

        return this.edges().member(new Tuple<Integer, Integer>(u, v));

    }

    // nodeIn testet, ob ein bestimmter Knoten im Graph existiert
    @Override
    public Boolean nodeIn(Integer v) {

        return nodeInHM(this.edges().keys(), false, v);

    }

    private Boolean nodeInHM(List<Tuple<Integer, Integer>> l, Boolean r, Integer v) {

        if (l.length() == 0) {

            return r;

        } else {

            if (l.head().fst == v || l.head().snd == v) {
                r = true;
            }

            return nodeInHM(l.tail(), r, v);

        }

    }

    // weight
    @Override
    public Result<A> weight(Integer u, Integer v) {

        if (this.edges().member(new Tuple<Integer, Integer>(u, v))) {

            return (Result<A>) Result.success(this.matrix[u][v]);

        } else {
            return Result.failure("empty");
        }

    }

    @Override
    public boolean weightBoolean(Integer u, Integer v) {

        if (this.edges().member(new Tuple<Integer, Integer>(u, v))) {

            return true;

        } else {
            return false;
        }

    }


    @Override
    public String toString() {

//        return this.edges().toList().toString();

        String s = toStringHM(this.matrix, 0, 0, "");
        return s;

    }

    private String toStringHM(Integer[][] m, int i, int j, String s) {

        if (i == this.matrix.length) {

            return s;

        } else {

            s = s + jIterator(m, i, 0, "");

            return toStringHM(m, i + 1, 0, s);

        }

    }

    private String jIterator(Integer[][] m, int i, int j, String s) {

        if (j == m[0].length - 1) {

            if (m[i][j] != null) {

                s = s + "(" + i + "," + j + ")" + "," + m[i][j] + " ";

            }

            return s;

        } else {

            if (m[i][j] != null) {

                s = s + "(" + i + "," + j + ")" + "," + m[i][j] + ", ";

            }

            return jIterator(m, i, j + 1, s);

        }

    }

}
