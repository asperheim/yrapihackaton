package no.asperheim.yrjsonlizr.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

/**
 * Created by andersa@netcompany.com at 13/06/2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Place {
    private UUID id;
    private String name;
    private String link;
    private int priority;
    private String type;
    private String municipality;
    private String county;
    private float lat;
    private float lon;
    private int masl;


    @JsonCreator
    public Place(
            @JsonProperty("Stadnamn") String name,
            @JsonProperty("Engelsk") String link,
            @JsonProperty("Prioritet") int priority,
            @JsonProperty("Stadtype engelsk") String type,
            @JsonProperty("Kommune") String municipality,
            @JsonProperty("Fylke") String county,
            @JsonProperty("Lat") float lat,
            @JsonProperty("Lon") float lon,
            @JsonProperty("Høgd") int masl) {

        this.name = name;
        this.link = link;
        this.priority = priority;
        this.type = type;
        this.municipality = municipality;
        this.county = county;
        this.lat = lat;
        this.lon = lon;
        this.masl = masl;
        id = UUID.randomUUID();
    }


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonIgnore
    public String getLink() {
        return link;
    }
}