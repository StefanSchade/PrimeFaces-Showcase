package de.stefanschade.primefacesshowcase.frontend.beans.view;

import de.stefanschade.primefacesshowcase.frontend.beans.entities.ConfigurableField;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Named
@ViewScoped
public class FieldTable implements Serializable {

    private final int PAGESIZE = 20;

    @Getter private int currentPage = 0;
    @Getter private List<ConfigurableField> fieldListCurrentPage;
    @Getter private boolean backButtonVisibility = true;
    @Getter private boolean nextButtonVisibility = true;
    @Getter private ConfigurableField fieldSelected = null;
    @Getter private boolean fieldIsSelected = false;

    private List<ConfigurableField> fieldListComplete;
    private int firstEntryOnCurrentPage;
    private int lastEntryOnCurrentPage;

    public void selectTemplate(List<ConfigurableField> fields) {
        unSelectFieldDetails();
        fieldListComplete = fields;
        currentPage = 0;
        updatePagedFieldList();
    }

    public void retrieveNext() {
        currentPage++;
        updatePagedFieldList();
    }

    public void retrieveLast() {
        currentPage--;
        updatePagedFieldList();
    }

    private void updatePagedFieldList() {
        this.firstEntryOnCurrentPage = currentPage * PAGESIZE;
        this.lastEntryOnCurrentPage = fieldListComplete.size() < firstEntryOnCurrentPage + PAGESIZE ? fieldListComplete.size() : firstEntryOnCurrentPage + PAGESIZE;
        this.fieldListCurrentPage = fieldListComplete.subList(firstEntryOnCurrentPage, lastEntryOnCurrentPage);
        this.updateVisibilityOfPaginationButtons();
    }

    public void updateVisibilityOfPaginationButtons() {
        backButtonVisibility = currentPage >= 1;
        nextButtonVisibility = lastEntryOnCurrentPage < fieldListComplete.size();
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
        Iterator<ConfigurableField> iterator = this.fieldListCurrentPage.iterator();
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