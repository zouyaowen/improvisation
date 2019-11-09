package top.suiyueran.user.exception;

import top.suiyueran.user.error.BusinessError;
import top.suiyueran.user.error.CommonError;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 19:09 2019/11/9
 * @Modifyed by:
 */
public class BusinessException extends RuntimeException implements CommonError {

    private BusinessError businessError;

    public BusinessException(BusinessError businessError) {
        super();
        this.businessError = businessError;
    }

    public BusinessException(BusinessError businessError, String errMessage) {
        super();
        this.businessError = businessError;
        this.businessError.setErrMsg(errMessage);
    }

    @Override
    public String getMessage() {
        return this.businessError.getErrMsg();
    }

    @Override
    public Integer getErrCode() {
        return this.businessError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.businessError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.businessError.setErrMsg(errMsg);
        return this;
    }
}
