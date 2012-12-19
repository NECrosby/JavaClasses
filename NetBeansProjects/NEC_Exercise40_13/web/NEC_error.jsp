<%-- 
    Document   : NEC_error
    Created on : Dec 17, 2012, 12:38:49 AM
    Author     : Naomi Crosby
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>

<html>
    <head>
        <title>Exercise 40.13: Error page</title>
        <link href="exercise4013.css" rel="stylesheet" type="text/css" media="screen" />
    </head>

    <body>
        <div id="bodywrap">
            <h2>Error occurred!</h2>
            <p>
                Message <jsp:expression> exception.getMessage()</jsp:expression>
            </p>
        </div>
    </body>
</html>
