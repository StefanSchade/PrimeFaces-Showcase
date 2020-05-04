package de.stefanschade.primefacesshowcase.frontend.beans.view;

import de.stefanschade.primefacesshowcase.frontend.beans.entities.ConfigurableField;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Slf4j
@Named
@Getter
@Setter
@ViewScoped
public class FieldTable implements Serializable {

    private boolean fieldSelectedFlag = false;

    private ConfigurableField fieldSelected = null;

    private List<ConfigurableField> completeFieldList;

    private List<ConfigurableField> pagedFieldList;

    boolean showBackButton = true;

    boolean showNextButton = true;

    int page = 0;

    final int size = 20;

    int firstEntry = 0;

    int lastEntry = size;

    public void update() {
        firstEntry = page * size;
        lastEntry = firstEntry + size;

        if (page == 0) {
            setShowBackButton(false);
        } else {
            setShowBackButton(true);
        }
        if (lastEntry < completeFieldList.size()) {
            setShowNextButton(true);
        } else {
            setShowNextButton(false);
        }

        log.info("Field Table updated: "
                + " page " + page
                + " size " + size
                + " from " + firstEntry
                + " to " + lastEntry
                + " showNext " + showNextButton
                + " showBack " + showBackButton
                + " nrFields " + completeFieldList.size());

        int from = firstEntry;
        int to = completeFieldList.size() < lastEntry ? completeFieldList.size() : lastEntry;
        pagedFieldList = completeFieldList.subList(from, to);
    }

    public void selectTemplate(List<ConfigurableField> fields) {
        completeFieldList = fields;
        unSelectFieldDetails();
        update();
        page = 0;
    }

    public void selectFieldDetails(ConfigurableField field) {
        fieldSelected = field;
        fieldSelectedFlag = true;
    }

    public void unSelectFieldDetails() {
        fieldSelected = null;
        fieldSelectedFlag = false;
    }

    public void retrieveNext() {
        page++;
        update();
    }

    public void retrieveLast() {
        page--;
        update();
    }
}
