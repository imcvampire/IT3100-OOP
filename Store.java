package Manage;

import java.lang.invoke.SerializedLambda;
import java.util.ArrayList;
import java.util.Iterator;

public class Store {
	private int monthlyCost;
	private ArrayList<Employee> dsNV = new ArrayList(); 
	private ArrayList<Product> dsSP = new ArrayList();
	private ArrayList<Bill> dsTT = new ArrayList(); 
	
	public Store(int money){
		this.monthlyCost = money;
	}
	
	public void addEmployee(String ten,int salary){
		Employee employee = new Employee();
		employee.setSalary = salary;
		employee.setName = ten;
		dsNV.add(employee);
	}
	
	public void addBill(Bill bill){
		bill = new Bill();
		dsTT.add(bill);
	}
	
	public int getRevenue(){
		Iterator product = dsSP.iterator();
		int revenue=0;
		int sellMoney=0;
		for(int i=0;i<dsSP.size();i++){
			sellMoney = dsSP.get(i).price* + dsSP.get(i).sold;
		}
		revenue = sellMoney - this.monthlyCost;
		return revenue;
	}
	
	public void addProduct(Product product){
		dsSP.add(product);
	}
}
