package com.haut.grain.service;

import java.util.List;

import com.haut.grain.pojo.ChuLiangParam;
import com.haut.grain.pojo.PredictionParam;
import com.mathworks.toolbox.javabuilder.MWException;

public interface IChuLiangPredictService {
public List<ChuLiangParam> predict(PredictionParam predictionParam) throws MWException;
}
