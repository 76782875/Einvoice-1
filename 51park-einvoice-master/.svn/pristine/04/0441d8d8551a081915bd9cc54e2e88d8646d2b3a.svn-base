package com.park.einvoice.service.eih5.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.park.einvoice.common.DataChangeTools;
import com.park.einvoice.common.ResultTools;
import com.park.einvoice.common.constants.CodeConstants;
import com.park.einvoice.common.service.ImageService;
import com.park.einvoice.dao.eih5.HasInvoiceDao;
import com.park.einvoice.service.eih5.HasInvoiceService;

@Repository(value="hasInvoiceServiceImpl")
public class HasInvoiceServiceImpl implements HasInvoiceService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="hasInvoiceDao")
	private HasInvoiceDao hasInvoiceDao;
	@Resource(name="imageService")
	private ImageService image;
	
	@Override
	public String getHasInvoiceList(String requestStr) {
		Map<String, Object> resultMap;
		try {
			//获取请求字符串中的主订单号
			Map<String, String> requestMap = DataChangeTools.json2Map(requestStr);
			String tradeNo = requestMap.get("tradeNo");
			logger.info("** 获取已开票列表请求的主订单号：" + tradeNo);
			//校验订单号是否正确
			if(tradeNo == null || tradeNo.equals("")){
				return ResultTools.setResponse(CodeConstants.参数为空.getCode());
			}
			//从数据库查询已经开出发票的列表
			List<Map<String, String>> hasInvoiceList = hasInvoiceDao.selectHasInvoiceList(tradeNo);
			//创建结果map，并将数据放入
			resultMap = new HashMap<String, Object>();
			resultMap.put("tradeNo", tradeNo);
			resultMap.put("invoiceList", hasInvoiceList);
			//返回结果
			return ResultTools.setObjectResponse(CodeConstants.成功.getCode(), resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("** 获取已开票列表信息异常：" + e.getMessage());
			return ResultTools.setResponse(CodeConstants.服务器异常.getCode());
		}
	}

	@Override
	public String getHasInvoiceDetail(String requestStr) {
		try {
			//获取请求字符串中的发票请求流水号
			Map<String, String> requestMap = DataChangeTools.json2Map(requestStr);
			String invoiceReqSerialNo = requestMap.get("invoiceReqSerialNo");
			logger.info("** 获取发票详细信息的发票请求流水号：" + invoiceReqSerialNo);
			//校验订单号是否正确
			if(invoiceReqSerialNo == null || invoiceReqSerialNo.equals("")){
				return ResultTools.setResponse(CodeConstants.参数为空.getCode());
			}
			//从数据库查询发票请求流水号对应的发票详情并放入结果集
			Map<String, String> resultMap = hasInvoiceDao.selectHasInvoiceDetail(invoiceReqSerialNo);
			//从OSS获取文件路径
			String invoiceImg = resultMap.get("invoiceImg");
			String pdfImgUrl = image.setBetaImage(invoiceImg);
			resultMap.put("invoiceImg", pdfImgUrl);
			//返回数据
			return ResultTools.setObjectResponse(CodeConstants.成功.getCode(), resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("** 获取发票详细信息异常：" + e.getMessage());
			return ResultTools.setResponse(CodeConstants.服务器异常.getCode());
		}
	}
}
