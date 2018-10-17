function displayItemsController($rootScope, $scope, $http) {

	$scope.itemExistsInCartArray = [];

	$http.get('http://localhost:3000/products').then(function (response) {
		$scope.products = response.data;
		for(var i = 0; i <= $scope.products.length; i++) {
			$scope.itemExistsInCartArray[i] = false;
		}
	});

	$http.get('http://localhost:3000/cartItems').then(function (response) {
		$scope.cartItems = response.data;
		$scope.cartItems.forEach(function(item) {
			console.log(item.id);
			console.log($scope.itemExistsInCartArray[3]);/* = true;*/
		});
		console.log($scope.itemExistsInCartArray);
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




	$scope.getTotalItemsInCart = function() {
		return 10;
	}

	$scope.showQuantityInCart = function(productId) {
		for(var i = 0; i < $scope.cartItems.length; i++){
			var result = $scope.cartItems[i];
			if(result.id === productId){
				return result.quantity;
			}
		}
		return 0;
	}

	$scope.addItemToCart = function(productId) {
		var cartData = {
			'id': productId,
			'quantity': 1
		}

		$http({
			method: 'POST',
			url: 'http://localhost:3000/cartItems',
			data: cartData,
			dataType: 'json'
		});

		$scope.showQuantityInCart(productId);
	}

	$scope.changeQuantity = function(productId, operation) {
		$http.get('http://localhost:3000/cartItems/' + productId).then(function (response) {
			if (operation == '+') {
				response.data.quantity += 1;
			} else {
				response.data.quantity -= 1;
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

angular.module('myMarket').component('displayedItems', {
	templateUrl: 'displayed-items/displayed-items.template.html',
	controller: displayItemsController
});