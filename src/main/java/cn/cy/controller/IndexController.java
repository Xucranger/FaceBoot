package cn.cy.controller;

import cn.cy.domain.Student;
import cn.cy.service.GetStuInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @Autowired
    GetStuInfo getStuInfo;
    Student student = new Student();
    @RequestMapping("/index")
    public String toindex(Model model){
        student = getStuInfo.getstudent("dasfa");
        model.addAttribute("stu",student);
        model.addAttribute("start",false);
        model.addAttribute("msg","请将校园卡放到读卡器上!");
        return "index";
    }
}
