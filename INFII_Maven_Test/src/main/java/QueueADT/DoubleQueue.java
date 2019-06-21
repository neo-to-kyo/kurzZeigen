package QueueADT;
import ListeADT.List;
import StackADT.Tuple;
import static ListeADT.List.append;

public class DoubleQueue<A> extends ListQueue<A>  implements Queue<A> {

    private final List<A> listeEins;
    private final List<A> listeZwei;

    private DoubleQueue (){
        listeEins = List.list();
        listeZwei = List.list();
    }


    public DoubleQueue(List<A> xs, List<A> ys) {
        if (xs.isEmpty() && ys.isEmpty()) throw new IllegalStateException("Queues leer");
        else {
            this.listeEins = xs;
            this.listeZwei = ys;
        }
    }




    @Override
    public String toString(){
        return "[" + this.listeEins.toString() + "] + [" + this.listeZwei.toString() +"]";
    }

    @Override
    public DoubleQueue<A> enQueue(A e) {

        // new ListQueue<>(append(list, List.list(e)));
        return new DoubleQueue<A>(listeEins, append(listeZwei, List.list(e)));
    }

    public A front() {

        if (listeEins.isEmpty()) return listeZwei.last();
        else {
           return listeEins.head();
        }
    }

    @Override
    public DoubleQueue<A> deQueue() {
        if (listeEins.isEmpty()) return new DoubleQueue<A>(listeEins, (listeZwei.init()));
        else {
            return new DoubleQueue<>(listeEins.tail(), listeZwei);
        }

    }

    public boolean isEmpty() {
        if (listeEins.isEmpty() && listeZwei.isEmpty()) return true;
        else {
            return false;
        }
    }

    public List<A> getListEins() {
        return this.listeEins;
    }

    public List<A> getListeZwei() {
        return this.listeEins;
    }

    public Tuple<A, Queue<A>> deQueueFront() {
        return new Tuple<>(front(), deQueue());
    }

    @Override
    public List<A> toList() {

        List<A> l = List.list();
        l = List.append(listeEins, listeEins);
        return l;

    }

    public boolean isEqualTo(Queue<A> qq) {
        return qq instanceof DoubleQueue && ((DoubleQueue<A>) qq).getListEins().equals(this.getListEins()) &&
                ((DoubleQueue<A>) qq).getListeZwei().equals(this.getListeZwei());
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof DoubleQueue && isEqualTo((DoubleQueue<A>) o);
    }




}
