'use strict';

var shoppingList = angular.module('shopping-list', ['ngRoute']);

shoppingList.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/signin', {
                templateUrl: 'views/signin.html',
                controller: 'AccountCreationCtrl'
            }).
            otherwise({
                redirectTo: 'index.html'
            });
    }
]);
