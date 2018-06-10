package model;

import java.time.LocalDate;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Expense {
	private String ID;
	private LocalDate date;
	private final StringProperty type;
	private final StringProperty name;
	private final LongProperty expense;	
	private final StringProperty contend;	
	
	public Expense(String ID,LocalDate date,String type,String name,Long expense,String contend) {
		this.ID = ID;
		this.date = date;
		this.type = new SimpleStringProperty(type);
		this.name = new SimpleStringProperty(name);
		this.expense = new SimpleLongProperty(expense);
		this.contend = new SimpleStringProperty(contend);
	}
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
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
	public Long getExpense() {
		return expense.get();
	}
	public void setExpense(Long expense) {
		this.expense.set(expense);
	}
	public LongProperty getExpenseProperty() {
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
