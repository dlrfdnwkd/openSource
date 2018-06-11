package model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Expense {
	private String ID;
	private final ObjectProperty<LocalDate> date;
	private final StringProperty type;
	private final StringProperty name;
	private final IntegerProperty expense;	
	private final StringProperty contend;	
	
	public Expense(String ID,LocalDate date,String type,String name,int expense,String contend) {
		this.ID = ID;
		this.date = new SimpleObjectProperty<LocalDate>(date);
		this.type = new SimpleStringProperty(type);
		this.name = new SimpleStringProperty(name);
		this.expense = new SimpleIntegerProperty(expense);
		this.contend = new SimpleStringProperty(contend);
	}
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public LocalDate getDate() {
		return date.get();
	}
	public void setDate(LocalDate date) {
		this.date.set(date);
	}
	public ObjectProperty<LocalDate> getDateProperty(){
		return date;
	}
	public String getType() {
		return type.get();
	}
	public void setType(String type) {
		this.type.set(type);
	}
	public StringProperty getTypeProperty() {
		return type;
	}
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public StringProperty getNameProperty() {
		return name;
	}
	public int getExpense() {
		return expense.get();
	}
	public void setExpense(int expense) {
		this.expense.set(expense);
	}
	public IntegerProperty getExpenseProperty() {
		return expense;
	}
	public String getContend() {
		return contend.get();
	}
	public void setContend(String contend) {
		this.contend.set(contend);
	}
	public StringProperty getContendProperty() {
		return contend;
	}

}
