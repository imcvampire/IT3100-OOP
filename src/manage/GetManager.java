/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import mediaone.HistoryGet;

/**
 *
 * @author Administrator
 */
public class GetManager {

    private HistoryGet historyGet;

    public GetManager(HistoryGet historyGet) {
        this.historyGet = historyGet;
    }
    
    public GetManager() {
        
    }

    // Getter Setter
    public HistoryGet getHistoryGet() {
        return historyGet;
    }

    public void setHistoryGet(HistoryGet historyGet) {
        this.historyGet = historyGet;
    }
    // End Getter Setter

    public int getTotalGet() {
        return historyGet.getTongDoanhThu();
    }
}
