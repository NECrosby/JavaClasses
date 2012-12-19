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

<%@ page import ="java.util.ArrayList" %>
<%@ page errorPage="NEC_error.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ page import ="java.util.*" %>
<%@ page import ="Chapter40.PollBean" %>
<jsp:useBean id="pollData" class="Chapter40.PollDataBean" scope="session" >
</jsp:useBean>
<jsp:setProperty name="pollData" property="*" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercise 40.13: Poll Results</title>
        <link href="exercise4013.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <div id="bodyWrap">
            <h1>Exercise 40.13: Poll Results</h1>
            <h4>by Naomi Crosby</h4>

            <table>
                <%
                    ArrayList<PollBean> pollList = pollData.getPollList();
                    Iterator pollListIterator = pollList.iterator();
                    PollBean poll;

                    while (pollListIterator.hasNext()) {
                        poll = (PollBean) pollListIterator.next();
                %>
                <tr> 
                    <td>
                        <%= poll.getQuestion()%>&nbsp;&nbsp;
                    </td>
                    <td>
                        (<%= poll.getYesCount()%>&nbsp; Yes)&nbsp;&nbsp; 
                    </td>
                    <td>
                        (<%= poll.getNoCount()%>&nbsp; No)
                    </td>
                </tr> 
                <% }%>
            </table>
            <p>
                <a href="NEC_MultiQuestionPoll.jsp" alt="Back to poll questions">Back to poll questions</a>
            </p>
        </div>
    </body>
</html>
