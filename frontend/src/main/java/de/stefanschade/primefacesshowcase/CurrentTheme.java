package de.stefanschade.primefacesshowcase;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
@NoArgsConstructor
@Getter
@Setter
public class CurrentTheme implements
        Serializable {

    private String theme = "aristo";

}
