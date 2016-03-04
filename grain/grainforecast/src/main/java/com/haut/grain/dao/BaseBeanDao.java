package com.haut.grain.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haut.grain.pojo.BaseBean;

public interface BaseBeanDao {
	public void add(BaseBean bean);
	//public List<BaseBean>query(@Param(value="table") String table,@Param(value="area") String area);
	public List<Double>queryAmount(@Param(value="table") String table,@Param(value="area") String area);
	public List<Integer>queryYear(@Param(value="table") String table,@Param(value="area") String area);
}
