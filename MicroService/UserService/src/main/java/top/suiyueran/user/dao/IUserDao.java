package top.suiyueran.user.dao;

import top.suiyueran.user.entity.UserDO;

import java.util.List;
import java.util.Optional;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 19:32 2019/11/9
 * @Modifyed by:
 */
public interface IUserDao {
    /**
     * 主键查询
     * @param id 系统ID
     * @return 用户实体
     */
    UserDO selectById(Long id);

    /**
     * 获取所有的用户
     *
     * @return 用户列表
     */
    List<UserDO> list();

    /**
     * 根据名字查询
     * @param userName 名称
     * @return 用户主键
     */
    Long selectByName(String userName);

    /**
     * 根据名字查询
     * @param userCode 用户编号
     * @return 用户实体
     */
    UserDO selectByCode(String userCode);

    /**
     * 添加用户
     * @param userDO 用户实体模型
     * @return 用户实体
     */
    Optional<UserDO> insertUserDO(UserDO userDO);
    /**
     * 修改用户
     * @param userDO 用户业务模型
     * @return 用户业务实体
     */
    Optional<UserDO> updateUserDO(UserDO userDO);

    /**
     * 删除用户
     * @param id 系统ID
     */
    void deleteUserDO(Long id);
}
