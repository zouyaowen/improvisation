package top.suiyueran.user.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import top.suiyueran.user.error.BusinessError;
import top.suiyueran.user.response.CommonResponse;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 19:12 2019/11/9
 * @Modifyed by:
 */
@RestControllerAdvice
@Slf4j
public class ControllerExceptionAdvice {
    /**
     * 错误信息处理
     *
     * @param ex 异常对象
     * @return 统一异常信息返回
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResponse<?> handleRuntimeException(RuntimeException ex) {
        if (ex instanceof BusinessException) {
            BusinessException businessException = (BusinessException) ex;
            return CommonResponse.error(businessException);
        } else {
            log.error("errMsg={}", ex.getMessage());
            log.error("execption className={}", ex.getClass().getName());
            return CommonResponse.error(BusinessError.UNKNOW_ERROR);
        }
    }

    /**
     * 404异常处理
     * @param ex 异常对象
     * @return 异常统一JSON返回
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommonResponse<?> handleRuntimeException(NoHandlerFoundException ex) {
        log.error("404异常信息", ex);
        log.error("errMsg={}", ex.getMessage());
        return CommonResponse.error(BusinessError.REQUEST_URL_NOT_EXIST);
    }

    /**
     * 请求方法找不到异常
     *  @param ex 异常对象
     * @return 异常统一JSON返回
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public CommonResponse<?> handleRuntimeException(HttpRequestMethodNotSupportedException ex) {
        log.error("405异常信息", ex);
        log.error("errMsg={}", ex.getMessage());
        return CommonResponse.error(BusinessError.REQUEST_METHOD_NOT_ALLOWED);
    }
}
