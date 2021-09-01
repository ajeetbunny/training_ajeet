<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<script type="text/javascript" src="index.js"></script>
<title>MyWebApp</title>
</head>
<body>
<h1>Welcome to My Store</h1>
<h3>User Creation</h3>
<label class = "required">All fields are mandatory</label><br><br>
<label id="missing" style="color:red;">The following field/s are missing</label>
<label id="error"></label>
<form action="http://localhost:8080/WebApp/MyServlet">
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
    <br><br>
    
    <table  align="center" class="data">
        <tr>
            <th>Name</th>
            <th>Account Type</th>
            <th>Balance/Limit</th>
        </tr>
        <tr>
            <td>Ajay</td>
            <td>Credit</td>
            <td>1000</td>
        </tr>
        <tr>
            <td>Bijay</td>
            <td>Debit</td>
            <td>200</td>
        </tr>
        <tr>
            <td>Govind</td>
            <td>Debit</td>
            <td>345</td>
        </tr>
        <tr>
            <td>Hari</td>
            <td>Credit</td>
            <td>1000</td>
        </tr>
    </table>
    

</body>
</html>