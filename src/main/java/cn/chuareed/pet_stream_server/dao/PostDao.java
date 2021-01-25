package cn.chuareed.pet_stream_server.dao;

import cn.chuareed.pet_stream_server.pojo.Post;

public interface PostDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);
}