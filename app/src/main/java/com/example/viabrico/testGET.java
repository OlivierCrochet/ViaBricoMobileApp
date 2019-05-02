package com.example.viabrico;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public abstract class testGET extends Context {

    RequestQueue queue = (RequestQueue) Volley.newRequestQueue(this);
    String url ="http://www.google.com";
    StringRequest strRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // Display the first 500 characters of the response string.
                    System.out.println("Response is: " + response.substring(0, 500));
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            System.out.println("That didn't work!");
        }
    });

    public Request<String> getQueue() {
        return queue.add(strRequest);
    }
}
