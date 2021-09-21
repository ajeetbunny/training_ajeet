<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<script type="text/javascript" src="index.js"></script>
<script>
/*$(document).ready(function(){
	$('uname').change(function(){
		var myuser=$(#'uname').val();
		
		$.ajax({
			type:'POST',
			data:{uname:uname},
			url:'',
			success:function(result)
			{
				$('').html(result);
			}
			
		});
	});
});
*/
</script>
<title>MyWebApp</title>
</head>
<body>
<h1>Welcome to My Store</h1>
<h3>User Creation</h3>
<label class = "required">All fields are mandatory</label><br><br>
<label id="missing" style="color:red;">The following field/s are missing </label>
<label id="error"></label>
<form action="http://localhost:8080/WebApp/Register" method="post">
	<label class = "required" for="uname">User Name</label>
    <input type="text" id="uname" name="uname" placeholder="Please enter username" maxlength="6"><br><br>
    <label class = "required" for="pass">Password</label>
    <input type="password" id="pass" name="pass" placeholder="Please enter password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@]).{6}"><br><br>
    <label class = "required" for="ctype">Card Type</label>
    
    <input type="radio" name="ctype" id="credit" value="credit" onclick="changeStatus(0)"> Credit
    
	<input type="radio" name="ctype" id="debit" value="debit"onclick="changeStatus(1)"> Debit<br><br>
	<label class = "required" id="balance" for="bal">Balance/Limit</label>
    <input type="number" id="bal" name="bal" placeholder="1000"><br><br>
   
    <input type="submit" value="Add" id="addbtn"/>
    <input type="reset" value="Reset" id="reset"/>
     </form>
    <br>
    <input type="submit" value="Login" id="login"  onclick="window.location.href='login.jsp'"/>
    <form action="UserDisplay" method="post">
    <input type="submit" value="Display User Data" id="display" />
    </form>
   

</body>
</html>