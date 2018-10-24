angular.module('cartDetail').
component('cartDetail',{
    templateUrl: "cart-detail/cart-detail.template.html",
    controller: function CartDetailController($http,$scope,$rootScope){
        $scope.cartCount = $rootScope.totalItemsInCart;
        $scope.totalOrderPrice=0;
        $http.get('http://localhost:3000/cartItems').then(function(response){
            $scope.cartItems = response.data;
            $http.get('http://localhost:3000/products').then(function (response) {
                $scope.products = response.data;
                for(var i = 0; i < $scope.cartItems.length; i++){
                    $scope.totalOrderPrice = $scope.totalOrderPrice + $scope.products[i].price * $scope.cartItems[i].quantity;
                }
            });
        });


        $scope.deleteAll=function(){
            for(var i = 0; i < $scope.cartItems.length; i++){
                $scope.cartItems[i].quantity = 0;
            }
            $scope.totalOrderPrice = 0;
            response.data = $scope.cartItems;

            $http({
                method: 'PUT',
                url: 'http://localhost:3000/cartItems/',
                data: response.data,
                dataType: 'json'
            });
            window.location.reload();
        }

    }
});