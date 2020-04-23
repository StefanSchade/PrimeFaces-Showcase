package de.stefanschade.primefacesshowcase.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleEntity {

    private String name;
    private int integerValue;


}