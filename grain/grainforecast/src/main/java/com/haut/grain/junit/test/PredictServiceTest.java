package com.haut.grain.junit.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.haut.grain.dao.BaseBeanDao;
import com.haut.grain.pojo.PredictionParam;
import com.haut.grain.service.IChuLiangPredictService;
import com.haut.grain.service.IYieldPredictionService;
import com.haut.grain.service.YieldPredictionServiceImpl;
import com.mathworks.toolbox.javabuilder.MWException;

public class PredictServiceTest {
	private static ApplicationContext context;
	private static IYieldPredictionService yieldPredictionService;
	private static IChuLiangPredictService chuLiangPredictService;

	static {
		// spring 加载
		context = new ClassPathXmlApplicationContext("classpath:conf/beans.xml");
		yieldPredictionService = (YieldPredictionServiceImpl) context.getBean("yieldPredictionService");// 获取对象
		chuLiangPredictService=(IChuLiangPredictService) context.getBean("chuLiangPredictService");
	}
@Test public void test() throws MWException{
	PredictionParam param=new PredictionParam();
	param.setArea("CN");
	param.setYear(10);
	param.setM(30);
	param.setDuoYuan(1);
	param.setDuoYuanXZ(1);
	param.setHuiSe(1);
	List<Integer>types=new ArrayList<Integer>();
	types.add(PredictionParam.ZUOWU);
	param.setTypes(types);
//	System.out.println(yieldPredictionServiceImpl.prediction(param));
	System.out.println(chuLiangPredictService.predict(param));
}
@Test public void lookup(){
	/*CommandManager commandManager=(CommandManager) context.getBean("commandManager");
	commandManager.process("这是状态一。");*/
}
}
