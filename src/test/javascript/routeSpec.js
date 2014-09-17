'use strict';

describe('Application routes', function() {

    it('should map routes to controllers', function() {
        module('shopping-list');

        inject(function($route) {

            expect($route.routes['/signin'].templateUrl).toEqual('views/signin.html');
            expect($route.routes['/signin'].controller).toEqual('AccountCreationCtrl');

            // otherwise redirect to
            expect($route.routes[null].redirectTo).toEqual('index.html')
        });
    });
});
