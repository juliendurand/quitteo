<%@page import="com.quitteo.converter.Pdf2Img"%>
<%@page import="com.quitteo.converter.PdfPreview"%>

<%@ include file="templates/header.jsp" %>
<p>
<a class="download" href="download"><img src="images/download.jpeg" />T&eacute;l&eacute;charger le document PDF</a>
<p>
<% 
PdfPreview images = Pdf2Img.createPreviewImages((byte[])session.getAttribute("quittance"));
session.setAttribute("pdf", images); 

int p=0;
for(p=0;p<images.pages.size();p++){
%>
<img src="preview/<%=p%>.jpg" style="border:1px solid black; box-shadow: 3px 3px 7px #777;"/>
<p>
<% 	
}
%>

<%@ include file="templates/footer.jsp" %>