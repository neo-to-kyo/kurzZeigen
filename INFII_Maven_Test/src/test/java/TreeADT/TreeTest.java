package TreeADT;

import ListeADT.List;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @Test
    void sizeInner() {
        Tree<Integer> t1 = Tree.empty();
        t1 = Tree.tree(List.list(5, 2, 84, 70, 6, 43, 90));
        assertEquals(t1.sizeInner(), 4);
    }


    @Test
    void sizeLeaf() {
        Tree<Integer> t1 = Tree.empty();
        t1 = Tree.tree(List.list(5, 2, 84, 70, 6, 43, 90));
        assertEquals(t1.sizeLeaf(), 3);

    }


    @Test
    void sizeHalf() {
        Tree<Integer> t1 = Tree.empty();
        t1 = Tree.tree(List.list(5, 2, 84, 70, 6, 43, 90));
        assertEquals(t1.sizeHalf(), 2);
    }

    @Test
    void sizeFull() {
        Tree<Integer> t1 = Tree.empty();
        t1 = Tree.tree(List.list(5, 2, 84, 70, 6, 43, 90));
        assertEquals(t1.sizeFull(), 2);
    }

    @Test
    void sizeEmpty() {
        Tree<Integer> t1 = Tree.empty();
        t1 = Tree.tree(List.list(5, 2, 84, 70, 6, 43, 90));
        assertEquals(t1.sizeEmpty(), 3);
    }

    @Test
    void isValueEmpty() {
        Tree<Integer> t1 = Tree.empty();
        t1 = Tree.tree(List.list(5, 2, 84, 70, 6, 43, 90));
        assertEquals(t1.isValueEmpty(), false);
    }

    @Test
    void remove() {
        Tree<Integer> t1 = Tree.empty();
        Tree<Integer> t2 = Tree.empty();
        t1 = Tree.tree(List.list(5, 2, 84, 70, 6, 43, 90));
        t2 = Tree.tree(List.list(5, 84, 70, 6, 43, 90));
        assertEquals(t1.remove(2), t2);
    }


    @Test
    void findMax() {
        Tree<Integer> t1 = Tree.empty();
        Tree<Integer> t2 = Tree.empty();
        t1 = Tree.tree(List.list(5, 2, 84, 70, 6, 43, 90));
        t2 = Tree.tree(List.list(5, 84, 70, 6, 43, 90));
        //   String neunz = "90";
        assertEquals(t1.findMax(), 90);
    }

    @Test
    void findMin() {
        Tree<Integer> t1 = Tree.empty();
        Tree<Integer> t2 = Tree.empty();
        t1 = Tree.tree(List.list(5, 2, 84, 70, 6, 43, 90));
        t2 = Tree.tree(List.list(5, 84, 70, 6, 43, 90));
        // String zwei = "2";
        assertEquals(t1.findMin(), 2);
    }

    @Test
    void isEmpty() {
        Tree<Integer> t1 = Tree.empty();
        Tree<Integer> t2 = Tree.empty();
        t1 = Tree.tree(List.list(5, 2, 84, 70, 6, 43, 90));
        //t2 = Tree.tree(List.list(5, 84, 70, 6, 43, 90));
        assertEquals(t2.isEmpty(), true);
    }


    @Test
    void insert() {
        Tree<Integer> t1 = Tree.empty();
        Tree<Integer> t2 = Tree.empty();
        t1 = Tree.tree(List.list(5, 2, 84, 70, 6, 43, 90));
        t2 = Tree.tree(List.list(5, 84, 70, 6, 43, 90));
        assertEquals(t1, t2.insert(2));
    }

    @Test
    void member() {
        Tree<Integer> t1 = Tree.empty();
        Tree<Integer> t2 = Tree.empty();
        t1 = Tree.tree(List.list(5, 2, 84, 70, 6, 43, 90));
        //   t2 = Tree.tree(List.list(5, 84, 70, 6, 43, 90));
        assertEquals(t1.member(84), true);
    }

    @Test
    void size() {
        Tree<Integer> t1 = Tree.empty();
        Tree<Integer> t2 = Tree.empty();
        t1 = Tree.tree(List.list(5, 2, 84, 70, 6, 43, 90));

        assertEquals(t1.size(), 7);
    }

    @Test
    void height() {
        Tree<Integer> t1 = Tree.empty();
        t1 = Tree.tree(List.list(5, 2, 84, 70, 6, 43, 90));
        assertEquals(t1.height(), 4);

    }

}