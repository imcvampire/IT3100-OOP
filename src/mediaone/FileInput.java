package mediaone;

import java.io.*;
import java.lang.*;
import java.util.*;
import com.opencsv.*;

public class FileInput {
    public static ArrayList<Product> getProductList() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("product.csv"));
        ArrayList<Product> productsList = new ArrayList<Product>();
        String[] nextLine;

        while ((nextLine = reader.readNext()) != null) {
            productsList.add(
                new Product((String) nextLine[0], Integer.parseInt(nextLine[1]), Integer.parseInt(nextLine[2]))
            );
        }

        return productsList;
    }

    public static Store getStoreData() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("store.csv"));
    }

    public static ArrayList<Employee> getEmployeeList() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("employees.csv"));
        ArrayList<Employee> employeesList = new ArrayList<Employee>();
        String[] nextLine;

        while ((nextLine = reader.readNext()) != null) {
            employeesList.add(
                new Employee()
            );
        }
    }

    public static void main() {
        System.out.println("cho");
    }
}
