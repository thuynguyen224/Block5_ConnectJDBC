<%-- 
    Document   : create
    Created on : Aug 16, 2021, 10:28:23 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <body>
        <form action="create" method="post">
            Name: <input type="text" value="" name="name" />
            <br/>
            Gender: 
            <input type="radio"  value="male" name="gender" /> Male
            <input type="radio" value="female" name="gender" /> Female
            <br/>
            Dob: <input type="date" value="" name="dob" />
            <br/>           
            <input type="submit" value="Save"/>
        </form>
    </body>
    </body>
</html>
