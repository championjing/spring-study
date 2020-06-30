package cn.coderstyle.demo.annotation.resolver;

import cn.coderstyle.demo.annotation.JSONParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : championjing
 * @ClassName: JSONParamAnnotationResolver
 * @Description: TODO
 * @Date: 3/5/2019 5:08 PM
 */
public class JSONParamAnnotationResolver implements HandlerMethodArgumentResolver {
    private static Logger LOGGER = LoggerFactory.getLogger(SessionAnnotationResolver.class);
    
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        LOGGER.info("初始化json参数解析器");
        JSONParam jsonParam = parameter.getParameterAnnotation(JSONParam.class);
        if( jsonParam == null ) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        JSONParam jsonParam = parameter.getParameterAnnotation(JSONParam.class);
        //是否必须
        boolean required = jsonParam.required();
        // 参数类型
        Class<?> parameterType = parameter.getParameterType();
        // 参数 的name，优先级 name > value > ParameterName
        String name = jsonParam.name();
        if ( StringUtils.isBlank(name) ) {
            name = jsonParam.value();
        }
        if ( StringUtils.isBlank(name) ) {
            name = parameter.getParameterName();
        }
        String parameter1 = request.getParameter(name);
        return null;
    }
}
