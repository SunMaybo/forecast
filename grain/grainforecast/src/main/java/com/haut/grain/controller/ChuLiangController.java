package com.haut.grain.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haut.grain.pojo.ChuLiangParam;
import com.haut.grain.pojo.PredictionParam;
import com.haut.grain.pojo.SearchParam;
import com.haut.grain.service.IChuLiangPredictService;
import com.mathworks.toolbox.javabuilder.MWException;

@RestController@RequestMapping("/grain/")
public class ChuLiangController {
	@Autowired
	private IChuLiangPredictService chuLiangPredictService;
	public void setChuLiangPredictService(
			IChuLiangPredictService chuLiangPredictService) {
		this.chuLiangPredictService = chuLiangPredictService;
	}
	@RequestMapping("chuliang")
public List<ChuLiangParam> predict(@ModelAttribute SearchParam searchParam) throws MWException{
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
List<ChuLiangParam>chuLiangParams=chuLiangPredictService.predict(param);
return chuLiangParams;
	
}
}
