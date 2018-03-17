myApp.config(function($locationProvider, $stateProvider, $urlRouterProvider) {
	// html5 모드
	$locationProvider.html5Mode(true).hashPrefix('!');
	$urlRouterProvider.otherwise("/");

	$stateProvider.state('couponList', {
		url : "/coupon",
		templateUrl : '/coupon/list.html',
		controller : 'couponListCtrl'

	}).state('couponWrite', {
		url : "^/coupon/write",
		templateUrl : '/coupon/write.html',
		controller : 'couponWriteCtrl'
	})

});
