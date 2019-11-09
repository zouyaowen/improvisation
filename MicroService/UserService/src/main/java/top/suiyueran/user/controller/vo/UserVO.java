package top.suiyueran.user.controller.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 20:43 2019/11/9
 * @Modifyed by:
 */
public class UserVO {
    @JsonIgnore
    private Long id;
    private String userCode;
    private String userName;
    private Integer age;
    private Integer gender;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
