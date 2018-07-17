package com.example.jairo.httprequest.Deserializer;

import com.example.jairo.httprequest.Models.City;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class CustomDeserializer implements JsonDeserializer<City>{

    @Override
    public City deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        int id = json.getAsJsonObject().get("id").getAsInt();
        String name = json.getAsJsonObject().get("name").getAsString();
        String country = json.getAsJsonObject().get("sys").getAsJsonObject().get("country").getAsString();
        String description = json.getAsJsonObject().get("weather").getAsJsonArray().get(0).getAsJsonObject().get("description").getAsString();
        String icon = json.getAsJsonObject().get("weather").getAsJsonArray().get(0).getAsJsonObject().get("icon").getAsString();
        float temp = json.getAsJsonObject().get("main").getAsJsonObject().get("temp").getAsFloat();
        float tempMin = json.getAsJsonObject().get("main").getAsJsonObject().get("temp_min").getAsFloat();
        float tempMax = json.getAsJsonObject().get("main").getAsJsonObject().get("temp_max").getAsFloat();

        City city = new City(id,name,country,description,icon,temp,tempMin,tempMax);
        return city;
    }
}
