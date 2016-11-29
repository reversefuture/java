package util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/28.
 */
public class testUtil {
    public static void main(String[] args) {
        Map parames = new HashMap<String, String>();
        parames.put("param1", "param1_value");
        parames.put("param2", "param2_value");
        parames.put("param3", "param3_value");
        // 如果地址栏中有aaa这个参数，则默认选择地址栏的，如果没有则选择添加的参数
        parames.put("aaa", "aaa_value");
        HttpUtil.http("http://localhost:8080/doGet?para1=dddd", parames);

    }
}
