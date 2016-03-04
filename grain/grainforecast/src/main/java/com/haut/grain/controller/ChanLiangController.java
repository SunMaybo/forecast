package com.haut.grain.controller;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haut.grain.pojo.PredictionParam;
import com.haut.grain.pojo.ResultParam;
import com.haut.grain.pojo.SearchParam;
import com.haut.grain.service.IYieldPredictionService;
import com.mathworks.toolbox.javabuilder.MWException;
@RestController@RequestMapping("/grain")
public class ChanLiangController {
	private Logger log=LoggerFactory.getLogger(ChanLiangController.class);
@Autowired
private IYieldPredictionService yieldPredictionService;
public void setYieldPredictionService(
		IYieldPredictionService yieldPredictionService) {
	this.yieldPredictionService = yieldPredictionService;
}
@RequestMapping("/predict")
public List<ResultParam>predict(@ModelAttribute SearchParam searchParam) throws MWException{
	PredictionParam param=new PredictionParam();
	param.setArea(searchParam.getArea());
	param.setLongTime(searchParam.getLongTime());
	param.setShortTime(searchParam.getShortTime());
	param.setM(searchParam.getM());
	List<Integer>types=new ArrayList<Integer>();
	if(searchParam.getDaoGu()==1){
		types.add(PredictionParam.DAOGU);
	}
	if(searchParam.getXiaoMai()==1){
		types.add(PredictionParam.XIAOMAI);
	}
	if(searchParam.getYuMi()==1){
		types.add(PredictionParam.YUMI);
	}
	if(searchParam.getZuoWu()==1){
		types.add(PredictionParam.ZUOWU);
	}
	param.setTypes(types);
	param.setYear(searchParam.getYear());
	log.info(param.toString());
	return yieldPredictionService.prediction(param);
}
}
