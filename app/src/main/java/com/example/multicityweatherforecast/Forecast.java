package com.example.multicityweatherforecast;

import java.io.Serializable;

public class Forecast implements Serializable {

    Double ForecastMainTemp;
    Double ForecastMaxTemp;
    Double ForecastMinTemp;
    Double ForecastHumidity;
    String ForecastDateTime;
    String ForecastDescription;

    public String getForecastIcon() {
        return ForecastIcon;
    }

    public void setForecastIcon(String forecastIcon) {
        ForecastIcon = forecastIcon;
    }

    String ForecastIcon;

    public Double getForecastMainTemp() {
        return ForecastMainTemp;
    }

    public void setForecastMainTemp(Double forecastMainTemp) {
        ForecastMainTemp = forecastMainTemp;
    }

    public Double getForecastMaxTemp() {
        return ForecastMaxTemp;
    }

    public void setForecastMaxTemp(Double forecastMaxTemp) {
        ForecastMaxTemp = forecastMaxTemp;
    }

    public Double getForecastMinTemp() {
        return ForecastMinTemp;
    }

    public void setForecastMinTemp(Double forecastMinTemp) {
        ForecastMinTemp = forecastMinTemp;
    }

    public Double getForecastHumidity() {
        return ForecastHumidity;
    }

    public void setForecastHumidity(Double forecastHumidity) {
        ForecastHumidity = forecastHumidity;
    }

    public String getForecastDateTime() {
        return ForecastDateTime;
    }

    public void setForecastDateTime(String forecastDateTime) {
        ForecastDateTime = forecastDateTime;
    }

    public String getForecastDescription() {
        return ForecastDescription;
    }

    public void setForecastDescription(String forecastDescription) {
        ForecastDescription = forecastDescription;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "ForecastMainTemp=" + ForecastMainTemp +
                ", ForecastMaxTemp=" + ForecastMaxTemp +
                ", ForecastMinTemp=" + ForecastMinTemp +
                ", ForecastHumidity=" + ForecastHumidity +
                ", ForecastDateTime='" + ForecastDateTime + '\'' +
                ", ForecastDescription='" + ForecastDescription + '\'' +
                '}';
    }
}

