/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaone;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class GetPaidPerDay {
    
    HistoryGet historyGet;
    HistoryPaid historyPaid;
    Date time;
    
    public GetPaidPerDay() {
        historyGet = new HistoryGet();
        historyPaid = new HistoryPaid();
        time = new Date();
    }

    public GetPaidPerDay(HistoryGet historyGet, HistoryPaid historyPaid, Date time) {
        this.historyGet = historyGet;
        this.historyPaid = historyPaid;
        this.time = time;
    }

    public HistoryGet getHistoryGet() {
        return historyGet;
    }

    public void setHistoryGet(HistoryGet historyGet) {
        this.historyGet = historyGet;
    }

    public HistoryPaid getHistoryPaid() {
        return historyPaid;
    }

    public void setHistoryPaid(HistoryPaid historyPaid) {
        this.historyPaid = historyPaid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
