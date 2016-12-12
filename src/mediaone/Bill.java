/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaone;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public abstract class Bill implements Paided{

    private int id;
    private Date time;
    private String name;
    private int cost;
    private boolean paid = false;

    public Bill() {
        this.time = new Date();
    }

    public Bill(int id, Date time, String name, int cost, boolean paid) {
        this.id = id;
        this.time = time;
        this.name = name;
        this.cost = cost;
        this.paid = paid;
    }
    
    public Bill(String name, int cost) {
        this.time = new Date();
        this.name = name;
        this.cost = cost;
        this.paid = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    
}
