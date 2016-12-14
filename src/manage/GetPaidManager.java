/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import mediaone.GetPaidPerDay;
import mediaone.*;

/**
 *
 * @author Administrator
 */
public class GetPaidManager {

    private Store store;
    private HistoryGetPaid historyGetPaid;
    private PaidManager paidManager;
    private GetManager getManager;

    public GetPaidManager(Store store) {
        this.store = store;
        this.historyGetPaid = store.getHistoryGetPaid();

        if (historyGetPaid.count() != 0) {
            this.paidManager = new PaidManager(historyGetPaid.getLastRecord().getHistoryPaid());
            this.getManager = new GetManager(historyGetPaid.getLastRecord().getHistoryGet());
        } else {
            this.paidManager = new PaidManager();
            this.getManager = new GetManager();
        }
    }

    public boolean checkOutOfDate() {
        if (historyGetPaid.getLastUpdate().before(new Date())) {
            return true;
        }
        return false;
    }

    public void makeNewRecord() {
        GetPaidPerDay temp = new GetPaidPerDay();
    }

    public void paySalary(Employee employee) {
        employee.paided(12);
        paidManager.addRecord(employee);
        store.decreaseFunds(employee.getSalary());
    }

    public void payBill(Bill bill) {
        bill.setPaid(true);
        paidManager.addRecord(bill);
        store.decreaseFunds(bill.getCost());
    }

    public int getDoanhThu(Date start, Date end) {
        int total = 0;

        // Take Record return if no record found
        HistoryGetPaid historyInTime = new HistoryGetPaid();
        historyInTime.setHistory(historyGetPaid.getRecordInTime(start, end));
        if (historyInTime.count() == 0) {
            return 0;
        }

        // loop and sum all total
        for (int i = 0; i < historyInTime.count(); i++) {
            GetPaidPerDay temp = historyInTime.getRecord(i);

            getManager.setHistoryGet(temp.getHistoryGet());

            total += getManager.getTotalGet();
        }

        return total;
    }

    public int getChiPhi(Date start, Date end) {
        int total = 0;

        // Take record return if no record found
        HistoryGetPaid historyInTime = new HistoryGetPaid();
        historyInTime.setHistory(historyGetPaid.getRecordInTime(start, end));
        if (historyInTime.count() == 0) {
            return 0;
        }

        // loop and sum all total
        for (int i = 0; i < historyInTime.count(); i++) {
            GetPaidPerDay temp = historyInTime.getRecord(i);

            paidManager.setHistoryPaid(temp.getHistoryPaid());

            total += paidManager.getTotalPaid();
        }

        return total;
    }

    public int getProfit(Date start, Date end) {
        return getDoanhThu(start, end) - getChiPhi(start, end);
    }

    public ArrayList<Get> listAllGet(Date start, Date end) {
        ArrayList<Get> result = new ArrayList<>();

        HistoryGetPaid historyInTime = new HistoryGetPaid();
        historyInTime.setHistory(historyGetPaid.getRecordInTime(start, end));
        if (historyInTime.count() == 0) {
            return result;
        }

        // loop and get all record
        for (int i = 0; i < historyInTime.count(); i++) {
            GetPaidPerDay temp = historyInTime.getRecord(i);

            ArrayList<Get> tempPerDay = temp.getHistoryGet().getGet();
            for (int j = 0; j < tempPerDay.size(); j++) {
                result.add(tempPerDay.get(j));
            }
        }

        return result;
    }

    public ArrayList<Paided> listAllPaided(Date start, Date end) {
        ArrayList<Paided> result = new ArrayList<>();

        //if doesn't get any record return
        HistoryGetPaid historyInTime = new HistoryGetPaid();
        historyInTime.setHistory(historyGetPaid.getRecordInTime(start, end));
        if (historyInTime.count() == 0) {
            return result;
        }

        // loop and get all record
        for (int i = 0; i < historyInTime.count(); i++) {
            GetPaidPerDay temp = historyInTime.getRecord(i);

            ArrayList<Paided> tempPerDay = temp.getHistoryPaid().getPaidHistory();
            for (int j = 0; j < tempPerDay.size(); j++) {
                result.add(tempPerDay.get(j));
            }
        }

        return result;
    }

    public void addHistoryRecordToResult(ArrayList<Get> gets) {

    }
}
