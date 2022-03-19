package cn.cy.service.imp;
import cn.cy.service.SocketCmn;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

@Service
public class SocketCmnImp implements SocketCmn {
    @Override
    public String getsocket(String args) {
        Socket socket = null;
        String Code_Adress = "127.0.0.1";
        String str = "";
        try {
            socket = new Socket(Code_Adress,9007);
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            outputStream.write(args.getBytes());
            int len = inputStream.read(bytes);
            str = new String(bytes,0,len);
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
