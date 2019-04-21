package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangqianlong
 * @create 2019-04-17 16:55
 */
@Target({ElementType.TYPE,ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface Value {

    String values() default "";
}
