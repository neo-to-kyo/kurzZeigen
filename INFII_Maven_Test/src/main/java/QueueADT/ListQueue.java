package QueueADT;

import ListeADT.List;
import StackADT.Tuple;

import static ListeADT.List.append;

public class ListQueue<A> extends AbstractQueue<A> {

    private final List<A> list;


    public ListQueue(){
        list = List.list();
    }

    public ListQueue(List<A> list) {
      //  if (list.isEmpty()) throw new IllegalStateException("ListQueue war leer");
        this.list = list;
    }


    @Override
    public Queue<A> enQueueAll(List<A> list) {
        return new ListQueue<>(append(this.toList(), list));
    }



    @Override
    public String toString() {
        return list.toString();
    }


    @Override
    public Queue<A> enQueue(A e) {
        return new ListQueue<>(append(list, List.list(e)));
    }

    @Override
    public Queue<A> deQueue() throws QueueException {
        if (list.isEmpty()) throw new QueueException("empty Queue");
        return new ListQueue(list.tail());

    }

    @Override
    public Tuple<A, Queue<A>> deQueueFront() {
        try {
            return new Tuple<A, Queue<A>>(front(), deQueue());
        } catch (QueueException e) {

            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<A> toList() {
        return this.list;
    }


    @Override
    public boolean isEqualTo(Queue<A> q) {
        return list.equals(q.toList());
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ListQueue && isEqualTo((ListQueue<A>) o);
    }



    @Override
    public A front() {
        return list.head();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }



}
