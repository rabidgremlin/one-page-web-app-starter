/* 
  Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
app.controller('TodoListCtrl', [ '$scope', '$location', 'TodoService',
		function($scope, $location, TodoService) {

			// use a function here so that scope can be set to actual data not
			// to the promise that query() returns
			// this allows the track by on the ng-repeat in todolistview.jsp to
			// function which reduces flicker
			function queryTodos() {
				TodoService.query(function(data) {
					$scope.todos = data;
				});
			}

			queryTodos();

			$scope.toggleCompleted = function(todo) {
				// alert('Toogle completed: ' + todoId);

				todo.completed = !todo.completed;
				todo.$update(function() {
					queryTodos();
				});
			};

			$scope.editTodo = function(todo) {
				$location.path('/todos/edit/' + todo.id);
			};

			$scope.deleteTodo = function(todo) {
				// alert('Delete Todo: ' + todo.id);
				todo.$delete(function() {
					queryTodos();
				});
			};
		} ]);