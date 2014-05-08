<div ng-controller="TodoAddCtrl">

    <h1>Add a todo</h1>

    <div class="row">
    	<div class="col-xs-12">    	
			<form name="addForm" role="form">
			
			  <div class="form-group" ng-class="{'has-error':addForm.inputDescription.$invalid && addForm.inputDescription.$dirty}">
			    <label for="inputDescription">Description</label>
			    <input type="text" class="form-control" name="inputDescription" placeholder="Enter description of todo" required ng-maxlength="100" ng-model="description">
			    <span class="help-block" ng-show="addForm.inputDescription.$error.required && addForm.inputDescription.$dirty">You must enter in a description</span>
			    <span class="help-block" ng-show="addForm.inputDescription.$error.maxlength && addForm.inputDescription.$dirty">Description must be less then 100 characters long</span>
			  </div>
			 
			  <button class="btn btn-primary" ng-click="addTodo()" ng-disabled="addForm.$invalid"><span class="glyphicon glyphicon-plus"></span> Add</button>
			  &nbsp;&nbsp;<a href="#/todos" class="btn btn-default">Cancel</a>
			</form>
		</div>	
	</div>	

</div>	