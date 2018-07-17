package com.example.jairo.httprequest.API.APIServices;

import com.example.jairo.httprequest.Models.City;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherService {
//    http://api.openweathermap.org/data/2.5/weather?q=Aguascalientes,mx&APPID=6a8ddc60d0c984c6c344499d3334386a
    @GET("weather")
    Call<City> getCity(@Query("q") String city, @Query("appid") String key);

    @GET("weather")
    Call<City> getCityCelsius(@Query("q") String city, @Query("units") String value, @Query("lang") String lang, @Query("appid") String key);
}
