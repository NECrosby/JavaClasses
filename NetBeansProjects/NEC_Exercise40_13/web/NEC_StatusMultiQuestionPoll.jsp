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

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Chapter40.DatabaseConnection" %>
<jsp:useBean id="databaseConnectionID" 
             scope="session" 
             class="Chapter40.DatabaseConnection">
</jsp:useBean>
<%@page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercise 40.13: Multiple Question Poll Status</title>
        <link href="exercise4013.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <div id="bodyWrap">
            <h1>Exercise 40.13: Multiple Question Poll</h1>
            <h4>by Naomi Crosby</h4>

            <% String tableName = request.getParameter("tablename");
                ResultSet columns = databaseConnectionID.getConnection().getMetaData().
                        getColumns(null, null, tableName, null);
            %>
            <table> <%-- border="1" --%>
                <tr>
                    <% // Add column names to the table
                    while (columns.next()) {%>
                    <td><%= columns.getString("COLUMN_NAME")%></td>
                    <% }%>
                </tr>

                <% Statement statement =
                            databaseConnectionID.getConnection().createStatement();
                    ResultSet result =
                            statement.executeQuery("SELECT * FROM " + tableName);
                    int columnCount = result.getMetaData().getColumnCount();

                    while (result.next()) {
                        out.println("<tr>");
                    for (int i = 0; i < columnCount; i++) {%>
                <td><%= result.getObject(i + 1)%></td>
                <% }
                 out.println("</tr>");
             }%>
            </table>
        </div>
    </body>
</html>
