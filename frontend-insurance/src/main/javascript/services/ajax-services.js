angular.module('AjaxService', [])

.factory('Ajax', function($http) {
	var instance = {};
         
     $http.defaults.useXDomain = true;

	instance.post = function(serviceUrl, request, success, error){
		$http({
            url: serviceUrl,
            method: "POST",
            data: request,
            //withCredentials: true,
            headers: {
            	'Content-Type': undefined
            }
        }).success(function(response) {
			success(response);
		}).error(function(response) {
			error(response);
		});
	}
	
    instance.get = function(serviceUrl, success, error){
    	$http({
            url: serviceUrl,
            method: "GET",
            //withCredentials: true
            headers: {
            	'Content-Type': undefined
            }
        }).success(function(response) {
			success(response);
		}).error(function(response) {
			error(response);
		});
	}
	
	instance.put = function(url, request, success, error){
		$http({
            url: serviceUrl,
            method: "PUT",
            data: request,
            withCredentials: true
        }).success(function(response) {
			success(response);
		}).error(function(response) {
			error(response);
		});
	}
	
	instance.del = function(url, success, error){
		$http({
            url: serviceUrl,
            method: "DELETE",
            withCredentials: true
        }).success(function(response) {
			success(response);
		}).error(function(response) {
			error(response);
		});
	}

	return instance;
});