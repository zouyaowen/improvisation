package top.suiyueran.user.entity;


import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 2:13 2019/10/19
 * @Modifyed by:
 */
@Data
public class UserDO {
    private Long id;
    private String userCode;
    private String userName;
    private Integer age;
    private Integer gender;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer valid;
}
