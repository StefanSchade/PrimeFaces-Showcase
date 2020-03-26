package de.stefanschade.PrimeFacesShowcase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.inject.Named;

@Named
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {

    private String id;
    private String brand;
    private int year;
    private String color;
    private int price;
    private boolean soldState;
}
