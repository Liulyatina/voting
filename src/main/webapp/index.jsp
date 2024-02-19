<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>First JSP App</title>
</head>
<body>
<p>Name: <%= request.getParameter("username")%>
</p>
<p>Country: <%= request.getParameter("country777")%>
</p>
<p>Gender: <%= request.getParameter("gender")%>
</p>
<h4>Selected courses</h4>
<ul>
<%
    String[] courses = request.getParameterValues("courses");
    if (courses != null) {
        for (String course : courses) {
            out.println("<li>" + course + "</li>");
        }
    }
%>
</ul>
</body>
</html>
