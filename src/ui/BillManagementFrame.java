/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.BillController;
import java.util.ArrayList;
import java.util.Calendar;
import mediaone.*;
import ui.presenter.BillTableModel;
import ui.presenter.EmployeeTableModel;
import ui.presenter.ListProductTableModel;

/**
 *
 * @author Administrator
 */
public class BillManagementFrame extends javax.swing.JFrame {

    private EmployeeTableModel tblEmployeeTableModel;
    private BillTableModel tblBillOneTimeTableModel;
    private BillTableModel tblBillPeriodicTableModel;
    private BillController billController;

    /**
     * Creates new form CostManagementFrame
     *
     * @param dsNV
     * @param dsTT
     */
    public BillManagementFrame(Store store) {

        initComponents();
        billController = new BillController(store, this);

        setDefaultButton();

        // Init model, set column name, load Data
        initTableModel();
        loadCollumn();
        loadData(store.getDsNV(), store.getDsTT());

        // Set model and reorder for the table
        setModel();
        setReorder();
    }

    private void setDefaultButton() {
        btnAddBill.setVisible(false);
        btnPayBill.setVisible(false);
    }

    /**
     * Init Model for the Table
     */
    private void initTableModel() {
        tblEmployeeTableModel = new EmployeeTableModel();
        tblBillOneTimeTableModel = new BillTableModel();
        tblBillPeriodicTableModel = new BillTableModel();
    }

    /**
     * Set Model for the table
     */
    private void setModel() {
        tblEmployee.setModel(tblEmployeeTableModel);
        tblBillOneTime.setModel(tblBillOneTimeTableModel);
        tblBillPeriodic.setModel(tblBillPeriodicTableModel);
    }

    /**
     * Set reorder for the column in the table
     */
    private void setReorder() {
        tblEmployee.getTableHeader().setReorderingAllowed(false);
    }

    /**
     * Load Column Name for the table
     */
    private void loadCollumn() {
        String[] columnEmp = {"Mã Nhân Viên", "Họ Tên", "Lương", "Trả Lương"};
        tblEmployeeTableModel.setColumnIdentifiers(columnEmp);

        String[] columnBillPeriodic = {"ID", "Tên", "Giá", "Tháng", "Thanh Toán", "Thời gian thu định kỳ"};
        tblBillPeriodicTableModel.setColumnIdentifiers(columnBillPeriodic);

        String[] columnBillOneTime = {"ID", "Tên", "Giá", "Tháng", "Thanh Toán", "Mô tả", "Đơn vị thu"};
        tblBillOneTimeTableModel.setColumnIdentifiers(columnBillOneTime);
    }

    /**
     * Load Data into Table model
     */
    private void loadData(ArrayList<Employee> listEmployees, ArrayList<Bill> listBills) {
        loadDataTableEmployee(listEmployees);
        loadDataTableBill(listBills);
    }

    private void loadDataTableEmployee(ArrayList<Employee> listEmployees) {
        for (int i = 0; i < listEmployees.size(); i++) {
            Employee temp = listEmployees.get(i);
            addEmployeeToModel(temp);
        }
    }

    private void loadDataTableBill(ArrayList<Bill> listBills) {
        for (int i = 0; i < listBills.size(); i++) {
            if (listBills.get(i) instanceof BillOneTime) {
                addBillOneTime((BillOneTime) listBills.get(i));
            } else if (listBills.get(i) instanceof BillPeriodic) {
                addBillPeriodic((BillPeriodic) listBills.get(i));
            }

        }
    }

    /**
     * Function inside LoadData to add Product to Model
     *
     * @param product
     */
    private void addEmployeeToModel(Employee employee) {
        ArrayList<String> row = new ArrayList<>();

        row.add(Integer.toString(employee.getMaNV()));
        row.add(employee.getName());
        row.add(Integer.toString(employee.getSalary()));

        if (!employee.getHistorySalary().get(12)) {
            row.add("Chưa trả");
        } else {
            row.add("Đã trả");
        }

        tblEmployeeTableModel.addRow(row.toArray());
    }

