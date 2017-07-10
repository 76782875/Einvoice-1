package com.park.einvoice.dao.mybatis;

import static com.park.einvoice.dao.mybatis.BaseDao.INSTANCE_NAME;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.ibatis.jdbc.SQL;

import com.park.einvoice.domain.mybatis.Column;
import com.park.einvoice.domain.mybatis.Table;

public class MInsertProvider{
	 
	public String insert(Map<String, Object> params) throws Exception {
		SQL sql = new SQL();
		if (null != params && !params.isEmpty()) {
			Object obj = params.get(INSTANCE_NAME);
			if (null != obj && obj.getClass().isAnnotationPresent(Table.class)) {
				Table table = obj.getClass().getAnnotation(Table.class);
				String tableName = table.value();
				sql.INSERT_INTO(tableName);
				List<Field> fields = FieldUtils
						.getAllFieldsList(obj.getClass());
				for (Field field : fields) {
					if (field.isAnnotationPresent(Column.class)) {
						Column column = field.getAnnotation(Column.class);
						if (column.isInsert()) {
							if (null != FieldUtils.readField(field, obj, true)) {
								sql.VALUES(column.value(), "#{" + INSTANCE_NAME
										+ "." + field.getName() + "}");
							} else if (!column.isNullable()) {
								throw new NullPointerException(
										"插入实体时出错，非空字段不能为空：" + field.getName());
							}
						}
					}
					/**else if (field.isAnnotationPresent(Index.class)) {
						Index id = field.getAnnotation(Index.class);
						if (null != FieldUtils.readField(field, obj, true)) {
							sql.VALUES(id.value(), "#{" + INSTANCE_NAME + "."
									+ field.getName() + "}");
						} else {
							throw new NullPointerException("插入实体时出错，主键不能为空："
									+ field.getName());
						}
					} **/
				}
			}
		}
		return sql.toString();
	}
}
