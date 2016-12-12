/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import mediaone.*;

import java.util.ArrayList;
import java.util.Comparator;

public class BookManager {
    private ArrayList<Book> bookList;
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

    public BookManager() {
        this.bookList = new ArrayList<>();
    }

    public void addItem(int id, String name, int quantity, int price, int sold, String author, String publisher) {
        bookList.add(new Book(id, name, quantity, price, sold, author, publisher));
    }

    public void delItem(String bookName) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getName().equals(bookName)) {
                bookList.remove(i);
            }
        }
    }

    // Tim cac sach theo ten
    public ArrayList<Product> searchItem(String productName) {
        ArrayList<Product> searchList = new ArrayList<>();
        String str1 = productName.toUpperCase();
        for (int i = 0; i < bookList.size(); i++) {
            String strI = bookList.get(i).getName().toUpperCase();
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
            if (check)
                searchList.add(bookList.get(i));
        }
        return searchList;
    }

    // Tim cac sach theo ten tac gia
    public ArrayList<Book> searchAuthor(String authorName) {
        ArrayList<Book> searchAuthorList = new ArrayList<>();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getAuthor().equals(authorName)) {
                searchAuthorList.add(bookList.get(i));
            }
        }
        return searchAuthorList;
    }

    // Tim cac sach theo ten nha xuat ban
    public ArrayList<Book> searchPublisher(String publisherName) {
        ArrayList<Book> searchPublisherList = new ArrayList<>();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getPublisher().equals(publisherName)) {
                searchPublisherList.add(bookList.get(i));
            }
        }
        return searchPublisherList;
    }

    // Sap xep
    public ArrayList<Book> sortItem(int tieuChi) {
        ArrayList<Book> orderedList = bookList;
        if (tieuChi == -1)
            orderedList.sort(nameOrderDown);
        if (tieuChi == 1)
            orderedList.sort(nameOrderUp);
        return orderedList;
    }
}

