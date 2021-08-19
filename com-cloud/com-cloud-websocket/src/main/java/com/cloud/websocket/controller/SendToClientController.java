package com.cloud.websocket.controller;

import com.cloud.websocket.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * 原文参考：https://blog.csdn.net/qq_35387940/article/details/93483678
*/
@Controller
public class SendToClientController {
    @Autowired
    WebSocket webSocket;


    /**
     * @Desc: 推送单个人
    */
    @ResponseBody
    @GetMapping("/sendTo")
    public String sendTo(@RequestParam("userId") String userId, @RequestParam("msg") String msg) throws IOException {
        webSocket.sendMessageTo(msg,userId);
        return "推送成功";
    }

    /**
     * @Desc:推送所有人
    */
    @ResponseBody
    @GetMapping("/sendAll")
    public String sendAll(@RequestParam("msg") String msg) throws IOException {
        String fromUserId="system";//其实没用上
        webSocket.sendMessageAll(msg,fromUserId);
        return "推送成功";
    }
}
