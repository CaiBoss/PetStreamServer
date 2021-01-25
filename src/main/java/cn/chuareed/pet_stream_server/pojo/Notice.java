package cn.chuareed.pet_stream_server.pojo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ： Gavin C
 * @date ： Created in 2021/1/18 15:03
 * @description ： 通知
 */
@Data
public class Notice {
    private String topic;       //通知主题
    private int noticeUserId;   //通知触发用户ID
    private int entityType;     //通知类型：点赞|评论|关注
    private int entityId;       //通知实体ID
    private int recvUserId;     //通知接受用户ID
    private Map<String, Object> data = new HashMap<>();
}
