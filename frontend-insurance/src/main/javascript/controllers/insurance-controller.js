angular.module('InsuranceApp.controllers', ['InsurancePolizaAPI'])

.controller('PolizaController', function($scope,$modalStack,PolizaAPI) {
	var controller = this;
	var policyRequest = {};
	$scope.policyResponse = null;
	var pdfResponse = {};
	var creditCardRequest = {};
	
	var marcas = [];
	
	PolizaAPI.loadMarcas(function(data){
		controller.marcas = data;
	},function(error){
		MsgPop.open({
			Type : 'error',
			Content : 'Error al obtener el listado de marcas: ' + error
		});
	})
	
	this.calcularPrecio = function() {
		
		PolizaAPI.calcularPrecio(controller.policyRequest, function(data){
			controller.policyRequest = {};
			$scope.policyResponse = data;
			MsgPop.open({
				Type : 'success',
				Content : 'Su poliza ha sido cotizada'
			});
		}, function(error){
			MsgPop.open({
				Type : 'error',
				Content : 'Error al cotizar su poliza: ' + error
			});
		});
	}
	
	
	this.comprarPoliza = function () {
		PolizaAPI.comprarPoliza(controller.creditCardRequest, function(data){
			$modalStack.dismissAll('nothin');
			
			if(data.valida){
				MsgPop.open({
					Type : 'success',
					Content : 'Su compra ha sido satisfactoria'
				});
			}else{
				MsgPop.open({
					Type : 'error',
					Content : 'Su tarjeta no es valida'
				});
			}
		},function(error){
			MsgPop.open({
				Type : 'error',
				Content : 'Error al realizar su compra: ' + error
			});
		});
	}
	
	this.limpiarDatos = function() {
		$scope.policyResponse = {};
		controller.policyRequest = null;
	}
	
	this.downloadPDF = function(){
		PolizaAPI.createPDF($scope.policyResponse , function(data){
			var binaryData = [];
			binaryData.push(data.datos);
			var file = new Blob(binaryData, {type: 'application/pdf'});
			var fileURL = URL.createObjectURL(file);
			
			window.open(fileURL);
			
			MsgPop.open({
				Type : 'success',
				Content : 'Descargando PDF'
			});
		}, function(error){
			MsgPop.open({
				Type : 'error',
				Content : 'Error al crear su archivo: ' + error
			});
		});
	}
});