package model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Schedule {
	private String ID;
	private ObjectProperty<LocalDate> date;
	private final StringProperty name;
	private final StringProperty contend;
	public Schedule(String ID,LocalDate date,String name,String contend) {
		this.ID = ID;
		this.date = new SimpleObjectProperty<LocalDate>(date);
		this.name = new SimpleStringProperty(name);
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
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public StringProperty getNameProperty() {
		return name;
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
