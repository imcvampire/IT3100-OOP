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
public class Music extends Product{

    private String singer;
    private String type;
    private int year;

    public Music (String name, int quantity, int price, String singer, String type) {
        super(name, quantity, price);
        this.singer = singer;
        this.type = type;
    }

    public Music(String singer, String type, int year, String name, int quantity, int price, int sold) {
        super(name, quantity, price, sold);
        this.singer = singer;
        this.type = type;
        this.year = year;
    }

    public String getSinger() {
        return singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}
