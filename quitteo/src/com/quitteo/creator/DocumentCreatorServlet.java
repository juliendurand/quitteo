package com.quitteo.creator;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jooreports.templates.DocumentTemplate;
import net.sf.jooreports.templates.DocumentTemplateException;
import net.sf.jooreports.templates.DocumentTemplateFactory;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.artofsolving.jodconverter.OfficeDocumentConverter;

import com.quitteo.context.WebappContext;
import com.quitteo.utils.utils;


/**
 * Servlet implementation class DocumentCreatorServlet
 */
public class DocumentCreatorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final Logger logger = Logger.getLogger(getClass().getName());
	public static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMM yyyy", Locale.FRENCH);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocumentCreatorServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebappContext webappContext = WebappContext.get(getServletContext());
		OfficeDocumentConverter converter = webappContext.getDocumentConverter();
		String outputExtension = "pdf";
		
		/*Receipt receipt = new Receipt();
		receipt.llname = request.getParameter("llname");
		receipt.lladdress = request.getParameter("lladdress");
		receipt.llzip = request.getParameter("llzip");
		receipt.llcity = request.getParameter("llcity");
		receipt.tname = request.getParameter("tname");
		receipt.taddress = request.getParameter("taddress");
		receipt.tzip = request.getParameter("tzip");
		receipt.tcity = request.getParameter("tcity");
		receipt.date = dateFormatter.format(new Date());
		receipt.startperiod = request.getParameter("startperiod");
		receipt.endperiod = request.getParameter("endperiod");
		receipt.rent = request.getParameter("rent");
		receipt.charges = request.getParameter("charges");
		receipt.total = request.getParameter("total");*/
		
		Map<String, String> parameters = new HashMap<String, String>();
		for(Object s : request.getParameterMap().keySet()){
			parameters.put((String)s, ((String[])request.getParameterMap().get(s))[0]);
		}
		parameters.put("date", dateFormatter.format(new Date()));
		
		try{
			File model = new File(getServletContext().getRealPath("models/quittance.odt"));
			
			File outputFile = createDocument(converter, model, parameters, outputExtension);
			byte data[] = IOUtils.toByteArray(new FileInputStream(outputFile));  
	        request.getSession(true).setAttribute("quittance", data);
        	//String outputFormat = converter.getFormatRegistry().getFormatByExtension(outputExtension).getMediaType();       	
        	//String filename = "quittance" + "." + outputExtension;
	        //utils.sendFile(response, filename, outputFormat, outputFile);
	        outputFile.delete();
		}catch (Exception e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/pdfpreview.jsp").forward(request,response);
	}

	private File createDocument(OfficeDocumentConverter converter, File model,
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
		logger.info(String.format("successful conversion: %s [%db] to %s in %dms", inputExtension, doc.length(), outputExtension, conversionTime));
		doc.delete();
		return outputFile;
	}


}
