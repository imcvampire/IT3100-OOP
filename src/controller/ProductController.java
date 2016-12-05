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
    
    public void addBook(ArrayList<String> book) {
        Book newRecord = new Book();
        newRecord.setName(book.get(0));
        newRecord.setAuthor(book.get(1));
        newRecord.setPublisher(book.get(2));
        newRecord.setQuantity(Integer.parseInt(book.get(3)));
        newRecord.setPrice(Integer.parseInt(book.get(4)));
        newRecord.setSold(Integer.parseInt(book.get(5)));
        
        dsSP.add(newRecord);
    }
    
    public void addMovie(ArrayList<String> movie) {
        Movie newRecord = new Movie();
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
    
    public void addMusic(ArrayList<String> music) {
        Music newRecord = new Music();
        newRecord.setName(music.get(0));
        newRecord.setSinger(music.get(1));
        newRecord.setType(music.get(2));
        newRecord.setQuantity(Integer.parseInt(music.get(3)));
        newRecord.setPrice(Integer.parseInt(music.get(4)));
        newRecord.setSold(Integer.parseInt(music.get(5)));
        
        dsSP.add(newRecord);        
    }
}
