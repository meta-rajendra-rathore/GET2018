angular.module('myMarket').
config(['$locationProvider', '$routeProvider',
       function config($locationProvider, $routeProvider) {

       $locationProvider.hashPrefix('!');
       $routeProvider.
       when('/', {
           template: '<displayed-items></displayed-items>'
       }).
       when('/products/cart/', {
           template: '<cart-detail></cart-detail>'
       }).
       when('/products/shipping/', {
           template: '<shipping-detail></shipping-detail>'
       }).
       when('/products/order-success/',{
                   template:'<order-success></order-success>'
               }).
       when('/products/orders/',{
                   template:'<order-list></order-list>'
               }).
       otherwise({
        template: '<displayed-items></displayed-items>'
           // template: '<item-list></item-list>'
       });
}]);