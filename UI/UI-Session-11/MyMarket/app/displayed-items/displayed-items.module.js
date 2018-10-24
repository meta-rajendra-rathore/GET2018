function displayItemsController($rootScope, $scope, $http) {

	$rootScope.totalItemsInCart = 0;

	$http.get('http://localhost:3000/cartItems').then(function (response) {
		$scope.cartItems = response.data;
		for (var i =  0; i < $scope.cartItems.length; i++) {
			if ($scope.cartItems[i].quantity > 0) {
				$rootScope.totalItemsInCart++;
			}
		}
	});

	$http.get('http://localhost:3000/products').then(function (response) {
		$scope.products = response.data;
	});


	/*for(var i = 0; i <= $scope.products.length; i++){
		console.log(cartIndex + " " + $scope.cartItems[cartIndex].id + " " + i);
		if( $scope.cartItems[cartIndex].id == i) {
			$scope.itemExistsInCartArray[i] = true;
			cartIndex++;
		} else {
			$scope.itemExistsInCartArray[i] = false;
		}
	}

	console.log($scope.itemExistsInCartArray);*/





	$scope.changeQuantity = function(productId, operation) {
		$http.get('http://localhost:3000/cartItems/' + productId).then(function (response) {
			if (operation == '+') {
				response.data.quantity++;
				if (response.data.quantity == 1) {
					$rootScope.totalItemsInCart++;
				}
				for (var i =  0; i < $scope.cartItems.length; i++) {
					if ($scope.cartItems[i].id == productId) {
						$scope.cartItems[i].quantity++;
					}
				}		
			} else {
				response.data.quantity--;
				if (response.data.quantity == 0) {
					$rootScope.totalItemsInCart--;
				}
				for (var i =  0; i < $scope.cartItems.length; i++) {
					if ($scope.cartItems[i].id == productId) {
						$scope.cartItems[i].quantity--;
					}
				}			
			}

			$http({
				method: 'PUT',
				url: 'http://localhost:3000/cartItems/' + productId,
				data: response.data,
				dataType: 'json'
			});
		});
	}
}

angular.module('displayedItems',[
    'ngRoute'
]).component('displayedItems', {
	templateUrl: 'displayed-items/displayed-items.template.html',
	controller: displayItemsController
});