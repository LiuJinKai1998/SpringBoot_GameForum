package com.kai.service;

import com.kai.mapper.MessageMapper;
import com.kai.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageMapper messageMapper;

    public List<Message> getMessageList() {
        return messageMapper.getMessageList();
    }

    public Message getMessageById(int id){
        return messageMapper.getMessageById(id);
    }

    public int newMessage(Message message){
        return messageMapper.newMessage(message);
    }

    public int upMessage(Message message) {
        return messageMapper.upMessage(message);
    }

    public int deleteMessage(Integer id) {
        return messageMapper.deleteMessage(id);
    }


}
