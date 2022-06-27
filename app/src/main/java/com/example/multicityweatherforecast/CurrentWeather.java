package com.example.multicityweatherforecast;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class CurrentWeather extends AppCompatActivity {

    TextView temperature;
    TextView temperatureMax;
    TextView temperatureMin;
    TextView descriptionTextView;
    TextView humidity;
    TextView windSpeed;
    TextView windDegree;
    TextView cloudiness;
    TextView cityName;
    // ImageView weatherIcon;
    Button buttonCheckForecast;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_weather);
        setTitle("Current Weather");

        temperature = findViewById(R.id.textViewTemperatureResult);
        temperatureMax = findViewById(R.id.textViewTemperatureMaxResult);
        temperatureMin = findViewById(R.id.textViewTemperatureMinResult);
        descriptionTextView = findViewById(R.id.textViewDescriptionResult);
        humidity = findViewById(R.id.textViewHumidityResult);
        windSpeed = findViewById(R.id.textViewWindSpeedResult);
        windDegree = findViewById(R.id.textViewWindDegreeResult);
        cloudiness = findViewById(R.id.textViewCloudinessResult);
        cityName = findViewById(R.id.textViewCityOverViewNameResult);
        buttonCheckForecast = findViewById(R.id.buttonCheckForecast);


        if(getIntent() != null && getIntent().getExtras() != null)
        {
            String temp = getIntent().getStringExtra("temp");
            String tempMax = getIntent().getStringExtra("tempMax");
            String tempMin = getIntent().getStringExtra("tempMin");
            String description = getIntent().getStringExtra("description");
            String humidityValue = getIntent().getStringExtra("humidity");
            String windSpeedValue = getIntent().getStringExtra("windSpeed");
            String windDegreeValue = getIntent().getStringExtra("windDegrees");
            String cloudinessValue = getIntent().getStringExtra("cloudiness");
            String cityNameValue = getIntent().getStringExtra("cityName");
            String wIconValue = getIntent().getStringExtra("wIcon");

            ImageView weatherIcon = (ImageView) findViewById(R.id.imageViewWeather);
            Picasso.get().load("https://openweathermap.org/img/wn/"+wIconValue+"@2x.png").into(weatherIcon);

            temperature.setText(temp + " F");
            temperatureMax.setText(tempMax + " F");
            temperatureMin.setText(tempMin + " F");
            descriptionTextView.setText(description);
            humidity.setText(humidityValue + "%");
            windSpeed.setText(windSpeedValue + " miles/hr");
            windDegree.setText(windDegreeValue + " degrees");
            cloudiness.setText(cloudinessValue + "%");
            cityName.setText(cityNameValue);

        }

        buttonCheckForecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToForecast = new Intent(getBaseContext(), WeatherForecast.class);
                goToForecast.putExtra("cityCountryCodeSend", cityName.getText().toString());
                startActivity(goToForecast);

            }
        });

    }


}
