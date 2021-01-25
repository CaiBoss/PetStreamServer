package cn.chuareed.pet_stream_server.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ： Gavin C
 * @date ： Created in 2021/1/18 11:17
 * @description ： 信息
 */
@Data
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private int fromId;
    private int toId;
    private String conversationId;
    private String content;
    private int readStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Integer isDeleted;//逻辑删除 表示是否已被删除 1——是 0——否
}
