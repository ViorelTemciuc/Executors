function constructSearchButtonWidget(inputId){
	
	$( "#"+inputId ).autocomplete({
	      source:  urlPersons+"/getSearchedPersons",
	      minLength: 3,
	      select: function( event, ui ) {
	    	  var $p = $('<p></p>').html(data.item.value).css({'display': 'inline-block', 'background-color': '#a0a0a0', 'color': '#ff0000'});
	            $(event.target).after($p);
	      }
	     
	    });
}