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
public class CartItem {
    
    private Product item;
    private int quantity;
    private int subTotal;

    public CartItem(Product item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.subTotal = item.getPrice() * quantity;
    }

    public Product getItem() {
        return item;
    }

    public void setItem(Product item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        updateSubTotal();
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }
    
    public void updateSubTotal() {
        subTotal = quantity * item.getPrice();
    }
    
    public void increaseQuantity() {
        this.quantity ++;
        updateSubTotal();
    }
}
