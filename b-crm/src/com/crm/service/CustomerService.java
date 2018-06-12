package com.crm.service;

import com.crm.common.utils.Page;
import com.crm.pojo.Customer;
import com.crm.pojo.QueryVo;

/**
 * @author zjl
 */
public interface CustomerService {
	// 通过四个条件 查询分页对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo);

	// 通过id查询客户
	public Customer selectCustomerById(Integer id);

	// 修改客户
	public void updateCustomerById(Customer customer);

	// 通过id删除客户
	public void deleteCustomerById(Integer id);
}