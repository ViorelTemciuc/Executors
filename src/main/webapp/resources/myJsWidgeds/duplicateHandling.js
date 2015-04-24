function construcDuplicateWindow(source){
	var sourceforPersons=new Array();
	
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
		           
		           localdata:source
	}
	var dataAdapter = new $.jqx.dataAdapter(sourceforAdapter);
	
	
    $("#duplicate p").jqxDataTable({
    	source:dataAdapter,
    	editable:false,
    	theme: 'energyblue',
    	selectionMode: "singleRow",
    	columns:[
    	         {"text":"Cod Fiscal",dataField:"idnp",width:120},
    	         {"text":"Denumire",dataField:"name",width:150},
    	         {"text":"Adresa/Sediul",dataField:"adress1",width:150},
    	         {"text":"Adresa Cor.",dataField:"adress2",width:150},
    	         {"text":"Email",dataField:"email",width:130}
    	         ]
    });
    
    $("#duplicate").css('display','block');
    $.blockUI({ message: $('#duplicate'),
		 css: { 
               top:  ($(window).height() - 400) /2 + 'px', 
               left: ($(window).width() - 400) /4 + 'px', 
               width: '800px' 
           } });
    
    $("#duplicateCancel").on("click",function(){
    	 $("#duplicate").css('display','none');
    	 $.blockUI({ message: $('#PPForm'),
    		 css: { 
                   top:  ($(window).height() - 400) /2 + 'px', 
                   left: ($(window).width() - 400) /2 + 'px', 
                   width: '500px' 
               } });
    });
    $('#duplicate p').on('rowDoubleClick',function(event){
    	var subType=GlobalPersonType.split("_")[0]+GlobalPersonSubType;
    	var args=event.args;
    	    	
    	var rowData =args.row;
    	rowData['idnp']=parseInt(rowData['idnp'].valueOf());
    	delete rowData['uid'];
    	$.ajax({
			contentType: 'application/json',
			type:"POST",
			url:urlPersons+"/personsForceAdd?type="+subType+"&incheiere_id=1&update=false",
			data:JSON.stringify(rowData),
			success:function(map){
				if(map['duplicate']===undefined){
					$("#duplicate p").remove();
					$('<p align="center" style="display:-moz-inline-grid"></p>').insertAfter($("#duplicate h4"));
					$.unblockUI();
					$("#duplicate").css('display','none');
					$("#PPForm").remove();
					updateDataTables(map);
					
					
				}
				else{
					
						construcDuplicateWindow(map['duplicate']);
					
				}
					
			}
		});
    	event.stopImmediatePropagation();
    	event.stopPropagation(); 	
    	
    });
	
}