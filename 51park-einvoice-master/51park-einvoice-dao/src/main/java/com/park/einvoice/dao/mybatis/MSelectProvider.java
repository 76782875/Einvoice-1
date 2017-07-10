package com.park.einvoice.dao.mybatis;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static com.park.einvoice.dao.mybatis.BaseDao.CLASS_NAME;
import static com.park.einvoice.dao.mybatis.BaseDao.INSTANCE_NAME;
import static com.park.einvoice.dao.mybatis.BaseDao.PRIMARY_KEY;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.ibatis.jdbc.SQL;

import com.park.einvoice.domain.mybatis.Column;
import com.park.einvoice.domain.mybatis.Index;
import com.park.einvoice.domain.mybatis.Table;

public class MSelectProvider {
	public <T> String find(Map<String, Object> params) throws Exception {
		SQL sql = new SQL();
		if (null != params && !params.isEmpty()) {
			Object obj = params.get(INSTANCE_NAME);
			if (null != obj && obj.getClass().isAnnotationPresent(Table.class)) {
				Table table = obj.getClass().getAnnotation(Table.class);
				String tableName = table.value();
				sql.SELECT("*");
				sql.FROM(tableName);
				List<Field> fields = FieldUtils.getAllFieldsList(obj.getClass());
				for (Field field : fields) {
					if (!isBlank(FieldUtils.readField(field, obj, true))) {
						if (field.isAnnotationPresent(Index.class)) {
							sql.WHERE(field.getAnnotation(Index.class).value()
									+ "=#{" + INSTANCE_NAME + "."
									+ field.getName() + "}");
						} else if (field.isAnnotationPresent(Column.class)) {
							sql.WHERE(field.getAnnotation(Column.class).value()
									+ "=#{" + INSTANCE_NAME + "."
									+ field.getName() + "}");
						}
					}
				}
			}
		}
		return sql.toString();
	}

	private boolean isBlank(Object obj) {
		boolean retVal = (null == obj);
		if (!retVal && obj instanceof String) {
			retVal = !StringUtils.isNotBlank((String) obj);
		}
		return retVal;
	}

	public <T> String findAll(Class<T> cls) throws Exception {
		SQL sql = new SQL();
		if (null != cls && cls.isAnnotationPresent(Table.class)) {
			Table table = cls.getAnnotation(Table.class);
			String tableName = table.value();

			sql.SELECT("*");
			sql.FROM(tableName);
		}
		return sql.toString();
	}

	@SuppressWarnings("unchecked")
	public <T> String get(Map<String, Object> params) throws Exception {
		SQL sql = new SQL();
		if (null != params && !params.isEmpty()) {
			Class<T> cls = (Class<T>) params.get(CLASS_NAME);
			Object pk = params.get(PRIMARY_KEY);
			if (null != cls && cls.isAnnotationPresent(Table.class)) {
				Table table = cls.getAnnotation(Table.class);
				String tableName = table.value();

				sql.SELECT("*");
				sql.FROM(tableName);
				if (null != pk) {
					List<Field> fields = FieldUtils.getAllFieldsList(cls);
					for (Field field : fields) {
						if (field.isAnnotationPresent(Index.class)) {
							Index id = field.getAnnotation(Index.class);
							String fieldName = field.getName();
							if (pk instanceof String || pk instanceof Number) {
								sql.WHERE(id.value() + "=#{" + PRIMARY_KEY
										+ "}");
								break;
							} else {
								sql.WHERE(id.value() + "=#{" + PRIMARY_KEY
										+ "." + fieldName + "}");
							}
						}
					}
				}
			}
		}

		return sql.toString();
	}
}
