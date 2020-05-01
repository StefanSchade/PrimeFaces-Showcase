package de.stefanschade.primefacesshowcase.frontend.beans;

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

    private boolean showConfigurableFieldTable = false;

    private List<ConfigurableField> configurableFieldTotalList;

    private List<ConfigurableField> configurableFieldPagedList;

    boolean showBackButton = true;

    boolean showNextButton = true;

    int page = 0;

    final int size = 20;

    int firstEntry = 0;

    int lastEntry = size;

    public void nextButtonClick() {
        page++;
        updateFields();
    }

    public void backButtonClick() {
        page--;
        updateFields();
    }

    public void updateFields() {

        firstEntry = page * size;
        lastEntry = firstEntry + size;

        if (page < 1) {
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
                + " numberOfFields " + configurableFieldTotalList.size());

        int from = firstEntry;
        int to = configurableFieldTotalList.size() < lastEntry ? configurableFieldTotalList.size() : lastEntry;

        configurableFieldPagedList = configurableFieldTotalList.subList(from, to);
    }

    public void templateDetailsButtonClicked(ProductTemplate template) {
        configurableFieldTotalList = template.getFields();
        showConfigurableFieldTable = true;
        updateFields();
    }

}
