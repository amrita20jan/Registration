$(document).ready(function(){
	 window.history.forward(-1); 
	 window.history.forward(1); 
	$('.btn-signin').click(function(){
		console.log("coming here");
	var mail=$('#mail').val();
	var pswd=$('#pswd').val();
	email_regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
	
	if(mail=="")
	{
		$('#dis').slideDown().html("<span style=color:#fff;float:right;margin:14px 125px 15px 0px;>Please enter email</span>");
		return false;
	}
	else if(!email_regex.test(mail)){
		$('#dis').slideDown().html("<span style=color:#fff;float:right;margin:14px 125px 15px 0px;>Please enter valid email</span>");
		return false;
	}
	
	if(pswd=="")
	{
		$('#dis').slideDown().html("<span style=color:#fff;float:right;margin:14px 125px 15px 0px;>Please enter password</span>");
		return false;
	}
	
	
	});
});
