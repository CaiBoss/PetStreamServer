package cn.chuareed.pet_stream_server.common;

import cn.chuareed.pet_stream_server.Exception.CustomException;
import cn.chuareed.pet_stream_server.Exception.CustomExceptionCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author ： Gavin C
 * @date ： Created in 2021/1/18 13:41
 * @description ： 全局异常处理
 */
@Log4j2
public class GlobalExceptionHandler {
    /**
     * @param e CustomException
     * @return ResultWrapper
     * @author Gavin C
     * @date 2021/1/18 13:43
     * @description 处理自定义异常
     */
    @ExceptionHandler(CustomException.class)
    public ResultWrapper<String> handleCustomException(CustomException e) {
        return new ResultWrapper<>(e);
    }

    /**
     * @return ResultWrapper
     * @author Gavin C
     * @date 2021/1/18 14:08
     * @description 处理非预知的运行时异常
     * @param    e    Exception
     */
    public ResultWrapper<String> handleSystemException(Exception e) {
        log.error(e.toString());
        return new ResultWrapper<>(CustomExceptionCode.SYSTEM_ERROR);
    }
}
