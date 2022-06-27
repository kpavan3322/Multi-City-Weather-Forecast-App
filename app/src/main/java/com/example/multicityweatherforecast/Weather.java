package com.example.multicityweatherforecast;

import java.io.Serializable;

public class Weather implements Serializable {

    Double weatherID;
    Double weatherMainTemp;
    Double weatherMainFeelsLike;
    Double weatherTempMin;
    Double weatherTempMax;
    Double weatherPressure;
    Double weatherHumidity;
    Double weatherWindSpeed;
    Double weatherWindDegrees;
    Double weatherCloudiness;
    Double weatherCountrySunrise;
    Double weatherCountrySunset;
    Double weatherCityTimeZone;
    Double weatherCityID;
    String weatherMain, weatherDescription, weatherIcon, weatherCountry, weatherCityName;

    public Double getWeatherID() {
        return weatherID;
    }

    public void setWeatherID(Double weatherID) {
        this.weatherID = weatherID;
    }

    public Double getWeatherMainTemp() {
        return weatherMainTemp;
    }

    public void setWeatherMainTemp(Double weatherMainTemp) {
        this.weatherMainTemp = weatherMainTemp;
    }

    public Double getWeatherMainFeelsLike() {
        return weatherMainFeelsLike;
    }

    public void setWeatherMainFeelsLike(Double weatherMainFeelsLike) {
        this.weatherMainFeelsLike = weatherMainFeelsLike;
    }

    public Double getWeatherTempMin() {
        return weatherTempMin;
    }

    public void setWeatherTempMin(Double weatherTempMin) {
        this.weatherTempMin = weatherTempMin;
    }

    public Double getWeatherTempMax() {
        return weatherTempMax;
    }

    public void setWeatherTempMax(Double weatherTempMax) {
        this.weatherTempMax = weatherTempMax;
    }

    public Double getWeatherPressure() {
        return weatherPressure;
    }

    public void setWeatherPressure(Double weatherPressure) {
        this.weatherPressure = weatherPressure;
    }

    public Double getWeatherHumidity() {
        return weatherHumidity;
    }

    public void setWeatherHumidity(Double weatherHumidity) {
        this.weatherHumidity = weatherHumidity;
    }

    public Double getWeatherWindSpeed() {
        return weatherWindSpeed;
    }

    public void setWeatherWindSpeed(Double weatherWindSpeed) {
        this.weatherWindSpeed = weatherWindSpeed;
    }

    public Double getWeatherWindDegrees() {
        return weatherWindDegrees;
    }

    public void setWeatherWindDegrees(Double weatherWindDegrees) {
        this.weatherWindDegrees = weatherWindDegrees;
    }

    public Double getWeatherCloudiness() {
        return weatherCloudiness;
    }

    public void setWeatherCloudiness(Double weatherCloudiness) {
        this.weatherCloudiness = weatherCloudiness;
    }

    public Double getWeatherCountrySunrise() {
        return weatherCountrySunrise;
    }

    public void setWeatherCountrySunrise(Double weatherCountrySunrise) {
        this.weatherCountrySunrise = weatherCountrySunrise;
    }

    public Double getWeatherCountrySunset() {
        return weatherCountrySunset;
    }

    public void setWeatherCountrySunset(Double weatherCountrySunset) {
        this.weatherCountrySunset = weatherCountrySunset;
    }

    public Double getWeatherCityTimeZone() {
        return weatherCityTimeZone;
    }

    public void setWeatherCityTimeZone(Double weatherCityTimeZone) {
        this.weatherCityTimeZone = weatherCityTimeZone;
    }

    public Double getWeatherCityID() {
        return weatherCityID;
    }

    public void setWeatherCityID(Double weatherCityID) {
        this.weatherCityID = weatherCityID;
    }

    public String getWeatherMain() {
        return weatherMain;
    }

    public void setWeatherMain(String weatherMain) {
        this.weatherMain = weatherMain;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public String getWeatherCountry() {
        return weatherCountry;
    }

    public void setWeatherCountry(String weatherCountry) {
        this.weatherCountry = weatherCountry;
    }

    public String getWeatherCityName() {
        return weatherCityName;
    }

    public void setWeatherCityName(String weatherCityName) {
        this.weatherCityName = weatherCityName;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "weatherID=" + weatherID +
                ", weatherMainTemp=" + weatherMainTemp +
                ", weatherMainFeelsLike=" + weatherMainFeelsLike +
                ", weatherTempMin=" + weatherTempMin +
                ", weatherTempMax=" + weatherTempMax +
                ", weatherPressure=" + weatherPressure +
                ", weatherHumidity=" + weatherHumidity +
                ", weatherWindSpeed=" + weatherWindSpeed +
                ", weatherWindDegrees=" + weatherWindDegrees +
                ", weatherCloudiness=" + weatherCloudiness +
                ", weatherCountrySunrise=" + weatherCountrySunrise +
                ", weatherCountrySunset=" + weatherCountrySunset +
                ", weatherCityTimeZone=" + weatherCityTimeZone +
                ", weatherCityID=" + weatherCityID +
                ", weatherMain='" + weatherMain + '\'' +
                ", weatherDescription='" + weatherDescription + '\'' +
                ", weatherIcon='" + weatherIcon + '\'' +
                ", weatherCountry='" + weatherCountry + '\'' +
                ", weatherCityName='" + weatherCityName + '\'' +
                '}';
    }
}

