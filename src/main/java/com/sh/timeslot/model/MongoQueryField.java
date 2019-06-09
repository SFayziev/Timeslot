package com.sh.timeslot.model;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD})
public @interface MongoQueryField {

    String name() default "";



}
