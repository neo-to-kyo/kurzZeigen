package SetADT;

import ListeADT.List;

import java.util.function.Function;

import static SetADT.ListSet.fromList;


public class SetMain {


    public static void main(String[] args) {

        List<Integer> ll = List.list(1, 2, 3, 4);

        Set<Integer> set1 = fromList(ll);
        Set<Integer> set = fromList(List.list(1,2,3));

        System.out.println(set.equals(set1));

        System.out.println("toList");
        System.out.println("ListSet: " + set1);
        System.out.println("toList: " + set1.toList().getClass());
        System.out.println();

        System.out.println("isEmpty");
        System.out.println("ListSet: " + set1);
        System.out.println("isEmpty? :" + set1.isEmpty());

        System.out.println("get");
        System.out.println("ListSet: " + set1);



        System.out.println();
        System.out.println("member: ");
        System.out.println("ListSet: " + set1);
        Integer num = 5;
        System.out.println(num + " member ?: " + set1.member(num));


        System.out.println();
        System.out.println("size: ");
        System.out.println("ListSet: " + set1);
        System.out.println(set1.size());

        System.out.println();
        System.out.println("get: ");
        System.out.println("ListSet: " + set1);
        System.out.println(set1.get(2));


        System.out.println();
        System.out.println("union");
        Set<Integer> setU1 = fromList(List.list(1, 2, 3, 4, 5));
        Set<Integer> setU2 = fromList(List.list(3, 4, 5, 6, 7, 8));
        System.out.println(setU1.union(setU2));


        System.out.println();
        System.out.println("Intersection");
        Set<Integer> setI1 = fromList(List.list(1, 2, 3, 4, 5, 6, 7, 8));
        Set<Integer> setI2 = fromList(List.list(5, 6, 7, 8));
        System.out.println(setI1.intersection(setI2));


        Set<Integer> s1 = fromList(List.list(1,2,3));
        Set<Integer> s2 = fromList(List.list(1,2,3,4,5,6));
        Set<Integer> s3 = fromList(List.list(6,7,8,9));

        System.out.println(" A ∩ (B ∩ C) = (A ∩ B) ∩ C");
        Set<Integer> a = fromList(List.list(1, 2, 3, 4, 5));
        Set<Integer> b = fromList(List.list(4, 5, 6, 7));
        Set<Integer> c = fromList(List.list(5, 6, 7, 8, 9));
        System.out.println(a.intersection(b.intersection(c)));


        Set<Integer> x = fromList(List.list(1, 2, 3, 4, 5));
        Function<Integer, Integer> mapTest = zahl -> zahl*3;
        System.out.println(List.map(mapTest, x.toList()));


        System.out.println(wordSet.wordSet("Elfen helfen Elfen"));




    }


}
