/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import mediaone.*;

import java.util.ArrayList;
import java.util.Comparator;

public class MovieManager {

    private ArrayList<Movie> movieList;
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

    public MovieManager() {
        this.movieList = new ArrayList<>();
    }

    public void addItem(int id, String name, int quantity, int price, int purchasePrice, int sold, ArrayList<String> actors, String director) {
        movieList.add(new Movie(id, name, quantity, price, purchasePrice, sold, actors, director));
    }

    // Xoa san pham theo ten
    public void delItem(String productName) {
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getName().equals(productName)) {
                movieList.remove(i);
            }
        }
    }

    // Tim cac phim theo ten (Cach tim giong nhu search ten Champ trong LoL)
    public ArrayList<Product> searchItem(String productName) {
        ArrayList<Product> searchList = new ArrayList<>();
        String str1 = productName.toUpperCase();
        for (int i = 0; i < movieList.size(); i++) {
            String strI = movieList.get(i).getName().toUpperCase();
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
            if (check) {
                searchList.add(movieList.get(i));
            }
        }
        return searchList;
    }

    // Tim cac sach theo ten dao dien
    public ArrayList<Movie> searchDirector(String directorName) {
        ArrayList<Movie> searchDirectorList = new ArrayList<>();
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getDirector().equals(directorName)) {
                searchDirectorList.add(movieList.get(i));
            }
        }
        return searchDirectorList;
    }

    // Tim cac sach theo ten dien vien
    public ArrayList<Movie> searchActor(String actorName) {
        ArrayList<Movie> searchActorList = new ArrayList<>();
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getActors().contains(actorName)) {
                searchActorList.add(movieList.get(i));
            }
        }
        return searchActorList;
    }

    // Sap xep
    public ArrayList<Movie> sortItem(int tieuChi) {
        ArrayList<Movie> orderedList = movieList;
        if (tieuChi == -1) {
            orderedList.sort(nameOrderDown);
        }
        if (tieuChi == 1) {
            orderedList.sort(nameOrderUp);
        }
        return orderedList;
    }
}
