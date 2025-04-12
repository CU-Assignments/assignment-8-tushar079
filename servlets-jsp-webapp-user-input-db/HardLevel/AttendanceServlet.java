import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/attendance")
public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String studentId = request.getParameter("studentId");
        String attendance = request.getParameter("attendance");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO attendance (student_id, attendance) VALUES (?, ?)");
            ps.setString(1, studentId);
            ps.setString(2, attendance);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.getWriter().println("<h1>Attendance submitted for student " + studentId + "</h1>");
    }
}