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
            switch(nextLine[0]) {
                case "movie": {
                    ArrayList<String> actors = new ArrayList<String>(Arrays.asList(nextLine[1].split("|")));

                    productsList.add(
                        new Movie(
                            actors,
                            nextLine[2],
                            nextLine[3],
                            Integer.parseInt(nextLine[4]),
                            Integer.parseInt(nextLine[5])
                        )
                    );

                    break;
                }

                case "music": {
                    productsList.add(
                        new Music(
                            nextLine[1],
                            Integer.parseInt(nextLine[2]),
                            Integer.parseInt(nextLine[3]),
                            nextLine[4],
                            nextLine[5]
                        )
                    );

                    break;
                }
            }
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
