package top.clydezhou.lab.demo.spring.web.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.clydezhou.lab.demo.spring.utils.JsonUtils;
import top.clydezhou.lab.demo.spring.web.api.ResultCodeConstants;
import top.clydezhou.lab.demo.spring.web.api.SimpleResult;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Target all Controllers assignable to specific classes @ControllerAdvice(assignableTypes = {ControllerInterface.class, AbstractController.class})
 *
 * Target all Controllers within specific packages @ControllerAdvice("org.example.controllers")
 *
 * 参考：https://docs.spring.io/spring/docs/5.2.6.RELEASE/spring-framework-reference/web.html#mvc-ann-exceptionhandler
 * @author clyde
 * @date 2020-07-02 23:30
 */
@RestControllerAdvice
public class ExceptionHandleManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandleManager.class);

    @ExceptionHandler({Exception.class})
    public SimpleResult globalException(HttpServletRequest request, Exception ex) {
        // 这里是全局异常捕获逻辑，仅仅只能打印参数。具体的异常现场数据，建议在具体 controller 中处理。
        Map<String, String[]> parameterMap = request.getParameterMap();
        // 这里简单的打印request中的内容。
        LOGGER.error("catch globalException. parameterMap:{}", JsonUtils.toJson(parameterMap), ex);
        SimpleResult result = new SimpleResult();
        result.setResultCode(ResultCodeConstants.SERVER_ERROR);
        return result;
    }
}
