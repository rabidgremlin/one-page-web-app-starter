<div ng-controller="TodoListCtrl">
   <h1>Todos <span><a href="#/todos/add" class="btn btn-primary pull-right" ><span class="glyphicon glyphicon-plus"></span> Add a todo</a></span></h1>
   
   <div class="alert alert-info" ng-hide="todos.length > 0">
   <p>No todos in your list, why don't you <a href="#/todos/add">add one</a></p>
   </div>
       
   <div class="panel panel-default" ng-repeat="todo in todos track by todo.id">
     <div class="panel-body" style="font-size:1.5em">
       <span class="glyphicon glyphicon-trash text-danger pull-right clickable" ng-click="deleteTodo(todo)"></span><span class="glyphicon glyphicon-ok clickable" ng-class="{'text-success': todo.completed, 'text-muted': !todo.completed}" ng-click="toggleCompleted(todo)"></span>&nbsp;&nbsp;
       <span class="clickable" ng-class="{'completed': todo.completed}" ng-click="editTodo(todo)">{{todo.description}}</span>      
     </div>
   </div>
</div>       