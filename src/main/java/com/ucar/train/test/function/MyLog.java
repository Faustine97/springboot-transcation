package com.ucar.train.test.function;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE_USE, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface MyLog {
    String value() default "";

    String operation() default "";

    String result() default "";
}
