var monitorOMaticApp = require('../monitorOMaticApp');

monitorOMaticApp.controller('chartsController', ['$scope',
function($scope) {

  var charts = require('./configs.js');

  charts.renderCharts();

}]);
