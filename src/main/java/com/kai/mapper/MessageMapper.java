package com.kai.mapper;

import com.kai.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface MessageMapper {

    //查询全部信息
    List<Message> getMessageList();

    //根据id查询信息
    Message getMessageById(int id);

    int newMessage(Message message);

    int upMessage(Message message);

    int deleteMessage(int id);


}
