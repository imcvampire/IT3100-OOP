/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import java.util.ArrayList;
import mediaone.*;

/**
 *
 * @author Administrator
 */
public class BillManager {
    
    ArrayList<Bill> billList;

    public BillManager(ArrayList<Bill> listBills) {
        billList = listBills;
    }

    public ArrayList<Bill> getBillList() {
        return billList;
    }

    public void setBillList(ArrayList<Bill> billList) {
        this.billList = billList;
    }
    
    public Bill findBillById(int id) {
        for (int i = 0; i < billList.size(); i++) {
            if (billList.get(i).getId() == id)
                return billList.get(i);
        }
        return null;
    }
    
    public void addBill(Bill bill) {
        int id = findLastId() + 1;
        bill.setId(id);
        billList.add(bill);
    }
    
    public int findLastId() {
        int max = 0;
        for (int i = 0; i < billList.size(); i++) {
            if (max < billList.get(i).getId()) {
                max = billList.get(i).getId();
            }
        }
        return max;
    }
}
