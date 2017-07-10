package com.park.einvoice.domain.mybatis;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 标识字段为数据库表的主键
 * 
 */
@Inherited
@Target(ElementType.FIELD)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface Index {

	

	/**
	 * 数据库表列名
	 * 
	 * @return
	 */
	String value();

	/**
	 * 是否为联合主键，默认为否
	 * 
	 * @return
	 */
	boolean isCombine() default false;


}
