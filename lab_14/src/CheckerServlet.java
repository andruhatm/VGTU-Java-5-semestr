import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/hello")
public class CheckerServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();

		String login = req.getParameter("login");
		String password = req.getParameter("password");

		//System.out.println(login +" "+password);

		String fulname = "";
		Connection connection = Connect.connect();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM \"password\" inner join \"name\" N on password.id = N.id where login = '"+login+"' and \"password\".password = '"+password+"'");
			while (rs.next()){
				fulname+=rs.getString(5)+" "+rs.getString(6);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		if(!fulname.isEmpty()){
			writer.write("<h1>Hello, "+fulname +"</h1>");
		}
		else {
			writer.write("<h1>No such account found! Try again!</h1>");
		}

	}
}
