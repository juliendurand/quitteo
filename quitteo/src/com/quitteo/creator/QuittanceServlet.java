package com.quitteo.creator;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
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


import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.artofsolving.jodconverter.OfficeDocumentConverter;

import com.quitteo.context.WebappContext;
import com.quitteo.utils.utils;


/**
 * Servlet implementation class DocumentCreatorServlet
 */
public class QuittanceServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(QuittanceServlet.class.getName());
	public static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMMM yyyy", Locale.FRENCH);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuittanceServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebappContext webappContext = WebappContext.get(getServletContext());
		OfficeDocumentConverter converter = webappContext.getDocumentConverter();
		
		Map<String, String> parameters = new HashMap<String, String>();
		for(Object s : request.getParameterMap().keySet()){
			parameters.put((String)s, ((String[])request.getParameterMap().get(s))[0]);
		}
		parameters.put("date", dateFormatter.format(new Date()));
		
		try{
			File model = new File(getServletContext().getRealPath("models/quittance.odt"));		
			File outputFile = CreateDocument.createDocument(converter, model, parameters, "pdf");
			byte data[] = IOUtils.toByteArray(new FileInputStream(outputFile));  
	        request.getSession(true).setAttribute("document", data);
	        outputFile.delete();
			getServletContext().getRequestDispatcher("/pdfpreview.jsp").forward(request,response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
