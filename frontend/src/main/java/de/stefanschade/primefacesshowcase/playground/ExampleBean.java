package de.stefanschade.primefacesshowcase.playground;

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
public class ExampleBean {

    private String id;
    private String field01;
    private int field02;
    private String field03;
    private int field04;
    private boolean field05;


}
