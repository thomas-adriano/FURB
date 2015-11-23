var app = require('monitor-o-matic');

var Chart = require('./chartFactory.js');

app.service('chartRenderer', [function($scope) {

  var renderPieChart = function(chartId, data) {

    // Get context with jQuery - using jQuery's .get() method.
    var ctx = $("#"+chartId).get(0).getContext("2d");
    // This will get the first returned node in the jQuery collection.

    var myNewChart = new Chart(ctx).Pie(data, Chart.defaults.global);
  };

}]);
