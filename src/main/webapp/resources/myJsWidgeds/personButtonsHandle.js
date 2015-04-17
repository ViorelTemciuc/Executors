var urlAbs="http://localhost:5080/executors/persons/";
$("#deb").on("click",function(){
	getPersonRequest("/personsGet","SolidarDebtor",1);
});
$("#rdeb").on("click",function(){
	getPersonRequest("/personsGet","CoDebtors",1);
});
$("#cred").on("click",function(){
	getPersonRequest("/personsGet","SolidarCreditor",1);
	
});
$("#rcred").on("click",function(){
	getPersonRequest("/personsGet","CoCreditors",1);
});
function getPersonRequest(url,type,incheiere_id){
	$.ajax({
		url:urlAbs+url+"?type="+type+"&incheiere_id="+incheiere_id,
		success:function(map){
			if(map['solidari'].length>0){
				constructHtmlList("Lista "+type+"ilor solidari","solidarP",true,"solidarTable",map['solidari']);
				constructAddTypesHTML("solidari","solidarP");}
			else{
				constructHtmlList("Nu exista "+type+"i solidari inserati pentru aceasta procedura","solidarP",false,"solidarTable");
				constructAddTypesHTML("solidari","solidarP");
			}
			if(map['co'].length>0){
				constructHtmlList("Lista co"+type+"ilor ","coP",true,"coTable",map['co']);
				constructAddTypesHTML("co","coP");
				}
			else{
				constructHtmlList("Nu exista co "+type+"i inserati pentru aceasta procedura","coP",false,"coTable");
				constructAddTypesHTML("co","coP");
			}
		}
	});
}
function constructHtmlList(title,widgetId,present,table,source){
	if(present){
		$("<h3>"+title+"</h3>").appendTo($("#"+widgetId));
		$("<div id='"+table+"'></div>").appendTo($("#"+widgetId));
		dataTableLoader(source,table);	
	}
	else{
		$title=$("<h3>"+title+"</h3>").appendTo($("#"+widgetId));
		}
}
function constructAddTypesHTML(type,widgetId){
	$('<div class="personsType">'+
			'<input id="'+type+'B" type="button"  value="Adaugare">'+
			'<select id="'+type+'BS" name="'+type+'BS">'+
			'<option value="private">Persoana Fizica</option>'+
			'<option value="public">Persoana Juridica</option>'+
			'</select></div></div>').appendTo($("#"+widgetId));
	$("#"+type+"B").on("click",function(){
		var formType;
		if($( "#"+type+"BS" ).val()=='private')
			formType="privateForm";
		else formType="publicForm";
		$.ajax({
				url:"http://localhost:5080/executors/initPersonsAddForm?formType="+formType,
				success:function(form){
					$( "body" ).append(form);
					
					$.getScript('resources/myJsWidgeds/formAddWidget.js').done(function() {
						generateForm();
						$.blockUI({ message: $('#PPForm') });
						 overrideSubmit();
						});
					 
					
					
					
				}
			});
		});
	}
