shoppingList.controller('AccountCreationCtrl', [ '$scope', '$http', function($scope, $http) {
    $scope.newAccount = {};

    $scope.create = function() {
        $http.post('users', $scope.newAccount);
    };
}]);
