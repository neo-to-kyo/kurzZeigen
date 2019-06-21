package QueueADT;

import ListeADT.List;
import StackADT.Tuple;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListQueueTest {


    //isEmpty(empty) -> True
    @Test
    void enQueue() {
        Queue<Integer> q = new ListQueue(List.list());
        assertEquals(true, q.isEmpty());

    }


    //deQueue(enQueue(x,empty)) -> True
    @Test
    void deQueue() {
        Queue<Integer> q = new ListQueue(List.list());
        assertEquals(true, q.enQueue(3).enQueue(4).enQueue(5).deQueue().deQueue().deQueue().isEmpty());
    }

    @Test
    void deQueueFront() {
        Queue<Integer> q = new ListQueue(List.list());
        Queue<Integer> yy = new ListQueue(List.list(8, 3, 4));
        Tuple<Integer, Queue<Integer>> t = new Tuple<Integer, Queue<Integer>>(yy.front(), yy.deQueue());
        assertEquals(t, yy.deQueueFront());

    }


    //front(enQueue(y,enQueue(x,q))) -> front(enque(x, q)
    @Test
    void front2() {
        Queue<Integer> q = new ListQueue(List.list());
        assertEquals(q.enQueue(q.enQueue(3).front()), q.enQueue(3));

    }


    //front(enQueue(x,empty)) -> x

    @Test
    void front1() {
        Queue<Integer> q = new ListQueue(List.list());
        assertEquals(1, q.enQueue(1).front());

    }

    // isEmpty(enQueue(x,q)) -> False
    @Test
    void enQueuetest1() {
        Queue<Integer> q = new ListQueue(List.list());
        assertEquals(false, (q.enQueue(5)).isEmpty());

    }

    // isEmpty(empty) -> True
    @Test
    void enQueuetest2() {
        Queue<Integer> q1 = new ListQueue(List.list());
        assertEquals(true, q1.isEmpty());
    }


}