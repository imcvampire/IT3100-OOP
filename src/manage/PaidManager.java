/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import java.util.Date;
import mediaone.HistoryGetPaid;
import mediaone.HistoryPaid;
import mediaone.Paided;

/**
 *
 * @author Administrator
 */
public class PaidManager {

    private HistoryPaid historyPaid;

    public PaidManager(HistoryPaid historyPaid) {
        this.historyPaid = historyPaid;
    }
    
    public PaidManager() {
        this.historyPaid = new HistoryPaid();
    }

    // Geter Setter
    public HistoryPaid getHistoryPaid() {
        return historyPaid;
    }

    public void setHistoryPaid(HistoryPaid historyPaid) {
        this.historyPaid = historyPaid;
    }
    // End Getter Setter

    public void addRecord(Paided paided) {
        historyPaid.addPaid(paided);
    }
    
    // Method calculate Doanh Thu
    public int getDoanhThu(Date start, Date end) {
        
        
        return 0;
        
    }

    public int getTotalPaid() {
        int totalPaid = 0;

        return totalPaid;
    }

}
