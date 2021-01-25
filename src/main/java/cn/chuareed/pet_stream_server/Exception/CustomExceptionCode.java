package cn.chuareed.pet_stream_server.Exception;

/**
 * @author ： Gavin C
 * @date ： Created in 2021/1/18 11:47
 * @description ：
 */
public enum CustomExceptionCode implements ICustomExceptionCode {
    SYSTEM_ERROR(100, "系统坏掉了，我先修修。"),
    TOKEN_ERROR(201, "您的登陆异常，请重新登录。"),
    TOKEN_EXPIRED(202, "您的登录已过期，请重新登录。"),
    PATH_ERROR(301, "您访问的页面离家出走了。"),
    COMMENT_ERROR(302, "您好像啥也没说。"),
    USER_NOT_EXIST(303, "喂喂喂找错人了。"),
    SEND_REPEAT(304, "您好像在自言自语。"),
    PERMISSION_ERROR(305, "管理员不让你这么干，你找他去。");

    private final Integer code;
    private final String message;

    CustomExceptionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
