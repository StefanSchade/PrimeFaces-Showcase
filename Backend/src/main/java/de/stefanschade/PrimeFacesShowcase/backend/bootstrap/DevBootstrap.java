package de.stefanschade.PrimeFacesShowcase.backend.bootstrap;

import de.stefanschade.PrimeFacesShowcase.backend.domain.CarEntity;
import de.stefanschade.PrimeFacesShowcase.backend.dto.ConfigurationFieldDto;
import de.stefanschade.PrimeFacesShowcase.backend.dto.FieldType;
import de.stefanschade.PrimeFacesShowcase.backend.repositories.CarRepository;
import de.stefanschade.PrimeFacesShowcase.backend.service.ConfigurationFieldService;
import de.stefanschade.PrimeFacesShowcase.backend.service.ProductTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DevBootstrap  implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CarRepository userRepository;

    @Autowired
    ProductTemplateService productTemplateService;

    @Autowired
    ConfigurationFieldService configurationFieldService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("load test data into db");

        CarEntity car1 = new CarEntity("Mercedes",1995, "Gold", 100000, true);
        CarEntity car2 = new CarEntity("VW",2010, "Weiss", 200000, false);
        CarEntity car3 = new CarEntity("Ford",2015, "Rot", 300000, false);

        userRepository.save(car1);
        userRepository.save(car2);
        userRepository.save(car3);

        log.info("load test data into db product templates");

        ConfigurationFieldDto notional = new ConfigurationFieldDto("Notional", "Notional", 8, FieldType.INTEGER);
        ConfigurationFieldDto interest = new ConfigurationFieldDto("Interest Rate", "Interest Rate", 8, FieldType.DOUBLE);
        ConfigurationFieldDto isin = new ConfigurationFieldDto("ISIN", "Interest Rate", 8, FieldType.STRING);

//        ProductTemplateDto loan = new ProductTemplateDto()

    }

}
