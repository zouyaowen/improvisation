package top.suiyueran.user.error;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 19:04 2019/11/9
 * @Modifyed by:
 */
public interface CommonError {
    /**
     * 获取错误码
     *
     * @return
     */
    Integer getErrCode();

    /**
     * 获取错误信息
     *
     * @return
     */
    String getErrMsg();

    /**
     * 获取当前错误对象
     *
     * @param errMsg
     * @return
     */
    CommonError setErrMsg(String errMsg);
}
