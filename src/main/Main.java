import tree.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        b.insereElemento(1);
        b.insereElemento(3);

        b.insereElemento(8);
        b.insereElemento(2);

        
        System.out.println(b.maximo());

        // System.out.println(b.emOrdem());
    }

}
