'use strict'

angular.module('app.controllers', [])

.controller('RandomQuoteCtrl', function($scope, QuoteService) {
	QuoteService.random()
		.$promise.then(function(quote) {
			$scope.quote = quote;
		});
})
.controller('SaveQuoteCtrl', function($scope, $state, QuoteService) {
    
    $scope.saveQuote = function() {
        QuoteService.save(
            $scope.quote,
            function(response) {
                $state.go("quote", {});
            },
            function(err) {
                console.log(err);
            }
        );
    };
})
.controller('GetQuoteCtrl', function ($scope ,$stateParams, QuoteService) {
	let id = $stateParams.id;
	console.log("id = " + id);
	QuoteService.list({id : id})
		.$promise.then(function(author) {
			console.log("return promise" + author.name);
			$scope.author = author;
		});
});