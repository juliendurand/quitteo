<%@ include file="templates/header.jsp" %>
		<form action="create"  method="get">
		Bailleur : <br/>
		Pr&eacute;nom et Nom<input type="text" name="llname"/><br/>
		Adresse <input type="text" name="lladdress"/><br/>
		Code Postal <input type="text" name="llzip"/><br/>
		Ville <input type="text" name="llcity"/><br/>
		<p/>
		Locataire : <br/>
		Nom <input type="text" name="tname"/><br/>
		Adresse <input type="text" name="taddress"/><br/>
		Code Postal <input type="text" name="tzip"/><br/>
		Ville <input type="text" name="tcity"/><br/>
		
		<p/>
		Autres informations :<br/>
		Début p&eacute;riode <input type="text" name="startperiod"/><br/>
		Fin p&eacute;riode<input type="text" name="endperiod"/><br/>
		Loyer <input type="text" name="rent"/><br/>
		Charges <input type="text" name="charges"/><br/>
		Total <input type="text" name="total"/><br/>
		<input type="submit"/>
		</form>
<%@ include file="templates/footer.jsp" %>