var PersoanaFizicaList=new Array();
var PersoanaJuridicaList=new Array();
var PersoanaFizica={};
var PersoanaFizicaReprezentant={};
var PersoanaJuridica={};
var PesoanaJuridicaReprezentant={};
var txtBox;

(function($){
	$.fn.personsForm = function(options){
		var settings=$.extend({
			source:null,
			solidari:false,
			update:false,
			updateIndex:0
			
		},options);
		
		return this.each(function(){
			var $form=$("<form/>",{
				action:settings.source.action,
				
				submit:function (e) {
				      e.preventDefault();
						
					    var $inputs = $(this).find("input, select, button, textarea");
					    var url = $(this).attr('action');
					    // Serialize the data in the form
					    var serializedData = $form.serializeObject();
					   // var serializedData={"nume":"fdf","prenume":"dfhdf","idnp":7177877,"adresa_domiciliu":"dhfh","adresa_corespondenta":"dfhdf","email":"fhd"}
					      serializedData['idnp']=parseInt(serializedData['idnp']);
					    // Let's disable the inputs for the duration of the Ajax request.
					    // Note: we disable elements AFTER the form data has been serialized.
					    // Disabled form elements will not be serialized.
					    $inputs.prop("disabled", true);

					    // Fire off the request to 
					        $.ajax({
					        	 contentType: 'application/json',
					        	 
					    	url: url,
					        type: "post",
					        data: JSON.stringify(serializedData),
					        
					       
					        
					    }).done(function(response){
					    	if(response=="exists"){
					    		open_dialog_form(serializedData,settings,updateIndex);
					    	}
					    	else{
					    		formEventsHandling(settings,serializedData);					    		
					    	}
					    });
                        
					    // Callback handler that will be called on success
					   
					}
			}).appendTo($(this));
			$('<legend style="color:blue;font-weight:bold;font-size:20px;">Date despre ' + settings.source.reprezentant + ' ' +settings.source.querier+ ' persoana ' +settings.source.tipPersoana+'</legend>').appendTo($form);
			var $fieldset=$("<fieldset></fieldset>").appendTo($form);
			for(var i=0;i<settings.source.constructor.length;i++)
				{	
				  
					$("<label for='"+settings.source.constructor[i][0][0]+"'>"+settings.source.constructor[i][1][1]+"</label>").appendTo($fieldset);
					construct_input(settings.source.constructor[i][0][0],$fieldset,settings.source.constructor[i][0][1],settings.source.constructor[i][1][2]);
					
				}
		$buttonsDiv=$("<div/>",{
			css:{
				
				"margin-top":"20px"
			}
		}).appendTo($form);	
		   
		    $("<input/>",{
		    	type:"submit",
		    	value:settings.source.text,
		    	id:settings.source.submitid,
		    	css:{
		    		"position":"absolute",
		    		"left":"5%",
		    		"width":"100px"
	    		
		    	}
		    }).appendTo($buttonsDiv);
			
			$("<input/>",{
				id:"clearbtn",
				type:"button",
				value:"Delete",
				disabled:true,
				css:{
		    		"position":"absolute",
		    		"left":"35%",
		    		"width":"100px"
	    		
		    	},
				click:function(){
					 var serializedData = $form.serializeObject();
					   // var serializedData={"nume":"fdf","prenume":"dfhdf","idnp":7177877,"adresa_domiciliu":"dhfh","adresa_corespondenta":"dfhdf","email":"fhd"}
					      serializedData['idnp']=parseInt(serializedData['idnp']);
					      deleteRecord(serializedData,options.source.action);
					      if(!options.solidari){
					      $("#"+options.source.textboxrootId).jqxInput({disabled:false});
					      $("#"+options.source.textboxrootId).val('');
							$("#"+options.source.buttonEventProvenience).jqxButton({	disabled : false});
							$form[0].remove();
							$( "#"+options.source.querier+"_data" ).empty();
							$("#datePersoane").css("display","block");
							$("#"+options.source.statutCombobox).jqxComboBox({disabled:false});
					      }
					      else{
					    	  if(options.source.tipPersoana=='fizica'){
					    		  PersoanaFizicaList.splice(updateIndex,1);
					    		  afterFormEvent(settings,serializedData,"",true);
					    	  }					    		  
					    	  else{
					    		  PersoanaJuridicaList.splice(updateIndex,1);
					    		  afterFormEvent(settings,serializedData,"",true);
					    	  }
					    		  
					      }
							
					      
					
				}
			}).appendTo($buttonsDiv);
			$("<input/>",{
				id:"cancelbtn",
				type:"button",
				value:"Cancel",
				disabled:true,
				css:{
		    		"position":"absolute",
		    		"left":"65%",
		    		"width":"100px"
	    		
		    	},
				click:function(settings){
					$form[0].remove();
					$("#datePersoane").css("display","block");
				}
			}).appendTo($buttonsDiv);
			
			
		});
	}
	
}(jQuery));

