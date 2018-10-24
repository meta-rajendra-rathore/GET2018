angular.module('shippingDetail').
    component('shippingDetail',{
        templateUrl:"shipping-detail/shipping-detail.template.html",
        controller:function ShippingDetailController($http,$scope){
            this.cartCount = 0;

            var self = this;
            $http.get('http://localhost:3000/cart').then(function(response){
                self.items = response.data;
                var item;
                self.totalOrderPrice=0;
                for(item in self.items){
                    self.totalOrderPrice += self.items[item].totalPrice;
                    self.cartCount += self.items[item].quantity;  
                }
            });

//            $http.get('http://localhost:3000/shipping').then(function(response){
//                self.shipping = response.data;
//            });
            self.shipping={};
            self.shipping.name="John";
            
            $scope.placeOrder=function(){
                $http({
                    method:'POST',
                    data:self.shipping,
                    url:'http://localhost:3000/shipping/',
                    dataType:'json'
                }).then(function(response){
                    console.log("successfull");
                });
                $http.get('http://localhost:3000/cart').then(function(response){
                    self.items = response.data;
                });

                var today = new Date();
                var dd = today.getDate();
                var mm = today.getMonth()+1; //January is 0!
                var yyyy = today.getFullYear();

                today = mm + '/' + dd + '/' + yyyy;


                var orderData={
                    "items":self.items,
                    "customerName":self.shipping.name,
                    "date":today
                }

                $http({
                    method:'POST',
                    url:'http://localhost:3000/orders',
                    data:orderData,
                    dataType:'json'
                });

                var item=1;
                for(item in self.items){
                    $http.delete('http://localhost:3000/cart/' + self.items[item].id, item).then(function(response){
                        console.log("successfull");
                    })
                }
                window.location="#!/products/order-success/";   
            }
            
        }
    });