package com.crm.mapper;

import java.util.List;

import com.crm.pojo.BaseDict;

/**
 * @author zjl
 */
public interface BaseDictDao {
	// 根据类别查询
	public List<BaseDict> selectBaseDictListByCode(String code);
}