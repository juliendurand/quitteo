<%@page import="com.quitteo.converter.Pdf2Img"%>
<%@page import="com.quitteo.converter.PdfPreview"%>

<%@ include file="templates/header.jsp" %>
<p>
<a class="download" href="download" style="text-decoration:none;"><img style="margin-right:10px" src="images/download.jpeg" /><span style="text-decoration:underline; margin-bottom:8px;">T&eacute;l&eacute;charger le document</span></a>
<p>
<% 
try{
PdfPreview images = Pdf2Img.createPreviewImages((byte[])session.getAttribute("document"));
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