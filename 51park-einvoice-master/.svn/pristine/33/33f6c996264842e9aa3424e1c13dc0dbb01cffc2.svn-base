package com.park.einvoice.dao.eih5;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.park.einvoice.dao.mybatis.MyBatisRepository;

@MyBatisRepository
@Repository(value="orderInvoiceDao")
public interface OrderInvoiceDao {

	/**
	 * 获取订单发票信息的方法
	 * @param tradeNo 传入主订单号
	 * @return 返回包含需要参数的map
	 */
	Map<String, String> selectOrderInvoiceInfo(String tradeNo);
	
	/**
	 * 查询企业是否注册
	 * @param tradeNo 传入订单号
	 * @return 返回查询到的结果数，0则说明企业未注册
	 */
	int selectIsRegEnterprise(String tradeNo);
	
}
