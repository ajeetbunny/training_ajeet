<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyStore Login Portal</title>
</head>
<body>
<form action="http://localhost:8080/WebApp/Login" method="post"><label class = "required" for="uname">User Name</label>
    <input type="text" id="uname" name="uname" placeholder="Please enter username" maxlength="6"><br><br>
    <label class = "required" for="pass">Password</label>
    <input type="password" id="pass" name="pass" placeholder="Please enter password"  maxlength="6"><br><br>
	 <input type="submit" value="Login" id="loginbtn"/>
	 </form>
	 
</body>
</html>