package com.quitteo.converter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PreviewServlet
 */
public class PreviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreviewServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PdfPreview preview = (PdfPreview) request.getSession(true).getAttribute("pdf");
		if(preview!=null){
			try{
				response.setContentType("image/jpeg");
				String query = request.getRequestURL().toString();
				System.out.println("query: "+query);		
				String page = query.substring(query.lastIndexOf("/")+1, query.lastIndexOf("."));
				System.out.println("page: "+page);
				int index = Integer.parseInt(page);
				response.getOutputStream().write(preview.pages.get(index));
			}catch (Exception e) {
				e.printStackTrace();
			}		
		}
	}

}
