var urlPersons=document.URL+"/persons";
var urlMain=document.URL;
var GlobalPersonType='';
var GlobalPersonSubType='';
var RomanianGlobalPersonSubType='';
$("#deb").on("click",function(){
	RomanianGlobalPersonSubType="Debitori";
	getPersonRequest("/personsGet","debtors",1);
	GlobalPersonSubType="Debtor"
    
});
$("#rdeb").on("click",function(){
	getPersonRequest("/personsGet","CoDebtors",1);
	
});
$("#cred").on("click",function(){
	RomanianGlobalPersonSubType="Creditori";
	getPersonRequest("/personsGet","creditors",1);
	GlobalPersonSubType="Creditor"
	
});
$("#rcred").on("click",function(){
	getPersonRequest("/personsGet","CoCreditors",1);
	RomanianGlobalPersonSubType="Creditori";
	
});
function getPersonRequest(url,type,incheiere_id){
	$.ajax({
		url:urlPersons+url+"?type="+type+"&incheiere_id="+incheiere_id,
		success:function(map){
			updateDataTables(map,type);
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
			'<input id="'+type+'_B" type="button"  value="Adaugare">'+
			'<select id="'+type+'_BS" name="'+type+'BS">'+
			'<option value="private">Persoana Fizica</option>'+
			'<option value="public">Persoana Juridica</option>'+
			'</select></div></div>').appendTo($("#"+widgetId));
	$("#"+type+"_B").on("click",function(){
		GlobalPersonType=this.id;
		var formType;
		if($( "#"+type+"_BS" ).val()=='private')
			formType="privateForm";
		else formType="publicForm";
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
						   overrideSubmit();
						});
					 
					
					
					
				}
			});
		});
	}
function updateDataTables(map){
	if(map['solidari'].length>0){
		$("#solidarP").empty();
		constructHtmlList("Lista "+RomanianGlobalPersonSubType+"lor solidari","Solidar_P",true,"solidarTable",map['solidari']);
		constructAddTypesHTML("Solidar","Solidar_P");}
	else{
		$("#solidarP").empty();
		constructHtmlList("Nu exista "+RomanianGlobalPersonSubType+"i solidari inserati pentru aceasta procedura","Solidar_P",false,"solidarTable");
		constructAddTypesHTML("Solidar","Solidar_P");
	}
	if(map['co'].length>0){
		$("#coP").empty();
		constructHtmlList("Lista co"+RomanianGlobalPersonSubType+"ilor ","Co_P",true,"coTable",map['co']);
		constructAddTypesHTML("Co","Co_P");
		}
	else{
		$("#coP").empty();
		constructHtmlList("Nu exista co "+RomanianGlobalPersonSubType+"i inserati pentru aceasta procedura","Co_P",false,"coTable");
		constructAddTypesHTML("Co","Co_P");
	}
}