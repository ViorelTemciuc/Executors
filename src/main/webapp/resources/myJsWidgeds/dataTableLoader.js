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
	
	
    $("#"+table).jqxGrid({
    	source:dataAdapter,
    	editable:false,
    	theme: 'energyblue',
    	selectionMode: 'singleRow',
    	autoheight: true,
    	width:790,
    	columns:[
    	         {"text":"Cod Fiscal",dataField:"idnp",width:120},
    	         {"text":"Denumire",dataField:"name",width:150},
    	         {"text":"Adresa/Sediul",dataField:"adress1",width:150},
    	         {"text":"Adresa Cor.",dataField:"adress2",width:150},
    	         {"text":"Email",dataField:"email",width:130},
    	         { "text": 'Delete', datafield: 'Delete', columntype: 'button',width:90, cellsrenderer: function () {
                     return "Delete";
                  }, buttonclick: function (row) {
                	  GlobalPersonType=table;
                	 
                		var rowData  =  $("#"+table).jqxGrid('getrowdata', row);
                		rowData['idnp']=parseInt(rowData['idnp'].valueOf());
                		delete rowData['uid'];
                     // open the popup window when the user clicks a button.
                	  $( "#dialog-confirm" ).dialog({
                	      resizable: false,
                	      height:140,
                	      width:500,
                	      modal: true,
                	      buttons: {
                	        "Eliminare din Incheiere": function() {
                	        	deletePerson(false,rowData);
                	        	$( this ).dialog( "close" );
                	        	$( "#dialog-confirm" ).empty();
                	        },
                	        "Eliminare din Incheiere si DB":function(){
                	        	deletePerson(true,rowData);
                	        	$( this ).dialog( "close" );
                	        	$( "#dialog-confirm" ).empty();
                	        },
                	        Cancel: function() {
                	          $( this ).dialog( "close" );
                	          $( "#dialog-confirm" ).empty();
                	        }
                	      }
                	    });
                	  $("#dialog-confirm").css('height','auto');
                	    $(".ui-dialog-buttonset").css("font-size","10px");
                    
                 }
    	         }
    	         ]
    });
   
    
    $("#"+table).on('rowdoubleclick',function(event){
    	
    	 var rowIndex = event.args.rowindex;
    	 var data={};
       
        $("#PPForm").remove();
         var dataRecord =  $("#"+table).jqxGrid('getrowdata', rowIndex);
         GlobalPersonType=table;
         data['idnp'] = parseInt(dataRecord.idnp);
         data['name'] = dataRecord.name;
         data['adress1']=dataRecord.adress1;
         data['adress2']=dataRecord.adress2;
         data['email']=dataRecord.email;
         constructInitFilledForm(data);
         
    	
    });
	
}
function deletePerson(all,rowData) {
	var subType=GlobalPersonType.split("_")[0]+GlobalPersonSubType;
	
	$.ajax({
		contentType: 'application/json',
		type:"POST",
		url:urlPersons+"/personsDelete"+"?type="+subType+"&incheiere_id=1&all="+all,
		data:JSON.stringify(rowData),
		success:function(map){
			
			updateDataTables(map);
							
		}
	});
}
