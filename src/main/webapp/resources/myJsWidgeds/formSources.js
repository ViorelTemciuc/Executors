var sourcePFTableTH=[["Nume","nume"],["Prenume","prenume"],["IDNP","idnp"]
,["Adresa domiciliu","adresa_domiciliu"],["Adresa corespondenta","adresa_corespondenta"],["Email","email"]];
var sourcePFInitiate = [
		[ [ "nume", "Introduceti nume (ex.Popescu)" ], 
		  [ "label", "Nume" ,"Numele introdus nu este sugestiv"] ],
		[ [ "prenume", "Introduceti prenumele (ex.Gheorghe)" ],
				[ "label", "Prenume" ,"Prenumele introdus nu este sugestiv"] ],
		[ [ "idnp", "Introduceti cod numeric personal (ex.200288871111)" ],
				[ "label", "IDNP" ,"IDNP contine numai cifre si este de lungimea 13"] ],
		[ [ "adresa_domiciliu", "Introduceti adresa de domiciliu" ],
				[ "label", "Adresa de domiciliu" ] ],
		[
				[ "adresa_corespondenta",
						"Introduceti adresa de corespondenta daca exista" ],
				[ "label", "Adresa de corespondenta" ] ],
		[ [ "email", "Introduceti adresa de email" ],
		  [ "label", "Email" ,"Adresa de email nu este valida"]] ];
var debitorSourcePFInitiate = {
	tipPersoana : "fizica",
	reprezentant : "",
	constructor : sourcePFInitiate,
	querier : "debitor",
	action : "http://localhost:5080/executors/personsFizAdd",
	text : "OK",
	submitid : "submit_debitor",
	textboxrootId : "debitor_input",
	reprezentantCheckBox: "reprezentant_debitor_checkbox",
	buttonEventProvenience : "open_form_persons_debitor",
	formLoadSource:sourcePFTableTH,
	statutCombobox:"statut_juridic_debitor",
	
}
var sourcePJTableTH=[["Denumire","denumire"],["Cod Fiscal","idnp"]
,["Adresa Sediu","adresa_sediu"],["Adresa corespondenta","adresa_corespondenta"],["Email","email"]];
var sourcePJInitiate = [
		[ [ "denumire", "Introduceti denumirea (de ex. SRL 'ALFA')" ], 
		  [ "label", "Denumirea" ,"Denumirea introdusa nu este sugestiva"] ],
		[ [ "idnp", "Introduceti codul fiscal (ex.200288871111)" ],
				[ "label", "Cod Fiscal" ,"Codul fiscal contine numai cifre si este de lungimea 13"] ],
		[ [ "adresa_sediu", "Introduceti adresa de sediu" ],
				[ "label", "Sediul" ] ],
		[
				[ "adresa_corespondenta",
						"Introduceti adresa de corespondenta daca exista" ],
				[ "label", "Adresa de corespondenta" ] ],
		[ [ "email", "Introduceti adresa de email" ],
		  [ "label", "Email" ,"Adresa de email nu este valida"]] ];
var debitorSourcePJInitiate = {
	tipPersoana : "juridica",
	reprezentant : "",
	constructor : sourcePJInitiate,
	querier : "debitor",
	action : "http://localhost:5080/executors/personsJurAdd",
	text : "OK",
	submitid : "submit_debitor",
	textboxrootId : "debitor_input",
	reprezentantCheckBox: "reprezentant_debitor_checkbox",
	buttonEventProvenience : "open_form_persons_debitor",
	formLoadSource:sourcePJTableTH,
	statutCombobox:"statut_juridic_debitor"
}


