package SetADT;

import ListeADT.List;

public class wordSet {

    public static Set<String> wordSet(String s) {
        List<String> l = List.list(s.split(" +"));

        Set<String> myNewList = ListSet.fromList(List.list());

        Set<String> set = wordSet1(l, myNewList);
        return set;

    }

    private static Set<String> wordSet1(List<String> l, Set<String> myNewList) {

        if (l.length() <= 1) {

            return myNewList.insert(l.head());

        } else {
            return wordSet1(l.tail(), myNewList.insert(l.head()));
        }

    }


}


