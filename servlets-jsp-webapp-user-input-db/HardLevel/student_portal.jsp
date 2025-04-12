<%@ page import="java.sql.*" %>
<html>
<body>
  <form action="attendance" method="post">
    Student ID: <input type="text" name="studentId"><br>
    Attendance (%): <input type="text" name="attendance"><br>
    <input type="submit" value="Submit">
  </form>
</body>
</html>