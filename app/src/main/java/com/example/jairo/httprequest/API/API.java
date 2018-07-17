package com.example.jairo.httprequest.API;

import com.example.jairo.httprequest.Deserializer.CustomDeserializer;
import com.example.jairo.httprequest.Models.City;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String BASE_ICON_URL = "http://openweathermap.org/img/w/";
    public static final String EXTENSION_ICONS = ".png";
    private static final String APPYKEY = "6a8ddc60d0c984c6c344499d3334386a";
    private static Retrofit retrofit = null;

    public static Retrofit getApi() {
        if(retrofit == null) {
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(City.class, new CustomDeserializer());

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(builder.create()))
                    .build();
        }
        return retrofit;
    }

    public static String getAppykey(){
        return APPYKEY;
    }
}
