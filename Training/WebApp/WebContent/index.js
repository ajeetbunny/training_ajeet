 function changeStatus(x)
 {
	 var status=document.getElementById("ctype");
	 if(x==0 )
		 {
		 document.getElementById("balance").innerHTML="Limit";
		 }
	 else
		 {
		 document.getElementById("balance").innerHTML="Balance";
		 }
 }
function checkPassword(){
	var pass=document.getElementById("pass").value;
	var regEx= /^[a-zA-Z0-9@]$/;
	if(pass.search(regEx)<0)
		{
			error.push("Password not in correct format");
		}
	
}
function errorMsg(){
	if(uname=="")
		error.push("username can't be empty");
}
	
