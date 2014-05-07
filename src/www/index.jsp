<!DOCTYPE html>
<html lang="en" ng-app="app">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>One Page Web App Starter</title>
	<link rel="icon" href="img/favicon.ico" type="image/x-icon" />

    <!-- Bootstrap -->
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
	
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	
	<style>
	  [ng\:cloak], [ng-cloak], [data-ng-cloak], [x-ng-cloak], .ng-cloak, .x-ng-cloak {
       display: none !important;
      }
	</style>
	
  </head>
  <body ng-controller="TodoListCtrl">
  
   <div class="container ng-cloak" ng-cloak>
   
	   <ul>
	    <li ng-repeat="todo in todos">
	      {{todo.id}} - {{todo.description}}	      
	    </li>
	  </ul>
     
   </div>
   
   <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
   <script src="//cdnjs.cloudflare.com/ajax/libs/underscore.js/1.6.0/underscore-min.js"></script>
   <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular.min.js"></script>
   <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular-resource.min.js"></script>
   <script src="js/app/app.js"></script>
  </body>
</html>











