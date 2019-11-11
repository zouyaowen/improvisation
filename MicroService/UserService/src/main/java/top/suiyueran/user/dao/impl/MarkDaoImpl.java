package top.suiyueran.user.dao.impl;

import com.free.core.sql.AbstractBaseDao;
import org.springframework.stereotype.Repository;
import top.suiyueran.user.dao.IMarkDao;
import top.suiyueran.user.dao.mapper.MarkMapper;
import top.suiyueran.user.entity.MarkDO;

import java.util.List;
import java.util.Optional;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 22:36 2019/11/11
 * @Modifyed by:
 */
@Repository
public class MarkDaoImpl extends AbstractBaseDao<MarkMapper, MarkDO> implements IMarkDao {

    @Override
    public MarkDO insertDO(MarkDO markDO) {
        this.add(markDO);
        return this.getById(markDO.getId());
    }

    @Override
    public void deleteDO(Long id) {
        this.remove(id);
    }

    @Override
    public MarkDO selectDO(Long id) {
        return this.getById(id);
    }

    @Override
    public List<MarkDO> selectAll() {
        return this.list();
    }

    @Override
    public MarkDO updateDO(MarkDO markDO) {
        return this.updateDO(markDO);
    }
}
