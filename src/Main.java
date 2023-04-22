import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> dic = Reader.readFile("src/Spanish.txt");

        while(true){
            System.out.println("=========================\nWelcome to the translator\n=========================");
            Scanner in = new Scanner(System.in);

            System.out.println("1) Traduccion con Splay Tree.");
            System.out.println("2) Traduccion con RBT.");
            System.out.println("3) Traduccion con BST.");

            String eject = in.nextLine(); //Will set the implementation


            switch (eject){
                case "1":

                    System.out.println("Implementando Splay Tree...");
                    Tree st = TreeFactory.getTree("Splay Tree");
                    st.insert("hola", "hello");
                    System.out.println(st.getTranslation("hola"));
                    break;

                case "2":

                    System.out.println("Implementando RBT.");
                    Tree rbt = TreeFactory.getTree("RBT");
                    rbt.setNodes(dic);

                    break;

                case "3":

                    System.out.println("Implementando BST");
                    Tree bst = TreeFactory.getTree("BST");
                    bst.setNodes(dic);

                    break;

                case "4":

                    System.out.println("Gracias por usar el traductor!");
                    System.exit(0);

                default:
                    System.out.println("Opcion no disponible");
            }
        }
    }
}