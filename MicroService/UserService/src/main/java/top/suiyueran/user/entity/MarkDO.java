package top.suiyueran.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.free.core.domin.BaseDO;
import lombok.Data;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 22:23 2019/11/11
 * @Modifyed by:
 */
@Data
@TableName("mark_mark")
public class MarkDO extends BaseDO {
    /**
     * 标签编号
     */
    private String markCode;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 标签名称
     */
    private String markName;
    /**
     * 标签URL
     */
    private String markUrl;
    /**
     * 标签排序
     */
    private String markSort;
}
