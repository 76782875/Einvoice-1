package com.park.einvoice.service.timertask;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.park.einvoice.common.DataChangeTools;
import com.park.einvoice.common.constants.CodeConstants;
import com.park.einvoice.dao.BlueInvoiceReqDao;
import com.park.einvoice.dao.BlueInvoiceReqHisDao;
import com.park.einvoice.domain.BlueInvoiceReq;
import com.park.einvoice.domain.request.BlueInvoiceRequest;
import com.park.einvoice.service.BlueInvoiceService;

@Repository(value="blueInvoiceTimeTask")
public class BlueInvoiceTimeTask {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="blueInvoiceServiceImpl")
	private BlueInvoiceService blueInvoiceService;
	@Resource(name="blueInvoiceReqDao")
	private BlueInvoiceReqDao blueInvoiceReqDao;
	@Resource(name="blueInvoiceReqHisDao")
	private BlueInvoiceReqHisDao blueInvoiceReqHisDao;
	/*
	 * 再创建一个跟发票请求表的表结构一样的bean，有的话再单查用于请求的bean
	 */
	/**
	 * 时间任务，对于获取蓝票返回错误信息的请求进行重复发送
	 */
	public void resendBlueInvoiceRequest(){
		//获取发票请求表中的所有请求数据
		List<BlueInvoiceReq> requestList = blueInvoiceReqDao.selectBlueInvoiceReqs();
		if(requestList.size() > 0){
			for (BlueInvoiceReq blueInvoiceReq : requestList) {
				logger.info("** 蓝票 重发请求定时任务，取出请求对象：" + blueInvoiceReq);
				//获取某个请求数据的对象，并调用获取蓝票方法
				BlueInvoiceRequest blueInvoiceRequest = blueInvoiceReqDao.selectBlueInvoiceRequestById(blueInvoiceReq.getId());
				String requestJsonStr = DataChangeTools.bean2gson(blueInvoiceRequest);
				String blueInvoiceResult = blueInvoiceService.blueInvoice(requestJsonStr);
				Map<String, String> resultMap = DataChangeTools.json2Map(blueInvoiceResult);
				if(resultMap.get("code").equals(CodeConstants.服务器异常.getCode())){
					Integer reqTime = blueInvoiceReq.getReq_times() + 1;
					if(blueInvoiceReq.getReq_times() >= 20){
						logger.info("** 蓝票 重发请求定时任务，请求次数超过20次，请求数据移动到蓝票请求历史表。");
						blueInvoiceReqHisDao.insertBlueInvoiceReqHis(blueInvoiceReq);
						blueInvoiceReqDao.deleteBlueInvoiceReq(blueInvoiceReq.getId());
					}else{
						logger.info("** 蓝票 重发请求定时任务，当前请求次数：" + reqTime);
						blueInvoiceReq.setUpdate_time(new Date());
						blueInvoiceReq.setReq_times(reqTime);
						blueInvoiceReqDao.updateBlueInvoiceReqTimes(blueInvoiceReq);
					}
				}else{
					logger.info("** 蓝票 重发请求定时任务，请求已成功，不再重新请求。");
					blueInvoiceReqDao.deleteBlueInvoiceReq(blueInvoiceReq.getId());
				}
			}
		}
	}
}
