package cn.coderstyle.demo.annotation;

import cn.coderstyle.demo.annotation.resolver.SessionAnnotationResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @ClassName: WebListenerConfiguration
 * @Description: TODO
 * @Date: 2019/1/31 0031 16:37
 * @author: championjing
 */
@Configuration
public class AnnotationWebListenerConfiguration extends WebMvcConfigurerAdapter {
    private final static Logger logger = LoggerFactory.getLogger(AnnotationWebListenerConfiguration.class);

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        logger.info("添加session解析器");
        argumentResolvers.add(new SessionAnnotationResolver());
    }
}
