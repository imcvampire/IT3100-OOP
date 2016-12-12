/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mediaone.*;
import ui.ListProductFrame;
import ui.SellingManagementFrame;

/**
 *
 * @author Administrator
 */
public class CartController {

    private Cart cart;
    private ArrayList<Product> dsSP;
    private SellingManagementFrame sellingManagementFrame;

    public CartController(ArrayList<Product> dsSP, SellingManagementFrame sellingManagementFrame) {
        createCart();
        this.dsSP = dsSP;
        this.sellingManagementFrame = sellingManagementFrame;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public ArrayList<Product> getDsSP() {
        return dsSP;
    }

    public void setDsSP(ArrayList<Product> dsSP) {
        this.dsSP = dsSP;
    }

    private void createCart() {
        this.cart = new Cart();
    }

    public void viewAddItemFrame(JFrame parent, ArrayList<Product> dsSP) {
        new ListProductFrame(parent, true, this).setVisible(true);
    }

    public void addProductById(int id) {
        Product product;

        if ((product = findProductById(id)) != null) {
            int maxQuantity = product.getQuantity();
            if (maxQuantity == 0) {
                JOptionPane.showMessageDialog(null, "Out of stock !");
                return;
            }
            cart.addProduct(new CartItem(product, 1), maxQuantity);
        }

        sellingManagementFrame.refresh(cart);
    }

    public Product findProductById(int id) {
        for (int i = 0; i < dsSP.size(); i++) {
            if (dsSP.get(i).getId() == id) {
                return dsSP.get(i);
            }
        }
        return null;
    }
    
    /**
     * Update CartItem on click row
     * @param id
     * @param quantity 
     */
    public void updateCartItem(int id, int quantity) {
        if (quantity < 0) {
            sellingManagementFrame.refresh(cart);
            return;
        }

        cart.updateCart(id, quantity);
        sellingManagementFrame.refresh(cart);
    }

    public void destroy() {
        cart.destroy();
        sellingManagementFrame.refresh(cart);
    }

    /**
     * Check out Cart
     */
    public void checkout() {
        JOptionPane.showMessageDialog(null, "Total cost is " + cart.getTotal());
        updateListProductAfterCheckout(cart.getListItems());
        destroy();
    }

    /**
     * Decrease product quantity in ListProduct
     * @param listItems 
     */
    public void updateListProductAfterCheckout(ArrayList<CartItem> listItems) {
        for (int i = 0; i < listItems.size(); i++) {
            Product product = findProductById(listItems.get(i).getItem().getId());
            product.decreaseQuantity(listItems.get(i).getQuantity());
            product.increaseSold(listItems.get(i).getQuantity());
        }
    }
}
