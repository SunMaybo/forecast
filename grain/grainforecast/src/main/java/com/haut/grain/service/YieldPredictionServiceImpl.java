package com.haut.grain.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chanLiang.ChanLiang;

import com.haut.grain.dao.BaseBeanDao;
import com.haut.grain.pojo.PredictionParam;
import com.haut.grain.pojo.ResultParam;
import com.haut.grain.pojo.Table;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
@Service("yieldPredictionService")
public class YieldPredictionServiceImpl implements IYieldPredictionService {
	private static final Logger log=LoggerFactory.getLogger(YieldPredictionServiceImpl.class);
	@Autowired
	private ChanLiang predict;
	@Autowired
	private BaseBeanDao baseBeanDao;

	public void setBaseBeanDao(BaseBeanDao baseBeanDao) {
		this.baseBeanDao = baseBeanDao;
	}

	public void setPredict(ChanLiang predict) {
		this.predict = predict;
	}

	public List<ResultParam> prediction(PredictionParam param)
			throws MWException {
		if (null == param.getTypes()) {
			return null;
		}
		List<ResultParam> resultParams = new ArrayList<ResultParam>();
		for (int i = 0; i < param.getTypes().size(); i++) {
			Object bzzmj = null;
			Object years = null;
			Object sjcl = null;
			if (param.getTypes().get(i) == PredictionParam.ZUOWU) {
				years = baseBeanDao.queryYear(Table.Y_Shijichanliang,
						param.getArea()).toArray();
				sjcl = baseBeanDao.queryAmount(Table.Y_Shijichanliang,
						param.getArea()).toArray();
				bzzmj = baseBeanDao.queryAmount(
						Table.LiangShizuoWuBoZhongZongMianJi, param.getArea())
						.toArray();
			} else if (param.getTypes().get(i) == PredictionParam.XIAOMAI) {
				years = baseBeanDao.queryYear(Table.XiaoMai_ShiJiChanLiang,
						param.getArea()).toArray();
				sjcl = baseBeanDao.queryAmount(Table.XiaoMai_ShiJiChanLiang,
						param.getArea()).toArray();
				bzzmj = baseBeanDao.queryAmount(Table.XiaoMaiBoZhongZongMianJi,
						param.getArea()).toArray();
			} else if (param.getTypes().get(i) == PredictionParam.DAOGU) {
				years = baseBeanDao.queryYear(Table.DaoGu_ShiJiChanLiang,
						param.getArea()).toArray();
				sjcl = baseBeanDao.queryAmount(Table.DaoGu_ShiJiChanLiang,
						param.getArea()).toArray();
				bzzmj = baseBeanDao.queryAmount(Table.DaoGuBOZhongZongMianJi,
						param.getArea()).toArray();
			} else if (param.getTypes().get(i) == PredictionParam.YUMI) {
				years = baseBeanDao.queryYear(Table.YuMi_ShiJiChanLiang,
						param.getArea()).toArray();
				sjcl = baseBeanDao.queryAmount(Table.YuMi_ShiJiChanLiang,
						param.getArea()).toArray();
				bzzmj = baseBeanDao.queryAmount(Table.YuMiBoZhongZongMianJi,
						param.getArea()).toArray();
			}
			ResultParam resultParam = null;
			Object[] objs = (Object[]) predict.ChanLiangYuCe(
					11,
					(double) param.getYear(),
					years,
					sjcl,
					bzzmj,
					baseBeanDao.queryAmount(Table.ZongLaoDongLi,
							param.getArea()).toArray(),
					baseBeanDao.queryAmount(Table.HuaFeiZongYongLiang,
							param.getArea()).toArray(),
					baseBeanDao.queryAmount(Table.YouXiaoGuanGaiMianJi,
							param.getArea()).toArray(),
					baseBeanDao.queryAmount(Table.YongDianZongLiang,
							param.getArea()).toArray(),
					baseBeanDao.queryAmount(Table.JiXieZongDongLi,
							param.getArea()).toArray(),
					baseBeanDao.queryAmount(Table.ShouZaiZongMianJi,
							param.getArea()).toArray(),(double)param.getM());
			resultParam = WMTOResult(objs);
			if (null != resultParam) {
				resultParams.add(resultParam);
			}
		}
			log.info(resultParams.toString());
		return resultParams;
	}

	private ResultParam WMTOResult(Object[] objs) {
		/*
		 * X_Niandu Y_Shijichanliang Y_Shijichanliang_HuiSeYuCe
		 * Y_Shijichanliang_DuoYuanYuCe Y_Shijichanliang_DuoYuanYuCe_Xiuzheng
		 * Y_Shijichanliang_HuiSeYuCe_RalativeError
		 * Y_Shijichanliang_DuoYuanYuCe_RalativeError
		 * Y_Shijichanliang_DuoYuanYuCe_Xiuzheng_RalativeError
		 * Y_Shijichanliang_HuiSeYuCe_MeanError
		 * Y_Shijichanliang_DuoYuanYuCe_MeanError
		 * Y_Shijichanliang_DuoYuanYuCe_Xiuzheng_MeanError
		 */
		DecimalFormat df = new DecimalFormat("0.0000");
		ResultParam param = new ResultParam();
		param.setClshsycme(Double.valueOf(objs[8].toString()));
		param.setClsdyycxzme(Double.valueOf(objs[10].toString()));
		param.setClsdyycme(Double.valueOf(objs[9].toString()));
		param.setYears(toIntegerData(objs[0]));
		param.setCls(toDoubleData(objs[1]));
		param.setClshsyc(toDoubleData(objs[2]));
		param.setClsdyyc(toDoubleData(objs[3]));
		param.setClsdyycxz(toDoubleData(objs[4]));
		param.setClshsycre(toDoubleData(objs[5]));
		param.setClsdyycre(toDoubleData(objs[6]));
		param.setClsdyycxzre(toDoubleData(objs[7]));
		return param;
	}

	private List<Double> toDoubleData(Object obj) {
		DecimalFormat df = new DecimalFormat("0.0000");
		MWNumericArray array=(MWNumericArray)obj;
		List<Double> lists = new ArrayList<Double>();
		double[] data=array.getDoubleData();
		for(int i=0;i<data.length;i++){
			lists.add(Double.valueOf(df.format(data[i])));
		}
		return lists;
	}

	private List<Integer> toIntegerData(Object obj) {
		List<Integer> lists = new ArrayList<Integer>();
		MWNumericArray array=(MWNumericArray)obj;
		int[] data=array.getIntData();
		for (int i = 0;i<data.length; i++) {
			
			lists.add(data[i]);
		}
		return lists;
	}
}
