package com.park.einvoice.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.park.einvoice.dao.mybatis.MyBatisRepository;

@MyBatisRepository
@Repository(value="tradeInvoiceDao")
public interface TradeInvoiceDao {

	/**
	 * 将交易单号和发票请求流水号对应插入表中
	 * @param paramList 传入包含tradeNo和invoiceReqSerialNo的map
	 */
	void insertTradeInvoice(@Param("paramList") List<Map<String, Object>> paramList);

	/**
	 * 查询交易单号是否已经开过蓝票
	 * @param tradeNo 传入交易单号
	 * @return 返回总条数
	 */
	int selectTradeNo(String tradeNo);

	/**
	 * 查询主订单号对应的子订单号
	 * @param tradeNo 传入主订单号
	 * @return 返回子订单号list
	 */
	List<String> selectInvSubTradeNoList(String tradeNo);
	
}
