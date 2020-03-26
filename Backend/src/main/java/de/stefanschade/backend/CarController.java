package de.stefanschade.backend;

import de.stefanschade.backend.repositories.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("cars")
public class CarController {


    @Autowired
    private CarRepository carRepository;

}
