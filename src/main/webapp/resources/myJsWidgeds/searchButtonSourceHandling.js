function constructSearchButtonWidget(inputId){
	
	$( "#"+inputId ).autocomplete({
	      source:  urlPersons+"/getSearchedPersons",
	      minLength: 3,
	      select: function( event, ui ) {
	    	  var subType=$( this ).attr('id').split("_")[0]+GlobalPersonSubType;
	    	    $.ajax({
	  			type:"GET",
	  			url:urlPersons+"/personsFromSearchAdd?idnp="+parseInt(ui.item.label.split(",")[0].trim())+"&type="+subType+"&incheiere_id=1",
	  			success:function(map){
	  				if(map['duplicate']===undefined){
	  				updateDataTables(map);
	  				$.unblockUI();
	  				$("#PPForm").remove();
	  				}
	  				else{
	  					
	  						construcDuplicateWindow(map['duplicate']);
	  											
	  				}
	  					
	  			}
	  		});
	    	  },
	    	  open: function() {
	    	  $( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
	    	  },
	    	  close: function() {
	    	  $( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
	    	  }
	     
	    });
}