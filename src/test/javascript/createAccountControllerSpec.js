'use strict';

describe('Create account controller', function() {

    var $httpBackend,
        $scope,
        newAccount = {
            username: "Nicolas Durand",
            email: "ndurand@xebia.fr",
            password: "password"
        };

    beforeEach(module('shopping-list'));

    beforeEach(inject(function(_$httpBackend_,$rootScope) {
        $httpBackend = _$httpBackend_;
        $scope = $rootScope.$new();
    }));

    it('it should initiate AccountCreationCtrl', inject(function($controller) {

        var scope = {};

        $controller('AccountCreationCtrl', {$scope:scope});

        expect(scope.newAccount).toBeDefined();
    }));

    it('should send account creation to backend', inject(function($controller) {

        $httpBackend
            .whenPOST('users', newAccount)
            .respond(201, newAccount);

        $controller("AccountCreationCtrl", {$scope: $scope});

        $scope.newAccount = newAccount;

        $scope.create();
        $httpBackend.flush();
        $httpBackend.expectPOST('users');
    }));

});
