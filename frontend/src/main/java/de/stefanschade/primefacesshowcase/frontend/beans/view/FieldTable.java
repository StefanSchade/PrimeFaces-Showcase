package de.stefanschade.primefacesshowcase.frontend.beans.view;

import de.stefanschade.primefacesshowcase.frontend.beans.entities.ConfigurableField;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Named
@Getter
@Setter
@ViewScoped
public class FieldTable implements Serializable {

    private ConfigurableField fieldSelected = null;
    private boolean fieldIsSelected = false;

    private List<ConfigurableField> completeFieldList;
    private List<ConfigurableField> pagedFieldList;
    int firstEntry;
    int lastEntry;

    boolean showBackButton = true;
    boolean showNextButton = true;

    int size = 20;
    int page = 0;

    public void selectTemplate(List<ConfigurableField> fields) {
        unSelectFieldDetails();
        completeFieldList = fields;
        page = 0;
        updatePagedFieldList();
    }

    public void retrieveNext() {
        page++;
        updatePagedFieldList();
    }

    public void retrieveLast() {
        page--;
        updatePagedFieldList();
    }

    private void updatePagedFieldList() {
        this.firstEntry = page * size;
        this.lastEntry = completeFieldList.size() < firstEntry + size ? completeFieldList.size() : firstEntry + size;
        this.pagedFieldList = completeFieldList.subList(firstEntry, lastEntry);
        this.updateVisibilityOfPaginationButtons();
    }

    public void updateVisibilityOfPaginationButtons() {
        showBackButton = page >= 1;
        showNextButton = lastEntry < completeFieldList.size();
    }

    public void selectFieldDetails(ConfigurableField field) {
        fieldSelected = field;
        fieldIsSelected = true;
    }

    public void unSelectFieldDetails() {
        fieldSelected = null;
        fieldIsSelected = false;
    }

    public String rowClasses() {
        if (!fieldIsSelected) return "odd, even";
        StringBuilder returnValue = new StringBuilder();
        Iterator<ConfigurableField> iterator = this.pagedFieldList.iterator();
        boolean oddEvenFlip = false;
        while (iterator.hasNext()) {
            if (iterator.next().equals(this.fieldSelected)) returnValue.append("highlight");
            else returnValue.append(oddEvenFlip ? "even" : "odd");
            oddEvenFlip = !oddEvenFlip;
            if (iterator.hasNext()) returnValue.append(", ");
        }
        return returnValue.toString();
    }
}