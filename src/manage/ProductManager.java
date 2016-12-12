/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import java.util.ArrayList;
import java.util.Comparator;
import mediaone.*;

public class ProductManager {
    private ArrayList<Product> productList;

    public ProductManager() {
        productList = new ArrayList<>();
    }

    private Comparator<Product> nameOrderDown = new Comparator<Product>() {

        @Override
        public int compare(Product o1, Product o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    private Comparator<Product> nameOrderUp = new Comparator<Product>() {

        @Override
        public int compare(Product o1, Product o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };

    public ArrayList<Book> selectBookList() {
        ArrayList<Book> bookList = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) instanceof Book) {
                bookList.add((Book) productList.get(i));
            }
        }
        return bookList;
    }

    public ArrayList<Music> selectMusicList() {
        ArrayList<Music> musicList = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) instanceof Music) {
                musicList.add((Music) productList.get(i));
            }
        }
        return musicList;
    }

    public ArrayList<Movie> selectMovieList() {
        ArrayList<Movie> movieList = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) instanceof Movie) {
                movieList.add((Movie) productList.get(i));
            }
        }
        return movieList;
    }

    public void addItem(Product e) {
        productList.add(e);
    }

    public ArrayList<Product> searchItem(String productName) {
        ArrayList<Product> searchList = new ArrayList<>();
        String str1 = productName.toUpperCase();
        for (int i = 0; i < productList.size(); i++) {
            String strI = productList.get(i).getName().toUpperCase();
            int mark = 0;
            boolean check = true;
            for (int j = 0; j < str1.length(); j++) {
                if ((strI.indexOf(str1.codePointAt(j), mark)) == -1) {
                    check = false;
                    break;
                } else {
                    mark = strI.indexOf(str1.codePointAt(j), mark) + 1;
                }
            }
            if (check)
                searchList.add(productList.get(i));
        }
        return searchList;
    }

    public ArrayList<Product> sortItem(int tieuChi) {
        ArrayList<Product> orderedList = productList;
        if (tieuChi == -1)
            orderedList.sort(nameOrderDown);
        if (tieuChi == 1)
            orderedList.sort(nameOrderUp);
        return orderedList;
    }

    public Product[] toArray() {
        Product[] pdArray = (Product[]) productList.toArray();
        return pdArray;
    }

}

