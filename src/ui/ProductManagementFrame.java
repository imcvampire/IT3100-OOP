/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mediaone.*;
import controller.*;
import ui.presenter.ProductTableModel;

/**
 *
 * @author Administrator
 */
public class ProductManagementFrame extends javax.swing.JFrame {

    private DefaultTableModel tblAllProductModel, tblBookModel, tblMovieModel, tblMusicModel;
    private ArrayList<Product> dsSP = new ArrayList();
    private ProductController productController = new ProductController();

    /**
     * Creates new form ProductManagementFrame
     *
     * @param dsSP
     */
    public ProductManagementFrame(ArrayList<Product> dsSP) {
        initComponents();
        this.dsSP = dsSP;
        this.productController.setDsSP(dsSP);
        loadData(dsSP);
    }

    private void loadData(ArrayList<Product> dsSP) {

        this.initTableModel();
        this.loadColumnName();

        for (int i = 0; i < this.dsSP.size(); i++) {
            if (dsSP.get(i) instanceof Book) {
                this.loadBook((Book) dsSP.get(i));
            } else if (dsSP.get(i) instanceof Movie) {
                this.loadMovie((Movie) dsSP.get(i));
            } else if (dsSP.get(i) instanceof Music) {
                this.loadMusic((Music) dsSP.get(i));
            }
            this.loadProduct(this.dsSP.get(i));
        }

        setModel();
        setReorder();
    }

    private void setModel() {
        tblBook.setModel(tblBookModel);
        tblMovie.setModel(tblMovieModel);
        tblMusic.setModel(tblMusicModel);
        tblAll.setModel(tblAllProductModel);
    }

    private void setReorder() {
        tblAll.getTableHeader().setReorderingAllowed(false);
        tblBook.getTableHeader().setReorderingAllowed(false);
        tblMovie.getTableHeader().setReorderingAllowed(false);
        tblMusic.getTableHeader().setReorderingAllowed(false);
    }

