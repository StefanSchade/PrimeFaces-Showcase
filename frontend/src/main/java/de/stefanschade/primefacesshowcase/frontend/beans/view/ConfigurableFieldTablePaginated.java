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
public class ConfigurableFieldTablePaginated implements Serializable {

    private boolean configurableFieldDetailsCurrentlySelected = false;

    private ConfigurableField currentlySelectedConfigurableField = null;

    private List<ConfigurableField> configurableFieldTotalList;

    private List<ConfigurableField> configurableFieldPagedList;

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
        if (lastEntry < configurableFieldTotalList.size()) {
            setShowNextButton(true);
        } else {
            setShowNextButton(false);
        }
        log.info("Fields updated: "
                + " page " + page
                + " size " + size
                + " firstEntry " + firstEntry
                + " lastEntry " + lastEntry
                + " showNextButton " + showNextButton
                + " showBackButton " + showBackButton
                + " numberOfFields " + configurableFieldTotalList.size()
        );
        int from = firstEntry;
        int to = configurableFieldTotalList.size() < lastEntry ? configurableFieldTotalList.size() : lastEntry;
        configurableFieldPagedList = configurableFieldTotalList.subList(from, to);
    }

    public void selectTemplate(List<ConfigurableField> fields) {
        configurableFieldTotalList = fields;
        unSelectFieldDetails();
        page = 0;
        update();
    }

    public void selectFieldDetails(ConfigurableField field) {
        currentlySelectedConfigurableField = field;
        configurableFieldDetailsCurrentlySelected = true;
    }

    public void unSelectFieldDetails() {
        currentlySelectedConfigurableField = null;
        configurableFieldDetailsCurrentlySelected = false;
    }

    public void retrieveNext() {
        page++;
        update();
    }

    public void retrieveLast() {
        page--;
        update();
    }

    // https://stackoverflow.com/questions/15787376/fajax-render-someid-does-not-update-target-component-but-fajax-render

}
