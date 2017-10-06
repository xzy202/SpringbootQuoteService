'use strict'

var app = angular.module('app', [
    'ui.router',
    'ngResource',
    'app.services',
    'app.controllers'

]);

app.config(function($urlRouterProvider, $stateProvider) {

    $urlRouterProvider.otherwise("/");

    $stateProvider
        .state("quote", {
            url: "/",
            templateUrl : "templates/quote.html",
            controller: "RandomQuoteCtrl"
        })
        .state("add", {
            url: "/add",
            templateUrl : "templates/add.html",
            controller: "SaveQuoteCtrl"
        })
        .state("getquote",{
        		url :"/quotes/:id",
        		templateUrl : "templates/author.html",
        		controller : "GetQuoteCtrl"
        });
});
