package cn.coderstyle.demo.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: SessionUserResolver
 * @Description: TODO
 * @Date: 2019/1/24 0024 14:04
 * @Auth: championjing
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SessionAnnotation {

    /**
     * The name of the request attribute to bind to.
     */
    String value() default "";

    /**
     * Whether the parameter is required. Default is true, leading to an
     * exception thrown in case of the parameter missing in the request. Switch
     * this to false if you prefer a null in case of the parameter missing.
     * Alternatively, provide a {@link #defaultValue() defaultValue}, which
     * implicitly sets this flag to false.
     */
    boolean required() default true;
}
