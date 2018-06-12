package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.common.utils.Page;
import com.crm.pojo.BaseDict;
import com.crm.pojo.Customer;
import com.crm.pojo.QueryVo;
import com.crm.service.BaseDictService;
import com.crm.service.CustomerService;

/**
 * @author zjl
 */
@Controller
public class CustomerController {

	@Autowired
	private BaseDictService baseDictService;

	@Autowired
	private CustomerService customerService;

	@Value("${fromType.code}")
	private String formTypeCode;
	@Value("${industryType.code}")
	private String industryTypeCode;
	@Value("${levelType.code}")
	private String levelTypeCode;

	/**
	 * 入口
	 */
	@RequestMapping(value = "/customer/list")
	public String list(QueryVo vo, Model model) {
		// 客户来源
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(formTypeCode);
		// 客户所属行业
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode(industryTypeCode);
		// 客户级别
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode(levelTypeCode);
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);

		// 通过四个条件 查询分页对象
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		return "customer";
	}

	/**
	 * 去修改页面
	 */
	@RequestMapping(value = "/customer/edit.action")
	@ResponseBody
	public Customer edit(Integer id) {
		return customerService.selectCustomerById(id);
	}

	/**
	 * 修改保存
	 */
	@RequestMapping(value = "/customer/update.action")
	@ResponseBody
	public String update(Customer customer) {
		// 修改客户信息
		customerService.updateCustomerById(customer);
		return "ok";
	}

	/**
	 * 删除客户
	 * 
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/customer/delete.action")
	@ResponseBody
	public String delete(Integer id) {
		// 删除客户
		customerService.deleteCustomerById(id);
		return "ok";
	}
}