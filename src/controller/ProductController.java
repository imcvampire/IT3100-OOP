/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import mediaone.*;
import ui.*;

/**
 *
 * @author Administrator
 */
public class ProductController {

    private ArrayList<Product> dsSP = new ArrayList<>();

    public ProductController() {
    }

    public ArrayList<Product> getDsSP() {
        return dsSP;
    }

    public void setDsSP(ArrayList<Product> dsSP) {
        this.dsSP = dsSP;
    }

    public ArrayList<Product> search(String keyword) {
        ArrayList<Product> result = new ArrayList<>();

        return result;
    }

    public void create(JFrame parent) {
        new CreateNewProductFrame(parent, true, this).setVisible(true);
    }

    public void addBook(ArrayList<String> book, int id) {
        Book newRecord = new Book();
        newRecord.setId(id);
        newRecord.setName(book.get(0));
        newRecord.setAuthor(book.get(1));
        newRecord.setPublisher(book.get(2));
        newRecord.setQuantity(Integer.parseInt(book.get(3)));
        newRecord.setPrice(Integer.parseInt(book.get(4)));
        newRecord.setSold(Integer.parseInt(book.get(5)));

        dsSP.add(newRecord);
    }

    public void addMovie(ArrayList<String> movie, int id) {
        Movie newRecord = new Movie();
        newRecord.setId(id);
        newRecord.setName(movie.get(0));
        newRecord.setDirector(movie.get(1));
        ArrayList<String> actors = new ArrayList<>();
        String[] movieActors = movie.get(2).split(",");
        actors.addAll(Arrays.asList(movieActors));
        newRecord.setActors(actors);
        newRecord.setQuantity(Integer.parseInt(movie.get(3)));
        newRecord.setPrice(Integer.parseInt(movie.get(4)));
        newRecord.setSold(Integer.parseInt(movie.get(5)));

        dsSP.add(newRecord);
    }

    public void addMusic(ArrayList<String> music, int id) {
        Music newRecord = new Music();
        newRecord.setId(id);
        newRecord.setName(music.get(0));
        newRecord.setSinger(music.get(1));
        newRecord.setType(music.get(2));
        newRecord.setQuantity(Integer.parseInt(music.get(3)));
        newRecord.setPrice(Integer.parseInt(music.get(4)));
        newRecord.setSold(Integer.parseInt(music.get(5)));

        dsSP.add(newRecord);
    }

    public int getLastId() {
        int maxId = 0;
        for (int i = 0; i < dsSP.size(); i++) {
            if (dsSP.get(i).getId() > maxId) {
                maxId = dsSP.get(i).getId();
            }
        }
        return maxId;
    }

    public void edit(JFrame parent, String type) {
        new EditProductFrame(parent, true, type).setVisible(true);
    }

    public void update(ArrayList<String> data, int id, String updateType) {
        Product updateProduct = this.findById(id);

        updateProduct.setName(data.get(0));
        if (updateType.equals("All")) {
            updateProduct.setQuantity(Integer.parseInt(data.get(1)));
            updateProduct.setPrice(Integer.parseInt(data.get(2)));
            updateProduct.setSold(Integer.parseInt(data.get(3)));
        } else if (updateType.equals("Book")) {
            Book updateBook = (Book) updateProduct;
            updateBook.setAuthor(data.get(1));
            updateBook.setPublisher(data.get(2));
        } else if (updateType.equals("Movie")) {
            Movie updateMovie = (Movie) updateProduct;
            String[] actorString = data.get(1).split(",");
            ArrayList<String> actors = new ArrayList<>();
            actors.add(actorString[0]);
            updateMovie.setActors(actors);
            updateMovie.setDirector(data.get(2));
        } else if (updateType.equals("Music")) {
            Music updateMusic = (Music) updateProduct;
            updateMusic.setSinger(data.get(1));
            updateMusic.setType(data.get(2));
            updateMusic.setYear(Integer.parseInt(data.get(3)));
            updateMusic.setQuantity(Integer.parseInt(data.get(4)));
            updateMusic.setPrice(Integer.parseInt(data.get(5)));
            updateMusic.setSold(Integer.parseInt(data.get(6)));
        }

        if (!updateType.equals("All") && !updateType.equals("Music")) {
            updateProduct.setQuantity(Integer.parseInt(data.get(3)));
            updateProduct.setPrice(Integer.parseInt(data.get(4)));
            updateProduct.setSold(Integer.parseInt(data.get(5)));
        }
    }

    private Product findById(int id) {
        for (int i = 0; i < dsSP.size(); i++) {
            if (dsSP.get(i).getId() == id) {
                return dsSP.get(i);
            }
        }

        return null;
    }

    public void deleteProduct(int id) {
        dsSP.remove(findPositionById(id));
    }

    private int findPositionById(int id) {
        int position = 0;

        for (int i = 0; i < dsSP.size(); i++) {
            if (dsSP.get(i).getId() == id) {
                position = i;
                break;
            }
        }

        return position;
    }
}
