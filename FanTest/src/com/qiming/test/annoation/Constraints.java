package com.qiming.test.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义一个约束注解
 */

//作用在属性上
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {

  boolean primaryKey() default false;
  boolean allowNull() default true;
  boolean unique() default false;

}
