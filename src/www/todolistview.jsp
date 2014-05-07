<div ng-controller="TodoListCtrl">
   <h1>Todos <span><a href="#/todos/add" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-plus"></span> Add a todo</a></span></h1>
       
   <div class="panel panel-default" ng-repeat="todo in todos">
     <div class="panel-body" style="font-size:1.5em">
       <span class="glyphicon glyphicon-ok" ng-class="{'text-success': todo.completed, 'text-muted': !todo.completed}"></span>&nbsp;&nbsp;{{todo.description}}
       <span class="glyphicon glyphicon-remove text-danger pull-right"></span>
     </div>
   </div>
</div>       