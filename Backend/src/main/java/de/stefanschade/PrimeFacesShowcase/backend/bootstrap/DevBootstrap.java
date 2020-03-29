package de.stefanschade.PrimeFacesShowcase.backend.bootstrap;

import de.stefanschade.PrimeFacesShowcase.backend.domain.CarEntity;
import de.stefanschade.PrimeFacesShowcase.backend.domain.ConfigurableFieldEntity;
import de.stefanschade.PrimeFacesShowcase.backend.domain.ProductTemplateEntity;
import de.stefanschade.PrimeFacesShowcase.backend.dto.FieldType;
import de.stefanschade.PrimeFacesShowcase.backend.repositories.CarRepository;
import de.stefanschade.PrimeFacesShowcase.backend.repositories.ConfigurableFieldRepository;
import de.stefanschade.PrimeFacesShowcase.backend.repositories.ProductTemplateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class DevBootstrap  implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CarRepository userRepository;

    @Autowired
    ProductTemplateRepository productTemplateRepository;

    @Autowired
    ConfigurableFieldRepository configurableFieldRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("load test data into db");

        CarEntity car1 = new CarEntity("Mercedes",1995, "Gold", 100000, true);
        CarEntity car2 = new CarEntity("VW",2010, "Weiss", 200000, false);
        CarEntity car3 = new CarEntity("Ford",2015, "Rot", 300000, false);

        userRepository.save(car1);
        userRepository.save(car2);
        userRepository.save(car3);

        log.info("load test data into db: loans");

        ProductTemplateEntity loan = new ProductTemplateEntity("loan");

        ConfigurableFieldEntity loan_businesspartner = new ConfigurableFieldEntity(loan,"businesspartner", FieldType.STRING);
        ConfigurableFieldEntity loan_notional = new ConfigurableFieldEntity(loan,"notional", FieldType.INTEGER);
        ConfigurableFieldEntity loan_interstrate = new ConfigurableFieldEntity(loan,"notional", FieldType.INTEGER);

        loan.setFields(new ArrayList<>());

        loan.getFields().add(loan_businesspartner);
        loan.getFields().add(loan_notional);
        loan.getFields().add(loan_interstrate);

        productTemplateRepository.save(loan);

//        todo saving the fields results in a jpa problem
//       configurableFieldRepository.save(loan_businesspartner);
//        configurableFieldRepository.save(loan_notional);
//        configurableFieldRepository.save(loan_interstrate);





        ProductTemplateEntity deposit = new ProductTemplateEntity("deposit");
        ProductTemplateEntity equity = new ProductTemplateEntity("equity");


        Set<ConfigurableFieldEntity> configurableFieldEntitySet = new HashSet<>();

        productTemplateRepository.save(deposit);
        productTemplateRepository.save(equity);



//        ConfigurableFieldEntity notional = new ConfigurableFieldEntity("Notional", "Notional", 8, FieldType.INTEGER);
//        ConfigurableFieldDto notional = new ConfigurableFieldDto("Notional", "Notional", 8, FieldType.INTEGER);
//        ConfigurableFieldDto interest = new ConfigurableFieldDto("Interest Rate", "Interest Rate", 8, FieldType.DOUBLE);
//        ConfigurableFieldDto isin = new ConfigurableFieldDto("ISIN", "Interest Rate", 8, FieldType.STRING);





//        ProductTemplateDto loan = new ProductTemplateDto()





    }

}
