package com.haut.grain.pojo;

public class SearchParam {
private String area;
private int zuoWu;
private int xiaoMai;
private int yuMi;
private int daoGu;
private int longTime;
private int shortTime;
private int year;
private int m;
public void setM(int m) {
	this.m = m;
}
public int getM() {
	return m;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public int getZuoWu() {
	return zuoWu;
}
public void setZuoWu(int zuoWu) {
	this.zuoWu = zuoWu;
}
public int getXiaoMai() {
	return xiaoMai;
}
public void setXiaoMai(int xiaoMai) {
	this.xiaoMai = xiaoMai;
}
public int getYuMi() {
	return yuMi;
}
public void setYuMi(int yuMi) {
	this.yuMi = yuMi;
}
public int getDaoGu() {
	return daoGu;
}
public void setDaoGu(int daoGu) {
	this.daoGu = daoGu;
}
public int getLongTime() {
	return longTime;
}
public void setLongTime(int longTime) {
	this.longTime = longTime;
}
public int getShortTime() {
	return shortTime;
}
public void setShortTime(int shortTime) {
	this.shortTime = shortTime;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
@Override
public String toString() {
	return "SearchParam [area=" + area + ", zuoWu=" + zuoWu + ", xiaoMai="
			+ xiaoMai + ", yuMi=" + yuMi + ", daoGu=" + daoGu + ", longTime="
			+ longTime + ", shortTime=" + shortTime + ", year=" + year + "]";
}

}
