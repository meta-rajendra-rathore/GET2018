'use strict';

// Register `userList` component, along with its associated controller and template
angular.
  module('userList').
  component('userList', {
    templateUrl: 'user-list/user-list.template.html',
    controller: function UserDetailsController($http) {
      var self = this;
      self.orderProp = 'age';
      debugger;

      $http.get('users/users.json').then(function(response) {
        self.users = response.data;
      });
    }
  });
