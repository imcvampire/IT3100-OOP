/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import manage.*;
import mediaone.*;
import ui.AnalysisManagementFrame;

/**
 *
 * @author Administrator
 */
public class AnalysisController {

    private Store store;
    private GetPaidManager getPaidManager;
    private AnalysisManagementFrame analysisManagementFrame;

    public AnalysisController(Store store, AnalysisManagementFrame analysisManagementFrame) {
        this.store = store;
        this.getPaidManager = new GetPaidManager(store);
        this.analysisManagementFrame = analysisManagementFrame;
    }

    // Getter Setter
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public GetPaidManager getGetPaidManager() {
        return getPaidManager;
    }

    public void setGetPaidManager(GetPaidManager getPaidManager) {
        this.getPaidManager = getPaidManager;
    }
    // End getter setter

    public void getInformation(String start, String end) throws ParseException {
        Date startDate = changeToDate(start);
        Date endDate = changeToDate(end);
        
        int DoanhThu = getPaidManager.getDoanhThu(startDate, endDate);
        
    }

    public Date changeToDate(String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        Date date = sdf.parse(str);
        return date;
    }

}
