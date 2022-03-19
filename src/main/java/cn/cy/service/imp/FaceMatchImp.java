package cn.cy.service.imp;


import cn.cy.core.AiFaceObject;
import cn.cy.core.FaceCompare;
import cn.cy.domain.Image;
import cn.cy.domain.Result;
import cn.cy.service.FaceMatch;
import com.baidu.aip.face.AipFace;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaceMatchImp implements FaceMatch {
    @Autowired
    AiFaceObject aiFaceObject;
    @Autowired
    FaceCompare faceCompare;
    //对比人脸
    @Override
    public Result faceMatch(Image image1, Image image2) {
        Result message  = new Result();
        JSONObject result = match(image1,image2);
        int error_code= result.getInt("error_code");

        if(error_code == 0){

            System.out.println(result.getJSONObject("result"));
            JSONObject resultlist = result.getJSONObject("result");
            double score = resultlist.getDouble("score");
            if(score>80)
            {
                message.setStart(true);
                message.setMsg("对比成功");
                System.out.println("对比成功！");
            }
        }
        else {
            System.out.println(error_code);
        }
        return message;
    }

    private JSONObject match(Image image1, Image image2){

        AipFace client = aiFaceObject.getClient();
        String res = faceCompare.facematch(client,image1,image2);
        JSONObject result = new JSONObject(res);
        return  result;
    }
}
