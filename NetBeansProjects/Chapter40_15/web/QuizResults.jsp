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
        <title>Subtraction Quiz: Results</title>
        <link href="exercise4015.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <% qqbean.setCorrectCount(0); %>
        <h1>Subtraction Quiz</h1>
        <h2>Results</h2>
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
                    <% qqbean.setAnswer(x,
                                Integer.parseInt(
                                request.getParameter(qqbean.getQuestion(x))));%> 
                    <%= qqbean.getValue(x, 3)%>
                </td>
                <td>
                    <%= qqbean.correctIt(x)%>
                </td>
            </tr> 
            <% }%>               
        </table>  
        <p>The total correct is: <%= qqbean.getCorrectCount() %></p>
        <p>
            <a href="QuizQuestions.jsp">Back to the Question Quiz</a>
        </p>
    </body>
</html>
