package com.park.einvoice.dao;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.park.einvoice.dao.mybatis.MyBatisRepository;

@MyBatisRepository
@Repository(value="orderDao")
public interface OrderDao {
	
	/**
	 * 查询发票总金额
	 * @param tradeNo 传入订单(交易)号(非交易流水号)
	 * @return 返回发票总金额 BigDecimal
	 */
	BigDecimal selectAmountByOrderNum(String tradeNo);

	/**
	 * 查询订单生成时间
	 * @param tradeNo 传入订单(交易)号(非交易流水号)
	 * @return 返回时间 Date
	 */
	Date selectCreateTimeByOrderNum(String tradeNo);
	
}
