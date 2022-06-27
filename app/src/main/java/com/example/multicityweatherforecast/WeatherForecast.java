package com.example.multicityweatherforecast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

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

public class WeatherForecast extends AppCompatActivity {

    private final OkHttpClient client  = new OkHttpClient();
    ListView listView;
    ForecastAdapter adapter;
    String cityAndCountryCode;
    TextView cityCodeObtained;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_forecast);
        setTitle("Weather Forecast");

        cityCodeObtained = findViewById(R.id.textViewcityCountryCodeResult);

        if(getIntent() != null && getIntent().getExtras() != null)
        {
            cityAndCountryCode = getIntent().getStringExtra("cityCountryCodeSend");
            cityCodeObtained.setText(cityAndCountryCode.toString());
            getWeatherForecast(cityAndCountryCode);
        }


    }

    public void getWeatherForecast(String cityAndCountryCode)
    {
        this.cityAndCountryCode = cityAndCountryCode;
        HttpUrl url = HttpUrl.parse("https://api.openweathermap.org/data/2.5/forecast").newBuilder()
                .addQueryParameter("q", cityAndCountryCode)
                .addQueryParameter("APPID", "82e14e040a5cbb5e2d1949ddeead0844")
                .addQueryParameter("units", "imperial")
                .build();

        Request requestingWeatherForecast = new Request.Builder()
                .url(url)
                .build();

        client.newCall(requestingWeatherForecast).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                try {
                    ArrayList<Forecast> forecastData = new ArrayList<>();
                    JSONObject mainJson = new JSONObject(response.body().string());
                    JSONArray forecastArray = mainJson.getJSONArray("list");
                    // Forecast forecast = new Forecast();
                    Log.d("BEFORELOOP", "onResponse: "+ forecastData.toString());
                    for(int i=0; i< forecastArray.length(); i++)
                    {

                        JSONObject eachForecastJsonObject = forecastArray.getJSONObject(i);
                        JSONObject everyMainForecastJsonObject = eachForecastJsonObject.getJSONObject("main");
                        Log.d("LOOPENTERED", "onResponse: "+ forecastData.toString());
                        Forecast forecast = new Forecast();
                        forecast.setForecastMainTemp(Double.parseDouble(everyMainForecastJsonObject.getString("temp")));

                        forecast.setForecastMinTemp(Double.parseDouble(everyMainForecastJsonObject.getString("temp_min")));

                        Log.d("LOOPENTERED", "onResponse: "+ forecastData.toString());
                        forecast.setForecastMaxTemp(Double.parseDouble(everyMainForecastJsonObject.getString("temp_max")));


                        forecast.setForecastHumidity(Double.parseDouble(everyMainForecastJsonObject.getString("humidity")));


                        forecast.setForecastDateTime(eachForecastJsonObject.getString("dt_txt"));


                        JSONArray weatherForecastArray = eachForecastJsonObject.getJSONArray("weather");

                        for(int j=0; j< weatherForecastArray.length(); j++)
                        {
                            JSONObject eachWeatherForecastJsonObject = weatherForecastArray.getJSONObject(j);
                            forecast.setForecastDescription(eachWeatherForecastJsonObject.getString("description"));

                            forecast.setForecastIcon(eachWeatherForecastJsonObject.getString("icon"));

                        }
                        Log.d("BEFOREADD", "onResponse: "+ forecastData.toString());
                        forecastData.add(forecast);
                        Log.d("AFTERADD", "onResponse: "+ forecastData.toString());
                        Log.d("FSIZE", "onResponse: "+ String.valueOf(forecastData.size()));

                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            listView = findViewById(R.id.forecastListView);
                            // form the adapter
                            Log.d("LOOK", "run: " + forecastData.toString());
                            Log.d("LOOKSIZE", "run: " + String.valueOf(forecastData.size()));
                            adapter = new ForecastAdapter(getBaseContext(), R.layout.forecast_row_items, forecastData);
                            // set the adapter
                            listView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                        }
                    });


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}