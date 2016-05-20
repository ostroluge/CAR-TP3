<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>

<body>
<h1>Résumé du login</h1>
	 <p>
            <% 
            String host = (String) request.getServerName();
            out.println( host);
            %>
    </p>
	 <p>
            <% 
            int port = request.getServerPort();
            out.println( port);
            %>
    </p>
	 <p>
            <% 
            String login = (String) request.getParameter("login");
            out.println( login);
            %>
    </p>
	 <p>
            <% 
            String password = (String) request.getParameter("password");
            out.println( password);
            %>
    </p>

</body>
</html>