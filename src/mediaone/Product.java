/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaone;

/**
 *
 * @author Administrator
 */
public abstract class Product implements Paided, Get {

    protected int id;
    protected String name;
    protected int quantity;
    protected int purchasePrice;
    protected int price;
    protected int sold;

    public Product() {
        
    }

    public Product(int id, String name, int quantity, int purchasePrice, int price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
        this.price = price;
    }

    public Product(int id, String name, int quantity, int purchasePrice, int price, int sold) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
        this.price = price;
        this.sold = sold;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void decreaseQuantity(int number) {
        this.quantity -= number;
    }

    public void increaseQuantity(int number) {
        this.quantity += number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }
    
    public void increaseSold(int number) {
        this.sold += number;
    }
}
