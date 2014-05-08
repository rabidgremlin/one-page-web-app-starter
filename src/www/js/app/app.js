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
		
	$scope.toggleCompleted = function(todo){
		//alert('Toogle completed: ' + todoId);
		
		todo.completed = !todo.completed;
		todo.$update(function(){
		  $scope.todos = TodoService.query();
		});
	};	
	
	$scope.editTodo = function(todo){
		//alert('Edit Todo: ' + todo.id);
		
		
		
	};
	
	$scope.deleteTodo = function(todo){
		//alert('Delete Todo: ' + todo.id);
		todo.$delete(function(){
		  $scope.todos = TodoService.query();
		});
	};
}]);

app.controller('TodoAddCtrl', ['$scope','$location','TodoService', function($scope,$location,TodoService) {

   $scope.description = '';

   $scope.addTodo = function(){
		TodoService.save({description:$scope.description},function(){
			$location.path('/todos');
		});
	};

}]);



app.factory('TodoService', ['$resource',  function($resource){
    return $resource('/api/todos/:todoId',{todoId:'@id'}, {update: {method:'PUT'}})
  }]);