package cn.cy.core;

import com.baidu.aip.face.AipFace;
import org.springframework.stereotype.Component;

@Component
public class AiFaceObject {
	public	String APP_ID = "25121269";
	public 	String API_KEY = "aygUXxENnVeycL23t2Nmcdei";
	public 	String SECRET_KEY = "ibAIlFtGTBGKhxCdONQVn9CvHmDEkvai";
	public String GROUD_LIST = "1234";
	    
	private AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

	public AipFace getClient(){
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);
		return client;
	}
	    
}
