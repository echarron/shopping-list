'use strict';

describe('My account controller', function() {

    var httpBackend, scope, ctrl, newList = {id: 1, title: 'Apéro tonight'};

    beforeEach(module('shopping-list'));

    beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
        httpBackend = _$httpBackend_;
        scope = $rootScope.$new();
        ctrl = $controller('MyAccountCtrl', {$scope: scope});
    }));

    it('it should initiate MyAccountCtrl', function() {
        expect(scope.newListTitle).toBeDefined();
        expect(scope.myShoppingLists).toBeDefined();
    });

    it('it should create one new shopping list', inject(function($location) {
        httpBackend
            .whenPOST('/api/users/1/lists', newList.title)
            .respond(201, newList);

        scope.newListTitle = newList.title;

        scope.create();
        httpBackend.flush();
        httpBackend.expectPOST('/api/users/1/lists');
        expect(scope.myShoppingLists.length).toEqual(1);
        expect(scope.myShoppingLists[0]).toEqual(newList);
        expect($location.path()).toBe('/me');
    }));

});
