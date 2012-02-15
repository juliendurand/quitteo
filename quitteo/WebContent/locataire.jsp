<%@ include file="templates/header.jsp" %>
<H3>Demander une quittance de loyer</H3>
Vous &ecirc;tes locataire de votre logement et vous souhaitez recevoir une quittance de loyer&nbsp;? 
Cette page est faite pour vous.
<p/>
Remplissez le formulaire ci-dessous et téléchargez gratuitement votre lettre de demande de quittance de loyer.
<p/> 
Imprimez, signez et envoyez la à votre propriétaire.
<p/>
C'est simple, rapide et gratuit !
		<form id="quittance" action="quittancerequest"  method="get" class="shadow form" oninput="t.value = rent.valueAsNumber + charges.valueAsNumber;total.value=t.value;">
		<fieldset>
			<legend>Bailleur</legend>
			<ol>
				<li>
					<label>Pr&eacute;nom et Nom</label>
					<input type="text" name="llname" placeholder="Pr&eacute;nom et Nom" required/>
				</li>
				<li>
					<label>Adresse</label> 
					<input type="text" name="lladdress" required/>
				</li>
				<li>
					<label>Code Postal</label>
					<input type="text" name="llzip" required/>
				</li>
				<li>
					<label>Ville</label>
					<input type="text" name="llcity" required/>
				</li>
			</ol>
		</fieldset>
		<fieldset>
			<legend>Locataire</legend>
			<ol>
				<li>
					<label>Nom</label>
					<input type="text" name="tname" required/>
				</li>
				<li>
					<label>Adresse</label>
					<input type="text" name="taddress" required/>
				</li>
				<li>
					<label>Code Postal</label> 
					<input type="text" name="tzip" required/>
				</li>
				<li>
					<label>Ville</label> 
					<input type="text" name="tcity" required/>
				</li>
			</ol>
		</fieldset>
		<fieldset>
			<legend>Autres informations :</legend>
			<ol>
				<li>
					<label>Début p&eacute;riode</label> 
					<input type="date" name="startperiod" class="datepicker" required/>
				</li>
			</ol>
		</fieldset>
		<fieldset>
			<button type="submit">Créer la lettre de demande de quittance</button>
		</fieldset>
	</form>
	<p>
<%@ include file="templates/footer.jsp" %>