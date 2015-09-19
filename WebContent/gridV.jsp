<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>CRUD operations using jTable in J2EE</title>
<!-- Include one of jTable styles. -->
<link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/style.css">

<!-- Include jTable script file. -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>
<!-- <script src="WebContent/js/jquery.jtable.min.js" type="text/javascript"></script> -->


<script type="text/javascript">
	$(document).ready(function() {
		    window.history.forward(-1); 
		    window.history.forward(1); 
     		$('#UserTableContainer').jtable({
			title : 'UsersList',
			actions : {
				listAction   : 'Controller?action=list',
				createAction : 'Controller?action=create',
				updateAction : 'Controller?action=update',
				deleteAction : 'Controller?action=delete'
			},
			fields : {
				
				id : {
					title : 'Id',
					width : '30%',
					edit : true
				},
				
				firstname : {
					title : 'Firstname',
					width : '30%',
					edit : true
				},
				
				lastname : {
					title : 'Lastname',
					width : '30%',
					edit : true
				},
				
				gender : {
					title : 'Gender',
					width : '20%',
					edit : true
				},
				
				country : {
					title : 'Country',
					width : '20%',
					edit : true
				},
				
				state : {
					title : 'State',
					width : '20%',
					edit : true
				},
				
				email : {
					title : 'Email',
					width : '20%',
					edit : true
				}
			}
		});
		$('#UserTableContainer').jtable('load');
		
	});
	
</script>
         <style>
			body
				{	background-image: url('img/love-lights-background-check-another-cool-hd-wallpaper-l-a-ibackgroundz.com.jpg');
					background-attachment: fixed;
					background-size: 100% 100%;
				}
		</style>
  </head>
		<body >
		   <div >
			<form action="Profile" method="get" class="form-horizontal" align="center">
			
			</form>
			</div>
			<div style="width: 80%; margin-right: 10%; margin-left: 10%; text-align: center;">
			        
			        <div id="UserTableContainer"></div>
				</div>
		
     </body>
</html>


