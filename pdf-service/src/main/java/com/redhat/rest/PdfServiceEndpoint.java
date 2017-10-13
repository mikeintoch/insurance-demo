package com.redhat.rest;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.itextpdf.text.DocumentException;
import com.redhat.insurance.messages.PolicyMessage;
import com.redhat.model.PdfFile;
import com.redhat.service.PdfService;

@SessionScoped
@Path("/pdfservice")
public class PdfServiceEndpoint implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7227732980791688773L;

    @Inject
    private PdfService pdfService;

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("text/plain")
    public  PdfFile createPDF(String message)
    		throws DocumentException, IOException {
    	Gson gson = new Gson();
    	PolicyMessage policy = gson.fromJson(message, PolicyMessage.class);
        return pdfService.createPDF(policy);
    }
}
