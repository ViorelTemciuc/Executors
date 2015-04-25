var urlPersons=document.URL+"/persons";
var urlMain=document.URL;
var GlobalPersonType='';
var GlobalPersonSubType='';
var RomanianGlobalPersonSubType='';
$("#deb").on("click",function(){
	RomanianGlobalPersonSubType="Debitori";
	getPersonRequest("/personsGet","Debtor",1);
	GlobalPersonSubType="Debtor"
    
});
$("#rdeb").on("click",function(){
	getPersonRequest("/personsGet","CoDebtors",1);
	
});
$("#cred").on("click",function(){
	RomanianGlobalPersonSubType="Creditori";
	getPersonRequest("/personsGet","Creditor",1);
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
		searchWidget(widgetId,widgetId+"search");
		$("<div id='"+table+"' style='margin-bottom:10px'></div>").appendTo($("#"+widgetId));
		dataTableLoader(source,table);	
	}
	else{
		$title=$("<h3>"+title+"</h3>").appendTo($("#"+widgetId));
		searchWidget(widgetId,widgetId+"search");
		}
}
function constructAddTypesHTML(type,widgetId){
	$('<div class="personsType" style="display:inline-flex;float:right;margin-right:10px">'+
			'<button id="'+type+'_B">Adaugare</button>'+
			'<div id="'+type+'_BS" name="'+type+'BS"></div>').appendTo($("#"+widgetId));
	 var comboBoxSource = ["Persoana Fizica","Persoana Juridica"];
	 $("#"+type+"_BS").jqxComboBox({ source: comboBoxSource, selectedIndex: 0, width: '200', height: '25', dropDownHeight:'50px',});
	 $("#"+type+"_B").jqxButton({ width: '150'});
	$("#"+type+"_B").on("click",function(){
		GlobalPersonType=this.id;
		var formType;
		 var item =$("#"+type+"_BS").jqxComboBox('getSelectedItem');
		if(item.label=='Persoana Fizica')
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
						   overrideSubmit(false);
						});
					 
					
					
					
				}
			});
		});
	}
function updateDataTables(map){
	if(map['solidari'].length>0){
		$("#Solidar_P").empty();
		constructHtmlList("Lista "+RomanianGlobalPersonSubType+"lor solidari","Solidar_P",true,"Solidar_Table",map['solidari']);
		constructAddTypesHTML("Solidar","Solidar_P");}
	else{
		$("#Solidar_P").empty();
		constructHtmlList("Nu exista "+RomanianGlobalPersonSubType+"i solidari inserati pentru aceasta procedura","Solidar_P",false,"solidarTable");
		constructAddTypesHTML("Solidar","Solidar_P");
	}
	if(map['co'].length>0){
		$("#Co_P").empty();
		constructHtmlList("Lista co"+RomanianGlobalPersonSubType+"ilor ","Co_P",true,"Co_Table",map['co']);
		constructAddTypesHTML("Co","Co_P");
		}
	else{
		$("#Co_P").empty();
		constructHtmlList("Nu exista co "+RomanianGlobalPersonSubType+"i inserati pentru aceasta procedura","Co_P",false,"coTable");
		constructAddTypesHTML("Co","Co_P");
	}
}
function searchWidget(widgetId,inputId){
	$('<div class="search-widget">' +
	  '<label for="'+inputId+'" style="line-height:2" >Cautare: </label>' +
	  '<input id="'+inputId+'" style="padding:0px"/><p id="searchIcon"></p>' +
	  '</div>').appendTo($("#"+widgetId));
	   constructSearchButtonWidget(inputId);
	 }
