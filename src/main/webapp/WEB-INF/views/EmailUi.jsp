<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compose Message</title>
<style type="text/css">
.err{
color:#ff0000;
}
</style>
</head>
<body>
<h1>Welcome to Email Program: Compose Message</h1>
<hr/>
<form:form action="sendmsg" method="POST" enctype="multipart/form-data" modelAttribute="message">
<pre>
Email To: <form:input path="mailTo"/>          Cc: <form:input path="mailCcc"/>
<form:errors path="mailTo" cssClass="err"/>		<form:errors path="mailCcc" cssClass="err"/>
Subject :<form:input path="mailSubject"/>     Bcc: <form:input path="mailBccc"/>
<form:errors path="mailSubject" cssClass="err"/>	<form:errors path="mailBccc" cssClass="err"/>
Text:	<form:textarea path="mailText" />
<form:errors path="mailText" cssClass="err"/>
File: 	<input type="file" name="mailFile"/>

		<input type="submit" value="Send"/>

</pre>

</form:form>
${msg}
</body>
</html>