package top.suiyueran.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import top.suiyueran.user.dao.IUserDao;
import top.suiyueran.user.entity.UserDO;
import top.suiyueran.user.error.BusinessError;
import top.suiyueran.user.exception.BusinessException;
import top.suiyueran.user.service.IUserService;
import top.suiyueran.user.service.model.UserModel;
import top.suiyueran.user.util.MarkStringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 19:24 2019/11/9
 * @Modifyed by:
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public List<UserModel> list() {
        List<UserDO> userDOList = userDao.list();
        if (!CollectionUtils.isEmpty(userDOList)) {
            ArrayList<UserModel> userModelList = new ArrayList<>();
            for (UserDO userDO : userDOList) {
                UserModel userModel = new UserModel();
                BeanUtils.copyProperties(userDO, userModel);
                userModelList.add(userModel);
            }
            return userModelList;
        }
        return Collections.emptyList();
    }

    @Override
    public UserModel findById(Long id) {
        log.info("findById,id={}", id);
        if (id == null) {
            throw new BusinessException(BusinessError.REQUEST_PERAM_ERROR, "用户唯一标识参数确实");
        }
        UserDO userDO = userDao.selectById(id);
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO, userModel);
        return userModel;
    }

    @Override
    public UserModel findByCode(String userCode) {
        log.info("findByCode，userCode={}", userCode);
        if (StringUtils.isEmpty(userCode)) {
            throw new BusinessException(BusinessError.REQUEST_PERAM_ERROR, "用户编号参数确实");
        }
        UserDO userDO = userDao.selectByCode(userCode);
        if (userDO != null) {
            return convertFromUserDO(userDO);
        }
        return null;
    }

    @Override
    public Long findByName(String userName) {
        log.info("findByName，userName={}", userName);
        if (StringUtils.isEmpty(userName)) {
            throw new BusinessException(BusinessError.REQUEST_PERAM_ERROR, "用户名参数确实");
        }
        return userDao.selectByName(userName);
    }

    @Override
    public UserModel addUserDO(UserModel userModel) {
        UserDO insert = convertFromUserModel(userModel);
        insert.setUserCode(MarkStringUtil.getUniqueCode());
        Optional<UserDO> userDOP = userDao.insertUserDO(insert);
        return userDOP.map(this::convertFromUserDO).orElse(null);
    }

    private UserModel convertFromUserDO(UserDO userDO) {
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO, userModel);
        return userModel;
    }

    private UserDO convertFromUserModel(UserModel userModel) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userModel, userDO);
        return userDO;
    }

    @Override
    public UserModel modifyUserDO(UserModel userModel) {
        UserDO update = convertFromUserModel(userModel);
        Optional<UserDO> userDO = userDao.updateUserDO(update);
        return userDO.map(this::convertFromUserDO).orElse(null);
    }

    @Override
    public void removeUserModel(Long id) {
        userDao.deleteUserDO(id);
    }
}
