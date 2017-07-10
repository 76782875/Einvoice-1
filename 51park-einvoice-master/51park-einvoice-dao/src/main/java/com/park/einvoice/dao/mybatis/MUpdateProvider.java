package com.park.einvoice.dao.mybatis;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.ibatis.jdbc.SQL;

import com.park.einvoice.domain.mybatis.Column;
import com.park.einvoice.domain.mybatis.Index;
import com.park.einvoice.domain.mybatis.Table;

import static com.park.einvoice.dao.mybatis.BaseDao.INSTANCE_NAME;
public class MUpdateProvider {
	public String update(Map<String, Object> params) throws Exception {
		SQL sql = new SQL();
		if (null != params && !params.isEmpty()) {
			Object obj = params.get(INSTANCE_NAME);
			Table table = obj.getClass().getAnnotation(Table.class);
			String tableName = table.value();

			sql.UPDATE(tableName);
			List<Field> fields = FieldUtils.getAllFieldsList(obj.getClass());
			for (Field field : fields) {
				if (field.isAnnotationPresent(Index.class)) {
					if (null != FieldUtils.readField(field, obj, true)) {
						Index id = field.getAnnotation(Index.class);
						sql.WHERE(id.value() + "=#{" + INSTANCE_NAME + "."
								+ field.getName() + "}");
					} else {
						throw new NullPointerException("更新实体时，非空字段不能为空："
								+ field.getName());
					}
				}
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					if (column.isUpdate()) {
						if (null != FieldUtils.readField(field, obj, true)) {
							sql.SET(column.value() + "=#{" + INSTANCE_NAME
									+ "." + field.getName() + "}");
						} else if (!column.isNullable()) {
							throw new NullPointerException("更新实体时，非空字段不能为空："
									+ field.getName());
						}
					}
				}
			}
		}
		return sql.toString();
	}
}
