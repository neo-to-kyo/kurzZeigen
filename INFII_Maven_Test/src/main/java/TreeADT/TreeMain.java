package TreeADT;

import ListeADT.List;



public class TreeMain {

    public static void main(String[] args) {

        Tree<Integer> t = Tree.empty();
        t = Tree.tree(List.list(5, 2, 84, 70, 6, 43, 90));

        System.out.println("Preorder: " + t.preOrder());
        System.out.println("sizePreOrder: " + t.preOrder().length());
        System.out.println("head: " + t.preOrder().head());

        System.out.println();
        System.out.println("inOrder: " + t.inOrder());
        System.out.println("sizeinOrder: " + t.inOrder().length());
        System.out.println("head: " + t.inOrder().head());

        System.out.println();
        System.out.println("postOrder: " + t.postOrder());
        System.out.println("sizePostOrder: " + t.postOrder().length());
        System.out.println("head: " + t.postOrder().head());
        System.out.println();
        System.out.println("levelOrder: " + t.levelOrder());
        System.out.println();
        int x = 2;
        System.out.println("Find: " + x + "? " + t.find(x));


        System.out.println("size: " + t.size());


        System.out.println("height: " + t.height());
        int x1 = 84;

        System.out.println("member: " + x + "? " + t.member(x1));
        System.out.println("findMax: " + t.findMax());


    }

}