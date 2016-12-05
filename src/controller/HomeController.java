/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import mediaone.*;
import ui.*;
/**
 *
 * @author Administrator
 */
public class HomeController {
    
    private Store store;

    public HomeController(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    
    public void viewProductManagement() {
        new ProductManagementFrame(store.getDsSP()).setVisible(true);
    }
    
    public void viewBillManagement() {
        new BillManagementFrame().setVisible(true);
    }
    
}
