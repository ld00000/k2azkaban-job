package com.k2data.platform.utils;

import com.k2data.platform.exception.InternalException;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.reflect.Field;

/**
 * Model　工具类, Model　与数据库 Table 对应
 * 
 * @author lidong
 * @since 2016-5-31
 */
public class ModelUtils {
    
    /**
     * 从 Model　的类获取对应的数据库的表名 </br>
     * 如果有 {@link Table} 注解，并且注明了 {@code name} 的值，表名就为该值 </br>
     * 如果没有，就取类名
     * 
     * @param modelClazz　Model 的类
     * @return 对应数据库的表名
     */
    public static String getTableName(final Class<?> modelClazz) {
        final Class<?> clazz = ClassUtils.getOriginalClass(modelClazz);
        
        if (clazz.isAnnotationPresent(Table.class)) {
            Table table = clazz.getAnnotation(Table.class);
            
            if (!StringUtils.isBlank(table.name()))
                return table.name().toUpperCase();
        }
        
        return clazz.getSimpleName().toUpperCase();
    }

    /**
     * 从Model的类获取对应主键的成员变量<br>
     * 主键上有{@link Id}的注释
     *
     * @param modelClazz Model的类
     * @return 对应主键的成员变量
     */
    public static Field getPkProperty(final Class<?> modelClazz) {
        final Class<?> clazz = ClassUtils.getOriginalClass(modelClazz);

        for (Field property : clazz.getDeclaredFields()) {
            if (property.isAnnotationPresent(Id.class)) {
                return property;
            }
        }

        throw new InternalException("Model Class doesn't have ID property.");
    }
    
}
