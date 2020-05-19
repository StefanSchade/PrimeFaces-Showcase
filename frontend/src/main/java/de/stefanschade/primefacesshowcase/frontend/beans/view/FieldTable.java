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

    public void selectTemplate(List<ConfigurableField> configurableFieldList) {
        this.fieldListComplete = configurableFieldList;
        this.currentPage = 0;
        this.unSelectFieldDetails();
        this.updatePaginatedFieldList();
    }

    public void retrieveNext() {
        this.currentPage++;
        this.updatePaginatedFieldList();
    }

    public void retrievePrevious() {
        this.currentPage--;
        this.updatePaginatedFieldList();
    }

    private void updatePaginatedFieldList() {
        this.firstEntryOnCurrentPage = currentPage * PAGESIZE;
        this.lastEntryOnCurrentPage = fieldListComplete.size() < firstEntryOnCurrentPage + PAGESIZE ? fieldListComplete.size() : firstEntryOnCurrentPage + PAGESIZE;
        this.fieldListCurrentPage = fieldListComplete.subList(firstEntryOnCurrentPage, lastEntryOnCurrentPage);
        this.updateVisibilityOfPaginationButtons();
    }

    public void updateVisibilityOfPaginationButtons() {
        this.backButtonVisibility = currentPage >= 1;
        this.nextButtonVisibility = lastEntryOnCurrentPage < fieldListComplete.size();
    }

    public void selectFieldDetails(ConfigurableField configurableField) {
        this.fieldSelected = configurableField;
        this.fieldIsSelected = true;
    }

    public void unSelectFieldDetails() {
        this.fieldSelected = null;
        this.fieldIsSelected = false;
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