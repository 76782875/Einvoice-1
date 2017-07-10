package com.park.einvoice.service.timertask;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.park.einvoice.common.constants.EnterpriseConstants;
import com.park.einvoice.dao.EnterpriseDao;
import com.park.einvoice.dao.EnterpriseRegisterDao;
import com.park.einvoice.domain.Enterprise;
import com.park.einvoice.service.EnterpriseService;

@Repository(value="enterpriseTimeTask")
public class EnterpriseTimeTask {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="enterpriseDao")
	private EnterpriseDao enterpriseDao;
	
	@Resource(name="enterpriseServiceImpl")
	private EnterpriseService enterpriseService;

	@Resource(name="enterpriseRegisterDao")
	private EnterpriseRegisterDao enterpriseRegisterDao;
	
	public void enterpriseRegisterTask(){
		List<Integer> enterpriseIds = enterpriseDao.selectUnregisteredEnterpriseId();
		if(enterpriseIds == null || enterpriseIds.isEmpty()){
			return;
		}
		for (Integer enterpriseId : enterpriseIds) {
			Enterprise enterprise = enterpriseDao.get(Enterprise.class, enterpriseId);
			logger.info(enterprise.getEnterprise_name() + " 注册中");
			boolean regRes = enterpriseService.enterpriseRegister(enterprise);
			if(regRes){
				//成功后，将操作类型改为1并更新数据
				Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("taxpayerNum", enterprise.getTaxpayer_num());
				paramMap.put("operationType", EnterpriseConstants.REG_STATUS_ING);
				enterpriseDao.updateOperateType(paramMap);
				enterpriseRegisterDao.insertReg(enterprise);
				logger.info(enterprise.getEnterprise_name() + " 注册完毕，已注册成功！");
			}else{
				logger.info(enterprise.getEnterprise_name() + " 注册完毕，注册失败！");
			}
		}
	}
	
	/*public void enterpriseRegisterTask1(){
		List<String> allEnterpriseList = enterpriseDao.selectAllEnterpriseCode();
		List<String> regedEnterpriseList = enterpriseDao.selectRegedEnterpriseCode();
		if(allEnterpriseList == null || allEnterpriseList.size() == 0){
			return;
		}
		if(regedEnterpriseList == null || regedEnterpriseList.size() == 0){
			for (String enterpriseCode : allEnterpriseList) {
				Integer operationType = enterpriseDao.selectEnterpriseOprByCode(enterpriseCode);
				if(operationType == 0){
					logger.info(enterpriseCode + "注册中");
					Integer enterpriseId = enterpriseDao.selectEnterpriseIdByCode(enterpriseCode);
					Enterprise enterprise = enterpriseDao.get(Enterprise.class, enterpriseId);
					boolean regRes = enterpriseService.enterpriseRegister(enterprise);
					if(regRes){
						logger.info(enterpriseCode + "注册完毕，已注册成功！");
					}else{
						logger.info(enterpriseCode + "注册完毕，注册失败！");
					}
				}
			}
			return;
		}
		//是否注册标记，默认false未注册
		boolean flag = false;
		for (String enterpriseCode : allEnterpriseList) {
			for (String regedEnterpriseCode : regedEnterpriseList) {
				if(enterpriseCode.equals(regedEnterpriseCode)){
					//如果两个list中有相等值，则说明该企业注册过，将标记改为true
					flag = true;
					logger.info(enterpriseCode + "已注册");
					break;
				}
			}
			//如果没有注册过，则调用注册企业方法
			if(!flag){
				logger.info(enterpriseCode + "注册中");
				Integer enterpriseId = enterpriseDao.selectEnterpriseIdByCode(enterpriseCode);
				Enterprise enterprise = enterpriseDao.get(Enterprise.class, enterpriseId);
				enterpriseService.enterpriseRegister(enterprise);
				logger.info(enterpriseCode + "注册完毕");
			}
		}
	}*/
	
	/*public void enterpriseRegister(){
		System.out.println("abc");
	}*/
}
