var app = require('monitor-o-matic');

var data = [
  {
    value: 300,
    color:"#F7464A",
    highlight: "#FF5A5E",
    label: "Red"
  },
  {
    value: 50,
    color: "#46BFBD",
    highlight: "#5AD3D1",
    label: "Green"
  },
  {
    value: 100,
    color: "#FDB45C",
    highlight: "#FFC870",
    label: "Yellow"
  }
];

app.controller('viewMemoryCtrl', ['$scope', 'chartRenderer',
function($scope, chartRenderer) {

  chartRenderer.renderPieChart("chart_1", data);

}]);
