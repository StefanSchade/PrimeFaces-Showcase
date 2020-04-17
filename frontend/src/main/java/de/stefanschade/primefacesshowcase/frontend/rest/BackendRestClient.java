package de.stefanschade.primefacesshowcase.frontend.rest;

import de.stefanschade.primefacesshowcase.frontend.beans.ProductTemplate;

import java.util.List;

public interface BackendRestClient {

    public List<ProductTemplate> productTemplates();
}
