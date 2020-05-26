package de.stefanschade.primefacesshowcase.frontend.beans.session;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Data
@Named
@SessionScoped
public class SessionInformation implements Serializable {

    private String resultFlow1;
    private String resultFlow2;
    private String resultTemplateBrowser;

    @PostConstruct public void init() {
        resultTemplateBrowser = "Template Browser not called yet";
    }

}
