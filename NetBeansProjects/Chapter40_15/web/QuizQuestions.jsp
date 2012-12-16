<%-- 
    Document   : Quiz Questions
    Created on : Dec 12, 2012, 12:23:32 PM
    Author     : Naomi Crosby
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="qqbean" class="Chapter40.Quiz" scope="session" ></jsp:useBean>
<jsp:setProperty name="qqbean" property="*" />


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subtraction Quiz</title>
        <link href="exercise4015.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <% qqbean.populate();%>
        <h1>Subtraction Quiz</h1>
        <h2>Questions</h2>
        <form method="post" action="QuizResults.jsp">
            <table>
                <% for (int x = 0; x < 10; x++) {%>
                <tr> 
                    <td>
                        <%= qqbean.getValue(x, 0)%>
                    </td>
                    <td> - </td>
                    <td>
                        <%= qqbean.getValue(x, 1)%>
                    </td>
                    <td> = </td>
                    <td>
                        <input name="<%=qqbean.getQuestion(x)%>">
                    </td>
                </tr> 
                <% }%>               
            </table>
            <input type="submit" name="Choice" value="Submit" />
            <input type="reset" value="Clear" />
            <input type="button" value="New Quiz" onclick="location.reload(true)" />
        </form>        
    </body>
</html>
