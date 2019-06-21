package TreeADT;

import ListeADT.List;
import SetADT.Set;


public class TreeSetMain {
    public static void main(String[] args) {

        Set<Integer> t5 = TreeSet.empty();
        t5 = TreeSet.fromList(ListeADT.List.list(50, 45, 70, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        // t5 = TreeSet.set(50, 45, 47, 70, 70, 60, 54, 53, 58, 57, 59, 63, 62);
        System.out.println("TreeSet: " + t5);

        System.out.println();
        int x = 47;
        t5 = t5.insert(x);
        System.out.println("insert: " + x + ":  " + t5);

        Set<Integer> t1 = TreeSet.empty();
        t1 = TreeSet.fromList(ListeADT.List.list(50, 45, 47, 70, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        System.out.println();
        System.out.println("Tree: " + t1);
        int y = 45;
        t1 = t1.delete(y);
        System.out.println("delete: " + y + ":  " + t1);

        // -----------
        Set<Integer> t2 = TreeSet.empty();
        t2 = TreeSet.fromList(ListeADT.List.list(50, 45, 47, 70, 70, 60, 54, 53, 58, 57, 59, 63, 62));

        System.out.println();
        System.out.println("Tree: " + t2);
        int m = 63;
        System.out.println("is " + m + " member? " + t2.member(m));

        System.out.println();
        System.out.println("Tree: " + t2);
        System.out.println("size: " + t2.size());

        System.out.println();
        System.out.println("Tree: " + t2);
        System.out.println("is empty?  " + t2.isEmpty());

        System.out.println();
        System.out.println("Tree: " + t2);
        Set<Integer> s = TreeSet.empty();
        s = TreeSet.fromList(ListeADT.List.list(58, 57, 59, 63, 62));
        System.out.println(s + " isSubSetOf ? " + t2.isSubsetOf(s));


        System.out.println();
        Set<Integer> t3 = TreeSet.empty();
        t3 = TreeSet.fromList(ListeADT.List.list(50, 45, 70, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        Set<Integer> union = TreeSet.empty();
        union = TreeSet.fromList(ListeADT.List.list(47));
        System.out.println("Tree: " + t3);
        System.out.println("TreeUnion: " + union);
        System.out.println("Union: " + t3.union(union));


        System.out.println();
        Set<Integer> t6 = TreeSet.empty();
        t6 = TreeSet.fromList(ListeADT.List.list(50, 45, 70, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        Set<Integer> inters = TreeSet.empty();
        inters = TreeSet.fromList(ListeADT.List.list(47, 70, 53));
        System.out.println("Tree: " + t6);
        System.out.println("TreeIntersection: " + inters);
        System.out.println("intersection: " + t6.intersection(inters));


        System.out.println();
        Set<Integer> t7 = TreeSet.empty();
        t7 = TreeSet.fromList(ListeADT.List.list(50, 45, 70, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        Set<Integer> t8 = TreeSet.empty();
        t8 = TreeSet.fromList(ListeADT.List.list(50, 45, 70, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        System.out.println("Tree1: " + t7);
        System.out.println("Tree2: " + t8);
        System.out.println("isEqualTo?: " + t7.isEqualTo(t8));


        System.out.println();
        Set<Integer> a = TreeSet.empty();
        a = TreeSet.fromList(ListeADT.List.list(50, 45, 70, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        Set<Integer> b = TreeSet.empty();
        b = TreeSet.fromList(ListeADT.List.list(70, 60));
        System.out.println("Tree1: " + a);
        System.out.println("Tree2: " + b);
        System.out.println("disjoint: " + a.disjoint(b));


        System.out.println();
        Set<Integer> a1 = TreeSet.empty();
        a1 = TreeSet.fromList(ListeADT.List.list(50, 45, 70, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        System.out.println("Tree1: " + a1);
        System.out.println("toList: " + a1.toList());


        Set<Integer> a2 = TreeSet.empty();
        a2 = TreeSet.fromList(ListeADT.List.list(50, 45, 70, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        System.out.println();
        System.out.println("Tree1: " + a2);
        // System.out.println("findMax: " + a2.lookupMax());
        System.out.println("findMax: " + a2.lookupMax());


        System.out.println();
        System.out.println("Tree1: " + a2);
        // System.out.println("findMax: " + a2.lookupMin());
        System.out.println("findMax: " + a2.lookupMin());

        Tree<Integer> baum = Tree.empty();
        baum = TreeADT.Tree.tree(List.list(5, 2, 84, 70, 6, 43, 90));
        baum = TreeADT.Tree.tree(List.list(50, 45, 70, 70, 60, 54, 53, 58, 57, 59, 63, 62));
        System.out.println("Inorder:" +baum.inOrder());

    }

}




