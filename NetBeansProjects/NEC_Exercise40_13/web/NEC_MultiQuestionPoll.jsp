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
<%@page import="java.lang.System" %>
<%@page import="java.io.PrintWriter"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
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
        <title>Exercise 40.13</title>
        <link href="exercise4013.css" rel="stylesheet" 
              type="text/css" media="screen" />
    </head>
    <body>
        <jsp:setProperty name="poll" property="*" />
        <jsp:setProperty name="pollData" property="yesNo" value="yesNo" />
        
        <div id="bodywrap">
            <h1>Exercise 40.13: Multiple Question Poll</h1>
            <h4>by Naomi Crosby</h4>
            <form method="post" action="NEC_StatusMultiQuestionPoll.jsp">
                <p>Please answer the following questions:</p>
                <table>
                    <%
                        ArrayList<PollBean> pollList = pollData.getPollList();
                        Iterator pollListIterator = pollList.iterator();
                        PollBean poll;
                        String myYesNo = "true";
                        PrintWriter debug = response.getWriter();
                        
                        while (pollListIterator.hasNext()) {
                            poll = (PollBean) pollListIterator.next();
                            out.print("<tr>");
                            
                            out.print("<td>");
                            out.print(poll.getQuestion());
                            out.print("&nbsp;&nbsp;</td>");
                            
                            out.print("<td>");
                            out.print("<input type=\"radio\" name=\"yesNo" + poll.getId() + "\" value=\"true\" checked=\"checked\">Yes");
                            out.print("</td>");
                            
                            out.print("<td>");
                            out.print("<input type=\"radio\" name=\"yesNo" + poll.getId() + "\" value=\"false\" >No");
                            out.print("</td>");

                            out.println("</tr>");
                            myYesNo = pollData.getYesNo();                           
                            pollData.updateQuestion(poll.getId(), myYesNo);
                        }
                    %>
                </table>
                <input type="submit" name="Submit" value="Submit" />
                <input type="reset" name="Reset" value="Reset" />
            </form>
        </div>
    </body>
</html>
