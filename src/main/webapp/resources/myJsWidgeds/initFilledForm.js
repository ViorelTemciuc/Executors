function constructInitFilledForm(source){
	var nameString=source['name'];
	var formType;
	 if(nameString.split("|").length>0)
		 formType = "publicForm";
	 else
		 formType = "privateForm";
		$.ajax({
				url:urlMain+"/initPersonsAddForm?formType="+formType,
				success:function(form){
					$( "body" ).append(form);
					
					$.getScript('resources/myJsWidgeds/formAddWidget.js').done(function() {
						generateForm();
						$.blockUI({ message: $('#PPForm'),
							 css: { 
					                top:  ($(window).height() - 400) /2 + 'px', 
					                left: ($(window).width() - 400) /2 + 'px', 
					                width: '500px' 
					            } });
						$("#groupButtons").jqxButtonGroup({ mode: 'default' });
						insertFormData(source, formType);
						   overrideSubmit(true);
						});
					 
					
					
					
				}
			});
		
	}
function insertFormData(source,formType){
	if(formType=='publicForm')
		$("#name").attr('value',source['name']);
	else {
		$("#name").attr('value',source['name'].split("|")[0]);
		$("#sname").attr('value',source['sname'].split("|")[1]);
	}
		$("#idnp").attr('value',source['idnp']);
		$("#adress1").attr('value',source['adress1']);
		$("#adress2").attr('value',source['adress2']);
		$("#email").attr('value',source['email']);
		
}
