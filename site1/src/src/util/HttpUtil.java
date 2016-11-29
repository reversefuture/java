package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/28.
 */
public class HttpUtil {
    public static String http(String url, Map<String, String> params) {
        //ctrl+space :auto complete
        URL u = null;
        HttpURLConnection con = null;
        StringBuffer sb = new StringBuffer();
       if (params!=null){
           for (Map.Entry<String, String> entry : params.entrySet()) {
               sb.append(entry.getKey());
               sb.append("=");
               sb.append(entry.getValue());
               sb.append("&");
           }
           sb.substring(0, sb.length() - 1);
       }
        System.out.println("send url:"+url);
        System.out.println("send data:"+sb);
        //try to send request ,ctrl+alt+t
        // 尝试发送请求
        try {

            u = new URL(url);
            con = (HttpURLConnection) u.openConnection();
            //// POST 只能为大写，严格限制，post会不识别
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
            osw.write(sb.toString());
            osw.flush();
            osw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }

        // 读取返回内容
        StringBuffer buffer = new StringBuffer();
        try {
            //一定要有返回值，否则无法把请求发送给server端。
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String temp;
            while ((temp = br.readLine()) != null) {
                buffer.append(temp);
                buffer.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
          /*  readLine()为阻塞方法，会等待服务器的响应，否则会一直等待
            con.setDoOutput(true); 这个表示是要发送请求到URL地址，没有这句话server是不会响应的。*/
        return buffer.toString();
    }
    //ctrl+shift+t: unit test

  /*  public static void main(String[] args) {

            Map parames = new HashMap<String, String>();
            parames.put("param1", "param1_value");
            parames.put("param2", "param2_value");
            parames.put("param3", "param3_value");
            // 如果地址栏中有aaa这个参数，则默认选择地址栏的，如果没有则选择添加的参数
            parames.put("aaa", "aaa_value");
            HttpUtil.http("http://localhost:8080/doGet?para1=dddd", parames);

    }*/
}