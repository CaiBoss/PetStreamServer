package cn.chuareed.pet_stream_server.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ： Gavin C
 * @date ： Created in 2021/1/18 10:51
 * @description ：帖子评论
 */
@Data
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private int userId;
    private int entityType; //被评论实体的类型  1——帖子  2——评论
    private int entityId;
    private int targetId;
    private String content;
    private int status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private long LikeCount;
    private int likeStatus;

    private Integer isDeleted; //逻辑删除，表示是否被删除  1——是  0——否
    private int postId; //冗余属性，方便通知
}
