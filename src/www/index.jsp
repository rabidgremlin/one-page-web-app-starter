<%@ taglib uri="http://packtag.sf.net" prefix="pack" %>
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
    <link rel="stylesheet" href="css/app/app.css">
	
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	
  </head>
  <body ng-controller="TodoListCtrl">
  
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
       	<div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#/todos">One Page Web App Starter</a>
    	</div>
    	<div class="collapse navbar-collapse" id="navbar-collapse">
    		<p class="navbar-text navbar-right">find out more at <a href="https://github.com/rabidgremlin/one-page-web-app-starter" class="navbar-link">https://github.com/rabidgremlin/one-page-web-app-starter</a></p>
    	</div>
      </div>
    </nav>
  
   <div class="container ng-cloak" ng-cloak ng-view></div>
   
   <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
   <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
   <script src="//cdnjs.cloudflare.com/ajax/libs/underscore.js/1.6.0/underscore-min.js"></script>
   <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular.min.js"></script>
   <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular-resource.min.js"></script>
   <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular-route.min.js"></script>
   
   <pack:script>
     <src>/js/app/app.js</src>
     <src>/js/app/todo_service.js</src>
     <src>/js/app/todo_add_ctrl.js</src>
     <src>/js/app/todo_edit_ctrl.js</src>
     <src>/js/app/todo_list_ctrl.js</src>
   </pack:script>  
  </body>
</html>











