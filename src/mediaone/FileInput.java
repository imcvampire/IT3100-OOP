package mediaone;

import java.io.*;
import java.lang.*;
import java.util.*;

import com.opencsv.*;

public class FileInput {

    public static void getProductsList(Store store) throws IOException {
        CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream("products.csv")));
        String[] nextLine;

        while ((nextLine = reader.readNext()) != null) {
            switch (nextLine[0]) {
                case "movie": {
                    ArrayList<String> actors = new ArrayList<>(Arrays.asList(nextLine[6].split("|")));

                    Movie movie = new Movie(
                        Integer.parseInt(nextLine[1]),
                        nextLine[2],
                        Integer.parseInt(nextLine[3]),
                        Integer.parseInt(nextLine[4]),
                        Integer.parseInt(nextLine[5]),
                        actors,
                        nextLine[7]
                    );

                    store.addProduct(movie);

                    break;
                }

                case "music": {
                    Music music = new Music(
                        Integer.parseInt(nextLine[1]),
                        nextLine[2],
                        Integer.parseInt(nextLine[3]),
                        Integer.parseInt(nextLine[4]),
                        Integer.parseInt(nextLine[5]),
                        Integer.parseInt(nextLine[6]),
                        nextLine[7],
                        nextLine[8],
                        Integer.parseInt(nextLine[9])
                    );

                    store.addProduct(music);

                    break;
                }

                case "book": {
                    Book book = new Book(
                        Integer.parseInt(nextLine[1]),
                        nextLine[2],
                        Integer.parseInt(nextLine[3]),
                        Integer.parseInt(nextLine[4]),
                        Integer.parseInt(nextLine[5]),
                        Integer.parseInt(nextLine[6]),
                        nextLine[7],
                        nextLine[8]
                    );

                    store.addProduct(book);

                    break;
                }
            }
        }
    }

    public static void getEmployeeList(Store store) throws IOException {
        CSVReader reader = new CSVReader(new FileReader("employees.csv"));
        String[] nextLine;
        int index = 1;

        while ((nextLine = reader.readNext()) != null) {
            store.addEmployee(new Employee(
                index,
                nextLine[1],
                Integer.parseInt(nextLine[2])
            ));

            index++;
        }
    }
}
