<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String u = request.getParameter("uu");
            if (u.startsWith("http://") || u.startsWith("https://")) {
                response.sendRedirect(u);
            } else {
                // session.setAttribute("error","Not a alid URL");
            }
        %>
    </body>
</html>