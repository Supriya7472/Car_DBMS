<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <% ResultSet rs=( ResultSet)request.getAttribute("resultSet"); %>
    <h1>All Cars Details :-</h1>
    <a href="index.jsp">Return back to Car Dashboard</a>
    <table border="1px solid black" rules="all" style="border-color:pink">
    <tr>
    <th>CarId</th>
    <th>CarModel</th>
    <th>CarBrand</th>
    <th>CarColor</th>
    <th>CarPrice</th>
    <th>Update</th>
    <th>Delete</th>
    </tr>
    <%while(rs.next()){ %>
    <tr>
    <td><%=rs.getInt(1) %></td>
    <td><%=rs.getString(2) %> </td>
    <td><%=rs.getString(3) %> </td>
    <td><%=rs.getString(4) %> </td>
    <td><%=rs.getInt(5) %></td>
    <td><a href="find-car-by-id?carId=<%=rs.getInt(1) %>">Update</a></td>
    <td><a href="find-car-by-id-delete?carId=<%=rs.getInt(1) %>">Delete</a></td>
    
    </tr>
    <%} %>
    
    </table>
</body>
</html>