<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="employee.html" method="post">
<label>Employee Id</label>
<input type="text" name="empId">
<label>Employee Name</label>
<input type="text" name="Empname">
<label>DOB</label>
<input type="text" name="empDOB">
<br>
<br>
<label>Courses</label>
<select multiple name="choices">
	<option>Java</option>
	<option>Python</option>
	<option>Scala</option>
	
</select>

<table>
<tr><td>Student's Address</td></tr>
<tr>
<td>city : <input type="text" name="add.city"></td>
<td>pincode : <input type="text" name="add.pincode"></td>
</tr>
</table>
<input type="submit">
</form>
</body>
</html>