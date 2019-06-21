package StackADT;

import ListeADT.List;

public class StackMain {
    public static void main(String[] args) {
        ListStack<Integer> xs = new ListStack<Integer>();
        ListStack<Integer> xs1 = new ListStack<Integer>();
        System.out.println("Liste: " + xs);
        System.out.println("----------------");

        List<Integer> y = List.list(1, 2, 3, 4, 5, 6, 7);
        xs = new ListStack<Integer>(y);
        xs1 = new ListStack<Integer>(y);

        System.out.println("1:");
        System.out.println(xs);
        System.out.println(xs.getClass());
        System.out.println();

        System.out.println("toList:");
        System.out.println(xs);
        System.out.println(xs.toList().getClass());

        System.out.println();
        System.out.println("Top");
        System.out.println(xs1.top());

        System.out.println("PopTop: ");
        System.out.println(xs.popTop().toString());
        System.out.println(xs.popTop());

    }

}
