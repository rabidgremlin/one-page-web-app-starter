var app = angular.module('app',['ngResource']);



app.controller('TodoListCtrl', ['$scope','TodoService', function($scope,TodoService) {
    	
	$scope.todos = TodoService.query();
		
}]);


app.factory('TodoService', ['$resource',  function($resource){
    return $resource('/api/todos/:todoId');
  }]);