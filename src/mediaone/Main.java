package mediaone;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ui.HomeFrame;

public class Main {

    public static void main(String[] args) {
        System.out.println("Getting data ...");

        System.out.println("Getting products list ...");

        ArrayList<Product> productList = new ArrayList<>();
//        try {
//            productList = FileInput.getProductsList();
//        } catch (Exception e) {
//            System.out.println(e);
//
//            return;
//        }

        System.out.println("Getting store ...");

        System.out.println("Getting employees list ...");

        System.out.println("Finish!");

        Music music1 = new Music(1, "Quoc Ca", 10, 80, 100, "Nam Cao", "Quoc Te", 1945);

        ArrayList<String> actors = new ArrayList<>();
        actors.add("Johnny Deep");
        Movie movie1 = new Movie(2, "Caribe", 10, 70, 100, 0, actors, "David Scoth");

        Book book1 = new Book(3, "Harry Potter", 20, 30, 40, 1, "J.K.Rowling", "Ly Lan");

        Employee tester = new Employee(1, "Pia", 100);
//        Bill bill = new Bill();
        BillOneTime bill1 = new BillOneTime(1, new Date(), "Quỹ doanh nghiệp", 100, false, "For Party", "Hội Doanh Nghiệp");
        BillPeriodic bill2 = new BillPeriodic(2, new Date(), "Hóa đơn tiền điện", 1000000, false, "1 Tháng 1 lần");
        
        // Init Store and add component
        Store store = new Store(100, 2000);
        store.addProduct(music1);
        store.addProduct(movie1);
        store.addProduct(book1);
        store.addEmployee(tester);
        store.addBill(bill1);
        store.addBill(bill2);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                new HomeFrame(store).setVisible(true);
            }
        });
    }

    public static void printMenu() {
        System.out.println("MediaOne Store");
        System.out.println("--------------");

        String[] Options = {"1", "2"};

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
