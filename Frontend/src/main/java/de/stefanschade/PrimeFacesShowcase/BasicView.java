package de.stefanschade.PrimeFacesShowcase;

import lombok.extern.java.Log;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Log
@Named("dtBasicView")
@ViewScoped
public class BasicView implements Serializable {

    private List<Car> cars;

    @Inject
    private CarService service;

    @PostConstruct
    public void init() {
        cars = service.createCars(25);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setService(CarService service) {
        this.service = service;
    }
}