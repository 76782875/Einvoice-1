package com.park.einvoice.dao;

import org.springframework.stereotype.Repository;
import com.park.einvoice.dao.mybatis.MyBatisRepository;

@MyBatisRepository
@Repository(value="enterpriseParkDao")
public interface EnterpriseParkDao {

	/**
	 * 获取纳税识别号
	 * @param parkId 传入参数为停车场ID
	 * @return 返回纳税识别号 String
	 */
	String selectTaxpayerNumByParkId(Integer parkId);
	
	/**
	 * 获取企业名称
	 * @param parkId 传入参数为停车场ID
	 * @return 返回企业名称 String
	 */
	String selectEnterpriseNameByParkId(Integer parkId);

}
