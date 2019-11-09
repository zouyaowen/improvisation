package top.suiyueran.user.enums;

import lombok.Getter;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 19:28 2019/11/9
 * @Modifyed by:
 */
@Getter
public enum ValidEnum {
    /**
     * 有效
     */
    VALID(1, "有效"),
    /**
     * 无效
     */
    NOT_VALID(0, "无效");
    private Integer valid;
    private String desc;

    ValidEnum(Integer valid, String desc) {
        this.valid = valid;
        this.desc = desc;
    }
}
