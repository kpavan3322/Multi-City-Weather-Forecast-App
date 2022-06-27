package com.example.multicityweatherforecast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private final OkHttpClient client  = new OkHttpClient();
    ArrayAdapter adapter;
    ListView listViewShowingVariousCities;
    ArrayList<Data.City> cityValues;
    String cityAndCountryCode;
    String iconID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Cities");
        cityValues = Data.cities;
        listViewShowingVariousCities = findViewById(R.id.listViewCities);
        ArrayList<String> cityNames = new ArrayList<>();
        for(int i = 0; i< cityValues.size(); i++)
        {
            cityNames.add(cityValues.get(i).getCity() + ", " + cityValues.get(i).getCountry());
        }

        // Form the adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, cityNames);
        // Set the adapter
        listViewShowingVariousCities.setAdapter(adapter);
        listViewShowingVariousCities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                cityAndCountryCode = adapterView.getItemAtPosition(position).toString();
                Log.d("FIND", "onItemClick: "+ cityAndCountryCode);
                getCurrentWeather(cityAndCountryCode);
            }
        });

    }

    public void getCurrentWeather(String cityAndCountryCode)
    {
        this.cityAndCountryCode = cityAndCountryCode;
        HttpUrl url = HttpUrl.parse("https://api.openweathermap.org/data/2.5/weather").newBuilder()
                .addQueryParameter("q", cityAndCountryCode)
                .addQueryParameter("APPID", "82e14e040a5cbb5e2d1949ddeead0844")
                .addQueryParameter("units", "imperial")
                .build();

        Request requestingCurrentWeather = new Request.Builder()
                .url(url)
                .build();

        client.newCall(requestingCurrentWeather).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                try {
                    ArrayList<Weather> weatherData = new ArrayList<>();
                    JSONObject mainJson = new JSONObject(response.body().string());
                    JSONArray weatherArray = mainJson.getJSONArray("weather");
                    Log.d("VERIFY", "onResponse: " + weatherArray.toString());
                    Weather weather = new Weather();

                    for(int i=0; i< weatherArray.length(); i++)
                    {
                        JSONObject eachWeatherJsonObject = weatherArray.getJSONObject(i);
                        weather.setWeatherID(Double.parseDouble(eachWeatherJsonObject.getString("id")));
                        weather.setWeatherMain(eachWeatherJsonObject.getString("main"));
                        weather.setWeatherDescription(eachWeatherJsonObject.getString("description"));
                        weather.setWeatherIcon(eachWeatherJsonObject.getString("icon"));
                        weatherData.add(weather);
                    }

                    JSONObject valueMainJsonObject = mainJson.getJSONObject("main");
                    weather.setWeatherMainTemp(Double.parseDouble(valueMainJsonObject.getString("temp")));
                    weather.setWeatherMainFeelsLike(Double.parseDouble(valueMainJsonObject.getString("feels_like")));
                    weather.setWeatherTempMin(Double.parseDouble(valueMainJsonObject.getString("temp_min")));
                    weather.setWeatherTempMax(Double.parseDouble(valueMainJsonObject.getString("temp_max")));
                    weather.setWeatherPressure(Double.parseDouble(valueMainJsonObject.getString("pressure")));
                    weather.setWeatherHumidity(Double.parseDouble(valueMainJsonObject.getString("humidity")));

                    JSONObject windJsonObject = mainJson.getJSONObject("wind");
                    weather.setWeatherWindSpeed(Double.parseDouble(windJsonObject.getString("speed")));
                    weather.setWeatherWindDegrees(Double.parseDouble(windJsonObject.getString("deg")));

                    JSONObject cloudsJsonObject = mainJson.getJSONObject("clouds");
                    weather.setWeatherCloudiness(Double.parseDouble(cloudsJsonObject.getString("all")));

                    JSONObject systemJsonObject = mainJson.getJSONObject("sys");
                    weather.setWeatherCountry(systemJsonObject.getString("country"));
                    weather.setWeatherCountrySunrise(Double.parseDouble(systemJsonObject.getString("sunrise")));
                    weather.setWeatherCountrySunset(Double.parseDouble(systemJsonObject.getString("sunset")));
                    weather.setWeatherCityID(Double.parseDouble(mainJson.getString("id")));
                    weather.setWeatherCityName(mainJson.getString("name"));

                    iconID = weather.getWeatherIcon();
                    Log.d("CITY", "onResponse: " + weather.getWeatherCityName().toString());

                    Intent intent = new Intent(getBaseContext(), CurrentWeather.class);
                    intent.putExtra("temp", weather.getWeatherMainTemp().toString());
                    intent.putExtra("tempMax", weather.getWeatherTempMax().toString());
                    intent.putExtra("tempMin", weather.getWeatherTempMin().toString());
                    Log.d("CHECK", "onResponse: " + weatherData.toString());
                    intent.putExtra("description", weather.getWeatherDescription().toString());
                    intent.putExtra("humidity", weather.getWeatherHumidity().toString());
                    intent.putExtra("windSpeed", weather.getWeatherWindSpeed().toString());
                    intent.putExtra("windDegrees", weather.getWeatherWindDegrees().toString());
                    intent.putExtra("cloudiness", weather.getWeatherCloudiness().toString());
                    intent.putExtra("cityName", cityAndCountryCode);
                    intent.putExtra("wIcon", weather.getWeatherIcon().toString());
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
