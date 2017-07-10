package com.park.einvoice.domain.mybatis;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 标识对应的数据库列名
 * 
 */
@Inherited
@Target(ElementType.FIELD)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface Column {

	/**
	 * 数据库表列名
	 * 
	 * @return
	 */
	String value();

	/**
	 * 更新时，是否更新此字段，默认更新
	 * 
	 * @return
	 */
	boolean isUpdate() default true;

	/**
	 * 插入时，是否插入此字段，默认插入
	 * 
	 * @return
	 */
	boolean isInsert() default true;

	/**
	 * 字段是否可以为空
	 * 
	 * @return
	 */
	boolean isNullable() default true;

}
