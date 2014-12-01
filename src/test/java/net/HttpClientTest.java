package net;

import com.kanmeizi.util.MD5Util;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by liuzhengyang on 14-11-27.
 */
public class HttpClientTest {

    private static final Logger logger = Logger.getLogger(HttpClientTest.class);

    HttpClient client;
    PostMethod post;
    GetMethod get;
    String username;
    String password;

    @Before
    public void setUp() {
        client = new HttpClient();
    }

    @Test
    public void testPostSend() throws IOException {
        username = "10241092";
        password = "qwe123";
        password = MD5Util.encrypt(password).substring(8, 24);
        get = new GetMethod("http://202.112.136.131/cgi-bin/do_login?uname=10241092&pass2=123");
        post = new PostMethod("http://202.112.136.131/cgi-bin/do_login");
        NameValuePair[] data = new NameValuePair[]{
                new NameValuePair("username", "10241092")
                , new NameValuePair("password", "10241092")
        };
        post.setRequestBody(data);
        post.setRequestHeader("Content-Type", "text/html; charset=utf-8");
        client.executeMethod(post);
        logger.info(post.getResponseBodyAsString());
    }

    @Test
    public void testGetSend() throws IOException {

        int count = 0;
        username = "10241092";
        String post4;
//        for (int i = 0; i < 100000000; i++) {
//            if (i < 10) {
//                post4 = "0000000" + i;
//            } else if (i < 100) {
//                post4 = "000000" + i;
//            } else if (i < 1000) {
//                post4 = "00000" + i;
//            } else if (i < 10000) {
//                post4 = "0000" + i;
//            } else if (i < 100000) {
//                post4 = "000" + i;
//            } else if (i < 1000000) {
//                post4 = "00" + i;
//            } else if (i < 10000000) {
//                post4 = "0" + i;
//            } else {
//                post4 = "" + i;
//            }

            password = "lzy123";
            logger.info("pasword : " + password);
            password = MD5Util.encrypt(password).substring(8, 24);
            get = new GetMethod("http://202.112.136.131/cgi-bin/do_login?drop=0&type=1&n=100&username=" + username + "&password=" + password);
            client.executeMethod(get);
            logger.info(get.getResponseBodyAsString());
            if (this.valid(get.getResponseBodyAsString())) {
                logger.info("found" + " m : " );
//                break;
            }
            get.releaseConnection();
        }

//    }



    @After
    public void tearDown() {
    }

private static final String BLANK_STR = "";

    //    @Test
//    public void testGenerateBirthDay(){
//        Assert.assertEquals("19910218", generateBirthday(1991, 2, 18));
//    }
    private String generateBirthday(int m, int d) {
        String month = String.valueOf(m);
        if (m < 10) {
            month = "0" + month;
        }
        String day = String.valueOf(d);
        if (d < 10) {
            day = "0" + day;
        }
        return month + day;
    }

    private String generateAccount() {
        return "SY1424106";
    }

    private boolean valid(String responseCode) {
        if (responseCode == null && responseCode.equals("")) {
            return false;
        }
        if (pattern.matcher(responseCode).matches()) {
            return true;
        } else {
            for (String s : validStrs) {
                if (responseCode.equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

private static String regex = "^[\\d]+$";
private static Pattern pattern = Pattern.compile(regex);

private String[] validStrs = new String[]{
        "flux_error",  // 流量不足
        "usernum_error", // 用户数已达上限
        "online_num_error", // 该帐号的登录人数已超过限额
        "ip_error", // ip_error
        "sync_error", // 正在等待同步
};
}
