package top.suiyueran.user.dao;

import com.free.core.sql.IBaseDao;
import top.suiyueran.user.entity.MarkDO;

import java.util.List;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 22:35 2019/11/11
 * @Modifyed by:
 */
public interface IMarkDao extends IBaseDao<MarkDO> {
    /**
     * 添加数据
     *
     * @param markDO
     * @return
     */
    MarkDO insertDO(MarkDO markDO);

    /**
     * 删除数据
     *
     * @param id
     */
    void deleteDO(Long id);

    /**
     * 查询数据
     *
     * @param id
     * @return
     */
    MarkDO selectDO(Long id);

    /**
     * 获取所有数据
     *
     * @return
     */
    List<MarkDO> selectAll();

    /**
     * 修改数据
     *
     * @param markDO
     * @return
     */
    MarkDO updateDO(MarkDO markDO);
}
