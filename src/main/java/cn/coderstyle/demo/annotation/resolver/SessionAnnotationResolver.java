package cn.coderstyle.demo.annotation.resolver;

import cn.coderstyle.demo.annotation.SessionAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: SessionUserResolver
 * @Description: TODO
 * @Date: 2019/1/24 0024 14:11
 * @Auth: championjing
 */
@Component
public class SessionAnnotationResolver implements HandlerMethodArgumentResolver {
    private static Logger logger = LoggerFactory.getLogger(SessionAnnotationResolver.class);


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
    	logger.info("判断需不需要参数解析");
        SessionAnnotation sessionUser = parameter.getParameterAnnotation(SessionAnnotation.class);
        if( sessionUser == null ) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest request, WebDataBinderFactory binderFactory) throws Exception {
        logger.info("解析用户信息");
        HttpServletRequest httpReq = (HttpServletRequest) request.getNativeRequest();
        SessionAnnotation boxSessionAttribute = parameter.getParameterAnnotation(SessionAnnotation.class);
        String key = boxSessionAttribute.value();
        Class<?> type = parameter.getParameterType();
       //TODO 逻辑处理
        return null;
    }
}
