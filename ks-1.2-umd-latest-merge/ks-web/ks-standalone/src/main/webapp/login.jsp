<%@ page import="org.springframework.security.ui.webapp.AuthenticationProcessingFilter" %>
<%@ page import="org.springframework.security.ui.AbstractProcessingFilter" %>
<%@ page import="org.springframework.security.AuthenticationException" %>

<script type="text/javascript">
	function setSubmitUrl(form){
		var hash = unescape(self.document.location.hash.substring(1));
		form.action = "j_spring_security_check#" + hash;
		return true;
	} 
</script>

<form method="get" onSubmit="return setSubmitUrl(this);">
	<label for="j_username">Username</label>
	<input type="text" name="j_username" id="j_username"/>
	<br/>
	<label for="j_password">Password</label>
	<input type="password" name="j_password" id="j_password"/>
	<br/>
	<input type="submit" value="Login"/>
</form>