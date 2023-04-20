import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true){
            System.out.println("=========================\nWelcome to the translator\n=========================");
            Scanner in = new Scanner(System.in);

            System.out.println("1) Traduccion con Splay Tree.");
            System.out.println("2) Traduccion con RBT.");
            System.out.println("3) Traduccion con BST.");

            String eject = in.nextLine();

            switch (eject){
                case "1":
                    System.out.println("Implementando Splay Tree...");
                    break;
                case "2":
                    System.out.println("Implementando RBT.");
                    break;
                case "3":
                    System.out.println("Implementando BST");
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