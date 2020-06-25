package de.stefanschade.primefacesshowcase.frontend.beans.view.productdefinition;

import lombok.Data;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;

@Data
@Named
@FlowScoped("productconfig")
public class ProductDefinitonFlow implements Serializable {

    private String visibleFields;

    private String editableFields;

    private String visibleFieldsDefaultValues;

    private String editableFieldsDefaultValues;

    private String editableFieldsScopes;

    public String finish() {
        return "finishproductconfig";
    }
}
