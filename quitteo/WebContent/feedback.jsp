<%@page import="com.quitteo.creator.AwsSNS"%>
<%@ include file="templates/header.jsp" %>
<%
String from = request.getParameter("email");
String content = "Auteur: "+from+"<br><br>"+request.getParameter("content");
AwsSNS.sendEmail("aws@quitteo.com", "aws@quitteo.com", "[Feedback]", content);
%>
Merci pour votre message.
<%@ include file="templates/footer.jsp" %>