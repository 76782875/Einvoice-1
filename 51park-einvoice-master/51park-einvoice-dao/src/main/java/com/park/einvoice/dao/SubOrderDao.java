package com.park.einvoice.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.park.einvoice.dao.mybatis.MyBatisRepository;

@MyBatisRepository
@Repository(value="subOrderDao")
public interface SubOrderDao {
	/**
	 * 查询发票总金额
	 * @param tradeNo 传入订单(交易)号(非交易流水号)
	 * @return 返回发票总金额 BigDecimal
	 */
	BigDecimal selectAmountByOrderNum(String subTradeNo);

	/**
	 * 查询订单生成时间
	 * @param tradeNo 传入订单(交易)号(非交易流水号)
	 * @return 返回时间 Date
	 */
	Date selectCreateTimeByOrderNum(String subTradeNo);

	/**
	 * 查询主订单的订单号
	 * @param subTradeNo 传入子订单号
	 * @return 返回主订单号 String
	 */
	String selectMainOrderNoByOrderNo(String subTradeNo);

	/**
	 * 查询主订单好对应的子订单号
	 * @param tradeNo 传入主订单号
	 * @return 返回子订单号list
	 */
	List<String> selectSubTradeNoList(String tradeNo);
}
