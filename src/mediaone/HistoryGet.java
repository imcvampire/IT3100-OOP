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
public class HistoryGet {
    
    private ArrayList<Get> getHistory;
    
    // Constructor
    public HistoryGet() {
        getHistory = new ArrayList<>();
    }
    
    public HistoryGet(ArrayList<Get> get) {
        this.getHistory = get;
    }

    public ArrayList<Get> getGet() {
        return getHistory;
    }
    
    public void setGet(ArrayList<Get> get) {
        this.getHistory = get;
    }
    
    public void addGet(Get get) {
        getHistory.add(get);
    }

    public int count() {
        return getHistory.size();
    }
    
    public int getTongDoanhThu () {
        int total = 0;
        for (int i = 0; i < getHistory.size(); i++) {
            if (getHistory.get(i) instanceof Cart) {
                Cart cart = (Cart) getHistory.get(i);
                total += cart.getTotal();
            }
        }
        return total;
    }
}
