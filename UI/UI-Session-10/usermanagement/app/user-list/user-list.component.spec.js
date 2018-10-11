'use strict';

describe('userList', function() {

  // Load the module that contains the `phoneList` component before each test
  beforeEach(module('userList'));

  // Test the controller
  describe('UserDetailsController', function() {
    var $httpBackend, ctrl;

    // The injector ignores leading and trailing underscores here (i.e. _$httpBackend_).
    // This allows us to inject a service and assign it to a variable with the same name
    // as the service while avoiding a name conflict.
    beforeEach(inject(function($componentController, _$httpBackend_) {
      $httpBackend = _$httpBackend_;
      $httpBackend.expectGET('users/users.json')
                  .respond([{name: 'Ankit'}, {name: 'Arya'}]);

      ctrl = $componentController('userList');
    }));

    it('should create a `users` property with 2 users fetched with `$http`', function() {
      expect(ctrl.users).toBeUndefined();

      $httpBackend.flush();
      expect(ctrl.users).toEqual([{name: 'Ankit'}, {name: 'Arya'}]);
    });

    it('should set a default value for the `orderProp` property', function() {
      expect(ctrl.orderProp).toBe('age');
    });

  });

});
