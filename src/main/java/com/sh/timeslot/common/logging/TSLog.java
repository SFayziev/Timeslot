package com.sh.timeslot.common.logging;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface TSLog {

    String description() default "UNKNOWN";

    String[] params() default {};
}
