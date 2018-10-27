<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Struts 2 - Login Application</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<style>
body,form{
	text-align:center;
}
table{
	margin:0 auto;
}
.errorMessage{
	color:red;
}
</style>
</head>
 
<body>
 
 
    <h2>Struts 2 - Login Application</h2>
    <s:actionerror />
 
    <s:form action="login" method="post" namespace="/">
        <s:textfield class="form-control" name="username" key="label.username" size="20" />
        <s:password class="form-control"  name="password" key="label.password" size="20" />
        <s:submit class="btn btn-info" method="execute" key="label.login" align="center" />
    </s:form>
     
    <br>
    Username: admin, password: 123
 
</body>
 
</html>