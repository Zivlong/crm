package com.crm.service;

import java.util.List;

import com.crm.pojo.BaseDict;

/**
 * @author zjl
 */
public interface BaseDictService {
	public List<BaseDict> selectBaseDictListByCode(String code);
}