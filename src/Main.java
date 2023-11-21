import Tree.SearchTree;

public class Main {
    public static void main(String[] args) {
        SearchTree arvore = new SearchTree();

        arvore.add(7);
        arvore.add(5);
        arvore.add(12);
        arvore.add(2);
        arvore.add(6);
        arvore.add(9);
        arvore.add(21);
        arvore.add(19);
        arvore.add(25);

        arvore.displayPreOrder();
        arvore.displayInOrder();
        arvore.displayPostOrder();

        System.out.println(arvore.research(9));
        System.out.println(arvore.research(10));

        arvore.remove(9);

        System.out.println(arvore.research(9));
    }
}