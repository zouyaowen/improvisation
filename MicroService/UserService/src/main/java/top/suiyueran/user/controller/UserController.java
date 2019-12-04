package top.suiyueran.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api("用户接口")
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation("获取所有数据")
    @GetMapping("/list")
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

    @ApiOperation("根据ID获取数据")
    @GetMapping("/{id}")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "long")
    public UserVO findById(@PathVariable("id") Long id) {
        UserModel byId = userService.findById(id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(byId, userVO);
        return userVO;
    }

    @ApiOperation("根据编号获取数据")
    @GetMapping("/code/{userCode}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userCode", value = "用户编号", required = true, dataType = "String")
    })
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
