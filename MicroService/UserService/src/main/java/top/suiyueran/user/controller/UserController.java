package top.suiyueran.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import top.suiyueran.user.controller.dto.AddUserDto;
import top.suiyueran.user.controller.dto.ModifyUserDto;
import top.suiyueran.user.controller.vo.UserVO;
import top.suiyueran.user.service.IUserService;
import top.suiyueran.user.service.model.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 18:54 2019/11/9
 * @Modifyed by:
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public List<UserVO> list() {
        List<UserModel> list = userService.list();
        ArrayList<UserVO> userVOList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(list)) {
            for (UserModel userModel : list) {
                UserVO userVO = new UserVO();
                BeanUtils.copyProperties(userModel, userVO);
                userVOList.add(userVO);
            }
            return userVOList;
        }
        return null;
    }


    @GetMapping("/{id}")
    public UserVO findById(@PathVariable("id") Long id) {
        UserModel byId = userService.findById(id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(byId, userVO);
        return userVO;
    }

    @GetMapping("/code/{userCode}")
    public UserVO findByCode(@PathVariable("userCode") String code) {
        UserModel byId = userService.findByCode(code);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(byId, userVO);
        return userVO;
    }

    @PostMapping("/add")
    public UserVO addUser(@RequestBody AddUserDto addUserDto) {
        UserModel add = new UserModel();
        BeanUtils.copyProperties(addUserDto, add);
        UserModel userModel = userService.addUserDO(add);
        return convertFromModel(userModel);
    }

    @PutMapping("/modify")
    public UserVO modifyUser(@RequestBody ModifyUserDto modifyUserDto) {
        UserModel modify = new UserModel();
        BeanUtils.copyProperties(modifyUserDto, modify);
        UserModel userModel = userService.modifyUserDO(modify);
        return convertFromModel(userModel);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Long id) {
        userService.removeUserModel(id);
    }


    private UserVO convertFromModel(UserModel userModel) {
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }


}
