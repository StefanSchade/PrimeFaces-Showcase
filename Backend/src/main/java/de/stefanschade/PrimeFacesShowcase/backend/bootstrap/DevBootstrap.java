package de.stefanschade.PrimeFacesShowcase.backend.bootstrap;

import de.stefanschade.PrimeFacesShowcase.backend.domain.ConfigurableFieldEntity;
import de.stefanschade.PrimeFacesShowcase.backend.domain.ProductTemplateEntity;
import de.stefanschade.PrimeFacesShowcase.backend.dto.FieldType;
import de.stefanschade.PrimeFacesShowcase.backend.deprecated.CarRepository;
import de.stefanschade.PrimeFacesShowcase.backend.deprecated.ConfigurableFieldRepository;
import de.stefanschade.PrimeFacesShowcase.backend.repositories.ProductTemplateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CarRepository userRepository;

    @Autowired
    ProductTemplateRepository productTemplateRepository;

    @Autowired
    ConfigurableFieldRepository configurableFieldRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        this.generateTestSample("loan",
                "business partner", FieldType.STRING,
                "outstanding", FieldType.DOUBLE,
                "interest rate", FieldType.DOUBLE);

        this.generateTestSample("deposit",
                "business partner", FieldType.STRING,
                "balance", FieldType.DOUBLE,
                "interest rate", FieldType.DOUBLE);

//        this.generateTestSample("equity depot",
//                "business partner", FieldType.STRING,
//                "stock", FieldType.INTEGER,
//                "interest rate", FieldType.DOUBLE);
    }

    private void generateTestSample(String templatename,
                                    String fieldname1, FieldType fieldtype1,
                                    String fieldname2, FieldType fieldtype2,
                                    String fieldname3, FieldType fieldtype3) {

        log.info("load test data into db: " + templatename);

        ProductTemplateEntity template = new ProductTemplateEntity(templatename);

        ConfigurableFieldEntity field1 = new ConfigurableFieldEntity(template, fieldname1, fieldtype1);
        ConfigurableFieldEntity field2 = new ConfigurableFieldEntity(template, fieldname2, fieldtype2);
        ConfigurableFieldEntity field3 = new ConfigurableFieldEntity(template, fieldname3, fieldtype3);

        template.setFields(new ArrayList<>());

        template.getFields().add(field1);
        template.getFields().add(field2);
        template.getFields().add(field3);

        productTemplateRepository.save(template);
        configurableFieldRepository.save(field1);
        configurableFieldRepository.save(field2);
        configurableFieldRepository.save(field3);
    }

}
