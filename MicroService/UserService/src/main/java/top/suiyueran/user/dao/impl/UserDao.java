package top.suiyueran.user.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import top.suiyueran.user.dao.IUserDao;
import top.suiyueran.user.dao.cache.UserCache;
import top.suiyueran.user.dao.mapper.UserMapper;
import top.suiyueran.user.entity.UserDO;
import top.suiyueran.user.enums.ValidEnum;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 19:34 2019/11/9
 * @Modifyed by:
 */
@Repository
public class UserDao implements IUserDao {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserCache userCache;

    @Override
    public UserDO selectById(Long id) {
        QueryWrapper<UserDO> query = new QueryWrapper<>();
        query.eq("valid", ValidEnum.VALID.getValid());
        query.eq("id", id);
        return userMapper.selectOne(query);
    }

    @Override
    public List<UserDO> list() {
        QueryWrapper<UserDO> query = new QueryWrapper<>();
        query.eq("valid", ValidEnum.VALID.getValid());
        List<UserDO> userDOList = userMapper.selectList(query);
        if (!CollectionUtils.isEmpty(userDOList)) {
            return userDOList;
        }
        return Collections.emptyList();
    }

    @Override
    public Long selectByName(String userName) {
        QueryWrapper<UserDO> query = new QueryWrapper<>();
        query.eq("valid", ValidEnum.VALID.getValid());
        query.eq("user_name", userName);
        UserDO userDO = userMapper.selectOne(query);
        if (userDO != null) {
            return userDO.getId();
        }
        return null;
    }

    @Override
    public UserDO selectByCode(String userCode) {
        QueryWrapper<UserDO> query = new QueryWrapper<>();
        query.eq("valid", ValidEnum.VALID.getValid());
        query.eq("user_code", userCode);
        UserDO userDO = userMapper.selectOne(query);
        return userDO;
    }

    @Override
    public Optional<UserDO> insertUserDO(UserDO userDO) {
        if (userDO == null) {
            return Optional.empty();
        }

        userMapper.insert(userDO);
        return Optional.of(userDO);
    }

    @Override
    public Optional<UserDO> updateUserDO(UserDO userDO) {
        if (userDO == null) {
            return Optional.empty();
        }
        userMapper.updateById(userDO);
        return Optional.ofNullable(userMapper.selectById(userDO.getId()));
    }

    @Override
    public void deleteUserDO(Long id) {
        UpdateWrapper<UserDO> update = new UpdateWrapper<>();
        update.eq("id", id);
        update.eq("valid", ValidEnum.NOT_VALID.getValid());
    }
}
