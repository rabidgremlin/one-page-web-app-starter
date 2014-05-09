<div ng-controller="TodoEditCtrl">

    <h1>Edit todo</h1>

    <div class="row">
    	<div class="col-xs-12">    	
			<form name="editForm" role="form">
			
			  <div class="form-group" ng-class="{'has-error':editForm.inputDescription.$invalid && editForm.inputDescription.$dirty}">
			    <label for="inputDescription">Description</label>
			    <input type="text" class="form-control" name="inputDescription" placeholder="Enter description of todo" required ng-maxlength="100" ng-model="todo.description">
			    <span class="help-block" ng-show="editForm.inputDescription.$error.required && editForm.inputDescription.$dirty">You must enter in a description</span>
			    <span class="help-block" ng-show="editForm.inputDescription.$error.maxlength && editForm.inputDescription.$dirty">Description must be less then 100 characters long</span>
			  </div>
			 
			  <button class="btn btn-primary" ng-click="saveTodo()" ng-disabled="editForm.$invalid"><span class="glyphicon glyphicon-floppy-disk"></span> Save</button>
			  &nbsp;&nbsp;<a href="#/todos" class="btn btn-default">Cancel</a>
			</form>
		</div>	
	</div>	

</div>   