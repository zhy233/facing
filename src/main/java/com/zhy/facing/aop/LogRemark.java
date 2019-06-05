package com.zhy.facing.aop;

import java.lang.annotation.*;

//日志注解
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogRemark {

    //日志打印模式 前缀打印: pref  后缀打印: suf  前后环绕打印 all
    String printType() default "all";
}