    /**
     * Add Bill One Time to table Bill One Time
     */
    private void addBillOneTime(BillOneTime bill) {
        ArrayList<String> row = new ArrayList<>();

        row.add(Integer.toString(bill.getId()));
        row.add(bill.getName());
        row.add(Integer.toString(bill.getCost()));

        Calendar cal = Calendar.getInstance();
        cal.setTime(bill.getTime());

        row.add(Integer.toString(cal.get(Calendar.MONTH) + 1));

        if (bill.isPaid()) {
            row.add("Đã trả");
        } else {
            row.add("Chưa trả");
        }
        row.add(bill.getDescription());
        row.add(bill.getTenDVThu());

        tblBillOneTimeTableModel.addRow(row.toArray());
    }

    /**
     * Add bill periodic to table Bill Periodic
     *
     * @param bill
     */
    private void addBillPeriodic(BillPeriodic bill) {
        ArrayList<String> row = new ArrayList<>();

        row.add(Integer.toString(bill.getId()));
        row.add(bill.getName());
        row.add(Integer.toString(bill.getCost()));

        Calendar cal = Calendar.getInstance();
        cal.setTime(bill.getTime());

        row.add(Integer.toString(cal.get(Calendar.MONTH) + 1));

        if (bill.isPaid()) {
            row.add("Đã trả");
        } else {
            row.add("Chưa trả");
        }
        row.add(bill.getPeriodic());

        tblBillPeriodicTableModel.addRow(row.toArray());
    }

