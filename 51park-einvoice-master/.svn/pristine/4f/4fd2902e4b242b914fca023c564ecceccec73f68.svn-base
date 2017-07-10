package com.park.einvoice.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.park.einvoice.dao.mybatis.MyBatisRepository;
import com.park.einvoice.domain.BlueInvoiceReq;
import com.park.einvoice.domain.request.BlueInvoiceRequest;

@MyBatisRepository
@Repository(value="blueInvoiceReqDao")
public interface BlueInvoiceReqDao{
	
	/**
	 * 蓝票请求失败后存入蓝票请求表中
	 */
	public void insertBlueInvoiceReq(Map<String, Object> paramMap);

	/**
	 * 查询蓝票请求表中是否存在该请求
	 * @param tradeNo
	 * @return
	 */
	public int selectCountByTradeNo(String tradeNo);

	/**
	 * 查询蓝票请求表中的所有蓝票请求
	 * @return
	 */
	public List<BlueInvoiceReq> selectBlueInvoiceReqs();

	/**
	 * 根据id查询某个蓝票请求
	 * @param id 传入蓝票请求表的id
	 * @return 
	 */
	public BlueInvoiceRequest selectBlueInvoiceRequestById(Integer id);

	/**
	 * 发送请求失败之后更新蓝票请求信息
	 * @param blueInvoiceReq
	 */
	public void updateBlueInvoiceReqTimes(BlueInvoiceReq blueInvoiceReq);

	/**
	 * 删除发送成功的或者自动发送达到20次的请求
	 * @param id 传入蓝票请求表的id
	 */
	public void deleteBlueInvoiceReq(Integer id);

}
