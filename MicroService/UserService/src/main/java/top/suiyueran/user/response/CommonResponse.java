package top.suiyueran.user.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import top.suiyueran.user.error.BusinessError;
import top.suiyueran.user.exception.BusinessException;

import java.util.HashMap;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 18:56 2019/11/9
 * @Modifyed by:
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> {
    /**
     * code为200表示成功，-1为参数异常，其他为业务或系统异常
     */
    private Integer code;
    /**
     * 错误或者成功信息
     */
    private String message;
    private T data;

    public CommonResponse() {
    }

    public CommonResponse(T data) {
        this();
        this.code = 200;
        this.message = "success";
        this.data = data;
    }

    public CommonResponse(Integer code, String message) {
        this();
        this.code = code;
        this.message = message;
    }

    public CommonResponse(Integer code, T data) {
        this();
        this.code = code;
        this.data = data;
    }

    public CommonResponse(BusinessError businessError) {
        this();
        this.code = businessError.getErrCode();
        this.message = businessError.getErrMsg();
    }

    public CommonResponse(BusinessException businessException) {
        this();
        this.code = businessException.getErrCode();
        this.message = businessException.getErrMsg();
    }

    @SuppressWarnings("unchecked")
    public static <T> CommonResponse<T> success() {
        CommonResponse<String> success = success(null);
        return (CommonResponse<T>) success;
    }

    public static <T> CommonResponse<T> success(T object) {
        return new CommonResponse<T>(object);
    }

    public static <T> CommonResponse<T> success(Integer code, T object) {
        return new CommonResponse<T>(code, object);
    }

    public static <T> CommonResponse<T> error(Integer code, String message) {
        return new CommonResponse<T>(code, message);
    }

    public static <T> CommonResponse<T> error(BusinessError businessError) {
        return new CommonResponse<T>(businessError);
    }

    public static <T> CommonResponse<T> error(BusinessException businessException) {
        return new CommonResponse<T>(businessException);
    }

    /**
     * 返回值中以键值对的形式存储数据
     */
    @SuppressWarnings("unchecked")
    public void appendData(String key, Object object) {
        if (data == null) {
            data = (T) new HashMap<String, Object>();
        }
        HashMap<String, Object> map = (HashMap<String, Object>) data;
        map.put(key, object);
    }
}
