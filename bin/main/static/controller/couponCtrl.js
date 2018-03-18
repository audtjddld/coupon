myApp
.controller('couponListCtrl', function($scope, $http, $stateParams, $location, $state, $rootScope) {
	// 쿠폰
	$scope.coupon = {
			// 검색
			search : function() 
			{
				var params = angular.copy(this.pagingInfo);
				var page = 0;
				console.log(params);
				for (param in params) {
					if (param == 'page') {
						page = params[param];
						params[param]--;
						if (!params[param] || params[param] < 1)
							params[param] = 0;
					}
				}

				$http.get('/rest/coupons', {
					params : params
				}).success(	function(coupon) {
							console.log('success');
							console.log(coupon);
							$scope.data = coupon;
							$scope.currentPage = page;
							//$scope.totalPages = Math.floor(coupon.totalElements / $scope.size);
							$scope.totalItems = Math.round(coupon.totalElements/coupon.size) * 10;
							$scope.offset = ($scope.currentPage - 1) * $scope.totalPages;
							$location.search(params);
				})
			},
			
			// 페이징 객체
			pagingInfo : {
				page : 1,
				sort : "regDate,desc",
				size : 20
			},
			
			// 초기화
			init : function() {
					// url 파라미터에 있는 내용에 따른 검색 파라미터 설정
					var obj = $location.search();
					if (obj.page != undefined) {
						this.pagingInfo.page = obj.page;
					}
					this.search();
			},
			
			// 페이지 변경
			pageChanged : function() {
				// console.log('query ' + $scope.query);
				console.log($scope.currentPage);
				this.pagingInfo.page = $scope.currentPage;
				this.search();						
			}
	};
	$scope.coupon.init();
});

myApp
.controller('couponWriteCtrl', function($scope, $http, $stateParams, $location, $state, $rootScope, toastr) {
	$scope.submitForm = function (form) {
		if(form.$valid == false){
			toastr.error('입력값이 올바르지 않습니다.', '입력오류');
			return ;
		}
		
		// 파라미터
		var params = angular.copy({email : $scope.email});
		// 변경한 서비스 사용
		console.log(params);
		
		var scope = this;
		$http.post('/rest/coupons', params).then(function successCallback(data) {
			//alert('등록되었습니다.');
			toastr.success("등록되었습니다.");
			console.log(data);
			$state.go('couponList');
		}, function errorCallback(error) {
			console.log(error);
			if (error.data.errorCode == 'INVALID_EMAIL') {
				toastr.error('입력하신 이메일 주소가 올바르지 않습니다.');
			}
			if (error.data.errorCode = 'DUPLICATE_EMAIL') {
				toastr.error('이미 등록된 이메일 입니다.');
			}
		})
	}
})