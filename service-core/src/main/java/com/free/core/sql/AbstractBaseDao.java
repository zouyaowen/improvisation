package com.free.core.sql;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.free.core.domin.BaseDO;
import com.free.core.exception.BaseException;
import org.springframework.util.CollectionUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @Author: zouyaowen
 * @Description: 抽象SQL工具
 * @Date: 22:15 2019/11/11
 * @Modifyed by:
 */
public class AbstractBaseDao<M extends BaseMapper<T>, T extends BaseDO> extends ServiceImpl<M, T> implements IBaseDao<T> {
    @Override
    public Optional<Integer> add(T entity) {
        if (entity == null) {
            return Optional.empty();
        }
        LocalDateTime now = LocalDateTime.now();
        entity.setCreateTime(now);
        entity.setUpdateTime(now);
        return Optional.of(this.baseMapper.insert(entity));
    }

    @Override
    public Optional<Integer> remove(Serializable pk) {
        if (pk == null) {
            return Optional.empty();
        }
        int delete = this.baseMapper.deleteById(pk);
        return Optional.ofNullable(delete);
    }

    @Override
    public Optional<Integer> removeSelective(T entity) {
        Map<String, Object> map = null;
        try {
            map = convertToMap(entity);
        } catch (InvocationTargetException | IllegalAccessException | IntrospectionException e) {
            throw new BaseException(e.getMessage());
        }
        int delete = this.baseMapper.deleteByMap(map);
        return Optional.of(delete);
    }

    private Map<String, Object> convertToMap(T obj) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Class type = obj.getClass();
        HashMap resMap = new HashMap(50);
        BeanInfo beanInfo = Introspector.getBeanInfo(type);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class")) {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(obj, new Object[0]);
                if (result != null) {
                    resMap.put(propertyName, result);
                }
            }
        }
        return resMap;
    }

    @Override
    public Optional<Integer> edit(T entity) {
        if (entity == null) {
            return Optional.empty();
        }
        entity.setUpdateTime(LocalDateTime.now());
        int updateById = this.baseMapper.updateById(entity);
        return Optional.of(updateById);
    }

    @Override
    public Optional<Integer> editSelective(T entity, UpdateWrapper<T> updateWrapper) {
        if (entity == null || updateWrapper == null) {
            return Optional.empty();
        }
        entity.setUpdateTime(LocalDateTime.now());
        int update = this.baseMapper.update(entity, updateWrapper);
        return Optional.of(update);
    }

    @Override
    public int countEntity(T entity) {
        if (entity == null) {
            return 0;
        }
        QueryWrapper<T> query = convertFromEntity(entity);
        return this.count(query);
    }

    private QueryWrapper<T> convertFromEntity(T entity) {
        QueryWrapper<T> query = new QueryWrapper<>();
        if (entity == null) {
            return query;
        }
        Class<? extends BaseDO> clazz = entity.getClass();
        ArrayList<Field> fields = parseField(clazz);
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object obj = field.get(entity);
                if (obj != null) {
                    String name = field.getName();
                    String camelToUnderline = StringUtils.camelToUnderline(name);
                    query.eq(camelToUnderline, obj);
//                  TableField annotation = field.getAnnotation(TableField.class);
//                  if (annotation != null) {
//                      query.eq(annotation.value(), obj);
//                  }
                }
            } catch (IllegalAccessException e) {
                throw new BaseException(e.getMessage());
            }
        }
        return query;
    }

    private ArrayList<Field> parseField(Class<?> clazz) {
        ArrayList<Field> fields = new ArrayList<>();
        Field[] declaredFields = clazz.getDeclaredFields();
        while (declaredFields.length > 0) {
            for (int i = 0; i < declaredFields.length; i++) {
                fields.add(declaredFields[i]);
            }
            clazz = clazz.getSuperclass();
            declaredFields = clazz.getDeclaredFields();
        }
        return fields;
    }

    @Override
    public Optional<List<T>> get(T entity) {
        QueryWrapper<T> query = convertFromEntity(entity);
        List<T> ts = this.baseMapper.selectList(query);
        if (CollectionUtils.isEmpty(ts)) {
            return Optional.empty();
        }
        return Optional.of(ts);
    }

    @Override
    public T getByPk(Serializable pk) {
        return this.getById(pk);
    }

    @Override
    public Optional<List<T>> listDO(T entity) {
        QueryWrapper<T> query = convertFromEntity(entity);
        List<T> list = this.baseMapper.selectList(query);
        return Optional.of(list);
    }
}
