var app = require('monitor-o-matic');

var Chart = require('chart-factory');

app.service('chartRenderer', function() {

  this.renderPieChart = function(chartId, data) {

    // Get context with jQuery - using jQuery's .get() method.
    var ctx = $("#"+chartId).get(0).getContext("2d");
    // This will get the first returned node in the jQuery collection.

    return new Chart(ctx).Pie(data, Chart.defaults.global);
  };

});
