package StackADT;

import static ListeADT.List.list;
import static ListeADT.List.words;
import ListeADT.List;


public class PostfixMain  {

    public static void main(String[] args) {

        String x = "8 5 13 +";
        String x1 = "5 !";
        //String x1 = "90 34 12 33 55 66 + * - + -";
        List y = list();
       // y = List.Cons.words(x, 0, 0);
        y = words(x);


        List<String> y2 = list();
        Postfix p = new Postfix();

        System.out.println("\n " + "2. String");
        y2 = words(x1);
        System.out.println(p.evalRek.apply(y2));


        System.out.println("add");
        System.out.println(p.evalRek.apply(y));



    }

}
