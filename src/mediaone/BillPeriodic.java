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
public class BillPeriodic extends Bill {

    private String periodic;

    public BillPeriodic() {
        super();
    }

    public BillPeriodic(int id, Date time, String name, int cost, boolean paid, String periodic) {
        super(id, time, name, cost, paid);
        this.periodic = periodic;
    }

    public BillPeriodic(String name, int cost, String periodic) {
        super(name, cost);
        this.periodic = periodic;
    }
    

    public String getPeriodic() {
        return periodic;
    }

    public void setPeriodic(String periodic) {
        this.periodic = periodic;
    }

}
