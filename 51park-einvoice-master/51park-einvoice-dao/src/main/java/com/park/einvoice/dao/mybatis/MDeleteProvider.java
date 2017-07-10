package com.park.einvoice.dao.mybatis;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.ibatis.jdbc.SQL;

import com.park.einvoice.domain.mybatis.Index;
import com.park.einvoice.domain.mybatis.Table;

import static com.park.einvoice.dao.mybatis.BaseDao.CLASS_NAME;
import static com.park.einvoice.dao.mybatis.BaseDao.INSTANCE_NAME;
import static com.park.einvoice.dao.mybatis.BaseDao.PRIMARY_KEY;
public class MDeleteProvider {
	@SuppressWarnings("unchecked")
    public <T, PK extends Serializable> String deleteById(Map<String, Object> params) {
        SQL sql = new SQL();
        if (null != params && !params.isEmpty()) {
            Class<T> cls = (Class<T>) params.get(CLASS_NAME);
            Object pk = params.get(PRIMARY_KEY);
            if (null != cls && cls.isAnnotationPresent(Table.class)) {
                Table table = cls.getAnnotation(Table.class);
                String tableName = table.value();
                sql.DELETE_FROM(tableName);
                if (null != pk) {
                    List<Field> fields = FieldUtils.getAllFieldsList(cls);
                    for (Field field : fields) {
                        if (field.isAnnotationPresent(Index.class)) {
                            Index id = field.getAnnotation(Index.class);
                            String fieldName = field.getName();
                            if (pk instanceof String || pk instanceof Number) {
                                sql.WHERE(id.value() + "=#{" + PRIMARY_KEY + "}");
                                break;
                            } else {
                                sql.WHERE(id.value() + "=#{" + PRIMARY_KEY + "." + fieldName + "}");
                            }
                        }
                    }
                }
            }
        }
        return sql.toString();
    }

    public <T> String delete(Map<String, Object> params) throws Exception {
        SQL sql = new SQL();
        if (null != params && !params.isEmpty()) {
            Object obj = params.get(INSTANCE_NAME);
            if (null != obj && obj.getClass().isAnnotationPresent(Table.class)) {
                Table table = obj.getClass().getAnnotation(Table.class);
                String tableName = table.value();

                List<Field> fields = FieldUtils.getAllFieldsList(obj.getClass());
                sql.DELETE_FROM(tableName);
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Index.class)) {
                        if (null != FieldUtils.readField(field, obj, true)) {
                            Index index = field.getAnnotation(Index.class);
                            sql.WHERE(index.value() + "=#{" + INSTANCE_NAME + "." + field.getName() + "}");
                        } else {
                            throw new RuntimeException("删除数据时，对象的主键不能为空");
                        }
                    }
                }
            }
        }
        return sql.toString();
    }
}
