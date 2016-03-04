package com.haut.grain.pojo;

public class BaseBean {
private int id;
private int year;
private String description;
private float amount;
private String area;
private String table;
public void setTable(String table) {
	this.table = table;
}
public String getTable() {
	return table;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public float getAmount() {
	return amount;
}
public void setAmount(float amount) {
	this.amount = amount;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
@Override
public String toString() {
	return "BaseBean [id=" + id + ", year=" + year + ", description="
			+ description + ", amount=" + amount + ", area=" + area
			+ ", table=" + table + "]";
}

}
