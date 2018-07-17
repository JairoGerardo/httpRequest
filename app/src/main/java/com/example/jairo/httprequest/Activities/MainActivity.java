package com.example.jairo.httprequest.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jairo.httprequest.API.API;
import com.example.jairo.httprequest.Models.City;
import com.example.jairo.httprequest.R;
import com.example.jairo.httprequest.API.APIServices.WeatherService;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button buttonSearch;
    EditText editTextCity;
    ImageView imageViewIcon;
    TextView textViewDescription;
    TextView textViewTemperature;
    TextView textViewMinTemperature;
    TextView textViewMaxTemperature;

    WeatherService service;
    Call<City> cityCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSearch = (Button) findViewById(R.id.buttonSearch);
        editTextCity = (EditText) findViewById(R.id.editTextCity);
        imageViewIcon = (ImageView) findViewById(R.id.imageViewIcon);
        textViewDescription = (TextView) findViewById(R.id.textViewDescription);
        textViewTemperature = (TextView) findViewById(R.id.textViewTemperature);
        textViewMinTemperature = (TextView) findViewById(R.id.textViewMinTemperature);
        textViewMaxTemperature = (TextView) findViewById(R.id.textViewMaxTemperature);

        service = API.getApi().create(WeatherService.class);
        if(!editTextCity.getText().toString().isEmpty()){
            searchCity();
        }else{
            Toast.makeText(MainActivity.this,"Por favor introduce una ciudad.",Toast.LENGTH_SHORT).show();
        }

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editTextCity.getText().toString().isEmpty()){
                    searchCity();
                }else{
                    Toast.makeText(MainActivity.this,"Por favor introduce una ciudad.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void searchCity() {
        cityCall = service.getCityCelsius(editTextCity.getText().toString(),"metric", "es", API.getAppykey());

        cityCall.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                if(response.isSuccessful()) {
                    City city = response.body();
                    updateData(city);
                }else {
                    Toast.makeText(MainActivity.this,"La ciudad no existe", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {
                Toast.makeText(MainActivity.this,"error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateData(City city){
        textViewDescription.setText(city.getDescription());
        textViewTemperature.setText(city.getTemp()+"ºC");
        textViewMinTemperature.setText("Min: " + city.getTempMin()+"ºC");
        textViewMaxTemperature.setText("Max: " + city.getTempMax()+"ºC");
        Picasso.get().load(API.BASE_ICON_URL+city.getIcon()+API.EXTENSION_ICONS).into(imageViewIcon);
    }
}
