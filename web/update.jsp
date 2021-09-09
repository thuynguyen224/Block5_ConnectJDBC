<%-- 
    Document   : update
    Created on : Aug 16, 2021, 3:30:40 PM
    Author     : dell
--%>

<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            Student s = (Student) request.getAttribute("student");
        %>
    </head>
    <body>
        <form action="update" method="POST">
            ID: <%=s.getId()%> 
            <input type="hidden" value="<%=s.getId()%>" name="id"/>
            <br/>
            Name: <input type="text" value="<%=s.getName()%>" name="name" />
            <br/>
            Gender: 
            <input type="radio" <%=s.isGender() ? "checked" : ""%> value="male" name="gender" /> Male
            <input type="radio" <%=!s.isGender() ? "checked" : ""%> value="female" name="gender" /> Female
            <br/>
            Dob: <input type="date" value="<%=s.getDob()%>" name="dob" />
            <br/>           
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
