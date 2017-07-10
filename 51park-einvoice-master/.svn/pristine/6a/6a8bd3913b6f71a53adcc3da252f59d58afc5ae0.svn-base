package com.park.einvoice.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.park.einvoice.dao.mybatis.MyBatisRepository;
import com.park.einvoice.domain.response.BlueInvoiceReponseContent;

@MyBatisRepository
@Repository(value="blueInvoiceDao")
public interface BlueInvoiceDao {

	/**
	 * 将向票通发送的请求插入蓝票表
	 * @param paramMap 请求信息的map
	 */
	void insertRequest2PT(Map<String, Object> paramMap);

	/**
	 * 将向票通发送的请求的开票项插入蓝票项目表
	 * @param listMap 请求信息的map
	 */
	void insertRequestItem2PT(Map<String, String> listMap);

	/**
	 * 将票通的回应插入蓝票表
	 * @param blueInvoiceReponseContent 回应信息的map
	 */
	void insertResponse4PT(BlueInvoiceReponseContent blueInvoiceReponseContent);
	
}
