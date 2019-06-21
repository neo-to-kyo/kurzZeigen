package QueueADT;


import ListeADT.List;



import static ListeADT.List.list;

public class QueueMain {
    public static void main(String[] args) {

        List list = List.list();
        List ex2 = list(1, 2, 3, 4);

        Queue q = new ListQueue(ex2);


        System.out.println("Queue: " + q);
        System.out.println("isEmpty? " + q.isEmpty());

        System.out.println();
        System.out.println("Queue: " + q);
        System.out.println("enQueue (5): " + q.enQueue(5));


        System.out.println();
        System.out.println("Queue: " + q);
        System.out.println();
        System.out.println("Queue: " + q);
        System.out.println("front: " + q.front());


        System.out.println();
        System.out.println("Queue: ");
        Queue q2 = new ListQueue(list(1, 2, 3, 4));
        System.out.println("Queue: " + q2);

        System.out.println("deQueueFront: " + q2.deQueueFront());


        System.out.println("\n" +"DoubleQueue");
        DoubleQueue qq = new DoubleQueue(list(1,2,3), list(4,5,6));
        System.out.println(qq);


        DoubleQueue qq2 = new DoubleQueue(List.list(1, 2), List.list(4, 5, 6));

        System.out.println("DoppelQueue: " + qq);
        System.out.println("enQueue(44)");
        System.out.println("enQueue: " + qq2.enQueue(44));


        System.out.println("leereListe + list(1,2,3)");
        DoubleQueue qq3 = new DoubleQueue(list(), List.list(1,2,3));
        System.out.println("FRONT:");
        System.out.println(qq3.front());

        System.out.println("\n" +"deQueue:");
        System.out.println(qq3.deQueue());


        System.out.println("\n" +"DEQUEUEFRONTDOUBLE");
        System.out.println(qq3.deQueueFront());
        System.out.println(qq2.deQueueFront());

        DoubleQueue qq4 = new DoubleQueue<>(list(), List.list(1,2,3));


        System.out.println("\n" + "isEqualDouble");
        System.out.println(qq3.isEqualTo(qq4));


        // isEqualtTo
        System.out.println();
        System.out.println("isEqualTo: ");
        System.out.println("DoubleQueue1: " + qq);
        Queue<Integer> qqD2 = new DoubleQueue<>(List.list(1,2,3), List.list(4,5,6));
        System.out.println("DoubleQueue1: " + qqD2);
        System.out.println(qq + " isEqualTo " + qqD2 + " :?\t" + qq.equals(qqD2));



        //ListQueue equals()
        System.out.println();
        System.out.println("Queue: " + q);
        List<Integer> ex3 = list(1, 2, 3, 4);
        Queue<Integer> q1 = new ListQueue(ex3);
        System.out.println(q + " isEqualto: " + q1 + "?  " + q.equals(q));


        // toList
        System.out.println();
        System.out.println("toList: ");
        Queue<Integer> q5 = new ListQueue(list(1, 2, 3, 4));
        System.out.println("List: " + q5.toList());
        System.out.println("List: " + q5.toList().getClass());
        System.out.println();


    }

}
