function overrideSubmit(update){
	$('#idnp').bind('input', function() {
	   update=false;
	} );
$("#"+id+" input[type='submit']").click(function(e){
		e.preventDefault();
		var serializedData =$("#"+id).serializeObject();
		if(serializedData['sname'] !== undefined) {
		serializedData['name']=serializedData['name']+"|"+serializedData['sname'];
		delete serializedData['sname'];
		}
		serializedData['idnp']=parseInt(serializedData['idnp']);
		delete serializedData['type'];
		var subType=GlobalPersonType.split("_")[0]+GlobalPersonSubType;
		
		$.ajax({
			contentType: 'application/json',
			type:"POST",
			url:urlPersons+url+"?type="+subType+"&incheiere_id=1&update="+update,
			data:JSON.stringify(serializedData),
			success:function(map){
				if(map['duplicate']===undefined){
					$.unblockUI();
					updateDataTables(map);
			
				
				}
				else{
					$.unblockUI();
					construcDuplicateWindow(map['duplicate']);
											
				}
					
			}
		});
	});
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
