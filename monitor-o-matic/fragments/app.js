require('angular');
// require('angular-route');
require('ui-router');
require('angular-ui-mask');

var monitorOMaticApp = angular.module('monitorOMaticApp',['ui.router','ui.mask']);

monitorOMaticApp.config(function($stateProvider, $urlRouterProvider) {
  console.log('app executado.');

  $urlRouterProvider.otherwise('home');

  $stateProvider
  .state('home', {
    url: '/home',
    templateUrl: 'fragments/home/home.html',
    controller: 'homeCtrl'
  })
  .state('viewMemory', {
    url: '/viewMemory',
    templateUrl: 'fragments/resourceViews/viewMemory.html',
    controller : 'viewMemoryCtrl'
  })
  .state('registerServer', {
    url: '/registerServer',
    templateUrl: 'fragments/registers/server/server.html',
    controller: 'serverRegCtrl'
  });

});

module.exports = monitorOMaticApp;
