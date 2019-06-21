package QueueADT;

import ListeADT.List;
import StackADT.Tuple;

public interface Queue<A> {
    boolean isEmpty();

    Queue<A> enQueue(A e);

    Queue<A> deQueue() throws QueueException;

    Tuple<A, Queue<A>> deQueueFront();

    boolean isEqualTo(Queue<A> q);

    List<A> toList();

    A front();

    Queue<A> enQueueAll(List<A> list);


}
