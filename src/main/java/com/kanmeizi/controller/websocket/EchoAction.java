package com.kanmeizi.controller.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liuzhengyang on 2014/12/19.
 */
@Controller
public class EchoAction {
    @RequestMapping("/echo")
    public String echo(){
        return "echo";
    }
}
