package de.stefanschade.primefacesshowcase.frontend.rest.impl;

import de.stefanschade.primefacesshowcase.frontend.beans.ProductTemplate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("resource")
public interface ServiceClient {

    @Path("test")
    @GET
    public String test();


}
