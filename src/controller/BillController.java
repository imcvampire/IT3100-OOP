/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import manage.*;
import mediaone.*;
import ui.BillManagementFrame;
import ui.CreateBillFrame;

/**
 *
 * @author Administrator
 */
public class BillController {

    private EmpManager empManager;
    private BillManager billManager;
    private Store store;
    private BillManagementFrame billManagementFrame;
    private GetPaidManager getPaidManager;

    public BillController(Store store, BillManagementFrame billManagementFrame) {
        this.store = store;
        empManager = new EmpManager(store.getDsNV());
        billManager = new BillManager(store.getDsTT());
        this.billManagementFrame = billManagementFrame;
        this.getPaidManager = new GetPaidManager(store);
    }

    /**
     * Getter Setter
     * @return 
     */
    public Store getStore() {
        return store;
    }

    public BillManagementFrame getBillManagementFrame() {
        return billManagementFrame;
    }

    public GetPaidManager getGetPaidManager() {
        return getPaidManager;
    }

    public EmpManager getEmpManager() {
        return empManager;
    }

    public void setEmpManager(EmpManager empManager) {
        this.empManager = empManager;
    }

    public BillManager getBillManager() {
        return billManager;
    }

    public void setBillManager(BillManager billManager) {
        this.billManager = billManager;
    }
    
    // End Getter Setter

    // Pay Salary for employee
    // @param employee id
    public void paySalary(int id) {
        Employee e = empManager.findByMaNV(id);
        getPaidManager.paySalary(e);
    }

    /**
     * Pay Bill by Bill Id
     * @param id 
     */
    public void payBill(int id) {
        Bill b = billManager.findBillById(id);
        getPaidManager.payBill(b);
    }

    /**
     * View form Create Bill
     * @param parent 
     */
    public void viewCreateBill(JFrame parent) {
        new CreateBillFrame(parent, true, this).setVisible(true);
    }

    /**
     * Add Bill
     * @param data
     * @param type 
     */
    public void addBill(ArrayList<String> data, String type) {
        if (type.equals("OneTime")) {
            billManager.addBill(makeNewRecordBillOneTime(data));
        } else {
            billManager.addBill(makeNewRecordBillPeriodic(data));
        }
        billManagementFrame.refresh(store.getDsNV(), store.getDsTT());
    }
    
    public BillPeriodic makeNewRecordBillPeriodic(ArrayList<String> data) {
        BillPeriodic bill = new BillPeriodic();
        bill.setName(data.get(0));
        bill.setCost(Integer.parseInt(data.get(1)));
        bill.setPeriodic(data.get(2));
        return bill;
    }

    public BillOneTime makeNewRecordBillOneTime(ArrayList<String> data) {
        BillOneTime bill = new BillOneTime();
        bill.setName(data.get(0));
        bill.setCost(Integer.parseInt(data.get(1)));
        bill.setDescription(data.get(2));
        bill.setTenDVThu(data.get(3));
        return bill;
    }
}
