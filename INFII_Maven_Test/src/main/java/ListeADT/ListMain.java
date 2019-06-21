package ListeADT;

import java.util.function.Function;

import static ListeADT.List.*;

public class ListMain {
    public static void main(String[] args) {


        List<Integer> nl = list(1, 2, 3, 4);

        System.out.println(nl.reverse());
        System.out.println(nl.drop(3));


        // Equals:
        System.out.println("Equals: ");
        List ex2 = list(1, 2, 3, 4);
        List exw = list(1, 2, 3, 4, 5);

        System.out.println("Liste: [" + exw + "]");
        System.out.println("Equals: " + exw.equals(ex2));

        List<String> stringListe = list();


        List ex1 = list();

        List exDouble = list(1.0, 2.0, 3.0, 4.0);
        List list1 = list("a", "b", "c", "d");
        List list2 = list(1, 2, 3, 4, 5);

        //Sum
        System.out.println("Sum:");
        System.out.println("Liste: [" + ex2 + "]" + "\tSum: " + List.sum(ex2));
        System.out.println();

        //Prod
        System.out.println("Prod:");
        System.out.println("Liste: [" + exDouble + "]" + "\tProd: " + List.prod(exDouble));
        System.out.println();

        //Length
        System.out.println("Length:");
        System.out.println("Liste: [" + ex2 + "]" + "\tLength: " + ex2.length());
        System.out.println();

        //elem
        System.out.println("Elem: ");
        int elem = 4;
        System.out.println("Liste: [" + ex2 + "]" + "\tElem: " + elem + " von Liste?: " + ex2.elem(elem));
        System.out.println();

        // any
        System.out.println("Any");
        Function<Integer, Boolean> pAny = x -> x == 4 ? true : false;
        System.out.println("Liste: [" + ex2 + "]" + "\tAny == 4 ? : " + ex2.any(pAny));
        System.out.println();

        // all
        System.out.println("All:");
        Function<Integer, Boolean> pAll = x -> x == 1 ? true : false;
        System.out.println("Liste: [" + ex2 + "]" + "\tAll == 1 ? : " + ex2.all(pAll));
        System.out.println();

        // append
        System.out.println("Append:");
        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);
        System.out.println("Append List1 List2= [" + List.append(list1, list2) + "]");
        System.out.println();

        // Map
        System.out.println("Map: ");
        Function<Integer, Integer> fMap = x -> (x * 2);
        System.out.println("Liste: [" + ex2 + "]");
        System.out.println("Map: x^2: [" + ex2.map(fMap) + "]");
        System.out.println();

        // Filter:
        System.out.println("Filter: ");
        Function<Integer, Boolean> fFilter = x -> x == 2;
        System.out.println("Liste: [" + ex2 + "]");
        System.out.println("Map: x^2: [" + ex2.filter(fFilter) + "]");
        System.out.println();

        // Find:
        System.out.println("Find: ");
        Function<Integer, Boolean> fFind = x -> x > 2;
        System.out.println("Liste: [" + ex2 + "]");
        System.out.println("Find: [" + ex2.find(fFind) + "]");
        System.out.println();

        // Last

        System.out.println("Last: ");
        System.out.println("Liste: [" + ex2 + "]");
        System.out.println("Last: [" + ex2.last() + "]");
        System.out.println();

        // Init

        System.out.println("Init: ");
        System.out.println("Liste: [" + ex2 + "]");
        System.out.println("Init: [" + ex2.init() + "]");
        System.out.println();

        // Drop

        System.out.println("Drop: ");
        System.out.println("Liste: [" + ex2 + "]");
        System.out.println("Drop: [" + ex2.drop(2) + "]");
        System.out.println();

        // DropWhile

        Function<Integer, Boolean> fDW = x -> x < 3;
        System.out.println("DropWhile: ");
        System.out.println("Liste: [" + ex2 + "]");
        System.out.println("DropWhile: [" + ex2.dropWhile(fDW) + "]");
        System.out.println();

        // Reverse

        List<Integer> l1 = list(1, 2, 3, 4);
        System.out.println("Reverse Liste: ");
        System.out.println(": [" + l1 + "]");
        System.out.println("Reverse: [" + l1.reverse() + "]");
        System.out.println();

        // takeWhile:
        System.out.println("TakeWhile: ");
        Function<Integer, Boolean> fTW = x -> x != 3;
        System.out.println("Liste: [" + ex2 + "]");
        System.out.println("TakeWhile: <3: [" + ex2.takeWhile(fTW) + "]");
        System.out.println();

        // Equals:
        System.out.println("Equals: ");


        List leereListe = list();
        List volleListe = list(1, 2, 3);
        List volleListe2 = list(1, 2, 3);

        System.out.println(volleListe.equals(volleListe));


        // toSet
        System.out.println();
        System.out.println("toSet");
        List<Integer> lToSet = list(1, 2, 3, 4, 5, 6, 7);
        System.out.println(lToSet.toSet());

        // nub
        System.out.println();
        System.out.println("nub");
        List<Integer> lToNub = list(1, 1, 2, 2, 3, 3, 4, 5, 6, 7);
        System.out.println(lToNub.nub());


    }
}
