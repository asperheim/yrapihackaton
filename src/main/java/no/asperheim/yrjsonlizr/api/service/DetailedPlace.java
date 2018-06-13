package no.asperheim.yrjsonlizr.api.service;

import no.asperheim.yrjsonlizr.api.controller.dto.Place;

/**
 * Created by andersa@netcompany.com at 13/06/2018
 */
public class DetailedPlace {
    private Place place;
    private Object forecast;

    public DetailedPlace(Place place, Object forecast) {
        this.place = place;
        this.forecast = forecast;
    }

    public Object getForecast() {
        return forecast;
    }

    public Place getPlace() {
        return place;
    }
}
