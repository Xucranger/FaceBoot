package cn.cy.controller;

import cn.cy.service.SocketCmn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/socket")
public class SocketController {
    @Autowired
    SocketCmn socketCmn;
    @RequestMapping("/startal")
    @ResponseBody
    public String startal(){
        System.out.println("hello!");
        String ans =  socketCmn.getsocket("我是嫩爹");
        return ans;
    }
}
