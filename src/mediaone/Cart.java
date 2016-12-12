/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaone;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class Cart implements Get {

    private ArrayList<CartItem> listItems;
    private int total;

    public Cart() {
        this.listItems = new ArrayList<>();
        this.total = 0;
    }

    public ArrayList<CartItem> getListItems() {
        return listItems;
    }

    public void setListItems(ArrayList<CartItem> listItems) {
        this.listItems = listItems;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * Add new CartItem to Cart
     * @param item
     * @param maxQuantity 
     */
    public void addProduct(CartItem item, int maxQuantity) {
        for (int i = 0; i < listItems.size(); i++) {
            if (listItems.get(i).getItem().getId() == item.getItem().getId()) {
                if (listItems.get(i).getQuantity() < maxQuantity) {
                    listItems.get(i).increaseQuantity();
                    updateTotal();
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Out of stock !");
                    return;
                }
            }
        }
        listItems.add(item);
        updateTotal();
    }

    public void removeProduct(int id) {
        listItems.remove(findPositionById(id));
    }

    private int findPositionById(int id) {
        int position = 0;

        for (int i = 0; i < listItems.size(); i++) {
            if (listItems.get(i).getItem().getId() == id) {
                position = i;
                break;
            }
        }

        return position;
    }

    private CartItem findItemById(int id) {
        for (int i = 0; i < listItems.size(); i++) {
            if (listItems.get(i).getItem().getId() == id) {
                return listItems.get(i);
            }

        }
        return null;
    }

    private void removeItem(int id) {
        CartItem item = findItemById(id);
        if (item != null) {
            listItems.remove(item);

        }
    }

    private void updateItem(int id, int quantity) {
        CartItem item = findItemById(id);
        if (item != null) {
            item.setQuantity(quantity);
        }
    }

    /**
     * Update Cart if (quantity = 0) remove Item
     * else update Item
     * @param id
     * @param quantity 
     */
    public void updateCart(int id, int quantity) {
        if (quantity == 0) {
            removeItem(id);
            updateTotal();
            return;
        }
        updateItem(id, quantity);
        updateTotal();
    }

    /**
     * Destroy Cart
     */
    public void destroy() {
        listItems.clear();
        this.total = 0;
    }

    public void updateTotal() {
        this.total = 0;
        for (int i = 0; i < listItems.size(); i++) {
            this.total += listItems.get(i).getSubTotal();
        }
    }

}
