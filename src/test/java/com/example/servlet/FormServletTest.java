//package com.example.servlet;
//
//import org.junit.jupiter.api.Test;
//
//import java.net.http.HttpClient;
//import java.net.http.HttpResponse;
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class FormServletTest {
//
//    @Test
//    public void whenPostRequestUsingHttpClient_thenCorrect()
//            throws Exception {
//
//        HttpClient client = new DefaultHttpClient();
//        HttpPost method = new HttpPost(
//                "http://localhost:8080/calculateServlet");
//
//        List<BasicNameValuePair> nvps = new ArrayList<>();
//        nvps.add(new BasicNameValuePair("height", String.valueOf(2)));
//        nvps.add(new BasicNameValuePair("weight", String.valueOf(80)));
//
//        method.setEntity(new UrlEncodedFormEntity(nvps));
//        HttpResponse httpResponse = client.execute(method);
//
//        assertEquals("Success", httpResponse
//                .getHeaders("Test")[0].getValue());
//        assertEquals("20.0", httpResponse
//                .getHeaders("BMI")[0].getValue());
//    }
//}