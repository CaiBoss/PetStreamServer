package cn.chuareed.pet_stream_server.Exception;

import lombok.Getter;

/**
 * @author ： Gavin C
 * @date ： Created in 2021/1/18 12:40
 * @description ： 全局自定义异常
 */
@Getter
public class CustomException extends RuntimeException {
    private final Integer code;
    private String message;

    public CustomException(final ICustomExceptionCode customExceptionCode) {
        this.code = customExceptionCode.getCode();
        this.message = customExceptionCode.getMessage();
    }

    public CustomException(String message) {
        super(message);
        this.code = 1;
    }
}
