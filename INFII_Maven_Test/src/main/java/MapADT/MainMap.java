package MapADT;


import ListeADT.List;
import java.util.function.Function;


public class MainMap {

    public static void main(String[] args) {
        
        
        Map<String, Integer> m = ListMap.empty();
        m = ListMap.fromList(List.list(new Tuple<>("a", 1), new Tuple<>("b", 2), new Tuple<>("c", 3)));

        m = m.insert("R", 23);
        m = m.insert("e", 44);
        System.out.println(m);

        // lookup:
        System.out.println("Lookup:");
        System.out.println(m.lookup("a"));
        System.out.println();

        // insertWith
        System.out.println("insertWith:");
        Map<Character, Integer> m1 = ListMap.fromList(List.list(new Tuple<>('a', 1), new Tuple<>('b', 2)));
        System.out.println("ListMap: " + m1);
        System.out.println("insertWith: " + m1.insertWith(x -> y -> x + y, 'a', 88));
        System.out.println();

        // toList:
        System.out.println();
        System.out.println("ListMap: " + m1);
        System.out.println("toList: " + m1.toList());
        System.out.println();

        // keys:
        System.out.println();
        System.out.println("ListMap: " + m1);
        System.out.println("keys: " + m1.keys());
        System.out.println();

        // values:
        System.out.println();
        System.out.println("ListMap: " + m1);
        System.out.println("elems: " + m1.elems());
        System.out.println();

        // all:
        System.out.println();
        System.out.println("all:");
        System.out.println("ListMap: " + m1);
        Function<Entry<Character, Integer>, Boolean> p = e -> e.getValue() < 3;
        System.out.println("all: " + m1.all(p));
        System.out.println();

        // allKeys
        System.out.println();
        System.out.println("allKeys: lenght == 1?");
        Map<String, Integer> m2 = ListMap.fromList(List.list(new Tuple<>("a", 1), new Tuple<>("bc", 2)));
        System.out.println("ListMap: " + m2);
        Function<String, Boolean> p1 = e -> e.length() == 1;
        System.out.println("allkeys: " + m2.allKeys(p1));
        System.out.println();

        // isEqualTo:
        System.out.println();
        Map<Character, Integer> mA = ListMap.fromList(List.list(new Tuple<>('a', 1), new Tuple<>('b', 2)));
        System.out.println("ListMap: " + mA);
        Map<Character, Integer> mB = ListMap.fromList(List.list(new Tuple<>('a', 1), new Tuple<>('b', 2)));
        System.out.println("ListMap: " + mB);
        System.out.println("isEqualsTo: " + mA.isEqualTo(mB));
        System.out.println();

        // equals:
        System.out.println();
        System.out.println("equals: ");
        Map<Character, Integer> mX = ListMap.
                fromList(List.list(new Tuple<>('a', 1), new Tuple<>('b', 2)));
        System.out.println("ListMap: " + mX);
        Map<Character, Integer> mY = ListMap.
                fromList(List.list(new Tuple<>('a', 1), new Tuple<>('b', 2)));
        System.out.println("ListMap: " + mY);
        System.out.println("isEqualsTo: " + mX.equals(mY));
        System.out.println();

        // wordFreqMap
        System.out.println();
        System.out.println("wordFreqMap:");
        String x = "Elfen helfen Elfen";
        Map<String, Integer> m4 = ListMap.empty();
        System.out.println("String: " + x);
        System.out.println("wordFreqMap: " + ListMap.wordFreqMap(x));
        System.out.println();
        
        // groupBy

        System.out.println("groupBy:");
        List<Payment> list = List.list();
        list = list.cons(new Payment("Alex", 100));
        list = list.cons(new Payment("Bart", 200));
        list = list.cons(new Payment("Carla", 300));
        list = list.cons(new Payment("David", 400));


        Map<String, List<Payment>> map = list.groupBy(e -> e.name);

        System.out.println(map);

    }

}
