angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:5555/cloud/products';

    $scope.fillTable = function () {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                min_price: $scope.filter ? $scope.filter.min_price : null,
                max_price: $scope.filter ? $scope.filter.max_price : null
            }
        }).then(function (response) {
            $scope.ProductsList = response.data;
        }, function errorCallback(response) {
            window.alert("Error");
        });

    };

    $scope.fillTable();
});