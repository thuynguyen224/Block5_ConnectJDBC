<%-- 
    Document   : list
    Created on : Sep 26, 2020, 8:33:19 PM
    Author     : fsoft
--%>
<%@page import="model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <h1> Student List </h1>
    <br/>
    <%
        ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("students");
    %>
</head>
<body>
    <table border="1">
        <tr>
            <td>
                ID
            </td>
            <td>
                Name
            </td>
            <td>
                Gender
            </td>
            <td>
                DOB
            </td>
        </tr>
        <% for (Student s : students) {
        %>
        <tr>
            <td>
                <%=s.getId()%>
            </td> 
            <td>
                <%=s.getName()%>
            </td>
            <td>
                <% if (s.isGender()) { %>
                Male
                <% } else { %>
                Female
                <%}%>
            </td>
            <td>
                <%=s.getDob()%>
            </td>
            <td>
                <a href="update?id=<%=s.getId()%>">update</a>
                <a href="delete?id=<%=s.getId()%>">delete</a>
            </td>
        </tr>
        <%}%>
    </table>
    <a href="create">Create</a>
</body>
</html>
