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
public class BillOneTime extends Bill {

    private String description;
    private String tenDVThu;

    public BillOneTime() {

    }

    public BillOneTime(int id, Date time, String name, int cost, boolean paid, String description, String tenDVThu) {
        super(id, time, name, cost, paid);
        this.description = description;
        this.tenDVThu = tenDVThu;
    }

    public BillOneTime(String name, int cost, String description, String tenDVThu) {
        super(name, cost);
        this.description = description;
        this.tenDVThu = tenDVThu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTenDVThu() {
        return tenDVThu;
    }

    public void setTenDVThu(String tenDVThu) {
        this.tenDVThu = tenDVThu;
    }

}
