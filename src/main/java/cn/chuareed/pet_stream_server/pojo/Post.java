package cn.chuareed.pet_stream_server.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ： Gavin C
 * @date ： Created in 2021/1/18 14:46
 * @description ： 帖子
 */
@Data
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private int userId;
    private String title;
    private String description;
    private int type;
    private int tag;
    private Date createTime;
    private int commentCount;
    private long likeCount;
    private int status;
    private Integer isDeleted;
}
