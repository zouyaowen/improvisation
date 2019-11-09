package top.suiyueran.user.controller.dto;

import lombok.Data;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 2:40 2019/11/10
 * @Modifyed by:
 */
@Data
public class ModifyUserDto {
    private Long id;
    private String userName;
    private Integer age;
    private Integer gender;
}
