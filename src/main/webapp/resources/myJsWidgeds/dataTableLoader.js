function dataTableLoader(source,table){
	
	loadTable(source,table);
	
}
function loadTable(source,table){
	var sourceforPersons=new Array();
	for (i=0;i<source.length;i++){
		sourceforPersons[i]=source[i]['person'];
	}
	var sourceforAdapter =
	{
		datatype: "array",
		datafields:[
		            {"name":"idnp"},
		            {"name":"name"},
		            {"name":"adress1"},
		            {"name":"adress2"},
		            {"name":"email"}
		           ],
		           id:"idnp",
		           localdata:sourceforPersons
	}
	var dataAdapter = new $.jqx.dataAdapter(sourceforAdapter);
	
	
    $("#"+table).jqxDataTable({
    	source:dataAdapter,
    	editable:false,
    	columns:[
    	         {"text":"Cod Fiscal",dataField:"idnp",width:120},
    	         {"text":"Denumire",dataField:"name",width:150},
    	         {"text":"Adresa/Sediul",dataField:"adress1",width:150},
    	         {"text":"Adresa Cor.",dataField:"adress2",width:150},
    	         {"text":"Email",dataField:"email",width:130}
    	         ]
    });
    $("#"+table).on('rowDoubleClick',function(event){
    	
    	var args=event.args;
    	var index=args.index;
    	initiatePersonsDataForm(index,debitorSourcePJInitiate,PersoanaJuridicaList);
    	event.stopImmediatePropagation();
    	event.stopPropagation(); 	
    	
    });
	
}