<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Store</title>
<script>
    function greet() {
        var txtInp = document.getElementById("txtInp");
        var divEle = document.getElementById("greeting");
        var birthDt = new Date(txtInp.value);
        var currentDt = new Date();
       
        var birthYr = birthDt.getFullYear();
        var birthMn = birthDt.getMonth()+1;
        var birthDa = birthDt.getDate();
       
        var currentYr = currentDt.getFullYear();
        var currentMn = currentDt.getMonth()+1;
        var currentDa = currentDt.getDate();
       
        divEle.innerHTML=("Your age is "+ (currentYr - birthYr) + " Years "
        + (currentMn - birthMn) + " Months "
        + (currentDa - birthDa) + " Days"
        );
    }
</script>
<style>
#greeting{
color: yellow;
background-color: blue;
}
</style>
</head>
<body>
    Enter Name :
    <input type="date" onKeyUp="greet()" id="txtInp"/>
    <button OnClick="greet()">Click Me</button>   
    <div id="greeting"></div>
</body>
</html>