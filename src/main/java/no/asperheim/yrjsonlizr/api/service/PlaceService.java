package no.asperheim.yrjsonlizr.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import no.asperheim.yrjsonlizr.api.controller.dto.Place;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toCollection;

/**
 * Created by andersa@netcompany.com at 13/06/2018
 */

@Service
public class PlaceService {

    static List<Place> placeList;

    @PostConstruct
    private void init() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Place>> mapType = new TypeReference<List<Place>>() {};
        try {
            InputStream is = new ClassPathResource("places.json").getInputStream();

            if (placeList == null)
                placeList = mapper.readValue(is, mapType);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Place> getPlaces() {
        return placeList.subList(0, 10);
    }

    public List<Place> getPlaces(String name){
        return placeList
                .stream()
                .filter(x -> x.getName()
                        .toLowerCase()
                        .trim()
                        .startsWith(name
                                .toLowerCase()
                                .trim()))
                .collect(toCollection(ArrayList::new));
    }

    public DetailedPlace getPlace(UUID id) {
        Place place = placeList.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .get();

        Object forecast = marshallXmlString(getXmlFromYr(place.getLink()));

        return new DetailedPlace(place, forecast);
    }

    private Object marshallXmlString(String xmlInput){
        XmlMapper xmlMapper = new XmlMapper();
        try {
            return xmlMapper.readValue(xmlInput, Object.class);
        } catch (IOException e) {
            return "";
        }
    }

    private String getXmlFromYr(String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
