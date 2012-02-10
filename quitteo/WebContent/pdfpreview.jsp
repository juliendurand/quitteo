<%@page import="com.quitteo.converter.Pdf2Img"%>
<%@page import="com.quitteo.converter.PdfPreview"%>

<%@ include file="templates/header.jsp" %>
<p>
<a class="download" href="download"><img src="images/download.jpeg" />T&eacute;l&eacute;charger le document PDF</a>
<p>
<% 
try{
PdfPreview images = Pdf2Img.createPreviewImages((byte[])session.getAttribute("quittance"));
session.setAttribute("pdf", images); 

int p=0;
for(p=0;p<images.pages.size();p++){
%>
<img src="preview/<%=p%>.jpg" class="shadow box"/>
<p>
<% 	
}
}catch(Exception e){
	e.printStackTrace();
}
%>

<%@ include file="templates/footer.jsp" %>