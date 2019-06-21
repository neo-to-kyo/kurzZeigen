package GraphADT;
import StackADT.StackError;
import ListeADT.List;
import MapADT.Map;
import MapADT.Tuple;
import QueueADT.QueueException;
import TreeADT.Result;


public interface Graph<A> {
    List<Integer> adj(Integer n);

    List<Integer> nodes();

    Map<Tuple<Integer, Integer>, Integer> edges();

    Boolean edgeIn(Integer u, Integer v);

    Boolean nodeIn(Integer v);

    Result<A> weight(Integer u, Integer v);

    boolean weightBoolean(Integer u, Integer v);

    List<Integer> breitenSuche(Integer u) throws QueueException;

    List<Integer> tiefenSuche(Integer v) throws StackError;

    List<Integer> nodesSort();

    boolean isEqualTo(Graph<A> g);
}

