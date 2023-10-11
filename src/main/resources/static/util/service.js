sap.ui.define(["jquery.sap.global"],function(jQuerry){
	return{callService:function(sUrl,sMethod,oPayload){
		return new Promise(function(resolve,reject)
		{
			switch(sMethod.toUpperCase())
			{
				case "GET":
					
				jQuerry.ajax(sUrl,{type: 'GET',
				success: function(data){
                  resolve(data);
				},
				error: function(err){
				  reject(err);
				}});
				
				
				case "POST":					
				jQuerry.ajax(sUrl,{
				type: 'POST',
				contentType: "application/json",
				data:JSON.stringify(oPayload),
				success: function(data){
                  resolve(data);
				},
				error: function(err){
				  reject(err);
				}});					
				
			}
		})
				
	}
	}
	}
	);
