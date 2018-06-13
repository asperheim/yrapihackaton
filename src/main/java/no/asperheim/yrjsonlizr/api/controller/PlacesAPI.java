package no.asperheim.yrjsonlizr.api.controller;

import no.asperheim.yrjsonlizr.api.controller.dto.Place;
import no.asperheim.yrjsonlizr.api.service.DetailedPlace;
import no.asperheim.yrjsonlizr.api.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


/**
 * Created by andersa@netcompany.com at 13/06/2018
 */
@RestController
public class PlacesAPI {

    @Autowired
    private PlaceService placeService;


    @RequestMapping("/places")
    public List<Place> getPlaces() {
        return placeService.getPlaces();
    }

    @RequestMapping("/places/{name}")
    public List<Place> getPlaces(@PathVariable(value="name") String name) {
        return placeService.getPlaces(name);
    }

    @RequestMapping("/place/{id}")
    public DetailedPlace getPlace(@PathVariable(value="id") String id) {
        return placeService.getPlace(UUID.fromString(id));
    }
}
