package com.sist.news;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

@Component
public class NewsManager {

    public static void main(String[] args) {
		NewsManager m=new NewsManager();
		List<NewsVO> list=m.newsFind("맛집");
		for(NewsVO vo:list)
		{
			System.out.println(vo.getTitle());
			System.out.println(vo.getDescription());
		}
	}
    public static List<NewsVO> newsFind(String fd) {
    	List<NewsVO> list=new ArrayList<NewsVO>();
        String clientId = "sBo0YizSUlQV0KMd5VAv"; //애플리케이션 클라이언트 아이디값"
        String clientSecret = "QXDa733yiz"; //애플리케이션 클라이언트 시크릿값"


        String text = null;
        try {
            text = URLEncoder.encode(fd, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }


        String apiURL = "https://openapi.naver.com/v1/search/news.json?display=100&query=" + text;    // json 결과
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과


        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL,requestHeaders);
        
        //System.out.println(responseBody);
        try
        {
        	JSONParser jp=new JSONParser();
        	JSONObject root=(JSONObject)jp.parse(responseBody);
        	JSONArray arr=(JSONArray)root.get("items");
        	for(int i=0;i<arr.size();i++)
        	{
        		JSONObject obj=(JSONObject)arr.get(i);
        		NewsVO vo=new NewsVO();
        		vo.setTitle((String)obj.get("title"));
        		vo.setAuthor((String)obj.get("author"));
        		vo.setDescription((String)obj.get("description"));
        		vo.setRegdate((String)obj.get("pubDate"));
        		list.add(vo);
        	}
        }catch(Exception ex) {}
        return list;
    }


    private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }


            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 에러 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }


    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }


    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);


        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();


            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }


            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}
