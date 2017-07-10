package com.park.einvoice.common;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckSerialNoTools {
	private static Logger logger = LoggerFactory.getLogger(DataChangeTools.class);
	
	/**
	 * 检测交易流水号是否有效
	 * @param serialNoList 传入数据库中所有流水号
	 * @param serialNo 传入收到的请求交易流水号
	 * @return true 数据库中存在该流水号，流水号有效； false 数据库中不存在该流水号，流水号无效
	 */
	public static boolean checkSerialNo(List<String> serialNoList, String serialNo){
		for (String string : serialNoList) {
			if(serialNo.equals(string)){
				logger.info("流水号 " + serialNo + " 有效");
				return true;
			}
		}
		logger.info("流水号 " + serialNo + " 无效");
		return false;
	}
}
