package com.javarush.task.task40.task4002;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* 
Опять POST, а не GET

Исправь ошибки в методе sendPost, чтобы он отправлял POST-запрос с переданными параметрами.
Примечание: метод main в тестировании не участвует, но чтобы программа корректно работала
локально, можешь зайти на сайт http://requestb.in/, создать свой RequestBin и использовать его в main.


Требования:
1. Метод sendPost должен создавать объект типа HttpPost с параметром url.
2. Метод sendPost должен вызвать метод setEntity у созданного объекта типа HttpPost.
3. В OutputStream соединения должны быть записаны переданные в метод sendPost параметры.
4. Метод sendPost должен использовать метод getHttpClient для получения HttpClient.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
//        solution.sendPost("http://requestb.in/1h4qhvv1", "name=zapp&mood=good&locale=&id=777");
        solution.sendPost("http://requestb.in/tu466itu", "name=zapp&mood=good&locale=&id=777");
    }

    public void sendPost(String url, String urlParameters) throws Exception {
        HttpClient client = getHttpClient();
        HttpPost request = new HttpPost(url);
        request.addHeader("User-Agent", "Mozilla/5.0");

        List<NameValuePair> valuePairs = new ArrayList<NameValuePair>();
        String[] s = urlParameters.split("&");
        for (int i = 0; i < s.length; i++) {
            String g = s[i];
            valuePairs.add(new BasicNameValuePair(g.substring(0,g.indexOf("=")), g.substring(g.indexOf("=")+1)));
        }

        request.setEntity(new UrlEncodedFormEntity(valuePairs));
        HttpResponse response = client.execute(request);
        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String responseLine;
        while ((responseLine = bufferedReader.readLine()) != null) {
            result.append(responseLine);
        }

        System.out.println("Response: " + result.toString());
    }

    protected HttpClient getHttpClient() {
        return HttpClientBuilder.create().build();
    }
}
