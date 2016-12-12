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
public class HistoryPaid {
    
    private ArrayList<Paided> paidHistory;

    public HistoryPaid() {
        paidHistory = new ArrayList<>();
    }

    public HistoryPaid(ArrayList<Paided> paid) {
        this.paidHistory = paid;
    } 
    
    // Getter Setter
    public ArrayList<Paided> getPaidHistory() {
        return paidHistory;
    }

    public void setPaidHistory(ArrayList<Paided> paidHistory) {
        this.paidHistory = paidHistory;
    }
    // End Getter Setter
    
    /**
     * Add record to History
     * @param record 
     */
    public void addPaid(Paided record) {
        paidHistory.add(record);
    }
    

 
}