function construct_input(id,$fieldset,text,title)
{
	var type="text";var pattern="[a-zA-Z]+";
	if(id=="idnp"||id=="cod_fiscal")
		{type="number";pattern="\d{10}";}
	else if(id=="email")
		{type="email";pattern="[^@]+@[^@]+\.[a-zA-Z]{2,}";}
	else {
		pattern="*";
		}
	var $ninput=$("<input/>",{
		id:id,
	    type:type,
	    pattern:pattern,
	    name:id,
	    title:title,
	  
	    
	    css:{
	    	"margin":"7px"
	    },
		class:"text ui-widget-content ui-corner-all"
		
		
			
		
	}).appendTo($fieldset);
	if(id=="nume"||id=="prenume"||id=="denumirea"||id=="idnp"||id=="cod_fiscal"||id=="adresa_domiciliu"||id=='sediul')
	$ninput.prop("required", true);
	
	if(id=="idnp"||id=="cod_fiscal")
		{
		$ninput.attr("max","9999999999999");
		}
	$ninput.jqxInput({placeHolder: text, height: 25,width:460, minLength: 1 });
	$ninput.on("invalid",function(){
		var input=document.getElementById(id);
		input.setCustomValidity(title);
		});
	$ninput.on("change",function(){
    	input=document.getElementById(id);
    	input.setCustomValidity('')
    	} );
	
}
(function($){
    $.fn.serializeObject = function(){

        var self = this,
            json = {},
            push_counters = {},
            patterns = {
                "validate": /^[a-zA-Z][a-zA-Z0-9_]*(?:\[(?:\d*|[a-zA-Z0-9_]+)\])*$/,
                "key":      /[a-zA-Z0-9_]+|(?=\[\])/g,
                "push":     /^$/,
                "fixed":    /^\d+$/,
                "named":    /^[a-zA-Z0-9_]+$/
            };


        this.build = function(base, key, value){
            base[key] = value;
            return base;
        };

        this.push_counter = function(key){
            if(push_counters[key] === undefined){
                push_counters[key] = 0;
            }
            return push_counters[key]++;
        };

        $.each($(this).serializeArray(), function(){

            // skip invalid keys
            if(!patterns.validate.test(this.name)){
                return;
            }

            var k,
                keys = this.name.match(patterns.key),
                merge = this.value,
                reverse_key = this.name;

            while((k = keys.pop()) !== undefined){

                // adjust reverse_key
                reverse_key = reverse_key.replace(new RegExp("\\[" + k + "\\]$"), '');

                // push
                if(k.match(patterns.push)){
                    merge = self.build([], self.push_counter(reverse_key), merge);
                }

                // fixed
                else if(k.match(patterns.fixed)){
                    merge = self.build([], k, merge);
                }

                // named
                else if(k.match(patterns.named)){
                    merge = self.build({}, k, merge);
                }
            }

            json = $.extend(true, json, merge);
        });

        return json;
    };
})(jQuery);


function form_select(source,solidari,update,index){

	$("#forma_add_persoane").css("display","block");	
$("#forma_add_persoane").personsForm({source:source,solidari:solidari,update:update,updateIndex:index});
$("#open_form_persons_debitor").jqxButton({
disabled : true
});
$("#datePersoane").css("display","none");
$("#bottomTable").css("display","none");
}
function setPersonsData(options,serializedData){
	if(options.tipPersoana == "fizica")
	{ 
	if(options.reprezentant!=""){
		PersoanaFizica=serializedData;
		txtBox=PersoanaFizica['nume']+ " " + PersoanaFizica['prenume'] + " /" + PersoanaFizica['idnp'];
	    return PersoanaFizica;
	}
	else
		PersoanaFizicaReprezentant=serializedData;
	    txtBox=PersoanaFizicaReprezentant['nume']+ " " + PersoanaFizicaReprezentant['prenume'] + " /" + PersoanaFizicaReprezentant['idnp'];
	    return PersoanaFizicaReprezentant
	}
else
	{
	if(options.reprezentant!=""){
		PersoanaJuridica=serializedData;
		txtBox=PersoanaJuridica['nume']+ " " + PersoanaJuridica['prenume'] + " /" + PersoanaJuridica['idnp'];
	    return PersoanaJuridica;
	}
	else{
		PersoanaJuridicaReprezentant=serializedData;
		txtBox=PersoanaJuridicaReprezentant['nume']+ " " + PersoanaJuridicaReprezentant['prenume'] + " /" + PersoanaJuridicaReprezentant['idnp'];
	    return PersoanaJuridicaReprezentant;
	}
	}
	
}
function formEventsHandling(settings,serializedData){
	if(setting.options.solidari){
		if(settings.options.source.tipPersoana=='fizica'){
			if(settings.options.update)
				PersoanaFizicaList[settings.options.updateIndex]=serializedData;
			else
		        PersoanaFizicaList.push(serializedData);
		afterFormEvent(settings,serializedData,"",true);
		}
		else{
			if(settings.options.update)
				PersoanaJuridicaList[settings.options.updateIndex]=serializedData;
			else
				PersoanaJuridicaList.push(serializedData);
		afterFormEvent(settings,serializedData,"",true);
		}
	}
	else
		{
		var personsData =setPersonsData(settings.options,serializedData);
	    afterFormEvent(settings,personsData,txtBox,false);
	//debitor_field(serializedData,settings.source);
		}
}