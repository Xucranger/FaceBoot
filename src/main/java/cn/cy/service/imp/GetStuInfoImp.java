package cn.cy.service.imp;

import cn.cy.domain.Image;
import cn.cy.domain.Student;
import cn.cy.service.GetStuInfo;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class GetStuInfoImp  implements GetStuInfo {

    @Override
    public Student getstudent(String Id) {
        Student student = new Student();
        student.setCollege("信息学院");
        student.setSid("2019030160");
        student.setSname("徐鹤翔");
        student.setMajor("计算机科学");
        student.setClassinfo("1903");
        Image simg = new Image();
        try{
            InputStream in = new FileInputStream("F:\\myprojects\\SpringBoot_IDEA\\facelogin_boot\\src\\main\\java\\cn\\cy\\service\\imp\\1.png");
            byte[] data = new byte[in.available()];
            in.read(data);
            in.close();
            BASE64Encoder encoder =new BASE64Encoder();
            simg.setImgStr(encoder.encode(data));
            simg.setImgType("BASE64");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        student.setImgstr(simg.getImgStr());
        return student;
    }
}
