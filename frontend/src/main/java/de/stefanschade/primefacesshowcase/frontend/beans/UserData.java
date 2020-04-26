package de.stefanschade.primefacesshowcase.frontend.beans;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;


@Named
@SessionScoped
@Getter
@Setter
public class UserData implements Serializable {

    String email;
}
