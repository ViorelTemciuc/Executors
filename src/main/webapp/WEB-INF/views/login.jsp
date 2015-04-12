<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<!--Slider-in icons-->
<script type="text/javascript">
$(document).ready(function() {
	$(".username").focus(function() {
		$(".user-icon").css("left","-48px");
	});
	$(".username").blur(function() {
		$(".user-icon").css("left","0px");
	});
	
	$(".password").focus(function() {
		$(".pass-icon").css("left","-48px");
	});
	$(".password").blur(function() {
		$(".pass-icon").css("left","0px");
	});
});
</script>
<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}
 
.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}
</style>
</head>
<body onload='document.loginForm.username.focus();'>
 
 <div id="wrapper">

	<!--SLIDE-IN ICONS-->
    <div class="user-icon"></div>
    <div class="pass-icon"></div>
    <!--END SLIDE-IN ICONS-->

<!--LOGIN FORM-->
<form name='loginForm'
		  action="<c:url value='j_spring_security_check' />" method='POST' class="loginform">

	<!--HEADER-->
    <div class="header">
    <!--TITLE--><h1>Login Form</h1><!--END TITLE-->
    <!--DESCRIPTION--><span>Enter please necessary data to authenticate:</span><!--END DESCRIPTION-->
    </div>
    <!--END HEADER-->
	
	<!--CONTENT-->
    <div class="content">
	<!--USERNAME--><input name="username" type="text" class="input username" value="Username" onfocus="this.value=''" /><!--END USERNAME-->
    <!--PASSWORD--><input name="password" type="password" class="input password" value="Password" onfocus="this.value=''" /><!--END PASSWORD-->
    <div  style="margin-top:10px;color:grey"> <input id="j_remember" name="_spring_security_remember_me" type="checkbox" /> <span>remember me</span></div>
    </div>
    <!--END CONTENT-->
    
    <!--FOOTER-->
    <div class="footer">
    <!--LOGIN BUTTON--><input type="submit" name="submit" value="Login" class="button" /><!--END LOGIN BUTTON-->
    <!--REGISTER BUTTON--><input type="submit" name="submit" value="register" class="register" /><!--END REGISTER BUTTON-->
   
    </div>
    <!--END FOOTER-->
<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
</form>
<!--END LOGIN FORM-->

</div>
<!--END WRAPPER-->

<!--GRADIENT--><div class="gradient"></div><!--END GRADIENT-->
 
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
 
	
 
</body>
</html>