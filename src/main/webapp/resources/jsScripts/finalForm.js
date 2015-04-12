function debitor_field(personObject,source)
{
	
	$( "#"+source.querier+"_data" ).empty();
	$div_container=$("<div/>",{class:"container",css:{"height":"100%"}}).appendTo($( "#"+source.querier+"_data" ));
	$table=$("<table style='width:90%;margin-left:20px;box-shadow:1px 1px 3px #888;background-color:#ADAA8F'></table>").appendTo($div_container);
	$("<caption/>",{css:{
		"text-align":"left",
		"font-size":"30px",
		"padding":"5px",
		"color":"#3E4D1D"
	}}).appendTo($table).html(source.querier+" personana " + source.tipPersoana);
	
	
	
	for(var i=0;i<source.formLoadSource.length;i++){
		$tr1=$("<tr></tr>").appendTo($table);
		$th=$("<th>"+source.formLoadSource[i][0]+"</th>").appendTo($tr1);
		$th.css("text-align","left");
		$th.css("width","35%");
		$th.css("padding","5px");
		var str=personObject[source.formLoadSource[i][1]];
		$td=$("<td></td>").appendTo($tr1);
		$("<input disabled></input>").css("width","90%").val(str).appendTo($td);
		$td.css("height","40px");
		
		
	}
	
	$editeaza=$("<input/>",{
		type:"button",
		value:"Editeaza",
		css:{
			"margin-left":"40%",
			
			"margin-top":"10px"
		},
		click:function(){
		
			$("#datePersoane").css("display","none");
			$("#bottomTable").css("display","none");
			
			
			form_select(source);
			$("#cancelbtn").prop("disabled",false);
			$("#clearbtn").prop("disabled",false);
			formSubscribeCompleteForEdit(personObject);
			}
			
		
		
	}).appendTo($div_container);
	if(source.querier=='debitor'){
		$("#bottomTable").empty();
		$("<h1 style='font-size:1.8em'>Debitori solidari:<h1>").appendTo($("#bottomTable"));
		$add=$("<input/>",{
			type:"button",
			value:"Adauga",
			css:{
				"float":"right",
				"margin-right":"350px"
			},
			click:function(){
				var index=$("#statut_juridic_debitor_solidar").jqxComboBox('getSelectedIndex');
				if(index==0)
				form_select(debitorSourcePFInitiate,true);
				else
				form_select(debitorSourcePJInitiate,true);
				
				$("#cancelbtn").prop("disabled",false);
				$("#clearbtn").prop("disabled",true);
				
			}
	}).appendTo($("#bottomTable"));
	$("<div/>",{
		"id":"statut_juridic_debitor_solidar"
	}).appendTo($("#bottomTable"));
	$("#statut_juridic_debitor_solidar").jqxComboBox({
		source : tipPersoaneStatutsource,
		selectedIndex : 0,
		width : '250',
		height : '25px'
	});
	$div_data_deb_solid=$("<div><h3 style='font-style:italic;margin-top:20px'>Debitori solidari Persoane Fizice</h3></div>").appendTo($("#bottomTable"));
	$("<div/>",{
		"id":"debListPF"
	}).appendTo($div_data_deb_solid);
	$div_data_deb_solidPJ=$("<div><h3 style='font-style:italic;margin-top:20px'>Debitori solidari Persoane Juridice</h3></div>").appendTo($("#bottomTable"));
	$("<div/>",{
		"id":"debListPJ"
	}).appendTo($div_data_deb_solidPJ);
	}
}