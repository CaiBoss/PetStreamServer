package cn.chuareed.pet_stream_server.common;

import cn.chuareed.pet_stream_server.Exception.CustomException;
import cn.chuareed.pet_stream_server.Exception.CustomExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ： Gavin C
 * @date ： Created in 2021/1/18 11:41
 * @description ： Rest统一返回格式
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultWrapper implements Serializable {
    private int code;
    private String msg;
    private Object data;

    public ResultWrapper(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultWrapper(CustomException e) {
        this.code = e.getCode();
        this.msg = e.getMessage();
    }

    public ResultWrapper(CustomExceptionCode e) {
        this.code = e.getCode();
        this.msg = e.getMessage();
    }

    public static ResultWrapper success(String msg) {
        return new ResultWrapper(200, msg);
    }

    public static ResultWrapper success(Object data) {
        return new ResultWrapper(200, "", data);
    }

    public static ResultWrapper error(String msg) {
        return new ResultWrapper(105, msg);
    }
}
