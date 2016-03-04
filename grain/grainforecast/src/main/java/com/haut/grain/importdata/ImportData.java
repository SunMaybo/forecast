package com.haut.grain.importdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.haut.grain.dao.BaseBeanDao;
import com.haut.grain.pojo.BaseBean;

public class ImportData {
	private static ApplicationContext context;
	private static BaseBeanDao baseBeanDao;

	static {
		// spring 加载
		context = new ClassPathXmlApplicationContext("classpath:conf/beans.xml");
		baseBeanDao = (BaseBeanDao) context.getBean(BaseBeanDao.class);// 获取对象

	}
@Test
	public  void main() throws FileNotFoundException, IOException {
	fileRead();
	}
@Test
public void query(){
	System.out.println(baseBeanDao.queryAmount("czrk","CN"));
}
private void fileRead() throws FileNotFoundException, IOException{
Properties properties=(Properties)context.getBean("dataProperties");
String nd=properties.getProperty("nd");
String[] splits=properties.get("nd").toString().split(";");
Enumeration e =properties.propertyNames();
while(e.hasMoreElements()){
	String name=e.nextElement().toString();
	if(!name.equals("nd")){
		String[] n=name.split("_");
		String[] datas=properties.getProperty(name).split(";");
		String area="";
		String table="";
		table=n[0].toLowerCase();
		if(n.length==2){
		 area=n[1];
		
		}
		if(n.length==1){
		area="CN";
		}
		for(int i=0;i<datas.length;i++){
			BaseBean baseBean=new BaseBean();
			baseBean.setAmount(Float.valueOf(datas[i]));
			baseBean.setArea(area);
			baseBean.setTable(table);
			baseBean.setYear(Integer.valueOf(splits[i]));
			//System.out.println(baseBean.toString());
			baseBeanDao.add(baseBean);
		}
	}
}
}
}
