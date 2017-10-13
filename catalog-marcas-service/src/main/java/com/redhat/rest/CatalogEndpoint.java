package com.redhat.rest;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.redhat.model.Marca;
import com.redhat.service.CatalogService;

@SessionScoped
@Path("/marcas")
public class CatalogEndpoint implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7227732980791688773L;

    @Inject
    private CatalogService catalogService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Marca> listAll() {

        return catalogService.getMarcas();
    }

}
