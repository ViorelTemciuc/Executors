var tipPersoaneStatutsource = new Array();
tipPersoaneStatutsource[0]={html:"<div>Persoana Fizica</div>",title:"Persoana Fizica"};
tipPersoaneStatutsource[1]={html:"<div>Persoana Juridica</div>",title:"Persoana Juridica"};
$(document).ready(
		function() {
$.ajax({
	 
	 
url: "http://localhost:5080/executors/personsFizAdd",
type: "get",
dataType:"json"



}).done(function(personsList){
fullfilldataTable(personsList,debitorSourcePFInitiate);
alert(personsList);
});
		});

