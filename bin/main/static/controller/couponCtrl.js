myApp
.controller('couponListCtrl', function($scope, $http, $stateParams, $location, $state, $rootScope) {
	
});

myApp
.controller('couponWriteCtrl', function($scope, $http, $stateParams, $location, $state, $rootScope) {
	$scope.submitForm = function (form) {
		if(form.$valid == false){
			 toastr.error('입력값이 올바르지 않습니다.', '입력오류');
			return ;
		}
		
		// 파라미터
		var params = $scope.email;
		// 변경한 서비스 사용
		
		var scope = this;
		$http.post('/rest/users', userData).success(function(data) {
			//alert('등록되었습니다.');
			toastr.success("등록되었습니다.");
			console.log(data);
		});
})