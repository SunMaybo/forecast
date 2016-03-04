package com.haut.grain.pojo;

import java.util.List;

public class PredictionParam {
private List<Integer> types;//预测类型，小麦，玉米，产量等
private  int year;//预测多长时间
private String area;//地区，全国CN,河南HN
private int longTime;//长期
private int shortTime;//短期
public static final int ZUOWU=1;
public static final int XIAOMAI=2;
public static final int YUMI=3;
public static final int DAOGU=4;
private int huiSe=1;//灰色预测
private int duoYuan=1;//多元预测
private int duoYuanXZ=1;//多元预测修正
private int m;//取最近几年的数据
public void setM(int m) {
	this.m = m;
}
public int getM() {
	return m;
}
public List<Integer> getTypes() {
	return types;
}
public void setTypes(List<Integer> types) {
	this.types = types;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
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

public int getHuiSe() {
	return huiSe;
}
public void setHuiSe(int huiSe) {
	this.huiSe = huiSe;
}
public int getDuoYuan() {
	return duoYuan;
}
public void setDuoYuan(int duoYuan) {
	this.duoYuan = duoYuan;
}
public int getDuoYuanXZ() {
	return duoYuanXZ;
}
public void setDuoYuanXZ(int duoYuanXZ) {
	this.duoYuanXZ = duoYuanXZ;
}
@Override
public String toString() {
	return "PredictionParam [types=" + types + ", year=" + year + ", area="
			+ area + ", longTime=" + longTime + ", shortTime=" + shortTime
			+ "]";
}


}
