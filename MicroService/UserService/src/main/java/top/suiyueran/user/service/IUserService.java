package top.suiyueran.user.service;

import top.suiyueran.user.service.model.UserModel;

import java.util.List;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 19:17 2019/11/9
 * @Modifyed by:
 */
public interface IUserService {
    /**
     * 获取所有的用户
     *
     * @return 用户列表
     */
    List<UserModel> list();

    /**
     * 主键查询
     *
     * @param id 系统ID
     * @return 用户业务实体
     */
    UserModel findById(Long id);

    /**
     * 主键查询
     *
     * @param userCode 用户编号
     * @return 用户业务实体
     */
    UserModel findByCode(String userCode);

    /**
     * 根据名字查询
     *
     * @param userName 名称
     * @return 用户主键
     */
    Long findByName(String userName);

    /**
     * 添加用户
     *
     * @param userModel 用户业务模型
     * @return 用户业务实体
     */
    UserModel addUserDO(UserModel userModel);

    /**
     * 修改用户
     *
     * @param userModel 用户业务模型
     * @return 用户业务实体
     */
    UserModel modifyUserDO(UserModel userModel);

    /**
     * 删除用户
     *
     * @param id 系统ID
     */
    void removeUserModel(Long id);
}
