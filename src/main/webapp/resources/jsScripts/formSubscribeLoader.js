
function formSubscribeCompleteForEdit(sourceObject)
{        	
        	$.each(sourceObject,function(key,value){
        	$("#"+key).val(value);
        
    });
}
function deleteRecord(serializedData,url){
	 $.ajax({
    	 contentType: 'application/json',
    	 
	url: url+'/delete',
    type: "post",
    data: JSON.stringify(serializedData),
    
   
    
}).done(function(response){
	
});
	
}
function open_dialog_form(serializedData,settings,updateIndex){
	var $div=$("<div/>",{
		id:"dialog-confirm",
		title:"Update la persoana?",
		css:{
			"overflow":"visible"
		}
	}).appendTo(document.body);
	var $p=$("<p></p>").appendTo($div)
	
	var $span=$("<span/>",{
		class:"ui-icon ui-icon-alert",
		css:{
			"float":"left",
			"margin":"0 7px 20px 0"
		}
	}).appendTo($p)
	$p.append("Doriti innoirea datelor despre persoana,sau reeditarea acesteia?");
	$div.dialog({
		resizable: false,
		height:140,
		modal: true,
		buttons: {
		"Innoire": function() {
			// Fire off the request to 
	        $.ajax({
	        	 contentType: 'application/json',
	        	 
	    	url: settings.source.action+'/update',
	        type: "post",
	        data: JSON.stringify(serializedData),
	        
	       
	        
	    }).done(function(response){
	    	if(!settings.options.solidari){
	    	afterFormEvent(settings,serializedData);
	    	}
	    	else{
	    		if(options.source.tipPersoana=='fizica'){
		    		  PersoanaFizicaList.splice(updateIndex,1);
		    		  afterFormEvent(settings,serializedData,"",true);
		    	  }					    		  
		    	  else{
		    		  PersoanaJuridicaList.splice(updateIndex,1);
		    		  afterFormEvent(settings,serializedData,"",true);
		    	  }
	    			
	    	}
	    });
		$( this ).dialog( "close" );
		},
		"Editare": function() {
		$( this ).dialog( "close" );
		}
		}
		});
	$(".ui-dialog-buttonset").css("margin-top","50px");
	$div.css("overflow","visible");
}
function validate_form($form){
	return false;
}
function delete_persons_form()
{
	$( "#forma_add_persoane" ).empty();
}
function afterFormEvent(settings,personsData,text,solidari)
{	
	delete_persons_form();
	$("#statut_juridic_"+settings.source.querier).jqxComboBox({disabled:true});
	$("#"+settings.source.reprezentantCheckBox).jqxCheckBox({disabled:false});
	$("#forma_add_persoane").css("display","none");
	$("#datePersoane").css("display","block");
	$("#bottomTable").css("display","block");
	if(solidari&&settings.source.querier=="debitor"){
		fullfilldataTable()
	}
	else{
		$("#"+settings.source.textboxrootId).val(text);
		$("#"+settings.source.textboxrootId).jqxInput({disabled:true});
		debitor_field(personsData,settings.source);
	}
	
}
function fullfilldataTable(personsList,debitorSourcePFInitiate){
	var sourcePF =
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
			           localdata:PersoanaFizicaList
		}
	var dataAdapterPF = new $.jqx.dataAdapter(sourcePF);
    $("#debListPF").jqxDataTable({
    	source:dataAdapterPF,
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
    $("#debListPF").on('rowDoubleClick',function(event){
    	var args=event.args;
    	var index=args.index;
    	initiatePersonsDataForm(index,debitorSourcePFInitiate,PersoanaFizicaList);
    	event.stopImmediatePropagation();
    	event.stopPropagation();
    	
    });
    
	var sourcePJ=
		{
			datatype: "array",
			datafields:[
			            {"name":"idnp"},
			            {"name":"denumire"},
			            {"name":"adresa_sediu"},
			            {"name":"adresa_corespondenta"},
			            {"name":"email"}
			           ],
			           id:"idnp",
			           localdata:PersoanaJuridicaList
		}
	var dataAdapterPJ = new $.jqx.dataAdapter(sourcePJ);
    $("#debListPJ").jqxDataTable({
    	source:dataAdapterPJ,
    	editable:false,
    	columns:[
    	         {"text":"Idnp",dataField:"idnp",width:120},
    	         {"text":"Denumire",dataField:"denumire",width:150},
    	         {"text":"Sediul",dataField:"adresa_sediu",width:150},
    	         {"text":"Adresa Cor.",dataField:"adresa_corespondenta",width:150},
    	         {"text":"Email",dataField:"email",width:130}
    	         ]
    });
 $("#debListPJ").on('rowDoubleClick',function(event){
    	
    	var args=event.args;
    	var index=args.index;
    	initiatePersonsDataForm(index,debitorSourcePJInitiate,PersoanaJuridicaList);
    	event.stopImmediatePropagation();
    	event.stopPropagation(); 	
    	
    });
}
function initiatePersonsDataForm(index,source,List){
	
	form_select(source,true,true,index);
	formSubscribeCompleteForEdit(List[index]);
	$("#cancelbtn").prop("disabled",false);
	$("#clearbtn").prop("disabled",false);
	
}