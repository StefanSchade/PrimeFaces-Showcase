package de.stefanschade.primefacesshowcase.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductTemplateDto {

    private String templatename;
    private List<ConfigurableFieldDto> fieldsdto = new ArrayList<>();
}
