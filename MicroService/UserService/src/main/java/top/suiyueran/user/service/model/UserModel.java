package top.suiyueran.user.service.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 19:17 2019/11/9
 * @Modifyed by:
 */
@Data
public class UserModel {
    private Long id;
    private String userCode;
    private String userName;
    private Integer age;
    private Integer gender;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
