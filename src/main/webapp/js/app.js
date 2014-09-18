'use strict';

var shoppingList = angular.module('shopping-list', ['ngRoute']);

shoppingList.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/signin', {
                templateUrl: 'views/signin.html',
                controller: 'AccountCreationCtrl'
            }).
            when('/me', {
                templateUrl: 'views/me.html',
                controller: 'MyAccountCtrl'
            }).
            otherwise({
                redirectTo: 'index.html'
            });
    }
]);
