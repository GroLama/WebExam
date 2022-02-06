
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connect</title>
</head>
<body>
    <h1>My Online Exams</h1>
    <h2>To proceed an Exam please Log In</h2>
<p>
    <form method="post" action="<%= request.getContextPath() %>/connect">
        <p>
            <label for="username">Username: </label>
            <input type="text" name="username" id="username">
        </p>
        <p>
            <label for="password">Password: </label>
            <input type="password" name="password" id="password">
        </p>
        <input type="submit"/>
    </form>
</p>
</body>
</html>
