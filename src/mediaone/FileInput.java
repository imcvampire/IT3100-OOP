package mediaone;

import java.io.*;
import java.lang.*;
import java.util.*;
import com.opencsv.*;

public class FileInput {

    public static ArrayList<Product> getProductsList() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("products.csv"));
        ArrayList<Product> productsList = new ArrayList<>();
        String[] nextLine;

        while ((nextLine = reader.readNext()) != null) {
            switch (nextLine[0]) {
                case "movie": {
                    ArrayList<String> actors = new ArrayList<>(Arrays.asList(nextLine[1].split("|")));

//                    productsList.add(
//                            new Movie(
//                                    actors,
//                                    nextLine[2],
//                                    nextLine[3],
//                                    Integer.parseInt(nextLine[4]),
//                                    Integer.parseInt(nextLine[5])
//                            )
//                    );

                    break;
                }

                case "music": {
//                    productsList.add(
//                            new Music(
//                                    nextLine[1],
//                                    Integer.parseInt(nextLine[2]),
//                                    Integer.parseInt(nextLine[3]),
//                                    nextLine[4],
//                                    nextLine[5]
//                            )
//                    );

                    break;
                }
            }
        }

        return productsList;
    }

    public static Store getStoreData() throws IOException {
        Store store = new Store(0);
        CSVReader reader = new CSVReader(new FileReader("store.csv"));
        return store;
    }

    public static ArrayList<Employee> getEmployeeList() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("employees.csv"));
        ArrayList<Employee> employeesList = new ArrayList<>();
        String[] nextLine;

        while ((nextLine = reader.readNext()) != null) {
            employeesList.add(
                    new Employee()
            );
        }

        return employeesList;
    }
}
