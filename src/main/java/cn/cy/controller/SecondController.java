package cn.cy.controller;

import cn.cy.domain.Student;
import cn.cy.service.GetStuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/second")
public class SecondController {
    @Autowired
    GetStuInfo getStuInfo;
    Student student = new Student();
    @RequestMapping("/tosecond")
    private String tosecond(Model model){
        student = getStuInfo.getstudent("ad");
        model.addAttribute("stu",student);
        model.addAttribute("msg","核对信息无误后点击确定");
        return  "second";
    }
}
