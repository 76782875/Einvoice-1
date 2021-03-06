package com.park.einvoice.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.park.einvoice.dao.mybatis.MyBatisRepository;
import com.park.einvoice.domain.response.GetQRCodeRespContent;

@MyBatisRepository
@Repository(value="qRCodeDao")
public interface QRCodeDao {

	/**
	 * 将获取二维码的请求的一部分数据插入数据库
	 * @param paramMap 传入请求参数的map
	 */
	void insertQRCodeReq(Map<String, String> paramMap);

	/**
	 * 将获取二维码的回应的一部分数据插入数据库
	 * @param resultMap 传入回应的map
	 */
	void updateQRCodeResp(Map<String, String> resultMap);

	/**
	 * 通过子交易号查询ID，主要用来检测用户是否重复获取二维码
	 * @param tradeNo 开票二维码交易号
	 * @return 返回开票二位码的ID
	 */
	Integer selectIdByTradeNo(String tradeNo);
	
	/**
	 * 通过ID获取要返回给用户的对象
	 * @param qRCodeId 获取开票二维码ID
	 * @return 返回要回应给用户的对象
	 */
	GetQRCodeRespContent selectResponseContentById(Integer qRCodeId);

	/**
	 * 获取主订单对应的已开票子订单的总金额
	 * @param tradeNo 传入主订单订单号
	 * @return 返回金额集合 List<BigDecimal>
	 */
	List<BigDecimal> selectOrderAmountByTradeNo(String tradeNo);

	/**
	 * 通过交易号查询ID，主要用来检测用户是否重复获取二维码
	 * @param tradeNo 开票二维码交易号
	 * @return 返回开票二位码的ID
	 */
	Integer selectIdByMainTradeNo(String tradeNo);

}
