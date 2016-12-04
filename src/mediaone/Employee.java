/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaone;

/**
 *
 * @author Admin
 */
public class Employee {
    private int maNV;
    private String tenNV;
    private int luong;

    public Employee(int maNV,String tenNV,int luong){
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.luong = luong;
    }

    Employee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }
    
    
    public int getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public int getLuong() {
        return luong;
    }
    
}
