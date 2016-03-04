package com.haut.grain.junit.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chanLiang.ChanLiang;

import com.haut.grain.dao.BaseBeanDao;
import com.haut.grain.pojo.Table;
import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

public class PredictionTest {
	private static ApplicationContext context;
	private static BaseBeanDao baseBeanDao;

	static {
		// spring 加载
		context = new ClassPathXmlApplicationContext("classpath:conf/beans.xml");
		baseBeanDao = (BaseBeanDao) context.getBean(BaseBeanDao.class);// 获取对象

	}
	@Test public void chanliang() throws MWException{
// N,X_Niandu,Y_Shijichanliang,LiangShiZuoWuBoZhongZongMianJi,ZongLaoDongLi,HuaFeiZongYongLiang,YouXiaoGuanGaiMianJi,YongDianZongLiang,JiXieZongDongLi,ShouZaiZongMianJi
		/*Predict predict=new Predict();
		predict.Y_ChanLiang((double)10,baseBeanDao.queryYear(Table.Y_Shijichanliang, "CN").toArray(),baseBeanDao.queryAmount(Table.Y_Shijichanliang, "CN").toArray(),baseBeanDao.queryAmount(Table.LiangShizuoWuBoZhongZongMianJi, "CN").toArray(),
				baseBeanDao.queryAmount(Table.ZongLaoDongLi,"CN").toArray(),baseBeanDao.queryAmount(Table.HuaFeiZongYongLiang, "CN").toArray(),baseBeanDao.queryAmount(Table.YouXiaoGuanGaiMianJi, "CN").toArray(),
				baseBeanDao.queryAmount(Table.YongDianZongLiang, "CN").toArray(),baseBeanDao.queryAmount(Table.JiXieZongDongLi, "CN").toArray(),baseBeanDao.queryAmount(Table.ShouZaiZongMianJi, "CN").toArray());*/
	ChanLiang chanLiang=new ChanLiang();
int[] len={1,baseBeanDao.queryYear(Table.Y_Shijichanliang, "CN").size()};
MWNumericArray year=MWNumericArray.newInstance(len, baseBeanDao.queryYear(Table.Y_Shijichanliang, "CN").toArray(), MWClassID.INT32);
MWNumericArray sjcl=MWNumericArray.newInstance(len, baseBeanDao.queryAmount(Table.Y_Shijichanliang, "CN").toArray(), MWClassID.DOUBLE);
MWNumericArray lswbz=MWNumericArray.newInstance(len, baseBeanDao.queryAmount(Table.LiangShizuoWuBoZhongZongMianJi, "CN").toArray(), MWClassID.DOUBLE);
MWNumericArray zldl=MWNumericArray.newInstance(len, baseBeanDao.queryAmount(Table.ZongLaoDongLi,"CN").toArray(), MWClassID.DOUBLE);	
MWNumericArray hfzy=MWNumericArray.newInstance(len, baseBeanDao.queryAmount(Table.HuaFeiZongYongLiang, "CN").toArray(), MWClassID.DOUBLE);	
MWNumericArray yxgg=MWNumericArray.newInstance(len, baseBeanDao.queryAmount(Table.YouXiaoGuanGaiMianJi, "CN").toArray(), MWClassID.DOUBLE);	
MWNumericArray ydzl=MWNumericArray.newInstance(len, baseBeanDao.queryAmount(Table.YongDianZongLiang, "CN").toArray(), MWClassID.DOUBLE);	
MWNumericArray jxzdl=MWNumericArray.newInstance(len,baseBeanDao.queryAmount(Table.JiXieZongDongLi, "CN").toArray(), MWClassID.DOUBLE);	
MWNumericArray szzmj=MWNumericArray.newInstance(len,baseBeanDao.queryAmount(Table.JiXieZongDongLi, "CN").toArray(), MWClassID.DOUBLE);	

Object[] objs=chanLiang.ChanLiangYuCe(11,(double)8,
		baseBeanDao.queryYear(Table.Y_Shijichanliang, "CN").toArray(),
		baseBeanDao.queryAmount(Table.Y_Shijichanliang, "CN").toArray(),
		baseBeanDao.queryAmount(Table.LiangShizuoWuBoZhongZongMianJi, "CN").toArray(),
			zldl,
			hfzy,
			yxgg,
			ydzl,
			jxzdl,
			szzmj);
		//chanLiang.Y_ChanLiang((double)10);
//int[] array=(int[]) objs[0];
	}
	
}
