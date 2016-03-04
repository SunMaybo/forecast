package com.haut.grain.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chuliang.Chuliang;

import com.haut.grain.pojo.ChuLiangParam;
import com.haut.grain.pojo.PredictionParam;
import com.haut.grain.pojo.ResultParam;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

@Service("chuLiangPredictService")
public class ChuLiangPredictServiceImpl implements IChuLiangPredictService {
	@Autowired
	private IYieldPredictionService yieldPredictionService;
	@Autowired
	private Chuliang chuliang;

	public void setChuliang(Chuliang chuliang) {
		this.chuliang = chuliang;
	}

	public void setPredictionService(
			IYieldPredictionService yieldPredictionService) {
		this.yieldPredictionService = yieldPredictionService;
	}

	public List<ChuLiangParam> predict(PredictionParam predictionParam)
			throws MWException {
		List<ResultParam> resultParams = yieldPredictionService
				.prediction(predictionParam);
		List<ChuLiangParam> chuLiangParams = new ArrayList<ChuLiangParam>();
		if (predictionParam.getHuiSe() >= 1) {
			Object[] objs = null;
			objs = chuliang.chuliang_main(3, resultParams.get(0).getCls()
					.toArray(), resultParams.get(0).getClshsyc().toArray());
			ChuLiangParam chuLiangParam = toObject(objs);
			chuLiangParam.setYear(1+resultParams.get(0).getYears()
					.get(resultParams.get(0).getYears().size() - 1));
			chuLiangParam.setSuanFa("灰色预测");
			chuLiangParams.add(chuLiangParam);
		}
		if (predictionParam.getDuoYuan() >= 1) {
			Object[] objs = null;
			objs = chuliang.chuliang_main(3, resultParams.get(0).getCls()
					.toArray(), resultParams.get(0).getClsdyyc().toArray());
			ChuLiangParam chuLiangParam = toObject(objs);
			chuLiangParam.setYear(1+resultParams.get(0).getYears()
					.get(resultParams.get(0).getYears().size() - 1));
			chuLiangParam.setSuanFa("多元预测");
			chuLiangParams.add(chuLiangParam);
		}
		if (predictionParam.getDuoYuanXZ() >= 1) {
			Object[] objs = null;
			objs = chuliang.chuliang_main(3, resultParams.get(0).getCls()
					.toArray(), resultParams.get(0).getClsdyycxz().toArray());
			ChuLiangParam chuLiangParam = toObject(objs);
			chuLiangParam.setYear(1+resultParams.get(0).getYears()
					.get(resultParams.get(0).getYears().size() - 1));
			chuLiangParam.setSuanFa("多元预测修正");
			chuLiangParams.add(chuLiangParam);
		}
		return chuLiangParams;
	}

	private ChuLiangParam toObject(Object[] objs) {
		ChuLiangParam chuLiangParam = new ChuLiangParam();
		MWNumericArray array1 = (MWNumericArray) objs[0];
		double[][] a1 = (double[][]) array1.toDoubleArray();
		MWNumericArray array2 = (MWNumericArray) objs[1];
		double[][] a2 = (double[][]) array2.toDoubleArray();
		MWNumericArray array3 = (MWNumericArray) objs[2];
		double[][] a3 = (double[][]) array3.toDoubleArray();
		DecimalFormat df = new DecimalFormat("0.0000");
		for (int i = 0; i < 6; i++) {
			chuLiangParam.getQuanMin().add(Double.valueOf(df.format(a1[i][1])));
			chuLiangParam.getQuanMax().add(Double.valueOf(df.format(a1[i][0])));
			chuLiangParam.getQuan().add(Double.valueOf(df.format(a1[i][2])));
			chuLiangParam.getCha().add(Double.valueOf(df.format(a2[i][2])));
			chuLiangParam.getChaMax().add(Double.valueOf(df.format(a2[i][0])));
			chuLiangParam.getChaMin().add(Double.valueOf(df.format(a2[i][1])));
			chuLiangParam.getBiliMax().add(Double.valueOf(df.format(a3[i][0])));
			chuLiangParam.getBiliMin().add(Double.valueOf(df.format(a3[i][1])));
			chuLiangParam.getBili().add(Double.valueOf(df.format(a3[i][2])));
		}
		return chuLiangParam;
	}

}
