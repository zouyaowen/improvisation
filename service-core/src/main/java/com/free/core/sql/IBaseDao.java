package com.free.core.sql;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.free.core.domin.BaseDO;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 22:13 2019/11/11
 * @Modifyed by:
 */
public interface IBaseDao <T extends BaseDO>{
    /**
     * 添加数据
     *
     * @param entity 实体条件
     * @return 影响条数
     */
    Optional<Integer> add(T entity);

    /**
     * 删除数据
     *
     * @param pk 主键
     * @return 影响条数
     */
    Optional<Integer> remove(Serializable pk);

    /**
     * 删除数据
     *
     * @param entity 条件
     * @return 影响条数
     */
    Optional<Integer> removeSelective(T entity);

    /**
     * 根据主键修改数据
     *
     * @param entity 实体条件
     * @return 影响条数
     */
    Optional<Integer> edit(T entity);

    /**
     * 根据条件更新数据
     *
     * @param entity        更新目标
     * @param updateWrapper 更新条件
     * @return
     */
    Optional<Integer> editSelective(T entity, UpdateWrapper<T> updateWrapper);

    /**
     * 统计数量
     *
     * @param entity 实体信息
     * @return 统计结果
     */
    int countEntity(T entity);

    /**
     * 获取单条数据
     *
     * @param entity 条件信息
     * @return 获取的数据结果
     */
    Optional<List<T>> get(T entity);

    /**
     * 主键查询
     *
     * @param pk 主键查询
     * @return 实体对象
     */
    T getByPk(Serializable pk);

    /**
     * 获取数据列表
     *
     * @param entity 实体条件
     * @return 实体列表
     */
    Optional<List<T>> listDO(T entity);
}
