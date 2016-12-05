/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaone;

/**
 *
 * @author Administrator
 */
import java.lang.invoke.SerializedLambda;
import java.util.ArrayList;
import java.util.Iterator;

public class Store {

    private int monthlyCost;
    private ArrayList<Employee> dsNV = new ArrayList();
    private ArrayList<Product> dsSP = new ArrayList();
    private ArrayList<Bill> dsTT = new ArrayList();

    // Constructor
    public Store(int money) {
        this.monthlyCost = money;
    }
    
    //Getter Setter

    public int getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(int monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public ArrayList<Employee> getDsNV() {
        return dsNV;
    }

    public void setDsNV(ArrayList<Employee> dsNV) {
        this.dsNV = dsNV;
    }

    public ArrayList<Product> getDsSP() {
        return dsSP;
    }

    public void setDsSP(ArrayList<Product> dsSP) {
        this.dsSP = dsSP;
    }

    public ArrayList<Bill> getDsTT() {
        return dsTT;
    }

    public void setDsTT(ArrayList<Bill> dsTT) {
        this.dsTT = dsTT;
    }

    public void addEmployee(String ten, int salary) {
        Employee employee = new Employee();
        employee.setSalary(salary);
        employee.setName(ten);
        dsNV.add(employee);
    }
    
    public void addEmployee(Employee employee) {
        dsNV.add(employee);
    }

    public void addBill(Bill bill) {
        dsTT.add(bill);
    }

    public int getRevenue() {
        Iterator product = dsSP.iterator();
        int revenue = 0;
        int sellMoney = 0;
        for (int i = 0; i < dsSP.size(); i++) {
            sellMoney = dsSP.get(i).price * +dsSP.get(i).sold;
        }
        revenue = sellMoney - this.monthlyCost;
        return revenue;
    }

    public void addProduct(Product product) {
        dsSP.add(product);
    }
}
