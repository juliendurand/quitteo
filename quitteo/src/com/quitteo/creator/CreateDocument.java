package com.quitteo.creator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import net.sf.jooreports.templates.DocumentTemplate;
import net.sf.jooreports.templates.DocumentTemplateException;
import net.sf.jooreports.templates.DocumentTemplateFactory;

import org.artofsolving.jodconverter.OfficeDocumentConverter;

public class CreateDocument {

	public static File createDocument(OfficeDocumentConverter converter, File model,
			Map<String, String> parameters, String outputExtension)
			throws IOException, DocumentTemplateException,
			FileNotFoundException {
		String inputExtension = model.getName().substring(model.getName().lastIndexOf(".")+1);
		File doc = File.createTempFile("test", inputExtension);
				
		DocumentTemplateFactory documentTemplateFactory = new DocumentTemplateFactory();
		DocumentTemplate template = documentTemplateFactory.getTemplate(model);
		template.createDocument(parameters, new FileOutputStream(doc));
	
		File outputFile = File.createTempFile(model.getName(), "." + outputExtension);
		long startTime = System.currentTimeMillis();
		converter.convert(doc, outputFile);
		long conversionTime = System.currentTimeMillis() - startTime;
		QuittanceServlet.logger.info(String.format("successful conversion: %s [%db] to %s in %dms", inputExtension, doc.length(), outputExtension, conversionTime));
		doc.delete();
		return outputFile;
	}

}
