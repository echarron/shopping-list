'use strict';

describe('My account controller', function() {

    var scope, ctrl;

    beforeEach(module('shopping-list'));

    beforeEach(inject(function($rootScope, $controller) {
        scope = $rootScope.$new();
        ctrl = $controller('MyAccountCtrl', {$scope: scope});
    }));

    it('it should initiate MyAccountCtrl', function() {
        expect(scope.myShoppingLists).toBeDefined();
    });

});
