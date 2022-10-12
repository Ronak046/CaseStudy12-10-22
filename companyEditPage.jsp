<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form:form method="post" action="company-edit" modelAttribute="companyRecord">
<h1 style="color:red">
<u><i>Company Share  Price updation</i></u>
</h1>
<br/><br/>
<h2>
Company Id:<form:input type="text" path="companyId" readonly="readonly"/>
<br/><br/>
Company Name:<form:input type="text" path="companyName" readonly="readonly"/>
<br/><br/>
Enter New Share Price<form:input type="text" path="sharePrice"/>
<br/><br/>
<input type="submit" value="Submit"/>
</h2>
</form:form>
</div>
</body>
</html>