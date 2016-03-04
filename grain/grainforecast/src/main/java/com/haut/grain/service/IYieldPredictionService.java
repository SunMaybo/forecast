package com.haut.grain.service;

import java.util.List;
import java.util.Map;

import com.haut.grain.pojo.PredictionParam;
import com.haut.grain.pojo.ResultParam;
import com.mathworks.toolbox.javabuilder.MWException;

/**
 * @author maybo
 *
 */
public interface IYieldPredictionService {
	/*
	 * 预测服务接口
	 * 
	 * @param:预测参数
	 * 
	 * @return:预测数据
	 */
public List<ResultParam> prediction(PredictionParam param) throws MWException;
}
