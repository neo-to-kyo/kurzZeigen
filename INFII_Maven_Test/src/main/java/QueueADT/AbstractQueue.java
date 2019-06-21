package QueueADT;

import ListeADT.List;
import StackADT.Tuple;


public abstract class AbstractQueue<A> implements Queue<A> {

    public abstract Queue<A> enQueue(A e);

    public abstract Queue<A> enQueueAll(List<A> list);

    public abstract Queue<A> deQueue() throws QueueException;

    public abstract A front();

    public abstract boolean isEmpty();

    public abstract boolean isEqualTo(Queue<A> q);

    public abstract Tuple<A, Queue<A>> deQueueFront();

    public abstract List<A> toList();




}


