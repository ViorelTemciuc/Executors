$(document).ready(
		function() {
			$("#debitor_input").jqxInput({
				placeHolder : "Introduceti debitor",
				height : 25,
				width : 225,
				minLength : 1
			});
			$("#debitor_input").keyup(function(e){
				if(e.keyCode==13)
					{
					var param;
					if(isNaN(parseInt($(this).val())))
					   param="searchName?name="+$(this).val();
					else
						param="searchIdnp?idnp="+parseInt($(this).val());
							
					var url="http://localhost:5080/executors/personsFizAdd/"+param;
					  $.ajax({
				        	 contentType: 'application/json',
				        	 
				    	url: url,
				        type: "get",
				        dataType:"json"
				        
				       
				        
				    }).done(function(personsList){
				    	fullfilldataTable(personsList,debitorSourcePFInitiate);
				    	alert(personsList);
					});
					}
				    
			});
			$("#datePersoane").jqxRibbon({ height: 350, width:720, position: "right", selectionMode: "hover", animationType: "fade" });
			$("#open_form_persons_debitor").jqxButton();
			$("#open_form_persons_debitor").on(
					'click',
					function() {
						{
							var index = $("#statut_juridic_debitor").jqxComboBox(
									'getSelectedIndex');
							if(index==0)
								form_select(debitorSourcePFInitiate);
							else
								form_select(debitorSourcePJInitiate);
						
						}
					});
			$("#reprezentant_debitor_input").jqxInput({
				placeHolder : "Introduceti reprezentant debitor",
				height : 25,
				width : 250,
				minLength : 1
			});
			$("#statut_juridic_debitor").jqxComboBox({
				source : tipPersoaneStatutsource,
				selectedIndex : 0,
				width : '250',
				height : '25px'
			});
			$('#statut_juridic_debitor').on('change', function(event) {
				if($.trim($("#forma_add_persoane").html())!='')
					{
				delete_persons_form();
				var index = args.index;
				
		if(index==0)
			form_select(debitorSourcePFInitiate);
		else
			form_select(debitorSourcePJInitiate);
					}

			});
			$("#statut_juridic_reprezentant_debitor").jqxComboBox({
				source : tipPersoaneStatutsource,
				selectedIndex : 0,
				width : '250',
				height : '25px'
			});
			$("#reprezentant_debitor_checkbox").jqxCheckBox({
				width : 120,
				height : 25,
				checked : false,
				disabled : true
			});
			$("#reprezentant_debitor_checkbox").on('checked', function(event) {
				$("#reprezentant_debitor").removeClass("hidden");
				$("#reprezentant_debitor").addClass("visible");
			});
			$("#reprezentant_debitor_checkbox").on('unchecked',
					function(event) {
						$("#reprezentant_debitor").removeClass("visible");
						$("#reprezentant_debitor").addClass("hidden");
					});
			$('#mainSplitter').jqxSplitter({
				width : 1080,
				height : 800,
				panels : [ {
					size : 350
				} ]
			});

		});
