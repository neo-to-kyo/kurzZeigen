package QueueADT;

import ListeADT.List;
import org.junit.jupiter.api.Test;
import static ListeADT.List.list;
import static org.junit.jupiter.api.Assertions.*;


class DoubleQueueTest {



    List list = List.list();
    List ex2 = list(1, 2, 3, 4);


    DoubleQueue<Integer> qq = new DoubleQueue<>(List.list(1, 2, 3, 4), List.list(5, 6, 7, 8));
    DoubleQueue qq2 = new DoubleQueue(List.list(1, 2), List.list(4, 5, 6));
    DoubleQueue qq3 = new DoubleQueue(list(), List.list(1,2,3));
    DoubleQueue qq4 = new DoubleQueue<>(list(), List.list(1,2,3));

    Queue<Integer> q5 = new ListQueue(list(1, 2, 3, 4));

    List<Integer> ex3 = list(1, 2, 3, 4);
    Queue<Integer> q1 = new ListQueue(ex3);

    Queue<Integer> qqD2 = new DoubleQueue<>(List.list(1,2,3), List.list(4,5,6));


    Queue<Integer> erwartetQueue = new DoubleQueue<>(list(1, 2, 3, 4), list(5, 6, 7, 8, 44));


    @Test
    void enQueue() {
        assertEquals(erwartetQueue, qq.enQueue(44));
    }




    @Test
    void front() {
        assertEquals(1, erwartetQueue.front());
    }

    @Test
    void deQueue() {
        Queue listDeQueue = new DoubleQueue(list(), list(1,2,3));
        Queue erwartetDeQueue = new DoubleQueue(list(), list(1,2));

    }


}