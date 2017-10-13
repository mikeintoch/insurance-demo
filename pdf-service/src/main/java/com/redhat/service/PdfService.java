package com.redhat.service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.enterprise.context.ApplicationScoped;
import javax.xml.bind.DatatypeConverter;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.redhat.insurance.messages.PolicyMessage;
import com.redhat.model.PdfFile;

@ApplicationScoped
public class PdfService {
	
	public PdfFile createPDF(PolicyMessage policy) throws DocumentException, IOException{
		Random rand = new Random();

		Date today = new Date();

		int  n = rand.nextInt(563544344) + 1;
		
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        String str_today = DATE_FORMAT.format(today);
        
        Date vigencia = this.calcularVigencia(today);
        String str_vigencia = DATE_FORMAT.format(vigencia);


        System.out.println("Driver Name: " + policy.getDriver().getNombre());
        
		PdfReader pdfTemplate = new PdfReader("mytemplate.pdf");
		FileOutputStream fileOutputStream = new FileOutputStream("test.pdf");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfStamper stamper = new PdfStamper(pdfTemplate, baos);
		stamper.setFormFlattening(true);

		stamper.getAcroFields().setField("numpoliza", "RHP-" + n);
		stamper.getAcroFields().setField("fecha", str_today);
		stamper.getAcroFields().setField("vigencia", str_vigencia);
		
		stamper.getAcroFields().setField("nombre", policy.getDriver().getNombre());
		stamper.getAcroFields().setField("edad", policy.getDriver().getEdad().toString());
		stamper.getAcroFields().setField("vigencia", str_vigencia);

		stamper.getAcroFields().setField("marca", policy.getCar().getMarca());
		stamper.getAcroFields().setField("modelo", policy.getCar().getModelo());

		stamper.getAcroFields().setField("total", "$" + policy.getPolicy().getPrecio().toString());

		stamper.close();
		pdfTemplate.close();
		
		byte[] bytes = baos.toByteArray();
		
		PdfFile pdf = new PdfFile();
		
		pdf.setNombre("RHP-" + n + ".pdf");
		pdf.setDatos(DatatypeConverter.printBase64Binary(bytes));
		
		return pdf;
	}
	
	private Date calcularVigencia(Date fecha){
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(fecha); 
	      calendar.add(Calendar.YEAR, 1);
	      
	      return calendar.getTime();
	 }
	
}
