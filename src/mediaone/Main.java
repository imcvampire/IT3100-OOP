package mediaone;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Getting data ...");

        System.out.println("Getting products list ...");

        ArrayList<Product> productList;
        try {
            productList = FileInput.getProductsList();
        }
        catch (Exception e) {
            System.out.println(e);

            return;
        }

        System.out.println("Getting store ...");

        System.out.println("Getting employees list ...");

        System.out.println("Finish!");
    }

    public static void printMenu() {
        System.out.println("MediaOne Store");
        System.out.println("--------------");

        int index = 1;
        for (String s : Options) {
            System.out.println((index++) + ". " + s);
        }
    }

    public static int chooseOption() {
        System.out.println("Choose your option: ");

        return Integer.parseInt(System.console().readLine());
    }
}
