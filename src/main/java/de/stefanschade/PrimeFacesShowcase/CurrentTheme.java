package de.stefanschade.PrimeFacesShowcase;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named
@SessionScoped
@NoArgsConstructor
@Getter
@Setter
public class CurrentTheme implements
        Serializable {

    private String theme = "aristo";

}