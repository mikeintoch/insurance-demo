angular.module('InsuranceApp').config([ '$routeProvider', function($routeProvider) {
  $routeProvider.when('/', {
    templateUrl : 'partials/home.html'
  }).when('/poliza', {
    templateUrl : 'partials/poliza.html',
    controller : 'PolizaController',
    controllerAs: 'polizaCtrl'
  }).otherwise({
    redirectTo : '/'
  });
} ]);