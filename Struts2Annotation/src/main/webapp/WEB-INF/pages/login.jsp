<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Struts 2 - Login Application</title>
</head>
 
<body>
 
 
    <h2>Struts 2 - Login Application</h2>
    <s:actionerror />
 
    <s:form action="login" method="post" namespace="/">
        <s:textfield name="username" key="label.username" size="20" />
        <s:password name="password" key="label.password" size="20" />
        <s:submit method="execute" key="label.login" align="center" />
    </s:form>
     
    <br>
    Username: admin, password: 123
 
</body>
 
</html>