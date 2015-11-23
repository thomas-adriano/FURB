var app = require('monitor-o-matic');



app.controller('topNavCtrl', ['$scope', function($scope) {
  console.log('topNavCtrl');
  $scope.registrables = ['Servidor'];
  $scope.viewables = ['Memória'];
  $scope.accountActions = ['Log out'];

}]);
