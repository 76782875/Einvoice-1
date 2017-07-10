package com.park.einvoice.dao;

import org.springframework.stereotype.Repository;

import com.park.einvoice.dao.mybatis.MyBatisRepository;
import com.park.einvoice.domain.BlueInvoiceReq;

@MyBatisRepository
@Repository(value="blueInvoiceReqHisDao")
public interface BlueInvoiceReqHisDao {

	/**
	 * 将请求次数达20次或以上将数据移入蓝票请求历史表
	 * @param blueInvoiceReq
	 */
	public void insertBlueInvoiceReqHis(BlueInvoiceReq blueInvoiceReq);
	
}
