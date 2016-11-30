/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaone;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Movie extends Product{
    ArrayList<String> actors;
    String director;

    public Movie(ArrayList<String> actors, String director, String name, int quantity, int price) {
        super(name, quantity, price);
        this.actors = actors;
        this.director = director;
    }

    public Movie(ArrayList<String> actors, String director, String name, int quantity, int price, int sold) {
        super(name, quantity, price, sold);
        this.actors = actors;
        this.director = director;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

}
