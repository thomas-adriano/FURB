var app = require('monitor-o-matic');



app.controller('topNavCtrl', ['$scope', function($scope) {
  console.log('topNavCtrl');
  $scope.registrables = ['Servidor'];
  $scope.viewables = ['Mem�ria'];
  $scope.accountActions = ['Log out'];

}]);
