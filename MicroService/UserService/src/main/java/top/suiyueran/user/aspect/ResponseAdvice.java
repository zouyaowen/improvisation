package top.suiyueran.user.aspect;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import top.suiyueran.user.annotation.IgnoreResponseAdvice;
import top.suiyueran.user.response.CommonResponse;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 18:59 2019/11/9
 * @Modifyed by:
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        if (returnType.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        if (returnType.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        CommonResponse<Object> res = new CommonResponse<>(200, "success");
        if (null == body) {
            return res;
        } else if (body instanceof CommonResponse) {
            res = (CommonResponse<Object>) body;
        } else {
            res.setData(body);
        }
        return res;
    }
}
