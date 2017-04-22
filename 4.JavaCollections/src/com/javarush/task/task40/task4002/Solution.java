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

//Валидатор говорит след:В OutputStream соединения должны быть записаны переданные в метод sendPost параметры.

// В условии задачи нигде не говорится о том, что здесь используем Apache HttpComponents
// Методом гугления, нашел, что надо скачать и подключить:
// http://hc.apache.org/downloads.cgi
// Однако, в условии задачи требуется - см 3 пункт. Но записать можно только через внутр объект реквеста Entity.
//
// И да у Entity есть два метода writeTo (OutputStream) и getContent возвращающий InputStream, но как я понимаю они
// предназначены для получения значений request, а не для записи. А Чтобы записать параметры в request есть
// метод setEntity и в него можно положить объект реализующий Interface HttpEntity.
// Объекты этих классов можно класть в setEntity:
// AbstractHttpEntity, BasicHttpEntity, BufferedHttpEntity, ByteArrayEntity,
// EntityTemplate, FileEntity, HttpEntityWrapper, InputStreamEntity, SerializableEntity, StringEntity

//Т.е. в упор не видно OutputStream

//Или тут речь идет о получении данных после выполнения запроса.Т.е. записать в OutputStream полученные данные после
//отсылки Поста. Или реализовать свой OutputStream Entity. Вообщем не ясно.



public class Solution {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
//        solution.sendPost("http://requestb.in/1h4qhvv1", "name=zapp&mood=good&locale=&id=777");
        solution.sendPost("http://requestb.in/tu466itu", "name=zapp&mood=good&locale=&id=777");
    }

    public void sendPost(String url, String urlParameters) throws Exception {
        // Create the request
        HttpPost request = new HttpPost(url);
        request.addHeader("User-Agent", "Mozilla/5.0");

        //Parse param from urlParameters
        String[] paramPairs = urlParameters.split("&");
        if (paramPairs.length>0) {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            for (String s : paramPairs) {
                String[] pair = s.split("=");

                if (pair.length == 2) {
                    String name = pair[0];
                    String value = pair[1];
                    nameValuePairs.add(new BasicNameValuePair(name, value));
                }
            }
            request.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        }

        //For test
        OutputStream outstream = new ByteArrayOutputStream();
        HttpEntity entity = request.getEntity();
        request.getEntity().writeTo(outstream);
        outstream.close();
        //System.out.println(outstream.toString());

        //Send request
        HttpClient client = getHttpClient();
        HttpResponse response = client.execute(request);
        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());

        //Get Content from response
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
