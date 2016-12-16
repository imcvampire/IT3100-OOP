/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import java.util.ArrayList;
import java.util.Date;
import mediaone.Bill;
import mediaone.Employee;
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

        ArrayList<Paided> listPaided = historyPaid.getPaidHistory();

        for (int i = 0; i < listPaided.size(); i++) {
            if (listPaided.get(i) instanceof Employee) {
                Employee e = (Employee) listPaided.get(i);
                totalPaid += e.getSalary();
            } else if (listPaided.get(i) instanceof Bill) {
                Bill bill = (Bill) listPaided.get(i);
                totalPaid += bill.getCost();
            }
        }

        return totalPaid;
    }

}
