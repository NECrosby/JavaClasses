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
<!DOCTYPE html>
<%-- if multiQPoll extends DBConnection, 
     dbConnection Bean shouldn't have to be "used"
<jsp:useBean id="dbConnection" class="Chapter40.DatabaseConnection" 
             scope="session" ></jsp:useBean>
<jsp:setProperty name="dbConnection" property="*" /> --%>
<jsp:useBean id="mqPoll" class="Chapter40.MultiQuestionPoll" scope="session" >
</jsp:useBean>
<jsp:setProperty name="mqPoll" property="*" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercise 40.13</title>
        <link href="exercise4013.css" rel="stylesheet" 
              type="text/css" media="screen" />
    </head>
    <body>
        <% mqPoll.populate(); %>
        <div id="bodywrap">
            <h1>Exercise 40.13: Multiple Question Poll</h1>
            <h4>by Naomi Crosby</h4>

            <form method="post" action="NEC_StatusMultiQuestionPoll.jsp">
                Please answer the following questions:
                <table>
                    <% for (int x = 0; x < 5; x++) {%>
                    <tr> 
                        <td>
                            
                        </td>
                        <td>
                            <input type="radio" name="yesNo" value="true" checked="checked">Yes
                        </td>
                        <td>
                            <input type="radio" name="yesNo" value="false">No
                        </td>
                        <td>
                            <input name="<%=mqPoll.getQuestion(x)%>">
                        </td>
                    </tr> 
                    <% }%>
                    <%-- The below 2 lines should have a method within the MultiPClass --%> 
                    <%-- String[] questions = databaseConnection.getColumns(); --%>
                    <%-- if (questions == null) { No questions found } else { }%> --%>
                </table>
                <input type="submit" name="Submit" value="Submit" />
                <input type="reset" name="Reset" value="Reset" />
            </form>

        </div>
    </body>
</html>
