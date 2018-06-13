package web.testDbConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/test")
public class TestDbServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = "Steve";
        String pass = "9863";
        String url = "jdbc:mysql://localhost:3306/spring_web_app?useSSL=false";

        String driver = "com.mysql.jdbc.Driver";

        try {
            PrintWriter out = resp.getWriter();

            Class.forName(driver);
            out.print("Connecting...");

            Connection connection = DriverManager.getConnection(url,user,pass);

            out.print("Success! No errors");

        }catch (ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
            throw new ServletException(ex);
        }
    }
}
