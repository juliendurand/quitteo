package com.quitteo.creator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.artofsolving.jodconverter.OfficeDocumentConverter;

import com.quitteo.context.WebappContext;
import com.quitteo.utils.utils;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebappContext webappContext = WebappContext.get(getServletContext());
		OfficeDocumentConverter converter = webappContext.getDocumentConverter();
		String format = converter.getFormatRegistry().getFormatByExtension("pdf").getMediaType();
		utils.sendByteArray(response, "quittance.pdf", format, (byte[]) request.getSession().getAttribute("quittance"));
	}

}
