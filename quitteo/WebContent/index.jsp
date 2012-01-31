<%@ include file="templates/header.jsp" %>
		<form action="create"  method="get" oninput="total.value=rent.valueAsNumber+charges.valuesAsNumber">
		<fieldset>
			<legend>Bailleur</legend>
			<ul>
				<li>
				<label>Pr&eacute;nom et Nom</label>
				<input type="text" name="llname" placeholder="Pr&eacute;nom et Nom" required/>
				</li>
				<li>
				Adresse <input type="text" name="lladdress"/>
				</li>
				<li>
				Code Postal <input type="text" name="llzip"/>
				</li>
				<li>
				Ville <input type="text" name="llcity"/>
				</li>
			</ul>
		</fieldset>
		<fieldset>
			<legend>Locataire</legend>
			Nom <input type="text" name="tname"/><br/>
			Adresse <input type="text" name="taddress"/><br/>
			Code Postal <input type="text" name="tzip"/><br/>
			Ville <input type="text" name="tcity"/><br/>
		</fieldset>
		<fieldset>
			<legend>Autres informations :</legend>
			Début p&eacute;riode <input type="text" name="startperiod"/><br/>
			Fin p&eacute;riode<input type="text" name="endperiod"/><br/>
			Loyer <input type="number" name="rent"/><br/>
			Charges <input type="number" name="charges"/><br/>
			Total <output name="total"/><br/>
		</fieldset>
		<input type="submit"/>
		</form>
<%@ include file="templates/footer.jsp" %>