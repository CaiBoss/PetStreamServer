package cn.chuareed.pet_stream_server.annotation;

import java.lang.annotation.*;

/**
 * @author ： Gavin C
 * @date ： Created in 2021/1/18 14:10
 * @description ： 不需要令牌
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TokenIgnore {
}
