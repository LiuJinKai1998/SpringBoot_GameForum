package com.kai.controller;

import com.kai.pojo.Message;
import com.kai.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;


    @RequestMapping("/getMessageList")
    public String getMessageList(Model model){
        List<Message> messageList = messageService.getMessageList();
        model.addAttribute("messageList",messageList);
        System.out.println(messageList);
        return "admin/messagelist";

    }


    //跳转到新增
    @GetMapping("/addmessage")
    public String toaddmessage(){
        return "admin/addmessage";
    }

    //新增
    @PostMapping("/newMessage")
    public String newMessage(Message message){
        System.out.println("newMessage"+ message);
        messageService.newMessage(message);
        return "redirect:/getMessageList";
    }

    //删除
    @GetMapping("/deleteMessage/{id}")
    public String deleteMessage(@PathVariable int id){
        messageService.deleteMessage(id);
        return "redirect:/getMessageList";
    }

    //跳转到修改
    @GetMapping("/upMessage/{id}")
    public String upMessage(@PathVariable int id, Model model) {
        //查出原来的数据
        Message messageById = messageService.getMessageById(id);
        model.addAttribute("messageById",messageById);
        return "admin/upmessage";
    }

    //修改信息
    @PostMapping("/upMessage")
    public String upMessage(Message message){
        messageService.upMessage(message);
        System.out.println(message);
        return "redirect:/getMessageList";
    }

    //个人信息界面的留言新增
    @PostMapping("/userMessage")
    public String userMessage(Message message){
        System.out.println("userMessage"+ message);
        messageService.newMessage(message);
        return "redirect:/home";
    }




}

