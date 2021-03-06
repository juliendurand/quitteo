<%@ include file="templates/header.jsp" %>
<H3>Editer une quittance de loyer</H3>
Vous &ecirc;tes propri�taire d'un logement locatif et vous souhaitez �diter une quittance de loyer&nbsp;? 
Cette page est faite pour vous.
<p/>
Remplissez le formulaire ci-dessous et t�l�chargez gratuitement votre quittance de loyer.
<p/> 
Imprimez, signez et envoyez la � votre locataire.
<p/>
C'est simple, rapide et gratuit !
		<form id="quittance" action="quittance"  method="get" class="shadow form" oninput="t.value = rent.valueAsNumber + charges.valueAsNumber;total.value=t.value;">
		<fieldset>
			<legend>Bailleur</legend>
			<ol>
				<li>
					<label>Pr&eacute;nom et Nom</label>
					<input type="text" name="llname" required/>
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
					<label>D�but p&eacute;riode</label> 
					<input type="date" name="startperiod" class="datepicker" required/>
				</li>
				<li>
					<label>Fin p&eacute;riode</label>
					<input type="date" name="endperiod" class="datepicker" required/>
				</li>
				<li>
					<label>Loyer</label> 
					<input type="number" step="0.01" name=rent value="0" required/>
				</li>
				<li>
					<label>Charges</label> 
					<input type="number" step="0.01" name=charges value="0"/>
				</li>
				<li>
					<label>Total</label> 				
					<input type="hidden" name="total">
					<output name=t>0</output>
				</li>
			</ol>
		</fieldset>
		<fieldset>
			<button type="submit">Cr�er la quittance</button>
		</fieldset>
	</form>
	<p>
<%@ include file="templates/footer.jsp" %>