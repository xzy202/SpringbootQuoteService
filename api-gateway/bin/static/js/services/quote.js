'use strict'

angular.module('app.services', [])

.factory('QuoteService', function($resource) {
	return $resource('/api/quote/:id', {id:'@_id'}, {
		random: {
			method: 'GET',
			url: '/api/quote/randomquote'
		},
		list : {
			method : 'GET',
			url : 'api/quotes/:id'
		},
	});
});
