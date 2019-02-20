package com.lhf.dynamicDB;

import java.lang.annotation.*;

/**
 * @Author lhf
 * @Description
 * @Date 2019/1/29 19:19
 * @Version 1.0
 **/
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value();
}
