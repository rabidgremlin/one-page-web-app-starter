<div ng-controller="TodoListCtrl">
   <h1>Todos <span><a href="#/todos/add" class="btn btn-primary pull-right" ><span class="glyphicon glyphicon-plus"></span> Add a todo</a></span></h1>
       
   <div class="panel panel-default" ng-repeat="todo in todos">
     <div class="panel-body" style="font-size:1.5em">
       <span class="glyphicon glyphicon-ok clickable" ng-class="{'text-success': todo.completed, 'text-muted': !todo.completed}" ng-click="toggleCompleted(todo)"></span>&nbsp;&nbsp;
       <a href="#/todos/edit/{{todo.id}}" class="hover-link">{{todo.description}}</a>
       <span class="glyphicon glyphicon-remove text-danger pull-right clickable" ng-click="deleteTodo(todo)"></span>
     </div>
   </div>
</div>       