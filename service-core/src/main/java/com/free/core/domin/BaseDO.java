package com.free.core.domin;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 22:06 2019/11/11
 * @Modifyed by:
 */
@Data
public class BaseDO implements Serializable {
    private Long id;
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
    @TableLogic
    private Integer deleted;
}
