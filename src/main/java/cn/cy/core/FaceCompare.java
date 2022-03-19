package cn.cy.core;

import cn.cy.domain.Image;
import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class FaceCompare {
    @Autowired
    AiFaceObject aiFaceObject;
    public String facematch(AipFace client, Image image1,Image image2){
        MatchRequest req1 = new MatchRequest(image1.getImgStr(),image1.getImgType());
        MatchRequest req2 = new MatchRequest(image2.getImgStr(),image2.getImgType());
        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
        requests.add(req1);
        requests.add(req2);
        JSONObject res = client.match(requests);
        return res.toString(2);
    }
}
