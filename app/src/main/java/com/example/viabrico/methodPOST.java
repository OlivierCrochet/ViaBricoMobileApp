package com.example.viabrico;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;
public class methodPOST {
    public static void main(String[] args) {
        try {
            methodPOST.call_me();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void call_me() throws Exception {
        URL url = new URL("https://viabricosrm.herokuapp.com/fournisseur");
        Map params = new LinkedHashMap<>();
        params.put("name", "Jinu Jawad");
        params.put("email", "helloworld@gmail.com");
        params.put("CODE", 1111);
        params.put("message", "Hello Post Test success");
        StringBuilder postData = new StringBuilder();
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);
        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (int c; (c = in.read()) >= 0;)
            sb.append((char)c);
        String response = sb.toString();
        JSONObject myResponse = new JSONObject(response.toString());
        System.out.println("url- "+myResponse.getString("url"));
        JSONObject form_data = myResponse.getJSONObject("form");

    }
}
