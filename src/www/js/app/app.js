var app = angular.module('app',['ngResource','ngRoute']);


app.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/todos', {
        templateUrl: 'todolistview.jsp'        
      }).
      when('/todos/edit/:todoId', {
        templateUrl: 'todoeditview.jsp'        
      }).
      when('/todos/add', {
        templateUrl: 'todoaddview.jsp'        
      }).
      otherwise({
        redirectTo: '/todos'
      });
  }]);



app.controller('TodoListCtrl', ['$scope','TodoService', function($scope,TodoService) {
    	
	$scope.todos = TodoService.query();
		
}]);


app.factory('TodoService', ['$resource',  function($resource){
    return $resource('/api/todos/:todoId');
  }]);