package de.stefanschade.primefacesshowcase.backend.bootstrap;

import de.stefanschade.primefacesshowcase.backend.repositories.ConfigurableFieldRepository;
import de.stefanschade.primefacesshowcase.backend.domain.ConfigurableFieldEntity;
import de.stefanschade.primefacesshowcase.backend.domain.ProductTemplateEntity;
import de.stefanschade.primefacesshowcase.backend.dto.FieldType;
import de.stefanschade.primefacesshowcase.backend.repositories.ProductTemplateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.util.ArrayList;

@Slf4j
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    ProductTemplateRepository productTemplateRepository;

    @Autowired
    ConfigurableFieldRepository configurableFieldRepository;

    @Autowired
    RandomDataGenerator randomDataGenerator;

    private final int NUMBERTEMPLATES = 2500;
    private final int MINIMUMNUMBEROFFIELDS = 10;
    private final int MAXIMUMNUMBEROFFIELDS = 20;
    private final int TEMPLATENAMELENGTH = 10;
    private final int FIELDNAMELENGTH = 10;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        log.info("generating testdata");

        this.generateTestSample("loan",
                new String[]{"business partner", "outstanding", "interest rate"},
                new FieldType[]{FieldType.STRING, FieldType.DOUBLE, FieldType.DOUBLE});

        this.generateTestSample("deposit",
                new String[]{"business partner", "outstanding", "interest rate"},
                new FieldType[]{FieldType.STRING, FieldType.DOUBLE, FieldType.DOUBLE});

        for (int templateCounter = 0; templateCounter < NUMBERTEMPLATES; templateCounter++) {
            String templateName;
//          templateName = randomDataGenerator.getRandomString(TEMPLATENAMELENGTH);
            templateName = "Test-Template #"+ (templateCounter+1);
            int fieldsInTemplate = randomDataGenerator.getRandomIntInRange(MINIMUMNUMBEROFFIELDS, MAXIMUMNUMBEROFFIELDS);
            log.info("Templatename = "+templateName + " Fields: " + fieldsInTemplate);
            String[] fieldNames = new String[fieldsInTemplate];
            FieldType[] fieldTypes = new FieldType[fieldsInTemplate];
            fieldNames = randomDataGenerator.getRandomStringArray(fieldsInTemplate, FIELDNAMELENGTH);
            fieldTypes = randomDataGenerator.getRandomFieldTypeArray(fieldsInTemplate);
            generateTestSample(templateName,fieldNames,fieldTypes);
        }
    }

    private void generateTestSample(String templatename,
                                    String[] fieldnames, FieldType[] fieldtypes) {

        ProductTemplateEntity template = new ProductTemplateEntity(templatename);

        if (fieldnames.length != fieldtypes.length) {
            throw new IllegalArgumentException("Arrays for fieldname (" + fieldnames.length
                    + ") and fieldlength (" + fieldtypes.length + ") must have the same length!");
        }

        template.setFields(new ArrayList<>());

        log.info("templatename " + templatename + " fields " + fieldnames.length + " types " + fieldtypes.length);
        for (int i = 0; i<fieldnames.length;i++){
            log.info("Field #"+i+": "+fieldnames[i] + "   " + fieldtypes[i]);
        }

        productTemplateRepository.save(template);
        for (int i = 0; i < fieldnames.length; i++) {
            ConfigurableFieldEntity field = new ConfigurableFieldEntity(template, fieldnames[i], fieldtypes[i]);
            template.getFields().add(field);
            configurableFieldRepository.save(field);
        }
    }
}