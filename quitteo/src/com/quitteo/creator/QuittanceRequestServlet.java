package com.quitteo.creator;

import java.io.File;
import java.io.FileInputStream;
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
import org.artofsolving.jodconverter.OfficeDocumentConverter;

import com.quitteo.context.WebappContext;


/**
 * Servlet implementation class DocumentCreatorServlet
 */
public class QuittanceRequestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(QuittanceRequestServlet.class.getName());
	public static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMMM yyyy", Locale.FRENCH);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuittanceRequestServlet() {
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
			File model = new File(getServletContext().getRealPath("models/lettre de demande de quittance.odt"));		
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
