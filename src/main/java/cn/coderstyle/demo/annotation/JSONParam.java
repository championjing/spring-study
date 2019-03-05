package cn.coderstyle.demo.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author : championjing
 * @ClassName: JSONParam
 * @Description: TODO
 * @Date: 3/5/2019 5:05 PM
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JSONParam {
    /**
     * The name of the request attribute to bind to.
     */
    @AliasFor("name")
    String value() default "";

    /**
     *  下步考虑做成数组，用于自定义对象，最后返回对象
     * @return
     */
    @AliasFor("value")
    String name() default "";
    /**
     * Whether the parameter is required. Default is true, leading to an
     * exception thrown in case of the parameter missing in the request. Switch
     * this to false if you prefer a null in case of the parameter missing.
     * Alternatively, provide a {@link #defaultValue() defaultValue}, which
     * implicitly sets this flag to false.
     */
    boolean required() default true;
}
