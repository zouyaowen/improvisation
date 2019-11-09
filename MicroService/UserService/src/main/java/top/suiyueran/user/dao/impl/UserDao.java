package top.suiyueran.user.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import top.suiyueran.user.dao.IUserDao;
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
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDao implements IUserDao {

    /**
     * 解决IDEA中Mapper注释失败提示问题
     * 第一种解决方案：@Autowired(required = false)
     * 第二种解决方案：用 @Resource 替换 @Autowired
     * 第三种解决方案：在Mapper接口上加上@Repository注解，@Component也可以
     * 第四种解决方案：@RequiredArgsConstructor(onConstructor = @__(@Autowired))，同时删除Autowired注解
     * 第五种解决方案：关掉IDEA提示：不推荐
     * 第六种解决方案：下载mybatis插件
     * 综上：推荐第四种
     */
    private final UserMapper userMapper;

    @Override
    public UserDO selectById(Long id) {
        QueryWrapper<UserDO> query = new QueryWrapper<>();
        query.eq("id", id);
        return userMapper.selectOne(query);
    }

    @Override
    public List<UserDO> list() {
        QueryWrapper<UserDO> query = new QueryWrapper<>();
        List<UserDO> userDOList = userMapper.selectList(query);
        if (!CollectionUtils.isEmpty(userDOList)) {
            return userDOList;
        }
        return Collections.emptyList();
    }

    @Override
    public Long selectByName(String userName) {
        QueryWrapper<UserDO> query = new QueryWrapper<>();
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
        UserDO userDO = new UserDO();
        userDO.setId(id);
        userDO.setValid(ValidEnum.NOT_VALID.getValid());
        //逻辑删除字段不能更新，只能删除
        //userMapper.updateById(userDO);
        userMapper.deleteById(id);
    }
}
