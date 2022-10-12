<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
   <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1 style="color:LightGreen">
<u><i>Company Share List</i></u>
</h1>
<h3>
<a href="company-entry"  style="color:#ED91ED">Enlist a new Company</a>
</h3>
<br/><br/>
<h4 style="color:#0000CD">
<table border="2">
  <tr bgcolor="#ff8c00">
    <th>COMPANY ID</th>
    <th>COMPANY NAME</th>
    <th>SHARE PRICE</th>
	<th>ACTION</th>
  </tr>
    <c:forEach  items="${companyList}" var="company">
      <tr bgcolor="#FFFF00">
      <td>${company.companyId}</td>
      <td>${company.companyName}</td>
      <td>${company.sharePrice}</td>
      <td>
      <a href="company-edit/${company.companyId}" style="color:#FF00FF">Edit Share Price</a> 
       &nbsp; &nbsp;
       	<a href="delete-company/${company.companyId}" style="color:#FF00FF">Delete Company</a>      	
      </td>
      </tr>
     </c:forEach>
  </table>
 </h4>
</div>
</body>
</html>