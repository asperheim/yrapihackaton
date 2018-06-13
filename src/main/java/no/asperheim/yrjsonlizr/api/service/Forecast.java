package no.asperheim.yrjsonlizr.api.service;

/**
 * Created by andersa@netcompany.com at 13/06/2018
 */
public class Forecast {

    private String forecast;

    public Forecast(String forecast) {
        this.forecast = forecast;
    }

    public String getForecast() {
        return forecast;
    }
}
