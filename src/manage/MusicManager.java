/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import mediaone.*;

import java.util.ArrayList;
import java.util.Comparator;

public class MusicManager {

    private ArrayList<Music> musicList;
    private Comparator<Product> nameOrderDown = new Comparator<Product>() {

        @Override
        public int compare(Product o1, Product o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    private Comparator<Product> nameOrderUp = new Comparator<Product>() {

        @Override
        public int compare(Product o1, Product o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };

    public MusicManager() {
        this.musicList = new ArrayList<>();
    }

    public void addItem(int id, String name, int quantity, int purchasePrice, int price, int sold, String singer, String type, int year) {
        musicList.add(new Music(id, name, quantity, purchasePrice, price, sold, singer, type, year));
    }

    public void delItem(String musicName) {
        for (int i = 0; i < musicList.size(); i++) {
            if (musicList.get(i).getName().equals(musicName)) {
                musicList.remove(i);
            }
        }
    }

    // Tim bai hat theo ten
    public ArrayList<Product> searchItem(String productName) {
        ArrayList<Product> searchList = new ArrayList<>();
        String str1 = productName.toUpperCase();
        for (int i = 0; i < musicList.size(); i++) {
            String strI = musicList.get(i).getName().toUpperCase();
            int mark = 0;
            boolean check = true;
            for (int j = 0; j < str1.length(); j++) {
                if ((strI.indexOf(str1.codePointAt(j), mark)) == -1) {
                    check = false;
                    break;
                } else {
                    mark = strI.indexOf(str1.codePointAt(j), mark) + 1;
                }
            }
            if (check) {
                searchList.add(musicList.get(i));
            }
        }
        return searchList;
    }

    // Tim bai hat theo the loai
    public ArrayList<Music> searhType(String type) {
        ArrayList<Music> searchTypeList = new ArrayList<>();
        for (int i = 0; i < musicList.size(); i++) {
            if (musicList.get(i).getType().equals(type)) {
                searchTypeList.add(musicList.get(i));
            }
        }
        return searchTypeList;
    }

    // Tim cac sach theo ca si
    public ArrayList<Music> searchSinger(String singerName) {
        ArrayList<Music> searchSingerList = new ArrayList<>();
        for (int i = 0; i < musicList.size(); i++) {
            if (musicList.get(i).getSinger().equals(singerName)) {
                searchSingerList.add(musicList.get(i));
            }
        }
        return searchSingerList;
    }

    // Sap xep
    public ArrayList<Music> sortItem(int tieuChi) {
        ArrayList<Music> orderedList = musicList;
        if (tieuChi == -1) {
            orderedList.sort(nameOrderDown);
        }
        if (tieuChi == 1) {
            orderedList.sort(nameOrderUp);
        }
        return orderedList;
    }
}
