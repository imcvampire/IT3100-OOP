/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaone;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class Employee implements Paided {

    private int maNV;

    private String name;
    private int salary;

    private Map<Integer, Boolean> historySalary = new HashMap<Integer, Boolean>();

    public Employee() {

    }

    public Employee(int maNV, String name, int salary) {
        this.maNV = maNV;
        this.name = name;
        this.salary = salary;
        setSimpleHistory();
    }

    /**
     * Set History get Salary simple
     */
    public void setSimpleHistory() {
        historySalary.put(1, true);
        historySalary.put(2, true);
        historySalary.put(3, true);
        historySalary.put(4, true);
        historySalary.put(5, true);
        historySalary.put(6, true);
        historySalary.put(7, true);
        historySalary.put(8, true);
        historySalary.put(9, true);
        historySalary.put(10, true);
        historySalary.put(11, true);
        historySalary.put(12, false);
    }
    
    public void paided(int month) {
        historySalary.replace(month, true);
    }

    public Map<Integer, Boolean> getHistorySalary() {
        return historySalary;
    }

    public void setHistorySalary(HashMap historySalary) {
        this.historySalary = historySalary;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
