/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaone;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class HistoryGetPaid {

    private ArrayList<GetPaidPerDay> history;

    public HistoryGetPaid() {
        this.history = new ArrayList<>();
    }

    public ArrayList<GetPaidPerDay> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<GetPaidPerDay> history) {
        this.history = history;
    }

    public int count() {
        return history.size();
    }

    public Date getLastUpdate() {
        return history.get(history.size() - 1).getTime();
    }

    public GetPaidPerDay getLastRecord() {
        return history.get(history.size() - 1);
    }
    
    // method return record between start and end
    public ArrayList<GetPaidPerDay> getRecordInTime(Date start, Date end) {
        ArrayList<GetPaidPerDay> result = new ArrayList<>();
        for (GetPaidPerDay historyItem : history) {
            if (historyItem.getTime().after(start) && historyItem.getTime().before(end)) {
                result.add(historyItem);
            }
        }
        return result;
    }
    
    // Lay phan tu thu i
    public GetPaidPerDay getRecord(int i) {
        return history.get(i);
    }
}
