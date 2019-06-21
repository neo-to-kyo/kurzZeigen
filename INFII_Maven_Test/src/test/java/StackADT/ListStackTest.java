package StackADT;

import ListeADT.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ListStackTest {

    @Test
    void isEmpty() {
        Stack s = new ListStack();
        assertEquals(true, s.isEmpty());
    }

    @Test
    void pop() {
        Stack s = new ListStack(List.list(1,2,3));
        Stack k = new ListStack(List.list(2,3));
        assertEquals(k, s.pop());


    }

    @Test
    void push() {
        Stack k = new ListStack(List.list(2,3));
        Stack s = new ListStack();
        assertEquals(k, s.push(3).push(2));

    }

    @Test
    void size() {
        Stack s= new ListStack(List.list(1,2,3,4));
        assertEquals(s.size() + 1, s.push(5).size());
    }

    @Test
    void top() {
        Stack s= new ListStack(List.list(1,2,3,4));
        assertEquals(1, s.top());

    }

    @Test
    void popTop() {
        Stack s= new ListStack(List.list(1,2,3,4));
        Tuple t = new Tuple(1, new ListStack(List.list(2,3,4)));
        assertEquals(s.popTop(), t);
    }


}