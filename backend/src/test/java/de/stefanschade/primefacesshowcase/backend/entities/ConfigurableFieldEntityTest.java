package de.stefanschade.primefacesshowcase.backend.entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConfigurableFieldEntityTest {

    static ConfigurableFieldEntity configurableFieldEntity;

    @BeforeAll
    public static void setUp(){
        configurableFieldEntity = new ConfigurableFieldEntity();
    }

    @Test
    void getFieldname() {
        String fieldname = "fieldname";
        configurableFieldEntity.setFieldname(fieldname);
        assertEquals(fieldname,configurableFieldEntity.getFieldname());
    }
}