    public void refresh(ArrayList<Employee> listEmployees, ArrayList<Bill> listBills) {

        while (tblEmployeeTableModel.getRowCount() != 0) {
            tblEmployeeTableModel.removeRow(0);
        }
        while (tblBillOneTimeTableModel.getRowCount() != 0) {
            tblBillOneTimeTableModel.removeRow(0);
        }
        while (tblBillPeriodicTableModel.getRowCount() != 0) {
            tblBillPeriodicTableModel.removeRow(0);
        }
        loadCollumn();
        loadData(listEmployees, listBills);
        setModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabBill = new javax.swing.JTabbedPane();
        spEmployee = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        spBillPeriodic = new javax.swing.JScrollPane();
        tblBillPeriodic = new javax.swing.JTable();
        spBillOneTime = new javax.swing.JScrollPane();
        tblBillOneTime = new javax.swing.JTable();
        btnPaySalary = new javax.swing.JButton();
        btlCancel = new javax.swing.JButton();
        btnPayBill = new javax.swing.JButton();
        cbMonth = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnAddBill = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cost Management");
        setLocation(new java.awt.Point(400, 300));

        tabBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabBillMouseClicked(evt);
            }
        });

        spEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spEmployeeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                spEmployeeMouseEntered(evt);
            }
        });

        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblEmployeeMouseEntered(evt);
            }
        });
        spEmployee.setViewportView(tblEmployee);

        tabBill.addTab("Nhân viên", spEmployee);

        spBillPeriodic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spBillPeriodicMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                spBillPeriodicMouseEntered(evt);
            }
        });

        tblBillPeriodic.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBillPeriodic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblBillPeriodicMouseEntered(evt);
            }
        });
        spBillPeriodic.setViewportView(tblBillPeriodic);

        tabBill.addTab("Hóa đơn định kỳ", spBillPeriodic);

        spBillOneTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spBillOneTimeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                spBillOneTimeMouseEntered(evt);
            }
        });

        tblBillOneTime.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBillOneTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblBillOneTimeMouseEntered(evt);
            }
        });
        spBillOneTime.setViewportView(tblBillOneTime);

        tabBill.addTab("Hóa đơn một lần", spBillOneTime);

        btnPaySalary.setText("Trả lương");
        btnPaySalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaySalaryActionPerformed(evt);
            }
        });

        btlCancel.setText("Cancel");
        btlCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlCancelActionPerformed(evt);
            }
        });

        btnPayBill.setText("Thanh Toán");
        btnPayBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayBillActionPerformed(evt);
            }
        });

        cbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbMonth.setSelectedIndex(11);
        cbMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbMonthMouseClicked(evt);
            }
        });

        jLabel1.setText("Tháng :");

        btnAddBill.setText("Thêm Hóa đơn");
        btnAddBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(tabBill, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPaySalary)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddBill)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPayBill)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btlCancel)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(tabBill, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btlCancel)
                    .addComponent(btnPaySalary)
                    .addComponent(btnPayBill)
                    .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnAddBill))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPaySalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaySalaryActionPerformed
        int id = Integer.parseInt(tblEmployee.getValueAt(tblEmployee.getSelectedRow(), 0).toString());

        billController.paySalary(id);

        refresh(billController.getEmpManager().getEmpList(), billController.getBillManager().getBillList());
    }//GEN-LAST:event_btnPaySalaryActionPerformed

    private void btlCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlCancelActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btlCancelActionPerformed

    private void tabBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabBillMouseClicked

    }//GEN-LAST:event_tabBillMouseClicked

    private void spEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spEmployeeMouseClicked
        btnPaySalary.setVisible(true);
        btnPayBill.setVisible(false);
    }//GEN-LAST:event_spEmployeeMouseClicked

    private void spBillPeriodicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spBillPeriodicMouseClicked
        btnPaySalary.setVisible(false);
        btnPayBill.setVisible(true);
    }//GEN-LAST:event_spBillPeriodicMouseClicked

    private void spBillOneTimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spBillOneTimeMouseClicked
        btnPaySalary.setVisible(false);
        btnPayBill.setVisible(true);
    }//GEN-LAST:event_spBillOneTimeMouseClicked

    private void spEmployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spEmployeeMouseEntered
        btnPaySalary.setVisible(true);
        btnPayBill.setVisible(false);
    }//GEN-LAST:event_spEmployeeMouseEntered

    private void spBillPeriodicMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spBillPeriodicMouseEntered
        btnPaySalary.setVisible(false);
        btnPayBill.setVisible(true);
        btnAddBill.setVisible(true);
    }//GEN-LAST:event_spBillPeriodicMouseEntered

    private void spBillOneTimeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spBillOneTimeMouseEntered
        btnPaySalary.setVisible(false);
        btnPayBill.setVisible(true);
        btnAddBill.setVisible(true);
        btnAddBill.setVisible(true);
    }//GEN-LAST:event_spBillOneTimeMouseEntered

    private void tblEmployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeeMouseEntered
        btnPaySalary.setVisible(true);
        btnPayBill.setVisible(false);
        btnAddBill.setVisible(false);

    }//GEN-LAST:event_tblEmployeeMouseEntered

    private void tblBillPeriodicMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBillPeriodicMouseEntered
        btnPaySalary.setVisible(false);
        btnPayBill.setVisible(true);
        btnAddBill.setVisible(true);

    }//GEN-LAST:event_tblBillPeriodicMouseEntered

    private void tblBillOneTimeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBillOneTimeMouseEntered
        btnPaySalary.setVisible(false);
        btnPayBill.setVisible(true);
    }//GEN-LAST:event_tblBillOneTimeMouseEntered

    private void cbMonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbMonthMouseClicked


    }//GEN-LAST:event_cbMonthMouseClicked

    private void btnAddBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBillActionPerformed

        billController.viewCreateBill(this);

    }//GEN-LAST:event_btnAddBillActionPerformed

    private void btnPayBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayBillActionPerformed

        int selectedRow = tblBillOneTime.getSelectedRow();
        if (selectedRow != -1) {
            int id = Integer.parseInt(tblBillOneTime.getValueAt(selectedRow, 0).toString());
            billController.payBill(id);
        } else {
            selectedRow = tblBillPeriodic.getSelectedRow();
            if (selectedRow != -1) {
                int id = Integer.parseInt(tblBillPeriodic.getValueAt(selectedRow, 0).toString());
                billController.payBill(id);
            }
        }
        
        refresh(billController.getEmpManager().getEmpList(), billController.getBillManager().getBillList());

    }//GEN-LAST:event_btnPayBillActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btlCancel;
    private javax.swing.JButton btnAddBill;
    private javax.swing.JButton btnPayBill;
    private javax.swing.JButton btnPaySalary;
    private javax.swing.JComboBox<String> cbMonth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane spBillOneTime;
    private javax.swing.JScrollPane spBillPeriodic;
    private javax.swing.JScrollPane spEmployee;
    private javax.swing.JTabbedPane tabBill;
    private javax.swing.JTable tblBillOneTime;
    private javax.swing.JTable tblBillPeriodic;
    private javax.swing.JTable tblEmployee;
    // End of variables declaration//GEN-END:variables
}
