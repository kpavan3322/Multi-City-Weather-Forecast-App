package com.example.multicityweatherforecast;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ForecastAdapter extends ArrayAdapter<Forecast> {

    public List<Forecast> list;
    public ForecastAdapter(@NonNull Context context, int resource, @NonNull List<Forecast> objects) {
        super(context, resource, objects);
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.forecast_row_items, parent, false);
            forecastViewHolder forecastViewHolder = new forecastViewHolder();
            forecastViewHolder.dateAndTimeResult = convertView.findViewById(R.id.textViewDateAndTimeResult);
            forecastViewHolder.mainTempResult = convertView.findViewById(R.id.textViewMainTemperatureResult);
            forecastViewHolder.tempMaxResult = convertView.findViewById(R.id.textViewTempMaxResult);
            forecastViewHolder.tempMinResult = convertView.findViewById(R.id.textViewTempMinResult);
            forecastViewHolder.humidityResult = convertView.findViewById(R.id.textViewTempHumidityResult);
            forecastViewHolder.forecastDescription = convertView.findViewById(R.id.textViewTempDescription);
            forecastViewHolder.forecastIcon = (ImageView) convertView.findViewById(R.id.imageViewWeatherIconResult);
            convertView.setTag(forecastViewHolder);
        }

        forecastViewHolder forecastViewHolders = (forecastViewHolder) convertView.getTag();
        Forecast forecast = new Forecast();
        Log.d("FINALADAPTER", "getView: " + list.toString());
        forecastViewHolders.dateAndTimeResult.setText(list.get(position).getForecastDateTime().toString());
        forecastViewHolders.mainTempResult.setText(list.get(position).getForecastMainTemp().toString() + "F");
        forecastViewHolders.tempMaxResult.setText(list.get(position).getForecastMaxTemp().toString() + "F");
        forecastViewHolders.tempMinResult.setText(list.get(position).getForecastMinTemp().toString() + "F");
        forecastViewHolders.humidityResult.setText(list.get(position).ForecastHumidity.toString() + "%");
        forecastViewHolders.forecastDescription.setText(list.get(position).ForecastDescription.toString());

        Picasso.get().load("https://openweathermap.org/img/wn/"+list.get(position).getForecastIcon().toString()+"@2x.png").into(forecastViewHolders.forecastIcon);

        return convertView;

    }

    public class forecastViewHolder{
        TextView dateAndTimeResult;
        TextView mainTempResult;
        TextView tempMaxResult;
        TextView tempMinResult;
        TextView humidityResult;
        TextView forecastDescription;
        ImageView forecastIcon;
    }
}

