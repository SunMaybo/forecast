package com.haut.grain.pojo;

import java.util.List;

public class ResultParam {
	/*X_Niandu,
	Y_Shijichanliang,
	Y_Shijichanliang_HuiSeYuCe,
	Y_Shijichanliang_DuoYuanYuCe,
	Y_Shijichanliang_DuoYuanYuCe_Xiuzheng,
	Y_Shijichanliang_HuiSeYuCe_RalativeError,
	Y_Shijichanliang_DuoYuanYuCe_RalativeError,
	Y_Shijichanliang_DuoYuanYuCe_Xiuzheng_RalativeError
	,Y_Shijichanliang_HuiSeYuCe_MeanError,
	Y_Shijichanliang_DuoYuanYuCe_MeanError,
	Y_Shijichanliang_DuoYuanYuCe_Xiuzheng_MeanError*/
private List<Integer> years;//年份
private List<Double>cls;//产量
private List<Double>clshsyc;//产量灰色预测
private List<Double>clsdyyc;//产量多元预测
private List<Double>clsdyycxz;//产量多元预测修正
private List<Double>clshsycre;//产量灰色预测误差
private List<Double>clsdyycre;//产量多元预测误差
private List<Double>clsdyycxzre;//多元预测修正误差
private double clshsycme;//产量预测平均误差
private double clsdyycme;// 多元预测平均误差
public void setClsdyycme(double clsdyycme) {
	this.clsdyycme = clsdyycme;
}
public double getClsdyycme() {
	return clsdyycme;
}
private double clsdyycxzme;//产量多元预测修正误差
public List<Integer> getYears() {
	return years;
}
public void setYears(List<Integer> years) {
	this.years = years;
}
public List<Double> getCls() {
	return cls;
}
public void setCls(List<Double> cls) {
	this.cls = cls;
}
public List<Double> getClshsyc() {
	return clshsyc;
}
public void setClshsyc(List<Double> clshsyc) {
	this.clshsyc = clshsyc;
}
public List<Double> getClsdyyc() {
	return clsdyyc;
}
public void setClsdyyc(List<Double> clsdyyc) {
	this.clsdyyc = clsdyyc;
}
public List<Double> getClsdyycxz() {
	return clsdyycxz;
}
public void setClsdyycxz(List<Double> clsdyycxz) {
	this.clsdyycxz = clsdyycxz;
}
public List<Double> getClshsycre() {
	return clshsycre;
}
public void setClshsycre(List<Double> clshsycre) {
	this.clshsycre = clshsycre;
}
public List<Double> getClsdyycre() {
	return clsdyycre;
}
public void setClsdyycre(List<Double> clsdyycre) {
	this.clsdyycre = clsdyycre;
}
public List<Double> getClsdyycxzre() {
	return clsdyycxzre;
}
public void setClsdyycxzre(List<Double> clsdyycxzre) {
	this.clsdyycxzre = clsdyycxzre;
}
public double getClshsycme() {
	return clshsycme;
}
public void setClshsycme(double clshsycme) {
	this.clshsycme = clshsycme;
}
public double getClsdyycxzme() {
	return clsdyycxzme;
}
public void setClsdyycxzme(double clsdyycxzme) {
	this.clsdyycxzme = clsdyycxzme;
}
@Override
public String toString() {
	return "ResultParam [years=" + years + ", cls=" + cls + ", clshsyc="
			+ clshsyc + ", clsdyyc=" + clsdyyc + ", clsdyycxz=" + clsdyycxz
			+ ", clshsycre=" + clshsycre + ", clsdyycre=" + clsdyycre
			+ ", clsdyycxzre=" + clsdyycxzre + ", clshsycme=" + clshsycme
			+ ", clsdyycme=" + clsdyycme + ", clsdyycxzme=" + clsdyycxzme + "]";
}

}
