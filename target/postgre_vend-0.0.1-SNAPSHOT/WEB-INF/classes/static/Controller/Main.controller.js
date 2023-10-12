sap.ui.define(
	["sap/ui/core/mvc/Controller",
	 "jquery.sap.global",
	 "bharath/util/service",
	 "sap/m/MessageBox",
	"sap/m/MessageToast"],
	function(Controller,jQuerry,service,MessageBox,MessageToast){
	return Controller.extend("bharath.controller.Main",{
		onInit: function(){
			
			var oModel = new sap.ui.model.json.JSONModel();
			oModel.setData({
				"postPayload":{
					    
			        "companyName": "",
			        "contactName": "",
			        "lastName": "",
			        "website": "",
			        "email": "",
			        "status": "",
			        "regDate": ""
   	
				},
				"vendor":{}				
			});	
			
			sap.ui.getCore().setModel(oModel);
		},
		onSave: function(){
			var oModel = sap.ui.getCore().getModel();
			var payload = oModel.getProperty("/postPayload");
			service.callService("/crvendor","POST",payload).then(function(){
				MessageBox.success,("Saved Successfully");
				
			}).catch(function(){
				
				MessageBox.error,("post failed");
			});
		},
		onLoadData: function(){
			var that = this;
			
			service.callService("/pgvendor","GET",{}).then(function(data){
					var oTable = that.getView().byId("idTable");
					var oModel = sap.ui.getCore().getModel();
					//oModel.setProperty("/vendor",data._embedded.vendor);	
					oModel.setProperty("/vendor",data);
					//sap.ui.getCore().setModel(oModel);
					oTable.bindRows("/vendor");
					
									
			}).catch(function(oError){
				
			})			
	}
	});
	});