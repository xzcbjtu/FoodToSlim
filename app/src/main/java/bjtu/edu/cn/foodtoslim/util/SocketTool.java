package bjtu.edu.cn.foodtoslim.util;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Properties;

/**
 * Created by xuzhi on 2016.5.19.
 */
public class SocketTool {

    private Socket connSocket = null;
    private static SocketTool tool = null;
    private SocketTool() {

        Properties prop = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(System.getProperty("user.dir")+"/app/src/main/assets/socket.properties"));
            prop.load(in);
            connSocket = new Socket(prop.getProperty("ip"),Integer.parseInt(prop.getProperty("port")));
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SocketTool getSocketTool(){
        if(tool==null){
            return tool= new SocketTool();
        }else {
            return tool;
        }
    }

    public String conversation(String content){
        String answer = null;
        try {
            BufferedReader answerReader = new BufferedReader(new InputStreamReader(connSocket.getInputStream()));
            PrintWriter askWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(connSocket.getOutputStream())),true);
            askWriter.write(content);
            askWriter.flush();
            answer = answerReader.readLine();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;
    }
}
