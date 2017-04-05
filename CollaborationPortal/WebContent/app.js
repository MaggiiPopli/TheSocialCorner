
var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/login", {
    	templateUrl : "l_user/login.html"
    })
    .when("/register", {
    	templateUrl : "l_user/register.html"
    })
    .when("/demo", {
        templateUrl : "demo.html"
    })
   
});