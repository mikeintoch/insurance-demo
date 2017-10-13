angular.module('InsuranceApp').directive('header', function() {
	return {
		restrict: 'A',
		replace: true,
		templateUrl: 'partials/header.html'
	}
});