    private void initTableModel() {
        this.tblAllProductModel = new ProductTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0 && column != 2;
            }
        };
        this.tblBookModel = new ProductTableModel();
        this.tblMovieModel = new ProductTableModel();
        this.tblMusicModel = new ProductTableModel();
    }

    private void loadColumnName() {
        String[] columnAll = {"id", "Name", "Type", "Quantity", "Purchase Price", "Price", "Sold"};
        this.tblAllProductModel.setColumnIdentifiers(columnAll);

        String[] columnBook = {"id", "Name", "Author", "Publisher", "Quantity", "Purchase Price", "Price", "Sold"};
        this.tblBookModel.setColumnIdentifiers(columnBook);

        String[] columnMovie = {"id", "Name", "Director", "Actors", "Quantity", "Purchase Price", "Price", "Sold"};
        this.tblMovieModel.setColumnIdentifiers(columnMovie);

        String[] columnMusic = {"id", "Name", "Singer", "Type", "Year", "Quantity", "Purchase Price", "Price", "Sold"};
        this.tblMusicModel.setColumnIdentifiers(columnMusic);
    }

    private void loadProduct(Product product) {
        ArrayList<String> row = new ArrayList<>();

        row.add(Integer.toString(product.getId()));
        row.add(product.getName());
        if (product instanceof Book) {
            row.add("Book");
        } else if (product instanceof Movie) {
            row.add("Movie");
        } else {
            row.add("Music");
        }
        row.add(Integer.toString(product.getQuantity()));
        row.add(Integer.toString(product.getPurchasePrice()));
        row.add(Integer.toString(product.getPrice()));
        row.add(Integer.toString(product.getSold()));

        tblAllProductModel.addRow(row.toArray());
    }

    private void loadBook(Book book) {
        ArrayList<String> row = new ArrayList<>();

        row.add(Integer.toString(book.getId()));
        row.add(book.getName());
        row.add(book.getAuthor());
        row.add(book.getPublisher());
        row.add(Integer.toString(book.getQuantity()));
        row.add(Integer.toString(book.getPurchasePrice()));
        row.add(Integer.toString(book.getPrice()));
        row.add(Integer.toString(book.getSold()));

        tblBookModel.addRow(row.toArray());
    }

    private void loadMovie(Movie movie) {
        ArrayList<String> row = new ArrayList<>();

        row.add(Integer.toString(movie.getId()));
        row.add(movie.getName());
        row.add(movie.getDirector());
        row.add(movie.getActors().toString());
        row.add(Integer.toString(movie.getQuantity()));
        row.add(Integer.toString(movie.getPurchasePrice()));
        row.add(Integer.toString(movie.getPrice()));
        row.add(Integer.toString(movie.getSold()));

        tblMovieModel.addRow(row.toArray());
    }

    private void loadMusic(Music music) {
        ArrayList<String> row = new ArrayList<>();

        row.add(Integer.toString(music.getId()));
        row.add(music.getName());
        row.add(music.getSinger());
        row.add(music.getType());
        row.add(Integer.toString(music.getYear()));
        row.add(Integer.toString(music.getQuantity()));
        row.add(Integer.toString(music.getPurchasePrice()));
        row.add(Integer.toString(music.getPrice()));
        row.add(Integer.toString(music.getSold()));

        tblMusicModel.addRow(row.toArray());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        allTable = new javax.swing.JTabbedPane();
        tabAll = new javax.swing.JScrollPane();
        tblAll = new javax.swing.JTable();
        tabBook = new javax.swing.JScrollPane();
        tblBook = new javax.swing.JTable();
        tabMovie = new javax.swing.JScrollPane();
        tblMovie = new javax.swing.JTable();
        tabMusic = new javax.swing.JScrollPane();
        tblMusic = new javax.swing.JTable();
        btnCreate = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        tfSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbSearchType = new javax.swing.JComboBox<>();
        cbSearchAttr = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        btnRefresh = new javax.swing.JToggleButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Product Management");
        setLocation(new java.awt.Point(300, 200));

        tblAll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAllMouseClicked(evt);
            }
        });
        tabAll.setViewportView(tblAll);

        allTable.addTab("All Product", tabAll);

        tblBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabBook.setViewportView(tblBook);

        allTable.addTab("Book", tabBook);

        tblMovie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabMovie.setViewportView(tblMovie);

        allTable.addTab("Movie", tabMovie);

        tblMusic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabMusic.setViewportView(tblMusic);

        allTable.addTab("Music", tabMusic);

        btnCreate.setText("Creat New");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnSearch.setText("Tìm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel1.setText("Tìm Kiếm");

        cbSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Book", "Movie", "Music" }));

        cbSearchAttr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Sắp xếp theo");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(allTable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbSearchAttr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClose)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(allTable, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearch)
                            .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSearchAttr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClose)
                            .addComponent(btnCreate)
                            .addComponent(btnEdit)
                            .addComponent(btnDelete))
                        .addGap(26, 26, 26))))
        );

        allTable.getAccessibleContext().setAccessibleName("Product");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        this.productController.create(this);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (!validateForm()) {
            JOptionPane.showMessageDialog(null, "Please type the search key ..");
            return;
        }

        loadData(this.productController.search(tfSearch.getText()));
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        loadData(dsSP);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int[] rowsTable = getRowsTable();

        int id = 0;
        int rowSelect = 0;
        String tableType = "";

        if (rowsTable[0] != -1) {
            id = Integer.parseInt(tblAll.getValueAt(rowsTable[0], 0).toString());
            tableType = "All";
            rowSelect = rowsTable[0];
        } else if (rowsTable[1] != -1) {
            id = Integer.parseInt(tblBook.getValueAt(rowsTable[1], 0).toString());
            tableType = "Book";
            rowSelect = rowsTable[1];
        } else if (rowsTable[2] != -1) {
            id = Integer.parseInt(tblMovie.getValueAt(rowsTable[2], 0).toString());
            tableType = "Movie";
            rowSelect = rowsTable[2];
        } else if (rowsTable[3] != -1) {
            id = Integer.parseInt(tblMusic.getValueAt(rowsTable[3], 0).toString());
            tableType = "Music";
            rowSelect = rowsTable[3];
        }

        if (id == 0) {
            return;
        }
        this.productController.update(this.getData(tableType, rowSelect), id, tableType);

        loadData(dsSP);
    }//GEN-LAST:event_btnEditActionPerformed

    private int[] getRowsTable() {
        return new int[]{tblAll.getSelectedRow(), tblBook.getSelectedRow(), tblMovie.getSelectedRow(), tblMusic.getSelectedRow()};
    }

    private ArrayList<String> getData(String type, int row) {
        ArrayList<String> data = new ArrayList<>();

        if (type.equals("All")) {
            data.add(tblAll.getValueAt(row, 1).toString());
            data.add(tblAll.getValueAt(row, 3).toString());
            data.add(tblAll.getValueAt(row, 4).toString());
            data.add(tblAll.getValueAt(row, 5).toString());
            data.add(tblAll.getValueAt(row, 6).toString());
        } else if (type.equals("Book")) {
            data.add(tblBook.getValueAt(row, 1).toString());
            data.add(tblBook.getValueAt(row, 2).toString());
            data.add(tblBook.getValueAt(row, 3).toString());
            data.add(tblBook.getValueAt(row, 4).toString());
            data.add(tblBook.getValueAt(row, 5).toString());
            data.add(tblBook.getValueAt(row, 6).toString());
            data.add(tblBook.getValueAt(row, 7).toString());
        } else if (type.equals("Movie")) {
            data.add(tblMovie.getValueAt(row, 1).toString());
            data.add(tblMovie.getValueAt(row, 2).toString());
            data.add(tblMovie.getValueAt(row, 3).toString());
            data.add(tblMovie.getValueAt(row, 4).toString());
            data.add(tblMovie.getValueAt(row, 5).toString());
            data.add(tblMovie.getValueAt(row, 6).toString());
            data.add(tblMovie.getValueAt(row, 7).toString());
        } else if (type.equals("Music")) {
            data.add(tblMusic.getValueAt(row, 1).toString());
            data.add(tblMusic.getValueAt(row, 2).toString());
            data.add(tblMusic.getValueAt(row, 3).toString());
            data.add(tblMusic.getValueAt(row, 4).toString());
            data.add(tblMusic.getValueAt(row, 5).toString());
            data.add(tblMusic.getValueAt(row, 6).toString());
            data.add(tblMusic.getValueAt(row, 7).toString());
            data.add(tblMusic.getValueAt(row, 8).toString());
        }

        return data;
    }

    private void tblAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAllMouseClicked

    }//GEN-LAST:event_tblAllMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int[] rowsTable = getRowsTable();
        int id = getIdDelete(rowsTable);

        this.productController.deleteProduct(id);
        loadData(dsSP);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private int getIdDelete(int[] rowsTable) {
        int deleteIndex = 0;
        int deleteId = 0;

        for (int i = 0; i < rowsTable.length; i++) {
            if (rowsTable[i] != -1) {
                deleteIndex = i;
                break;
            }
        }

        switch (deleteIndex) {
            case 0:
                deleteId = Integer.parseInt(tblAll.getValueAt(rowsTable[0], 0).toString());
                break;
            case 1:
                deleteId = Integer.parseInt(tblBook.getValueAt(rowsTable[0], 0).toString());
                break;
            case 2:
                deleteId = Integer.parseInt(tblMovie.getValueAt(rowsTable[0], 0).toString());
                break;
            default:
                deleteId = Integer.parseInt(tblMusic.getValueAt(rowsTable[0], 0).toString());
                break;
        }
        return deleteId;
    }

    private boolean validateForm() {
        String stSearch = tfSearch.getText();
        return !stSearch.isEmpty();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane allTable;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JToggleButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbSearchAttr;
    private javax.swing.JComboBox<String> cbSearchType;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane tabAll;
    private javax.swing.JScrollPane tabBook;
    private javax.swing.JScrollPane tabMovie;
    private javax.swing.JScrollPane tabMusic;
    private javax.swing.JTable tblAll;
    private javax.swing.JTable tblBook;
    private javax.swing.JTable tblMovie;
    private javax.swing.JTable tblMusic;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
