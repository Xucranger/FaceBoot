package cn.cy.controller;

import cn.cy.domain.Image;
import cn.cy.domain.Result;
import cn.cy.domain.Student;
import cn.cy.domain.User;
import cn.cy.service.FaceMatch;
import cn.cy.service.FaceRegister;
import cn.cy.service.FaceSearch;
import cn.cy.service.GetStuInfo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    FaceSearch faceSearch;
    @Autowired
    FaceRegister faceRegister;
    @Autowired
    FaceMatch faceMatch;
    @Autowired
    GetStuInfo getStuInfo;
    @RequestMapping("/login")
    @ResponseBody
    public Result login(Image image, HttpSession session){
        User user = new User();
        Result result = faceSearch.faceLogin(image);
        user.setUserId(result.getUserId());
        session.setAttribute("user",user);
        return result;
    }

    @RequestMapping("/register")
    @ResponseBody
    public Result register(Image image){
        Result result = faceRegister.register(image);
        return result;
    }
    @RequestMapping("/match")
    @ResponseBody
    public Result match(@RequestBody Map<String,Object> map, Model model){
       Image img1 = new Image();
       Image img2 = new Image();

        img1 = JSON.parseObject(map.get("img1").toString(),Image.class);
        img2 = JSON.parseObject(map.get("img2").toString(),Image.class);
//        System.out.println("img1" + map.get("img1").toString());
//        System.out.println("img2" + map.get("img2").toString());

        Result result = faceMatch.faceMatch(img1, img2);

        boolean isstart = result.isStart();
        System.out.println(isstart);
        if(isstart)
        {
            Student student = new Student();
            student = getStuInfo.getstudent("dsdf");
            String str = JSON.toJSONString(student);
            model.addAttribute("stu",student);
            model.addAttribute("start",true);
            model.addAttribute("msg","核对信息无误后点击确定");

        }
        return result;
    }
}
