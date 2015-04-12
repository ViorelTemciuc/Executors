	
$.when(PrivatePersonsListAjax(table)).done(function(responseList){
    var PrivatePersonsTable =
		{
			datatype: "array",
			datafields:[
			            {"name":"idnp"},
			            {"name":"nume"},
			            {"name":"prenume"},
			            {"name":"adresa_domiciliu"},
			            {"name":"adresa_corespondenta"},
			            {"name":"email"}
			           ],
			           id:"idnp",
			           localdata:responseList
		}
   	var PrivatePersonsDataAdapter = new $.jqx.dataAdapter(PrivatePersonsTable);
    $("#"+table).jqxDataTable({
    	source:PrivatePersonsDataAdapter,
    	editable:false,
    	columns:[
    	         {"text":"Idnp",dataField:"idnp",width:120},
    	         {"text":"Nume",dataField:"nume",width:80},
    	         {"text":"Prenume",dataField:"prenume",width:80},
    	         {"text":"Adresa Dom.",dataField:"adresa_domiciliu",width:150},
    	         {"text":"Adresa Cor.",dataField:"adresa_corespondenta",width:150},
    	         {"text":"Email",dataField:"email",width:100}
    	         ]
    });
});
    function PrivatePersonsListAjax(table){
    	 $.ajax({
        	 contentType: 'application/json',       	 
    	     url: "getPersonsList?type=private",
             type: "get",
             dataType:"json" 
             });
           
    }