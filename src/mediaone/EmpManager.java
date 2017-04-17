package mediaone;

import java.util.ArrayList;
import java.util.Comparator;

public class EmpManager {

    private ArrayList<Employee> empList;
    //Khai bao 2 Comparator sap xep ho ten theo Ten truoc, Ho sau
    private Comparator<Employee> nameOrderDown = new Comparator<Employee>() {

        @Override
        public int compare(Employee o1, Employee o2) {
            String str1 = o1.getTenNV().trim();
            String str2 = o2.getTenNV().trim();
            String ten1 = str1.substring(str1.lastIndexOf(' '));
            String ten2 = str2.substring(str2.lastIndexOf(' '));
            if (ten1.equals(ten2)) {
                return str1.compareTo(str2);
            } else
                return ten1.compareTo(ten2);
        }

    };

    private Comparator<Employee> nameOrderUp = new Comparator<Employee>() {

        @Override
        public int compare(Employee o2, Employee o1) {
            String str1 = o1.getTenNV().trim();
            String str2 = o2.getTenNV().trim();
            String ten1 = str1.substring(str1.lastIndexOf(' '));
            String ten2 = str2.substring(str2.lastIndexOf(' '));
            if (ten1.equals(ten2)) {
                return str1.compareTo(str2);
            } else
                return ten1.compareTo(ten2);
        }

    };

    public EmpManager() {
        empList = new ArrayList<>();
    }

    public void addItems(int maNV, String tenNV, int luong) {
        empList.add(new Employee(maNV, tenNV, luong));
    }

    // Xoa nhan vien theo maNV
    public boolean delItem(int maNV) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getMaNV() == maNV) {
                empList.remove(i);
                // Giam ma nhan vien sau 1 don vi
                for (int j = i; j < empList.size(); i++) {
                    empList.get(i).setMaNV(empList.get(i).getMaNV() - 1);
                }
                return true;
            }
        }
        return false;
    }

    // Xoa nhan vien theo ten
    public boolean delItem(String tenNV) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getTenNV().equals(tenNV)) {
                empList.remove(i);
                // Giam ma nhan vien sau 1 don vi
                for (int j = i; j < empList.size(); i++) {
                    empList.get(i).setMaNV(empList.get(i).getMaNV() - 1);
                }
                return true;
            }
        }
        return false;
    }

    // Tim theo maNV, neu khong co tra ve null
    public Employee searchItem(int maNV) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getMaNV() == maNV) {
                return empList.get(i);
            }
        }
        return null;
    }

    // Tim theo tenNV, neu khong co tra ve ds null
    // ket qua tra ve giong tim ten Champ trong LoL
    public ArrayList<Employee> searchItem(String empName) {
        ArrayList<Employee> searchList = new ArrayList<>();
        String str1 = empName.toUpperCase();
        for (int i = 0; i < empList.size(); i++) {
            String strI = empList.get(i).getTenNV().toUpperCase();
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
                searchList.add(empList.get(i));
        }
        return searchList;
    }

    public ArrayList<Employee> sortItems(int tieuChi) {
        ArrayList<Employee> listSX = empList;
        if (tieuChi == -1)
            listSX.sort(nameOrderDown);
        if (tieuChi == 1)
            listSX.sort(nameOrderUp);
        return listSX;
    }

    public Employee[] toArray() {
        Employee[] empArray = (Employee[]) empList.toArray();
        return empArray;
    }

}
