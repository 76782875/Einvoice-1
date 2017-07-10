package com.park.einvoice.dao;

import java.io.Serializable;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.park.einvoice.dao.mybatis.BaseDao;
import com.park.einvoice.dao.mybatis.MyBatisRepository;
import com.park.einvoice.domain.Demo;
@MyBatisRepository
@Repository(value="pdfDao")
public interface PdfDao extends BaseDao<Demo, Serializable>{
    
	/**
	 * 将pdf文件和pic文件的文件名存入数据库
	 * @param paramMap 传入参数map，包括invoiceReqSerialNo、pdfFileName和picFileName
	 */
	public void insertPdfImg(Map<String, String> paramMap);
	
	/**
	 * 检测是否已存在发票请求流水号对应的pdf和pic
	 * @param invoiceReqSerialNo 传入发票请求流水号
	 * @return
	 */
	public int pdfExist(String invoiceReqSerialNo);
	
}
