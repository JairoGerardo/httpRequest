package com.example.jairo.httprequest.Models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {

    private int id;
    private String name;
    private String country;
    private String description;
    private String icon;
    private float temp;
    private float tempMin;
    private float tempMax;
    //@SerializedName("main") private Temperature temperature;

    public City(){

    }

    public City(int id, String name, String country, String description, String icon, float temp, float tempMin, float tempMax) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.description = description;
        this.icon = icon;
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        //this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getTempMin() {
        return tempMin;
    }

    public void setTempMin(float tempMin) {
        this.tempMin = tempMin;
    }

    public float getTempMax() {
        return tempMax;
    }

    public void setTempMax(float tempMax) {
        this.tempMax = tempMax;
    }
    //public Temperature getTemperature() {
    //    return temperature;
    //}

    //public void setTemperature(Temperature temperature) {
    //    this.temperature = temperature;
    //}

    //public static Temperature parseJSON(String response){
    //    Gson gson = new GsonBuilder().create();
    //    Temperature temp = gson.fromJson(response,Temperature.class);
    //    return temp;
    //}
}
