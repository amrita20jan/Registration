$(document).ready(function(){
	$('.btn').click(function(){
		console.log("coming here");
	var firstname=$('#fname').val();
	var lastname=$('#lname').val();
	var username=$('#uname').val();
	var email=$('#email').val();
	var password=$('#password').val();
	var cpassword=$('#cpassword').val();
	var radiobutton=$('#passwordsignup').val();
	var address=$('#address').val();
	var country=$('#country').val();
	var state=$('#state').val();
	email_regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i; 
	//regex= ([a-zA-Z0-9\\'\\(\\+\\)\\,\\-\\.\\=]+);
	rege = /^[ A-Za-z0-9_@./#&+-]*$/
	
  
			if(firstname=="")
			{
			$('#dis').slideDown().html("<span style=color:#fff;float:right;margin:14px 125px 15px 0px;>Please enter firstname</span>");
			//alert('Please enter firstname');
			return false;
			}
			
			if(lastname=="")
			{
			$('#dis').slideDown().html("<span style=color:#fff;float:right;margin:14px 125px 15px 0px;>Please enter lastname</span>");
			return false;
			}
			
			if(username=="")
			{
			$('#dis').slideDown().html("<span style=color:#fff;float:right;margin:14px 125px 15px 0px;>Please enter username</span>");
			return false;
			}
			
			if(email=="")
			{
			$('#dis').slideDown().html("<span style=color:#fff;float:right;margin:14px 125px 15px 0px;>Please enter email</span>");
			return false;
			}
			else if(!email_regex.test(email)){
				$('#dis').slideDown().html("<span style=color:#fff;float:right;margin:14px 125px 15px 0px;>Please enter valid email</span>");
				return false;
			}
			
			if(password=="")
			{
			$('#dis').slideDown().html("<span style=color:#fff;float:right;margin:14px 125px 15px 0px;>Please enter password</span>");
			return false;
			}
			
			if(cpassword=="")
			{
			$('#dis').slideDown().html("<span style=color:#fff;float:right;margin:14px 125px 15px 0px;>Please enter confirm-password</span>");
			return false;
			}
			else
			{ //to check the password and confirm password
			  if (password != cpassword){
			        $("#dis").slideDown().html("<span style=color:#fff;float:right;margin:14px 125px 15px 0px;>Passwords do not match!</span>");
			        return false;}
			    else
			        $("#dis").slideDown().html("<span style=color:#fff;float:right;margin:14px 125px 15px 0px;>Passwords match.</span>");
			        
			}
			
			if(radiobutton=="")
			{	/*if(radiobutton == null) 
				{ 
				  console.log("gender");// moving the control to final jsp page 
				  return false;
				} */
			$('#dis').slideDown().html("<spanstyle=color:#fff;float:right;margin:14px 125px 15px 0px;>Please enter gender</span>");
			return false;
			}
			
			if(address=="")
			{
			$('#dis').slideDown().html("<span style=color:#fff;float:right;margin:14px 125px 15px 0px;>Please enter address</span>");
			return false;
			}
			
			if(country=="")
			{
			$('#dis').slideDown().html("<span style=color:#fff;float:right;margin:14px 125px 15px 0px;>Please enter country</span>");
			return false;
			}
			
			if(state=="")
			{
			$('#dis').slideDown().html("<span style=color:#fff;float:right;margin:14px 125px 15px 0px;>Please enter state</span>");
			return false;
			}
  
	
	});
});
