<%--

    Document   : NEC_MultiQuestionPoll
    Created on : Dec 8, 2012, 11:21:59 PM
    Author     : Naomi Crosby
    Assignment : Exercise 40.13

    (Multiple-question opinion poll) The Poll table in Exercise 39.13 contains
    only one question. Suppose you have a Poll table that contains multiple
    questions. Write a JSP that reads all the questions from the table & display
    them in a form, as shown in Figure 40.12(a). When the user clicks the Submit
    button, another JSP page is invoked. This page updates the Yes or No counts
    for each question and displays the current Yes and No counts for each
    question in the Poll table, as shown in Figure 40.12(b). Note that the table 
    may contain many questions. The three questions in the figure are just 
    examples. Sort the questions in alphabetical order.

--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import = "Chapter40.DatabaseConnection" %>
<jsp:useBean id="databaseConnectionID" 
             scope="session" 
             class="Chapter40.DatabaseConnection">
</jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercise 40.13</title>
        <link href="exercise4013.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <div id="bodywrap">
            <h1>Exercise 40.13: Multiple Question Poll</h1>
            <h4>by Naomi Crosby</h4>
            <% String[] questions = databaseConnectionID.getColumns();
                if (questions == null) {%>
            No questions found
            <% } else {%>
            <form method="post" action="NEC_StatusMultiQuestionPoll.jsp">
                Please answer the following questions:
                    <% for (int i = 0; i < questions.length; i++) {%>
                    <%-- print each question with 2 YES NO radio buttons --%>
                    <p> <%-- print each question --%>
                        <input type="radio" name="yesNo" value="true" checked="checked">Yes
                        <input type="radio" name="yesNo" value="false">No
                    </p>
                <% }%>
                <input type="submit" name="Submit" value="Submit" />
                <input type="reset" name="Reset" value="Reset" />
            </form>
            <% }%>
        </div>
    </body>
</html>
