package com.haut.grain.pojo;

import java.util.ArrayList;
import java.util.List;

public class ChuLiangParam {
private int year;
private String suanFa;//用的算法
private List<Double>quanMax =new ArrayList<Double>();//全额最大
private List<Double>chaMax =new ArrayList<Double>();//差额最大
private List<Double>biliMax =new ArrayList<Double>();//比例最大
private List<Double>quanMin =new ArrayList<Double>();//全额最小
private List<Double>chaMin =new ArrayList<Double>();//差额最小
private List<Double>biliMin =new ArrayList<Double>();//比例最小
private List<Double>quan =new ArrayList<Double>();//全额
private List<Double>cha =new ArrayList<Double>();//差额
private List<Double>bili =new ArrayList<Double>();//比例
public void setSuanFa(String suanFa) {
	this.suanFa = suanFa;
}
public String getSuanFa() {
	return suanFa;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public List<Double> getQuanMax() {
	return quanMax;
}
public void setQuanMax(List<Double> quanMax) {
	this.quanMax = quanMax;
}
public List<Double> getChaMax() {
	return chaMax;
}
public void setChaMax(List<Double> chaMax) {
	this.chaMax = chaMax;
}
public List<Double> getBiliMax() {
	return biliMax;
}
public void setBiliMax(List<Double> biliMax) {
	this.biliMax = biliMax;
}
public List<Double> getQuanMin() {
	return quanMin;
}
public void setQuanMin(List<Double> quanMin) {
	this.quanMin = quanMin;
}
public List<Double> getChaMin() {
	return chaMin;
}
public void setChaMin(List<Double> chaMin) {
	this.chaMin = chaMin;
}
public List<Double> getBiliMin() {
	return biliMin;
}
public void setBiliMin(List<Double> biliMin) {
	this.biliMin = biliMin;
}
public List<Double> getQuan() {
	return quan;
}
public void setQuan(List<Double> quan) {
	this.quan = quan;
}
public List<Double> getCha() {
	return cha;
}
public void setCha(List<Double> cha) {
	this.cha = cha;
}
public List<Double> getBili() {
	return bili;
}
public void setBili(List<Double> bili) {
	this.bili = bili;
}
@Override
public String toString() {
	return "ChuLiangParam [year=" + year + ", quanMax=" + quanMax + ", chaMax="
			+ chaMax + ", biliMax=" + biliMax + ", quanMin=" + quanMin
			+ ", chaMin=" + chaMin + ", biliMin=" + biliMin + ", quan=" + quan
			+ ", cha=" + cha + ", bili=" + bili + "]";
}


}
