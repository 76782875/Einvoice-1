package com.park.einvoice.dao.mybatis;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

/** 
 * MyBatis CRUD基接口 
 * @param <T> 处理的POJO对象 
 */  
public interface BaseDao <T, PK extends Serializable> {
	
      
	public String INSTANCE_NAME = "inst";

	public String PRIMARY_KEY = "pk";

	public String CLASS_NAME = "cls";  
    /** 
     * Insert语句从MInsertProvider类中生成 
     * @param obj 
     */  
    @InsertProvider(type =MInsertProvider.class,method = "insert")  
    public int insert(@Param(INSTANCE_NAME) T inst);  
      
    /** 
     * Update语句从MUpdateProvider类中生成 
     * @param obj 
     */  
    @UpdateProvider(type = MUpdateProvider.class,method = "update")  
    public int update(@Param(INSTANCE_NAME) T inst);  
      
    /** 
     * Delete语句从MDeleteProvider类中生成 
     * @param obj 
     */  
    @DeleteProvider(type = MDeleteProvider.class,method = "delete")  
    public int delete(@Param(INSTANCE_NAME) T inst); 
    
    @DeleteProvider(type = MDeleteProvider.class, method = "deleteById")
	public int deleteById(@Param("cls") Class<T> cls, @Param(PRIMARY_KEY) PK pk);
    
//    @SelectProvider(type = MSelectProvider.class, method = "find")
//	public List<T> find(@Param(INSTANCE_NAME) T inst);
    /**
     * 根据主键查询
     * @return
     */
	@SelectProvider(type = MSelectProvider.class, method = "get")
	public T get(@Param("cls") Class<T> cls, @Param(PRIMARY_KEY) PK pk);

	@SelectProvider(type = MSelectProvider.class, method = "findAll")
	public List<T> findAll(Class<T> cls);
}
